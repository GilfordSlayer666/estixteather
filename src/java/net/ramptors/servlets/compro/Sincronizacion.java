package net.ramptors.servlets.compro;

import java.util.List;
import net.ramptors.jee.compro.entidad.Aviso;

public class Sincronizacion {
  private boolean finalizada;
  private List<Aviso> lista;
  private String error;
  public Sincronizacion() {
  }
  public Sincronizacion(boolean finalizada, List<Aviso> lista) {
    this.finalizada = finalizada;
    this.lista = lista;
  }
  public boolean isFinalizada() {
    return finalizada;
  }
  public void setFinalizada(boolean finalizada) {
    this.finalizada = finalizada;
  }
  public List<Aviso> getLista() {
    return lista;
  }
  public void setLista(List<Aviso> lista) {
    this.lista = lista;
  }
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }
}
