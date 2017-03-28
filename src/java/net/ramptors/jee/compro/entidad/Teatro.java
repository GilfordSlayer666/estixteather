package net.ramptors.jee.compro.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "TEATRO")
@NamedQueries({
  @NamedQuery(name = "Teatro.TODAS", query
      = "SELECT c FROM Teatro c ORDER BY c.upperNombre"),
  @NamedQuery(name = Teatro.FILTRO, query
      = "SELECT c "
      + "FROM Teatro c "
      + "WHERE c.upperNombre LIKE :filtro "
      + "ORDER BY c.upperNombre")})
public class Teatro extends Entidad<Long> {
  private static final long serialVersionUID = 1L;
  public static final String FILTRO = "Teatro.FILTRO";
  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TEATRO_ID")
  private Long id;
  @NotNull
  @Size(min = 1, max = 255)
  @Basic(optional = false)
  @Column(name = "NOMBRE_TEATRO")
  private String nombre;
  @Version
  @Column(name = "VERSION")
  private Integer version;
  @Column(name = "UPPER_NOMBRE")
  private String upperNombre;
  public Teatro() {
  }
  public Teatro(String nombre) {
    this.nombre = nombre;
  }
  @Override public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  @PrePersist @PreUpdate private void antesDeGuardar() {
    upperNombre = toUpperCase(getNombre());
  }
}
