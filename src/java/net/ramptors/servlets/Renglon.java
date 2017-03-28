
package net.ramptors.servlets;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Renglon {
  private String detalleId;
  private String imagenUrl;
  private String texto1;
  private String texto2;
  public Renglon() {
  }
  public Renglon(Object detalleId, Object texto1) {
    this.detalleId = Objects.toString(detalleId, null);
    this.texto1 = Objects.toString(texto1, null);
  }
  public Renglon(Object detalleId, Object texto1, Object texto2) {
    this(detalleId, texto1);
    this.texto2 = Objects.toString(texto2, null);
  }
  public Renglon(Object detalleId, Object imagenUrl, Object texto1,
      Object texto2) {
    this(detalleId, texto1, texto2);
    this.imagenUrl = Objects.toString(imagenUrl, null);
  }
  public String getDetalleId() {
    return detalleId;
  }
  public void setDetalleId(String detalleId) {
    this.detalleId = detalleId;
  }
  public String getImagenUrl() {
    return imagenUrl;
  }
  public void setImagenUrl(String imagenUrl) {
    this.imagenUrl = imagenUrl;
  }
  public String getTexto1() {
    return texto1;
  }
  public void setTexto1(String texto1) {
    this.texto1 = texto1;
  }
  public String getTexto2() {
    return texto2;
  }
  public void setTexto2(String texto2) {
    this.texto2 = texto2;
  }
}
