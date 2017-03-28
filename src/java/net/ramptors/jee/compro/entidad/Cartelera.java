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
@Table(name = "CARTELERA")
@NamedQuery(name = Cartelera.FILTRO, query
    = "SELECT c "
    + "FROM Cartelera c "
    + "WHERE c.upperFecha LIKE :filtro "
    + "ORDER BY c.upperFecha")
public class Cartelera extends Entidad<Long>  {
  private static final long serialVersionUID = 1L;
  public static final String FILTRO = "Cartelera.FILTRO";
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "CARTELERA_ID")
  private Long id;
  
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "FECHA_INICIO")
  private String fechaI; 
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "FECHA_TERMINO")
  private Date fechaT; 
    
  @Basic(optional = false)
  @NotNull
  @Column(name = "HORARIO_INICIO")
  private Date horarioI;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "HORARIO_TERMINO")
  private Date horarioT;
  
  @Basic(optional = false)
  @NotNull @Digits(integer = 11, fraction = 2)
  @Column(name = "COSTO_BOLETO")
  private BigDecimal costo;
  
  @NotNull
  @JoinColumn(name = "OBRA_ID", referencedColumnName = "OBRA_ID")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Obra obra;
   
  @NotNull
  @JoinColumn(name = "TEATRO_ID", referencedColumnName = "TEATRO_ID")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Teatro teatro;
  
  @JoinColumn(name = "IMAGEN_ID", referencedColumnName = "ARCH_ID")
  @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Archivo imagen;
   
  
  @Size(max = 255)
  @Column(name = "UPPER_FECHA")
  private String upperFecha;
   
  @Version
  @Column(name = "VERSION")
  private Integer version;
  
  
  @Override public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaT() {
        return fechaT;
    }

    public void setFechaT(Date fechaT) {
        this.fechaT = fechaT;
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

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Archivo getImagen() {
        return imagen;
    }

    public void setImagen(Archivo imagen) {
        this.imagen = imagen;
    }
    
    

    @PrePersist @PreUpdate private void antesDeGuardar() {
    upperFecha = toUpperCase(getFechaI());
    }
    
}
