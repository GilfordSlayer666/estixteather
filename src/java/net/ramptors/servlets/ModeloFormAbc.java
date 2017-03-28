
package net.ramptors.servlets;

import java.util.List;

public class ModeloFormAbc {
  private String accion;
  private String filtro;
  private List<Renglon> lista;
  private String detalleId;
  private String muestraDetalle;
  private String nuevo;
  public String getAccion() {
    return accion;
  }
  public void setAccion(String accion) {
    this.accion = accion;
  }
  public String getFiltro() {
    return filtro;
  }
  public void setFiltro(String filtro) {
    this.filtro = filtro;
  }
  public List<Renglon> getLista() {
    return lista;
  }
  public void setLista(List<Renglon> lista) {
    this.lista = lista;
  }
  public String getDetalleId() {
    return detalleId;
  }
  public void setDetalleId(String detalleId) {
    this.detalleId = detalleId;
  }
  public String getMuestraDetalle() {
    return muestraDetalle;
  }
  public void setMuestraDetalle(String muestraDetalle) {
    this.muestraDetalle = muestraDetalle;
  }
  public String getNuevo() {
    return nuevo;
  }
  public void setNuevo(String nuevo) {
    this.nuevo = nuevo;
  }
}
