package net.ramptors.jee.compro.entidad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import static jee.UtilJee.toUpperCase;
import jee.Entidad;


@Entity
@Table(name = "USUARIO")
@NamedQueries({
  @NamedQuery(name = Usuario.FILTRO, query
      = "SELECT u "
      + "FROM Usuario u "
      + "WHERE u.upperId LIKE :filtro OR UPPER(u.nombre) LIKE :filtro "
      + "ORDER BY u.upperId"),
  @NamedQuery(name = "Usuario.PARA_ROL", query
      = "SELECT u "
      + "FROM Usuario u JOIN u.roles r "
      + "WHERE r.id = :rol "
      + "ORDER BY u.upperId")
})
public class Usuario extends Entidad<String> {
  private static final long serialVersionUID = 1L;
  public static final String FILTRO = "Usuario.FILTRO";
  @Id
  @Basic(optional = false)
  @NotNull
  @Pattern(regexp = "\\w{5,16}")
  @Column(name = "USU_ID")
  private String id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "USU_CONTRA")
  private String contrasena;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "USU_NOMBRE")
  private String nombre;
  @JoinTable(name = "USUARIO_ROL", joinColumns
      = {@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")},
      inverseJoinColumns
      = {@JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<Rol> roles = new ArrayList<>();
  @Version
  private Integer version;
  @Size(max = 255)
  @Column(name = "UPPER_ID")
  private String upperId;
  @Override public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getContrasena() {
    return contrasena;
  }
  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public List<Rol> getRoles() {
    return roles;
  }
  public void setRoles(List<Rol> roles) {
    this.roles = roles;
  }
  @PrePersist @PreUpdate private void antesDeGuardar() {
    upperId = toUpperCase(getId());
  }
}
