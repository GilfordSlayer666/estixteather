
package net.ramptors.servlets.compro;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import jee.Archivo;
import static jee.UtilJee.getFormatoPrecio;
import static jee.UtilJee.format;
import static jee.UtilJee.getFormatoFecha;
import static jee.UtilJee.getFormatoHora;
import static jee.UtilJee.parseHoraWeb;
import static jee.UtilJee.parseFechaWeb;
import static jee.UtilJee.parsePrecio;
import net.ramptors.jee.compro.entidad.Teatro;
import net.ramptors.jee.compro.entidad.Cartelera;
import net.ramptors.jee.compro.entidad.Obra;
import net.ramptors.servlets.CtrlAbc;
import net.ramptors.servlets.ModeloForm;
import net.ramptors.servlets.Opcion;
import net.ramptors.servlets.Renglon;
import static net.ramptors.servlets.UtilServlets.buscaId;
import static net.ramptors.servlets.UtilServlets.getId;
import static net.ramptors.servlets.UtilServlets.getImagenUrl;
import static net.ramptors.servlets.UtilServlets.getOpciones;
import static net.ramptors.servlets.UtilServlets.texto;
import net.ramptors.servlets.compro.form.ModeloFormCarteleras;

/**
 *
 * @author JorgeVargas
 */
@WebServlet(name = "CtrlCarteleras", urlPatterns = "ctrlCarteleras")

public class CtrlCarteleras extends CtrlAbc<Cartelera, Long, ModeloFormCarteleras> {
   public CtrlCarteleras() {
    super(Cartelera.FILTRO, Cartelera.class, Long.class, ModeloFormCarteleras.class,
        "Carteleras", "Cartelera Nueva");
  } 
   
   @Override protected Renglon getRenglon(HttpServletRequest req, Cartelera modelo) {
    return new Renglon(modelo.getId(),getImagenUrl(req,modelo.getImagen().getId()),
            modelo.getObra().getNombre(), format(getFormatoPrecio(), modelo.getCosto()));
  }
   
   @Override protected String getTituloDeModelo(Cartelera modelo) {
    return modelo.getObra().getNombre();
  }
   
 
   
 @Override protected void llenaModelo(EntityManager em,
      ModeloForm<ModeloFormCarteleras> modeloForm, Cartelera modelo) {
    final boolean nuevo = isNuevo(modeloForm);
    final ModeloFormCarteleras valores = modeloForm.getValores();
     if (nuevo && valores.getImagen() == null) {
      throw new RuntimeException("Falta seleccionar la imagen.");
    } else {
        modelo.setObra(buscaId(em, Obra.class, Long.class, valores.getObra()));
        modelo.setTeatro(buscaId(em, Teatro.class, Long.class, valores.getTeatro()));
    if (nuevo || valores.getImagen() != null) {
        modelo.setImagen(new Archivo(valores.getImagen()));
      }
        modelo.setFechaI(valores.getFechaI());
        modelo.setFechaT(parseFechaWeb(valores.getFechaT(),
            "Formato incorrecto para fecha de Termino."));
        modelo.setHorarioI(parseHoraWeb(valores.getHorarioI(),
          "Formato incorrecto Horario de Inicio."));
        modelo.setHorarioT(parseHoraWeb(valores.getHorarioT(),
            "Formato incorrecto para Horario de Termino."));
        modelo.setCosto(parsePrecio(valores.getCosto(),
              "Formato incorrecto para costo."));
    }
    valores.setImagen(null);
  }
 
 
   @Override protected void muestraModelo(EntityManager em,
      HttpServletRequest req, ModeloForm<ModeloFormCarteleras> modeloForm,
      Cartelera modelo) {
    final ModeloFormCarteleras valores = modeloForm.getValores();
    valores.setImg(isNuevo(modeloForm) ? ""
        : getImagenUrl(req, modelo.getImagen().getId()));
    valores.setImagen(new byte[0]);
    valores.setFechaI(texto(modelo.getFechaI()));
    valores.setFechaT(format(getFormatoFecha(), modelo.getFechaT()));
    valores.setHorarioI(format(getFormatoHora(), modelo.getHorarioI()));
    valores.setHorarioT(format(getFormatoHora(), modelo.getHorarioT())); 
    valores.setCosto(format(getFormatoPrecio(), modelo.getCosto()));
    valores.setObra(getId(modelo.getObra()));
    valores.setTeatro(getId(modelo.getTeatro()));
  }
 
 
 
 @Override
  protected void muestraOpciones(EntityManager em, HttpServletRequest req,
      ModeloForm<ModeloFormCarteleras> modeloForm) {
    modeloForm.getOpciones().put("obra", getOpciones("-- Selecciona Obra --",
        em.createNamedQuery("Obra.TODAS", Obra.class).getResultList(),
        o -> new Opcion(o.getId().toString(), o.getNombre())));
   
    modeloForm.getOpciones().put("teatro", getOpciones(
    "-- Selecciona Teatro --",
    em.createNamedQuery("Teatro.TODAS", Teatro.class).getResultList(),
    t -> new Opcion(t.getId().toString(), t.getNombre())));
  
  
  }
  
}
