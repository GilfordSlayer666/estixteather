package net.ramptors.jee.compro.entidad;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Usuario> usuario;
	public static volatile SingularAttribute<Cliente, String> id;
	public static volatile SingularAttribute<Cliente, String> upperId;
	public static volatile SingularAttribute<Cliente, Date> horaFavorita;
	public static volatile SingularAttribute<Cliente, Integer> version;
	public static volatile SingularAttribute<Cliente, Date> nacimiento;

}

