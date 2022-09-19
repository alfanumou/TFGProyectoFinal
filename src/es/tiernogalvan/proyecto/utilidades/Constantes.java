/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.utilidades;

/**
 *
 * @author vekto
 */
public interface Constantes {
    //Constantes numéricas
    public final static int CERO=0;
    public final static int UNO=1;
    public final static int DOS=2;
    public final static int TRES=3;
    
    //Constantes booleanas
    public final static boolean TRUE=true;
    public final static boolean FALSE=false;
    
    //mensajes de error y textos
    public final static String VACIO="";
    public final static String FALTAN_DATOS="Faltan datos";
    public final static String NO_DATA="No se puede conectar con la base de datos";
    public final static String CLAVE_EXISTE="Clave ya existente, introduce otra o modifica los datos asociados";
    public final static String FALTA_MEDICO="Selecciona un medico";
    public final static String FALTA_UNIDAD="Selecciona una unidad";
    public final static String FALTA_PACIENTE="Selecciona un paciente";
    public final static String FALTA_SOLICITUD="Selecciona una solicitud";
    public final static String CODIGO="Codigo";
    public final static String NOMBRE="Nombre";
    public final static String COMA=",";
    public final static String UNIDAD="Unidad";
    public final static String MEDICO="Medico";
    public final static String PACIENTE="Paciente";
    public final static String PRUEBA_GENER="A VALORACIÓN DEL FACULTATIVO";
    public final static String NO_MED="No hay medicos registrados, registra un medico.";
    
    //Títulos de columnas y combobox
    public final static String[] COL_PAC={"CODIGO","NOMBRE","MEDICO"};
    public final static String[] COL_MED={"CODIGO", "NOMBRE", "ESPECIALIDAD", "JEFE"};
    public final static String[] COL_UNI={"CODIGO","NOMBRE"};
    public final static String[] COL_SOLIC={"MEDICO","UNIDAD","PACIENTE","PRUEBAS"};
    public final static String[] COL_RECEP={"MEDICO","UNIDAD","PACIENTE","PRUEBAS"};
    public final static String[] PRIORIDADES={"NORMAL","URGENTE","PREFERENTE"};
    
    
    //sentencias HQL
    public final static String FROM_HOSPITAL="from Hospital h";
    
    public static final String FROM_MEDICO="from Medico m";
    public static final String FROM_MEDICO_HOSPITAL="from Medico m where m.hospital.idhosp=";
    public static final String DEL_MEDICO="delete from Medico m where m.codMed=";
    public static final String UPD_ALL_MED_JEFE="update Medico m  set m.medico.codMed=";
    public static final String UPD_ALL_MED_WHERE="where m.medico.codMed=";
    public static final String UPD_ALL_MED_PAC="update Paciente p  set p.medico.codMed=";
    public static final String UPD_ALL_MED_PAC_WHERE=" where p.medico.codMed=";
    
    public final static String FROM_PACIENTE="from Paciente p";
    public static final String FROM_PACIENTE_HOSP="from Paciente p where p.medico.hospital.idhosp=";
    public static final String DEL_PACIENTE="delete from Paciente p where p.numPa=";
    
    public static final String FROM_SOLICITUD="from SolicitudAnalitica c";
    public static final String FROM_SOLICITUD_HOSP="from SolicitudAnalitica c where c.medico.hospital.idhosp=";
    public static final String DEL_SOLICITUD_1="delete from SolicitudAnalitica c where c.unidad.codUni=";
    public static final String DEL_SOLICITUD_2=" and c.paciente.numPa=";
    public static final String DEL_SOLICITUD_3=" and c.medico.codMed=";
    
    public static final String FROM_UNIDAD="from Unidad u";
    public static final String FROM_UNIDAD_HOSP="from Unidad u where u.hospital.idhosp=";
    public static final String DEL_UNIDAD="delete from Unidad u where u.codUni=";
    
    
    //peticion modelo
    public final static String HOSPITAL_SOLI = "Hospital: ";
    public final static String TELEFONO_SOLI = "Telefono: ";
    public final static String CIUDAD_SOLI = "Ciudad: ";
    public final static String MEDICO_SOLI = "Medico: ";
    public final static String UNIDAD_PET = "Unidad peticionaria: ";
    public final static String PACIENTE_SOLI = "Paciente: ";
    public final static String PRUEBAS = "Pruebas solicitadas: ";
    public final static String PRIORIDAD_SOLI = "Prioridad: ";
    public final static String OBSERVACIONES = "Observaciones: ";
    public final static String USER = "user.home";
    public final static String BARRA = "/";
    public final static String PDF = ".pdf";
    
    //ACommands
    public static final String AC_INSERT="Insertar";
    public static final String AC_BORRAR="Borrar";
    public static final String AC_MODIFICAR="Modificar";
    public static final String AC_BUSCAR="Buscar";
    public static final String AC_RECEPCION="Recepcionar";
    
    //Atributos POJOs
    public static final String ATT_IDHOSP="idhosp";
    public static final String ATT_CODMED="codMed";
    public static final String ATT_MEDICO="medico";
    public static final String ATT_NUMPA="numPa";
    public static final String ATT_ID="Id";
    public static final String ATT_CODUNI="codUni";
    public static final String ATT_HOSPITAL="hospital";
}
