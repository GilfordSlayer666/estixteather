package net.ramptors.servlets.compro;

import java.util.HashMap;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import jee.ReemplazoDeMensajes;
//import net.ramptors.servlets.compro.form.ModeloFormCarteleras ;
//import static jee.UtilJee.getFormatoPrecio;
//import static jee.UtilJee.format;

/** Indica como crear una instancia de Entity Manager. */
@Dependent
public class Configuracion {
  private static final HashMap<String, String> REEMPLAZO_DE_MENSAJES
      = new HashMap<>();
  static {
    REEMPLAZO_DE_MENSAJES.put("PRIMARY", "El identificador ya existe.");
    REEMPLAZO_DE_MENSAJES.put("TEA_PK", "El id del teatro ya existe.");
    REEMPLAZO_DE_MENSAJES.put("TEA_NOUN", "El nombre del teatro ya existe.");
    REEMPLAZO_DE_MENSAJES.put("TEA_NOCH", "Falta el nombre del teatro.");
    REEMPLAZO_DE_MENSAJES.put("USU_PK",
        "El identificador de usuario ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("USU_IDCH",
        "El identificador de usuario no puede tener menos de 5 caracteres.");
    REEMPLAZO_DE_MENSAJES.put("USU_COCH", "Falta la contraseña del usuario.");
    REEMPLAZO_DE_MENSAJES.put("USU_NOCH", "Falta el nombre del usuario.");
    REEMPLAZO_DE_MENSAJES.put("DIS_ID",
        "El identificador de dispositivo ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("DIS_USU",
        "El dispositivo debe apuntar a una usuario válido.");
    REEMPLAZO_DE_MENSAJES.put("ROL_PK",
        "El identificador del rol ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("UR_PK",
        "La combinación de usuario y rol ya está registrada.");
    REEMPLAZO_DE_MENSAJES.put("UR_USU",
        "La combinación de usuario y rol debe apuntar a un usuario válido.");
    REEMPLAZO_DE_MENSAJES.put("UR_ROL",
        "La combinación de usuario y rol debe apuntar a un rol válido.");
    REEMPLAZO_DE_MENSAJES.put("CLI_PK",
        "El identificador del cliente ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("CLI_VAUN",
        "La venta actual del cliente ya está registrada.");
    REEMPLAZO_DE_MENSAJES.put("CLI_USU",
        "El cliente debe apuntar a un usuario válido.");
    REEMPLAZO_DE_MENSAJES.put("ARC_PK",
        "El identificador del archivo ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("OBRA_PK",
        "El identificador de la obra  ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("OBRA_NOCH",
        "El nombre de la obra no puede estar en blanco.");
    REEMPLAZO_DE_MENSAJES.put("OBRA_NOUN",
        "El nombre de la obra ya está registrado.");
    REEMPLAZO_DE_MENSAJES.put("OBRA_IMUN",
        "La imagen de la obra ya está registrada.");
    REEMPLAZO_DE_MENSAJES.put("OBRA_IMG",
        "La obra debe apuntar a una imagen válida.");
//        String COSTO_CK="";
//   REEMPLAZO_DE_MENSAJES.put(COSTO_CK,"El costo del boleto no es valido debe estar entre 100 y 9999.");
//  }
//  public String costo (ModeloFormCarteleras car, String COSTO_CK){
//      double costo = Double.parseDouble(car.getCosto()); 
//     if (costo>199 && costo<9999){
//         System.out.print("Bien");
//     } else{
//         COSTO_CK="El costo del boleto no es valido debe estar entre 100 y 9999.";
//     }
//     return COSTO_CK;
 }
  
  @Produces @PersistenceUnit EntityManagerFactory emf;
  @Produces @ReemplazoDeMensajes
  public HashMap<String, String> getREEMPLAZO_DE_MENSAJES() {
    return REEMPLAZO_DE_MENSAJES;
  }
}
