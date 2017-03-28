package net.ramptors.jee.compro.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Horario.class)
public abstract class Horario_ {

	public static volatile SingularAttribute<Horario, Date> horarioT;
	public static volatile SingularAttribute<Horario, Date> horarioI;
	public static volatile SingularAttribute<Horario, BigDecimal> costo;
	public static volatile SingularAttribute<Horario, Long> id;
	public static volatile SingularAttribute<Horario, String> upperDia;
	public static volatile SingularAttribute<Horario, String> dia;
	public static volatile SingularAttribute<Horario, Integer> version;

}

