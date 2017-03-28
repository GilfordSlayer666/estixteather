package net.ramptors.servlets.compro;

import net.ramptors.servlets.compro.form.ModeloFormObraTeatrals;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import jee.Archivo;
import net.ramptors.jee.compro.entidad.Obra;


import net.ramptors.servlets.CtrlAbc;
import net.ramptors.servlets.ModeloForm;

import net.ramptors.servlets.Renglon;

import static net.ramptors.servlets.UtilServlets.getImagenUrl;

import static net.ramptors.servlets.UtilServlets.texto;



@WebServlet(name = "CtrlObraTeatrals ", urlPatterns = "ctrlObraTeatrals")
public class CtrlObraTeatrals extends CtrlAbc<Obra, Long, ModeloFormObraTeatrals> {
  public CtrlObraTeatrals() {
    super(Obra.FILTRO,Obra.class, Long.class, ModeloFormObraTeatrals.class,
        "Obras Registradas ","Nueva Obra ");
  }
  @Override protected Renglon getRenglon(HttpServletRequest req, Obra modelo) {
    return new Renglon(modelo.getId(),
        getImagenUrl(req, modelo.getImagen().getId()),
        modelo.getNombre(),modelo.getDireccionDeEntrega());
  }
  @Override protected String getTituloDeModelo(Obra modelo) {
    return modelo.getNombre();
  }
  @Override protected void llenaModelo(EntityManager em,
      ModeloForm<ModeloFormObraTeatrals> modeloForm, Obra modelo) {
    final boolean nuevo = isNuevo(modeloForm);
    final ModeloFormObraTeatrals valores = modeloForm.getValores();
    if (nuevo && valores.getImagen() == null) {
      throw new RuntimeException("Falta seleccionar la imagen.");
    } else {

       if (nuevo || valores.getImagen() != null) {
        modelo.setImagen(new Archivo(valores.getImagen()));
      }
      modelo.setNombre(valores.getNombre());
      modelo.setDireccionDeEntrega(valores.getDireccionDeEntrega());

    }
    valores.setImagen(null);
  }
  @Override protected void muestraModelo(EntityManager em,
      HttpServletRequest req, ModeloForm<ModeloFormObraTeatrals> modeloForm,
      Obra modelo) {
    final ModeloFormObraTeatrals valores = modeloForm.getValores();
    valores.setImg(isNuevo(modeloForm) ? ""
        : getImagenUrl(req, modelo.getImagen().getId()));
    valores.setImagen(new byte[0]);
    valores.setNombre(texto(modelo.getNombre()));
    valores.setDireccionDeEntrega(texto(modelo.getDireccionDeEntrega()));
  }

}
