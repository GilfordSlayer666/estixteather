/*
 * Copyright 2017 Gilberto Pacheco Gallegos.
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
package net.ramptors.servlets.compro;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import net.ramptors.servlets.Renglon;
import net.ramptors.jee.compro.entidad.Teatro;
import net.ramptors.servlets.CtrlAbc;
import net.ramptors.servlets.ModeloForm;
import static net.ramptors.servlets.UtilServlets.texto;
import net.ramptors.servlets.compro.form.ModeloFormTeatros;

/**
 *
 * @author Gilberto Pacheco Gallegos
 */
@WebServlet(name = "CtrlTeatros", urlPatterns = "ctrlTeatros")
public class CtrlTeatros
    extends CtrlAbc<Teatro, Long, ModeloFormTeatros> {
  public CtrlTeatros() {
    super(Teatro.FILTRO, Teatro.class, Long.class,
        ModeloFormTeatros.class, "Teatros", "Teatro Nueva");
  }
  @Override protected Renglon getRenglon(HttpServletRequest req,
      Teatro modelo) {
    return new Renglon(modelo.getId(), modelo.getNombre());
  }
  @Override protected String getTituloDeModelo(Teatro modelo) {
    return modelo.getNombre();
  }
  @Override protected void llenaModelo(EntityManager em,
      ModeloForm<ModeloFormTeatros> modeloForm, Teatro modelo) {
    modelo.setNombre(modeloForm.getValores().getNombre());
  }
  @Override protected void muestraModelo(EntityManager em,
      HttpServletRequest req, ModeloForm<ModeloFormTeatros> modeloForm,
      Teatro modelo) {
    modeloForm.getValores().setNombre(texto(modelo.getNombre()));
  }
}
