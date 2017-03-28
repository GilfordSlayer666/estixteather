
package net.ramptors.servlets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <T>
 */
public class ModeloForm<T> {
  private String titulo;
  private String siguienteForm;
  private String error;
  private Map<String, String> violaciones;
  private Map<String, List<Opcion>> opciones = new HashMap<>();
  private T valores;
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public String getSiguienteForm() {
    return siguienteForm;
  }
  public void setSiguienteForm(String siguienteForm) {
    this.siguienteForm = siguienteForm;
  }
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }
  public Map<String, String> getViolaciones() {
    return violaciones;
  }
  public void setViolaciones(Map<String, String> violaciones) {
    this.violaciones = violaciones;
  }
  public Map<String, List<Opcion>> getOpciones() {
    return opciones;
  }
  public void setOpciones(Map<String, List<Opcion>> opciones) {
    this.opciones = opciones;
  }
  public T getValores() {
    return valores;
  }
  public void setValores(T valores) {
    this.valores = valores;
  }
}
