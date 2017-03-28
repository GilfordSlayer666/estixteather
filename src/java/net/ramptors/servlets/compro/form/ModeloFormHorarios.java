
package net.ramptors.servlets.compro.form;

import net.ramptors.servlets.ModeloFormAbc;
/**
 *
 * @author JorgeVargas
 */
public class ModeloFormHorarios extends ModeloFormAbc {
  private String dia;
  private String horarioI;
  private String horarioT;
  private String costo;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorarioI() {
        return horarioI;
    }

    public void setHorarioI(String horarioI) {
        this.horarioI = horarioI;
    }

    public String getHorarioT() {
        return horarioT;
    }

    public void setHorarioT(String horarioT) {
        this.horarioT = horarioT;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
  
  
  
}
