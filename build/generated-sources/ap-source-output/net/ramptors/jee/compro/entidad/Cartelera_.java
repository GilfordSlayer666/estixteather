package net.ramptors.jee.compro.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jee.Archivo;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cartelera.class)
public abstract class Cartelera_ {

	public static volatile SingularAttribute<Cartelera, String> fechaI;
	public static volatile SingularAttribute<Cartelera, Date> horarioT;
	public static volatile SingularAttribute<Cartelera, Obra> obra;
	public static volatile SingularAttribute<Cartelera, Date> horarioI;
	public static volatile SingularAttribute<Cartelera, BigDecimal> costo;
	public static volatile SingularAttribute<Cartelera, String> upperFecha;
	public static volatile SingularAttribute<Cartelera, Archivo> imagen;
	public static volatile SingularAttribute<Cartelera, Long> id;
	public static volatile SingularAttribute<Cartelera, Date> fechaT;
	public static volatile SingularAttribute<Cartelera, Integer> version;
	public static volatile SingularAttribute<Cartelera, Teatro> teatro;

}

