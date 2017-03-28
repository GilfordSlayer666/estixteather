
package net.ramptors.servlets.compro.form;

import net.ramptors.servlets.ModeloFormAbc;


public class ModeloFormUsuarios extends ModeloFormAbc {
  private String id;
  private String contrasena;
  private String confirma;
  private String debeConfirmar;
  private String nombre;
  private String[] roles;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getContrasena() {
    return contrasena;
  }
  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }
  public String getConfirma() {
    return confirma;
  }
  public void setConfirma(String confirma) {
    this.confirma = confirma;
  }
  public String getDebeConfirmar() {
    return debeConfirmar;
  }
  public void setDebeConfirmar(String debeConfirmar) {
    this.debeConfirmar = debeConfirmar;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String[] getRoles() {
    return roles;
  }
  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}
