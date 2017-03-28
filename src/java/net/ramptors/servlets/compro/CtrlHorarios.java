package net.ramptors.servlets.compro;

import net.ramptors.servlets.compro.form.ModeloFormHorarios;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
//import jee.Archivo;
import static jee.UtilJee.format;
import static jee.UtilJee.getFormatoFecha;
import static jee.UtilJee.getFormatoPrecio;
//import static jee.UtilJee.parseFechaWeb;
import static jee.UtilJee.parseHoraWeb;
import static jee.UtilJee.parsePrecio;
import net.ramptors.jee.compro.entidad.Horario;
//import net.ramptors.jee.compro.entidad.Teatro;
import net.ramptors.servlets.CtrlAbc;
import net.ramptors.servlets.ModeloForm;
import net.ramptors.servlets.Renglon;
import static net.ramptors.servlets.UtilServlets.getImagenUrl;
import static net.ramptors.servlets.UtilServlets.texto;
//import net.ramptors.servlets.compro.form.ModeloFormClientes;
//import net.ramptors.servlets.compro.form.ModeloFormObraTeatrals;
//import net.ramptors.servlets.compro.form.ModeloFormTeatros;

/**
 *
 * @author JorgeVargas
 */


@WebServlet(name = "CtrlHorarios ", urlPatterns = "ctrlHorarios")
public class CtrlHorarios extends CtrlAbc<Horario, Long, ModeloFormHorarios>{
 public CtrlHorarios() {
    super(Horario.FILTRO,Horario.class, Long.class, ModeloFormHorarios.class,
        "Horarios Registrados ","Nuevo Horario ");
  }
   @Override protected Renglon getRenglon(HttpServletRequest req,
      Horario modelo) {
    return new Renglon(modelo.getId(), modelo.getDia());
  }
   
  @Override protected String getTituloDeModelo(Horario modelo) {
    return modelo.getDia();
  }
 @Override protected void llenaModelo(EntityManager em,
      ModeloForm<ModeloFormHorarios> modeloForm, Horario modelo) {
     final ModeloFormHorarios valores = modeloForm.getValores();
    modelo.setDia(modeloForm.getValores().getDia());
    modelo.setHorarioI(parseHoraWeb(valores.getHorarioI(),
        "Formato incorrecto Horario de Inicio."));
    modelo.setHorarioT(parseHoraWeb(valores.getHorarioT(),
        "Formato incorrecto para Horario de Termino."));
    modelo.setCosto(parsePrecio(valores.getCosto(),
          "Formato incorrecto para costo."));
  }
    
   
 @Override protected void muestraModelo(EntityManager em,
      HttpServletRequest req, ModeloForm<ModeloFormHorarios> modeloForm,
      Horario modelo) {
    final ModeloFormHorarios valores = modeloForm.getValores();
    modeloForm.getValores().setDia(texto(modelo.getDia()));
    valores.setHorarioI(format(getFormatoFecha(), modelo.getHorarioI()));
    valores.setHorarioT(format(getFormatoFecha(), modelo.getHorarioT())); 
    valores.setCosto(format(getFormatoPrecio(), modelo.getCosto()));
  }    
}
