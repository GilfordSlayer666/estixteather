package net.ramptors.jee.compro.entidad;

import jee.Archivo;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static jee.UtilJee.toUpperCase;
import jee.Entidad;

/**
 *
 * @author JorgeVargas
 */
@Entity
@Table(name = "HORARIO")
@NamedQuery(name = Horario.FILTRO, query
    = "SELECT h "
    + "FROM Horario h "
    + "WHERE h.upperDia LIKE :filtro "
    + "ORDER BY h.upperDia")
public class Horario extends Entidad<Long> {

  private static final long serialVersionUID = 1L;
  public static final String FILTRO = "Horario.FILTRO";
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "HORARIO_ID")
  private Long id;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "HORARIO_INICIO")
  private Date horarioI;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "HORARIO_TERMINO")
  private Date horarioT; 
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "DIA")
  private String dia; 
  
  @Basic(optional = false)
  @NotNull @Digits(integer = 11, fraction = 2)
  @Column(name = "COSTO_BOLETO")
  private BigDecimal costo;
  
  @Version
  @Column(name = "VERSION")
  private Integer version;
  
  @Size(max = 255)
  @Column(name = "UPPER_DIA")
  private String upperDia;
  
   @Override public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

    public Date getHorarioI() {
        return horarioI;
    }

    public void setHorarioI(Date horarioI) {
        this.horarioI = horarioI;
    }

    public Date getHorarioT() {
        return horarioT;
    }

    public void setHorarioT(Date horarioT) {
        this.horarioT = horarioT;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

//    public Horario(Date horarioI, Date horarioT, String dia, BigDecimal costo) {
//        this.horarioI = horarioI;
//        this.horarioT = horarioT;
//        this.dia = dia;
//        this.costo = costo;
//    }
//  
//  public Horario(){
//      
//  }
  
  @PrePersist @PreUpdate private void antesDeGuardar() {
    upperDia = toUpperCase(getDia());
  }
}
