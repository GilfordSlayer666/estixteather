
package net.ramptors.servlets.compro.form;

import net.ramptors.servlets.ModeloFormAbc;

public class ModeloFormClientes extends ModeloFormAbc {
  private String usuario;
  private String nacimiento;
  private String horaFavorita;
  public String getUsuario() {
    return usuario;
  }
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  public String getNacimiento() {
    return nacimiento;
  }
  public void setNacimiento(String nacimiento) {
    this.nacimiento = nacimiento;
  }
  public String getHoraFavorita() {
    return horaFavorita;
  }
  public void setHoraFavorita(String horaFavorita) {
    this.horaFavorita = horaFavorita;
  }
}
