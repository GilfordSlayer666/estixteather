/*
 * Copyright 2017 JorgeVargas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ramptors.servlets.compro.form;

import net.ramptors.servlets.ModeloFormAbc;

/**
 *
 * @author JorgeVargas
 */
public class ModeloFormCartelerasCliente extends ModeloFormAbc{
  private String fechaI;
  private String fechaT;
  private String horarioI;
  private String horarioT;
  private String costo;
  private String obra;
  private String teatro;
   private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getFechaT() {
        return fechaT;
    }

    public void setFechaT(String fechaT) {
        this.fechaT = fechaT;
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

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getTeatro() {
        return teatro;
    }

    public void setTeatro(String teatro) {
        this.teatro = teatro;
    }
}
