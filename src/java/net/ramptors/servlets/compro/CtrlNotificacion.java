
package net.ramptors.servlets.compro;

import java.io.IOException;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/ctrlNotificacion")
public class CtrlNotificacion {
  private static final Logger LOGGER = Logger.getLogger(CtrlNotificacion.class.
      getName());
  /* Cola para todas las sesiones de WebSocket abiertas. */
  private static final Queue<Session> QUEUE = new ConcurrentLinkedQueue<>();
  public static void notifica(final String usuarioId, final String mensaje)
      throws IOException {
    QUEUE.parallelStream().
        filter(sesion -> sesion.isOpen() && sesion.getUserPrincipal() != null
        && Objects.equals(usuarioId, sesion.getUserPrincipal().getName())).
        forEach(sesion -> {
          try {
            sesion.getBasicRemote().sendText(mensaje);
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
  }
  @OnOpen public void openConnection(Session session) {
    /* Registra la conexión en la cola. */
    QUEUE.add(session);
    LOGGER.log(Level.INFO, "Sesión de CtrlNotificacion abierta.");
  }
  @OnClose public void closedConnection(Session session) {
    /* Saca la sesión de la cola. */
    QUEUE.remove(session);
    LOGGER.log(Level.INFO, "Sesión de CtrlNotificacion cerrada.");
  }
  @OnError public void error(Session session, Throwable e) {
    /* Saca la sesión de la cola. */
    QUEUE.remove(session);
    LOGGER.log(Level.SEVERE, "Error de notificación.", e);
  }
}
