package net.ramptors.servlets.compro;

import java.util.Collections;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import static jee.UtilJee.encripta;
import static jee.UtilJee.isNullOrEmpty;
import net.ramptors.jee.compro.entidad.Rol;
import net.ramptors.jee.compro.entidad.Usuario;
import net.ramptors.servlets.CtrlAbc;
import net.ramptors.servlets.ModeloForm;
import net.ramptors.servlets.Opcion;
import net.ramptors.servlets.Renglon;
import static net.ramptors.servlets.UtilServlets.getIds;
import net.ramptors.servlets.compro.form.ModeloFormUsuarios;
import static net.ramptors.servlets.UtilServlets.getOpciones;
import static net.ramptors.servlets.UtilServlets.texto;
import static net.ramptors.servlets.compro.CtrlInicio.CLIENTE;

@MultipartConfig
@WebServlet(name = "CtrlUsuariosCliente", urlPatterns = "ctrlUsuariosCliente")
public class CtrlUsuariosCliente extends CtrlAbc<Usuario, String, ModeloFormUsuarios> {
  public CtrlUsuariosCliente() {
    super(Usuario.FILTRO, Usuario.class, String.class,
        ModeloFormUsuarios.class, "Usuarios", "Usuario Nuevo");
  }
  @Override protected Renglon getRenglon(HttpServletRequest req, Usuario modelo) {
    return new Renglon(modelo.getId(), modelo.getId(), modelo.getNombre());
  }
  @Override protected String getTituloDeModelo(Usuario modelo) {
    return modelo.getId();
  }
  @Override protected void llenaModelo(EntityManager em,
      ModeloForm<ModeloFormUsuarios> modeloForm, Usuario modelo) {
    final ModeloFormUsuarios valores = modeloForm.getValores();
    final String contrasena = valores.getContrasena();
    final String id = valores.getId();
    if (isNuevo(modeloForm) && isNullOrEmpty(id)) {
      throw new RuntimeException("Falta el identificador.");
    } else if (isNuevo(modeloForm) && isNullOrEmpty(contrasena)) {
      throw new RuntimeException("Falta la Contraseña.");
    } else if ("true".equals(valores.getDebeConfirmar())
        && !Objects.equals(contrasena, valores.getConfirma())) {
      throw new RuntimeException("Las Contraseñas no coinciden.");
    } else if (contrasena != null
        && (contrasena.length() < 5 || contrasena.length() > 25)) {
      throw new RuntimeException(
          "La Contraseña debe tener de 5 a 25 caracteres.");
    } else {
      if (isNuevo(modeloForm)) {
        modelo.setId(valores.getId());
        modelo.setContrasena(encripta(contrasena));
      } else if (!isNullOrEmpty(contrasena)) {
        modelo.setContrasena(encripta(contrasena));
      }
      modelo.setNombre(valores.getNombre());
      modelo.setRoles(Collections.singletonList(em.find(Rol.class,CLIENTE )));
    }
  }
  @Override protected void muestraModelo(EntityManager em,
      HttpServletRequest req, ModeloForm<ModeloFormUsuarios> modeloForm,
      Usuario modelo) {
    final ModeloFormUsuarios valores = modeloForm.getValores();
    valores.setId(texto(modelo.getId()));
    valores.setContrasena("");
    valores.setConfirma("");
    valores.setNombre(texto(modelo.getNombre()));
    valores.setRoles(getIds(modelo.getRoles()));
  }
  @Override
  protected void muestraOpciones(EntityManager em, HttpServletRequest req,
      ModeloForm<ModeloFormUsuarios> modeloForm) {
    modeloForm.getOpciones().put("roles", getOpciones(null,
        em.createNamedQuery(Rol.TODOS, Rol.class).getResultList(),
        r -> new Opcion(r.getId(), r.getId() + ": " + r.getDescripcion())));
  }
}
