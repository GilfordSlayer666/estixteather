package net.ramptors.servlets.compro;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import jee.CtrlTransacciones;
import net.ramptors.jee.compro.entidad.Aviso;


@ServerEndpoint(value = "/sincronizacion",
    encoders = {EncoderSincronizacion.class}, decoders = DecoderAvisos.class)
public class EndpointSincronizacion {
  @Inject CtrlTransacciones ctrlTransacciones;
  private static final Logger LOGGER
      = Logger.getLogger(EndpointSincronizacion.class.getName());
  @OnOpen public void openConnection(Session session) {
    /* Registra la conexión en la cola. */
    LOGGER.log(Level.INFO, "Conexión abierta.");
  }
  @OnClose public void closedConnection(Session session) {
    /* Saca la sesión de la cola. */
    LOGGER.log(Level.INFO, "Conexión cerrada.");
  }
  @OnMessage public void onMessage(Session session, List<Aviso> lista) throws
      IOException, EncodeException {
    EntityManager em = null;
    try {
      int modificados = 0;
      em = iniciaTransaccion();
      for (final Aviso modeloCliente : lista) {
        final Aviso modeloServidor = em.find(Aviso.class, modeloCliente.getId());
        if (modeloServidor == null) {
          /* CONFLICTO. El objeto no ha estado en el servidor. AGREGARLO. Si ya
           * está eliminado, simplemente no se agrega. */
          if (!modeloCliente.isEliminado()) {
            em.persist(modeloCliente);
            em.flush();
            modificados++;
          }
        } else if (modeloCliente.isEliminado()
            && !modeloServidor.isEliminado()) {
          /* CONFLICTO. El registro está en el servidor, pero ha sido eliminado
           * en el cliente. Lo eliminamos, porque optamos por no revivir lo que
           * se ha borrado. */
          modeloServidor.setEliminado(true);
          modificados++;
        } else if (!modeloServidor.isEliminado()) {
          /* CONFLICTO. El registro está tanto en el servidor como en el
           * cliente. Los datos pueden ser diferentes. PREVALECE LA FECHA MÁS
           * GRANDE. Cuando gana el servidor no se hace nada. */
          final long modificaciónCliente = modeloCliente.getModificacion();
          final long modificaciónServidor = modeloServidor.getModificacion();
          if (modificaciónCliente > modificaciónServidor) {
            // La versión del móvil es más nueva y prevalece.
            em.merge(modeloCliente);
            em.flush();
            modificados++;
          }
        }
      }
      if (modificados == 0) {
        session.getBasicRemote().sendObject(new Sincronizacion(true,
            em.createNamedQuery("Aviso.TODOS", Aviso.class).getResultList()));
      } else {
        final Sincronizacion sincronizacion = new Sincronizacion();
        for (Session s : session.getOpenSessions()) {
          s.getBasicRemote().sendObject(sincronizacion);
        }
      }
      commit(em);
    } finally {
      cierra(em);
    }
  }
  @OnError public void error(Session session, Throwable t) {
    /* Saca la sesión de la cola. */
    LOGGER.log(Level.SEVERE, "Error de web socket.", t);
  }
  private void cierra(EntityManager em) {
    ctrlTransacciones.cierra(em);
  }
  private void commit(EntityManager em) {
    ctrlTransacciones.commit(em);
  }
  private EntityManager iniciaTransaccion() {
    return ctrlTransacciones.inicia();
  }
}
