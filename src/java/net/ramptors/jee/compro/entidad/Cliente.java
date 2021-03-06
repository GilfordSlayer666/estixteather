/*
 * Copyright 2017 Jorge Vargas.

 */
package net.ramptors.jee.compro.entidad;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import jee.Entidad;
import static jee.UtilJee.toUpperCase;

/**
 *
 * @author Jorge Vargas
 */
@Entity
@Table(name = "CLIENTE")
@NamedQuery(name = Cliente.FILTRO, query
    = "SELECT c "
    + "FROM Cliente c JOIN c.usuario u "
    + "WHERE c.upperId LIKE :filtro OR UPPER(u.nombre) LIKE :filtro "
    + "ORDER BY c.upperId")
public class Cliente extends Entidad<String> {
  private static final long serialVersionUID = 1L;
  public static final String FILTRO = "Cliente.FILTRO";
  @Id
  @NotNull
  @Basic(optional = false)
  @Size(min = 1, max = 16)
  @Column(name = "USU_ID")
  private String id;
  @NotNull
  @Past
  @Basic(optional = false)
  @Column(name = "CLI_NACIMIENTO")
  @Temporal(TemporalType.TIMESTAMP)
  private Date nacimiento;
  @NotNull
  @Basic(optional = false)
  @Column(name = "CLI_HORA_FAV")
  @Temporal(TemporalType.TIMESTAMP)
  private Date horaFavorita;
  
  @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID", insertable
      = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.EAGER)
  
  private Usuario usuario;
  @JoinColumn(name = "VNT_ACT_ID", referencedColumnName = "VNT_ID")
  
  @Version
  @Column(name = "VERSION")
  private Integer version;
  @Column(name = "UPPER_ID")
  private String upperId;
  
  @Override public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Date getNacimiento() {
    return nacimiento;
  }
  public void setNacimiento(Date nacimiento) {
    this.nacimiento = nacimiento;
  }
  public Date getHoraFavorita() {
    return horaFavorita;
  }
  public void setHoraFavorita(Date horaFavorita) {
    this.horaFavorita = horaFavorita;
  }
  public Usuario getUsuario() {
    return usuario;
  }
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @PrePersist @PreUpdate private void antesDeGuardar() {
    upperId = toUpperCase(getId());
    if (getUsuario() != null) {
      setId(getUsuario().getId());
    }
  }
}
