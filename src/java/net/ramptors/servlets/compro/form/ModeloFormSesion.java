
package net.ramptors.servlets.compro.form;

public class ModeloFormSesion {
  private String accion;
  private String formUsuarioId;
  private String rolAdministrador;
  private String rolCliente;
  private String sesionIniciada;
  public String getAccion() {
    return accion;
  }
  public void setAccion(String accion) {
    this.accion = accion;
  }
  public String getFormUsuarioId() {
    return formUsuarioId;
  }
  public void setFormUsuarioId(String formUsuarioId) {
    this.formUsuarioId = formUsuarioId;
  }
  public String getRolAdministrador() {
    return rolAdministrador;
  }
  public void setRolAdministrador(String rolAdministrador) {
    this.rolAdministrador = rolAdministrador;
  }
  public String getRolCliente() {
    return rolCliente;
  }
  public void setRolCliente(String rolCliente) {
    this.rolCliente = rolCliente;
  }
  public String getSesionIniciada() {
    return sesionIniciada;
  }
  public void setSesionIniciada(String sesionIniciada) {
    this.sesionIniciada = sesionIniciada;
  }
}
