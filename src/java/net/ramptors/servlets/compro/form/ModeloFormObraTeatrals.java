package net.ramptors.servlets.compro.form;

import net.ramptors.servlets.ModeloFormAbc;

public class ModeloFormObraTeatrals extends ModeloFormAbc {
  private String img;
  private byte[] imagen;
  private String nombre;

  private String direccionDeEntrega;

  public String getImg() {
    return img;
  }
  public void setImg(String img) {
    this.img = img;
  }
  public byte[] getImagen() {
    return imagen;
  }
  public void setImagen(byte[] imagen) {
    this.imagen = imagen;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccionDeEntrega() {
    return direccionDeEntrega;
  }
  public void setDireccionDeEntrega(String direccionDeEntrega) {
    this.direccionDeEntrega = direccionDeEntrega;
  }
}
