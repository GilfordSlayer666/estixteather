/*
 * Copyright 2017 JorgeVargas.
 */
package net.ramptors.servlets.compro;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import static jee.UtilJee.format;
import static jee.UtilJee.getFormatoFecha;
import static jee.UtilJee.getFormatoHora;
import static jee.UtilJee.getFormatoPrecio;
//import net.ramptors.jee.compro.entidad.Cliente;
import net.ramptors.jee.compro.entidad.Cartelera;
import net.ramptors.servlets.CtrlAbc;
import net.ramptors.servlets.ModeloForm;
import net.ramptors.servlets.Renglon;
import static net.ramptors.servlets.UtilServlets.getImagenUrl;
import static net.ramptors.servlets.UtilServlets.texto;
import net.ramptors.servlets.compro.form.ModeloFormCartelerasCliente;

/**
 *
 * @author JorgeVargas
 */
@WebServlet(name = "CtrlCartelerasCliente", urlPatterns = "ctrlCartelerasCliente")
public class CtrlCartelerasCliente extends CtrlAbc<Cartelera, Long, ModeloFormCartelerasCliente>{
    public CtrlCartelerasCliente() {
    super(Cartelera.FILTRO, Cartelera.class, Long.class,
        ModeloFormCartelerasCliente.class, "Carteleras", "Selecciona un Cartelera");
  }
  
   @Override protected Renglon getRenglon(HttpServletRequest req, Cartelera modelo) {
    return new Renglon(modelo.getId(),getImagenUrl(req, modelo.getImagen().getId()),
            modelo.getObra().getNombre(), format(getFormatoPrecio(), modelo.getCosto()));
  }
   
   @Override protected String getTituloDeModelo(Cartelera modelo) {
    return modelo.getObra().getNombre();
  }
  @Override protected void llenaModelo(EntityManager em,
      ModeloForm<ModeloFormCartelerasCliente> modeloForm, Cartelera modelo) {
  }
  
  @Override protected void muestraModelo(EntityManager em,
      HttpServletRequest req, ModeloForm<ModeloFormCartelerasCliente> modeloForm,
      Cartelera modelo) {
    final ModeloFormCartelerasCliente valores = modeloForm.getValores();
        valores.setImg(getImagenUrl(req, modelo.getImagen().getId()));
        valores.setFechaI(texto(modelo.getFechaI()));
        valores.setFechaT(format(getFormatoFecha(), modelo.getFechaT()));
        valores.setHorarioI(format(getFormatoHora(), modelo.getHorarioI()));
        valores.setHorarioT(format(getFormatoHora(), modelo.getHorarioT()));
        valores.setCosto(format(getFormatoPrecio(), modelo.getCosto()));
        valores.setObra(modelo.getObra().getNombre());
        valores.setTeatro(modelo.getObra().getNombre());
  }
   
}
