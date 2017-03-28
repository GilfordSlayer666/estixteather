
package net.ramptors.servlets.compro;

import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import net.ramptors.servlets.*;
import javax.servlet.http.HttpServletRequest;
import net.ramptors.servlets.compro.form.ModeloFormIniciarSesion;


@WebServlet(name = "CtrlIniciarSesion", urlPatterns = "ctrlIniciarSesion")
public class CtrlIniciarSesion extends CtrlBase<ModeloFormIniciarSesion> {
  public CtrlIniciarSesion() {
    super(ModeloFormIniciarSesion.class);
  }
  @Override protected void inicia(HttpServletRequest req,
      ModeloForm<ModeloFormIniciarSesion> modeloForm) {
    final ModeloFormIniciarSesion valores = modeloForm.getValores();
    final Principal userPrincipal = req.getUserPrincipal();
    if (userPrincipal == null) {
      valores.setContrasena("");
      valores.setId("");
    } else {
      modeloForm.setSiguienteForm("compro-inicio");
    }
  }
  @Override protected void procesa(HttpServletRequest req,
      ModeloForm<ModeloFormIniciarSesion> modeloForm) {
    if ("submit".equals(modeloForm.getValores().getAccion())) {
      final ModeloFormIniciarSesion valores = modeloForm.getValores();
      final Principal userPrincipal = req.getUserPrincipal();
      if (userPrincipal == null) {
        try {
          final String id = valores.getId();
          final String contrasena = valores.getContrasena();
          req.login(id, contrasena);
          modeloForm.setSiguienteForm("compro-inicio");
        } catch (ServletException e) {
          procesaError(modeloForm, "Error iniciando sesión.", e);
        }
      } else {
        modeloForm.setSiguienteForm("compro-inicio");
      }
    }
  }
}
