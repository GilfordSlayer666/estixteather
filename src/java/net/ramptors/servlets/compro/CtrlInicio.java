package net.ramptors.servlets.compro;

import java.util.Arrays;
import java.util.Collections;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import jee.CtrlTransacciones;
import static jee.UtilJee.encripta;
import net.ramptors.jee.compro.entidad.Rol;
import net.ramptors.jee.compro.entidad.Usuario;

public class CtrlInicio implements ServletContextListener {
  public static final String ADMINISTRADOR = "Administrador";
  public static final String CLIENTE = "Cliente";
  public static final Rol[] ROLES = {
    new Rol(ADMINISTRADOR, "Administra el sistema."),
    new Rol(CLIENTE, "Realiza compras.")};
  private static final String ID_ADMINISTRADOR = "estix";
  private static final String CONTRASENA_ADMINISTRADOR = "estix";
  private static final String NOMBRE_ADMINISTRADOR = "Cámbiame";
  @Inject CtrlTransacciones ctrlTransacciones;
  @Override public void contextInitialized(ServletContextEvent sce) {
    EntityManager em = null;
    try {
      em = iniciaTransaccion();
      final EntityManager em1 = em;
      Arrays.stream(ROLES).forEach(rol -> {
        if (em1.find(Rol.class, rol.getId()) == null) {
          em1.persist(rol);
        }
      });
      if (em.find(Usuario.class, ID_ADMINISTRADOR) == null) {
        final Usuario usuario = new Usuario();
        usuario.setId(ID_ADMINISTRADOR);
        usuario.setContrasena(encripta(CONTRASENA_ADMINISTRADOR));
        usuario.setNombre(NOMBRE_ADMINISTRADOR);
        usuario.setRoles(
            Collections.singletonList(em.find(Rol.class, ADMINISTRADOR)));
        em.persist(usuario);
      }
      commit(em);
    } finally {
      ctrlTransacciones.cierra(em);
    }
  }
  @Override public void contextDestroyed(ServletContextEvent sce) {
  }
  private EntityManager iniciaTransaccion() {
    return ctrlTransacciones.inicia();
  }
  private void commit(EntityManager em) {
    ctrlTransacciones.commit(em);
  }
}
