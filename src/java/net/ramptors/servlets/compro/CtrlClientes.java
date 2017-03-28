///*
// * Copyright 2016 Gilberto Pacheco Gallegos.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package net.ramptors.servlets.compro;
//
//import javax.persistence.EntityManager;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import net.ramptors.servlets.Opcion;
//import net.ramptors.servlets.Renglon;
//import static net.ramptors.jee.UtilJee.format;
//import net.ramptors.jee.compro.entidad.Cliente;
//import static net.ramptors.jee.UtilJee.getFormatoFecha;
//import static net.ramptors.jee.UtilJee.getFormatoHora;
//import static net.ramptors.jee.UtilJee.isNullOrEmpty;
//import static net.ramptors.jee.UtilJee.parseFechaWeb;
//import static net.ramptors.jee.UtilJee.parseHoraWeb;
//import static net.ramptors.servlets.compro.CtrlInicio.CLIENTE;
//import net.ramptors.jee.compro.entidad.Usuario;
//import net.ramptors.jee.compro.entidad.Venta;
//import net.ramptors.servlets.CtrlAbc;
//import net.ramptors.servlets.ModeloForm;
//import static net.ramptors.servlets.UtilServlets.getId;
//import static net.ramptors.servlets.UtilServlets.getOpciones;
//import net.ramptors.servlets.compro.form.ModeloFormClientes;
//import static net.ramptors.servlets.UtilServlets.buscaId;
//
///**
// *
// * @author Gilberto Pacheco Gallegos
// */
//@WebServlet(name = "CtrlClientes", urlPatterns = "ctrlClientes")
//public class CtrlClientes extends CtrlAbc<Cliente, String, ModeloFormClientes> {
//  public CtrlClientes() {
//    super(Cliente.FILTRO, Cliente.class, String.class,
//        ModeloFormClientes.class, "Clientes", "Cliente Nuevo");
//  }
//  @Override
//  protected Renglon getRenglon(HttpServletRequest req, Cliente modelo) {
//    return new Renglon(modelo.getId(), modelo.getId(),
//        modelo.getUsuario().getNombre());
//  }
//  @Override protected String getTituloDeModelo(Cliente modelo) {
//    return modelo.getId();
//  }
//  @Override protected void llenaModelo(EntityManager em,
//      ModeloForm<ModeloFormClientes> modeloForm, Cliente modelo) {
//    final ModeloFormClientes valores = modeloForm.getValores();
//    final String usuario = valores.getUsuario();
//    if (isNuevo(modeloForm) && isNullOrEmpty(usuario)) {
//      throw new RuntimeException("Falta seleccionar el usuario.");
//    }
//    if (isNuevo(modeloForm)) {
//      final Venta venta = new Venta();
//      venta.setCliente(modelo);
//      modelo.setVentaActual(venta);
//      modelo.setUsuario(buscaId(em, Usuario.class, String.class, usuario));
//    }
//    modelo.setNacimiento(parseFechaWeb(valores.getNacimiento(),
//        "Formato incorrecto para Nacimiento."));
//    modelo.setHoraFavorita(parseHoraWeb(valores.getHoraFavorita(),
//        "Formato incorrecto para Hora Favorita."));
//  }
//  @Override protected void muestraModelo(EntityManager em,
//      HttpServletRequest req, ModeloForm<ModeloFormClientes> modeloForm,
//      Cliente modelo) {
//    final ModeloFormClientes valores = modeloForm.getValores();
//    valores.setNacimiento(format(getFormatoFecha(), modelo.getNacimiento()));
//    valores.
//        setHoraFavorita(format(getFormatoHora(), modelo.getHoraFavorita()));
//    valores.setUsuario(getId(modelo.getUsuario()));
//  }
//  @Override protected void muestraOpciones(EntityManager em,
//      HttpServletRequest req, ModeloForm<ModeloFormClientes> modeloForm) {
//    modeloForm.getOpciones().put("usuario", getOpciones(
//        "-- Selecciona Usuario --",
//        em.createNamedQuery("Usuario.PARA_ROL", Usuario.class).
//            setParameter("rol", CLIENTE).getResultList(),
//        u -> new Opcion(u.getId(), u.getId() + ": " + u.getNombre())));
//  }
//}
