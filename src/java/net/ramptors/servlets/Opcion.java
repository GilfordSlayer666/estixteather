
package net.ramptors.servlets;

import java.util.Objects;

public class Opcion {
  private String id;
  private String texto;
  public Opcion() {
  }
  public Opcion(Object id, Object texto) {
    this.id = Objects.toString(id, null);
    this.texto = Objects.toString(texto, null);
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getTexto() {
    return texto;
  }
  public void setTexto(String texto) {
    this.texto = texto;
  }
}
