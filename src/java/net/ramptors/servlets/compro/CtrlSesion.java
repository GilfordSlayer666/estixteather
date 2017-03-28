
package net.ramptors.servlets.compro;

import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import net.ramptors.servlets.*;
import javax.servlet.http.HttpServletRequest;
import net.ramptors.servlets.compro.form.ModeloFormSesion;


@WebServlet(name = "CtrlSesion", urlPatterns = "ctrlSesion")
public class CtrlSesion extends CtrlBase<ModeloFormSesion> {
  public CtrlSesion() {
    super(ModeloFormSesion.class);
  }
  @Override protected void inicia(HttpServletRequest req,
      ModeloForm<ModeloFormSesion> modeloForm) {
    final ModeloFormSesion valores = modeloForm.getValores();
    final Principal userPrincipal = req.getUserPrincipal();
    if (userPrincipal == null) {
      valores.setFormUsuarioId("");
      valores.setSesionIniciada("false");
      valores.setRolAdministrador("false");
      valores.setRolCliente("false");
    } else {
      valores.setFormUsuarioId(userPrincipal.getName());
      valores.setSesionIniciada("true");
      valores.setRolAdministrador(
          req.isUserInRole("Administrador") ? "true" : "false");
      valores.setRolCliente(req.isUserInRole("Cliente") ? "true" : "false");
    }
  }
  @Override protected void procesa(HttpServletRequest req,
      ModeloForm<ModeloFormSesion> modeloForm) {
    final ModeloFormSesion valores = modeloForm.getValores();
    if ("terminarSesion".equals(valores.getAccion())) {
      try {
        req.logout();
        valores.setFormUsuarioId("");
        valores.setSesionIniciada("false");
        valores.setRolAdministrador("false");
        valores.setRolCliente("false");
        modeloForm.setSiguienteForm("compro-inicio");
      } catch (ServletException e) {
        procesaError(modeloForm, "Error cerrando sesión", e);
      }
    }
  }
}
