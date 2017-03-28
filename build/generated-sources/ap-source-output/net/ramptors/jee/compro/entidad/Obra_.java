package net.ramptors.jee.compro.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jee.Archivo;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Obra.class)
public abstract class Obra_ {

	public static volatile SingularAttribute<Obra, String> direccionDeEntrega;
	public static volatile SingularAttribute<Obra, String> upperNombre;
	public static volatile SingularAttribute<Obra, Archivo> imagen;
	public static volatile SingularAttribute<Obra, Long> id;
	public static volatile SingularAttribute<Obra, String> nombre;
	public static volatile SingularAttribute<Obra, Integer> version;

}

