
package net.ramptors.jee.compro.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static jee.UtilJee.toUpperCase;
import jee.Entidad;


@Entity
@Table(name = "ROL")
@NamedQueries({
  @NamedQuery(name = Rol.TODOS, query
      = "SELECT r FROM Rol r ORDER BY r.upperId")})
public class Rol extends Entidad<String> {
  private static final long serialVersionUID = 1L;
  public static final String TODOS = "Rol.TODOS";
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "ROL_ID")
  private String id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "ROL_DESCRIPCION")
  private String descripcion;
  @Version
  private Integer version;
  @Size(max = 255)
  @Column(name = "UPPER_ID")
  private String upperId;
  public Rol() {
  }
  public Rol(String id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }
  @Override public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  @PrePersist @PreUpdate private void antesDeGuardar() {
    upperId = toUpperCase(getId());
  }
}
