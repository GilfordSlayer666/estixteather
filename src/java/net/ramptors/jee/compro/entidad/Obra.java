
package net.ramptors.jee.compro.entidad;

import jee.Archivo;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static jee.UtilJee.toUpperCase;
import jee.Entidad;

@Entity
@Table(name = "OBRA")
@NamedQueries({
    @NamedQuery(name = "Obra.TODAS", query
          = "SELECT o FROM Obra o ORDER BY o.upperNombre"),
    @NamedQuery(name = Obra.FILTRO, query
        = "SELECT o "
        + "FROM Obra o "
        + "WHERE o.upperNombre LIKE :filtro "
        + "ORDER BY o.upperNombre")})
public class Obra extends Entidad<Long>{

  private static final long serialVersionUID = 1L;
  public static final String FILTRO = "Obra.FILTRO";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "OBRA_ID")
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "NOMBRE_OBRA")
  private String nombre;
  @Basic(optional = false)
  @Size(min = 1, max = 255)
  @Column(name = "SINOPSIS")
  private String direccionDeEntrega;

  @JoinColumn(name = "IMAGEN_ID", referencedColumnName = "ARCH_ID")
  @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Archivo imagen;

  @Version
  @Column(name = "VERSION")
  private Integer version;
  @Size(max = 255)
  @Column(name = "UPPER_NOMBRE")
  private String upperNombre;
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
  public String getDireccionDeEntrega() {
    return direccionDeEntrega;
  }
  public void setDireccionDeEntrega(String direccionDeEntrega) {
    this.direccionDeEntrega = direccionDeEntrega;
  }
  public Archivo getImagen() {
    return imagen;
  }
  public void setImagen(Archivo imagen) {
    this.imagen = imagen;
  }

  @PrePersist @PreUpdate private void antesDeGuardar() {
    upperNombre = toUpperCase(getNombre());
  }
}
   

