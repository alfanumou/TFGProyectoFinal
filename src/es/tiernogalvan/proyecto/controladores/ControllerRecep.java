/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.SolicitudDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnalitica;
import es.tiernogalvan.proyecto.ui.Recepcion;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import es.tiernogalvan.proyecto.utilidades.CreacionPeticion;
import es.tiernogalvan.proyecto.utilidades.ModeloTabla;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vekto
 */
public class ControllerRecep extends ControllerModelo {

    private Recepcion citas;
    private List<SolicitudAnalitica> sAnalit;
    private SolicitudAnalitica solic;
    private SolicitudDAO soli;

    public ControllerRecep(Recepcion citas, Hospital hospital) {
        super(hospital);
        soli =(SolicitudDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.SOL_DAO);
        this.citas = citas;
    }

    public SolicitudDAO getSoli() {
        return soli;
    }

    //inicia la pantalla de recepcion de solicitudes
    @Override
    public void iniciarPantalla() {
        getCitas().getTablaSolicitudes().getTableHeader().setReorderingAllowed(Constantes.FALSE);
        getCitas().getRecepcion().setEnabled(Constantes.FALSE);
        getCitas().addWindowListener(this);
        cargarTabla();
        cargarCombo();
        getCitas().getRecepcion().addActionListener(this);
        getCitas().getTablaSolicitudes().addMouseListener(this);
        getCitas().setVisible(Constantes.TRUE);

    }

    public Recepcion getCitas() {
        return citas;
    }
    
    //carga un combobox de prioridades
    private void cargarCombo() {
        setDcm(new DefaultComboBoxModel());
        getDcm().addElement(Constantes.PRIORIDADES[Constantes.CERO]);
        getDcm().addElement(Constantes.PRIORIDADES[Constantes.UNO]);
        getDcm().addElement(Constantes.PRIORIDADES[Constantes.DOS]);
        getCitas().getPrioridad().setModel(getDcm());

    }

    //carga la tabla de peticiones
    @Override
    protected void cargarTabla() {
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_RECEP);
        
        List<SolicitudAnalitica> lUni = getSoli().selectAllHospi(getHospital().getIdhosp());
        sAnalit=lUni;
        for (SolicitudAnalitica unidad : lUni) {

            String rowRecep[] = {String.valueOf(unidad.getId().getCodMed()),
                String.valueOf(unidad.getId().getCodUni()),
                String.valueOf(unidad.getId().getNumPa()),
                unidad.getDescripcion()};
            
            this.getDtf().addRow(rowRecep);

        }
        getCitas().getTablaSolicitudes().setModel(getDtf());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Constantes.AC_RECEPCION));
        recepcion();
    }
    
    //asigna la accion de recepcionar una peticion al boton recepcionar
    private void recepcion() {
            CreacionPeticion creaP = new CreacionPeticion(solic,getHospital());
            creaP.crearPdf(getCitas().getPrioridad().getSelectedItem().toString(), getCitas().getObservaciones().getText());
            getCitas().getRecepcion().setEnabled(Constantes.FALSE);
            getCitas().getObservaciones().setText(Constantes.VACIO);
            getCitas().getPrioridad().setSelectedIndex(Constantes.CERO);
    }

    //carga los datos de la peticion seleccionada en la tabla
    @Override
    protected void tocarFila() {
                solic = sAnalit.get(getCitas().getTablaSolicitudes().getSelectedRow());
                getCitas().getRecepcion().setEnabled(true);

            }

   
}
