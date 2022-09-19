/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.MedicoDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.PacienteDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.SolicitudDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.UnidadDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Paciente;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnalitica;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.SolicitudAnaliticaId;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Unidad;
import es.tiernogalvan.proyecto.ui.Solicitudes;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import es.tiernogalvan.proyecto.utilidades.ModeloTabla;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vekto
 */
public class ControllerSolicit extends ControllerModelo {

    private Solicitudes citas;
    private SolicitudDAO soli;

    public ControllerSolicit(Solicitudes citas, Hospital hospital) {
        super(hospital);
        soli =(SolicitudDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.SOL_DAO);
        this.citas = citas;
    }

    public SolicitudDAO getSoli() {
        return soli;
    }

    public void setSoli(SolicitudDAO soli) {
        this.soli = soli;
    }

    //inicia la ventana de solicitudes
    @Override
    public void iniciarPantalla() {
        getCitas().getCitaTabla().getTableHeader().setReorderingAllowed(Constantes.FALSE);
        cargaComboboxMed();
        cargaComboboxPac();
        cargaComboboxUni();
        cargarTabla();
        getCitas().addWindowListener(this);
        getCitas().getInsertar().addActionListener(this);
        getCitas().getModificar().addActionListener(this);
        getCitas().getBorrar().addActionListener(this);
        getCitas().getBuscador().addActionListener(this);
        getCitas().getCitaTabla().addMouseListener(this);
        getCitas().setVisible(Constantes.TRUE);

    }

    public Solicitudes getCitas() {
        return this.citas;
    }

    //carga la tabla de solicitudes
    @Override
    protected void cargarTabla() {
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_SOLIC);
        List<SolicitudAnalitica> lUni = getSoli().selectAllHospi(getHospital().getIdhosp());
        for (SolicitudAnalitica unidad : lUni) {

            String rowMed[] = {String.valueOf(unidad.getId().getCodMed()),
                String.valueOf(unidad.getId().getCodUni()),
                String.valueOf(unidad.getId().getNumPa()),
                unidad.getDescripcion()};
            this.getDtf().addRow(rowMed);

        }
        getCitas().getCitaTabla().setModel(getDtf());
    }

    //filtra y carga la tabla de solicitudes
    @Override
    protected void buscar() {
        String filtro = getCitas().getCajaBusq().getText();
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_SOLIC);
        List<SolicitudAnalitica> lUni = getSoli().selectAllHospi(getHospital().getIdhosp());
        for (SolicitudAnalitica unidad : lUni) {
            if (unidad.getId().toString().contains(filtro) || unidad.getDescripcion().contains(filtro)) {
                String rowMed[] = {String.valueOf(unidad.getId().getCodMed()),
                    String.valueOf(unidad.getId().getCodUni()),
                    String.valueOf(unidad.getId().getNumPa()),
                    unidad.getDescripcion()};
                this.getDtf().addRow(rowMed);
            }

        }
        getCitas().getCitaTabla().setModel(getDtf());
    }

    //devuleve una cadena con los checkbox marcados
    private String devolverChecks() {
        String pruebas = Constantes.VACIO;

        if (getCitas().getAlfa().isSelected()) {
            pruebas += getCitas().getAlfa().getText() + Constantes.COMA;
        }
        if (getCitas().getBq().isSelected()) {
            pruebas += getCitas().getBq().getText() + Constantes.COMA;
        }
        if (getCitas().getCoag().isSelected()) {
            pruebas += getCitas().getCoag().getText() + Constantes.COMA;
        }
        if (getCitas().getGaso().isSelected()) {
            pruebas += getCitas().getGaso().getText() + Constantes.COMA;
        }
        if (getCitas().getSoh().isSelected()) {
            pruebas += getCitas().getSoh().getText() + Constantes.COMA;
        }
        if (getCitas().getHemo().isSelected()) {
            pruebas += getCitas().getHemo().getText() + Constantes.COMA;
        }
        pruebas = pruebas.equals(Constantes.VACIO) ? Constantes.PRUEBA_GENER : pruebas.substring(Constantes.CERO, pruebas.length() - Constantes.UNO);
        return pruebas;
    }

    //devuleve una cadena con los checkbox marcados para modificar
    private String devolverChecksB() {
        String pruebas = Constantes.VACIO;

        if (getCitas().getAlfa1().isSelected()) {
            pruebas += getCitas().getAlfa1().getText() + Constantes.COMA;
        }
        if (getCitas().getBq1().isSelected()) {
            pruebas += getCitas().getBq1().getText() + Constantes.COMA;
        }
        if (getCitas().getCoag1().isSelected()) {
            pruebas += getCitas().getCoag1().getText() + Constantes.COMA;
        }
        if (getCitas().getGaso1().isSelected()) {
            pruebas += getCitas().getGaso1().getText() + Constantes.COMA;
        }
        if (getCitas().getSoh1().isSelected()) {
            pruebas += getCitas().getSoh1().getText() + Constantes.COMA;
        }
        if (getCitas().getHemo1().isSelected()) {
            pruebas += getCitas().getHemo1().getText() + Constantes.COMA;
        }
        pruebas = pruebas.equals(Constantes.VACIO) ? Constantes.PRUEBA_GENER : pruebas.substring(Constantes.CERO, pruebas.length() - Constantes.UNO);
        return pruebas;
    }

    //carga combobox de medicos
    private void cargaComboboxMed() {
        MedicoDAO am = (MedicoDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.MED_DAO);
        List<Medico> listaM = am.selectAllHospi(getHospital().getIdhosp());
        setDcm(new DefaultComboBoxModel());
        for (Medico medico : listaM) {
            getDcm().addElement(medico.getCodMed());
        }
        getCitas().getMediCombo().setModel(getDcm());

    }

    //carga combobox de unidades
    private void cargaComboboxUni() {
        UnidadDAO au =  (UnidadDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.UNI_DAO);
        List<Unidad> listaU = au.selectAllHospi(getHospital().getIdhosp());
        setDcm(new DefaultComboBoxModel());
        for (Unidad unidad : listaU) {
            getDcm().addElement(unidad.getCodUni());
        }
        getCitas().getUniCombo().setModel(getDcm());

    }

    //carga combobox de pacientes
    private void cargaComboboxPac() {
        PacienteDAO ap = (PacienteDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.PAC_DAO);
        List<Paciente> listaU = ap.selectAllHospi(getHospital().getIdhosp());
        setDcm(new DefaultComboBoxModel());
        for (Paciente paciente : listaU) {
            getDcm().addElement(paciente.getNumPa());
        }
        getCitas().getPaCombo().setModel(getDcm());

    }

    //comprueba los checkboxs seleccionados
    private void comprobarChecks(String descrip) {
        String pruebas[] = descrip.split(Constantes.COMA);
        for (int i = 0; i < pruebas.length; i++) {
            if (pruebas[i].equals(getCitas().getAlfa1().getText())) {
                getCitas().getAlfa1().setSelected(Constantes.TRUE);

            }
            if (pruebas[i].equals(getCitas().getCoag1().getText())) {
                getCitas().getCoag1().setSelected(Constantes.TRUE);

            }
            if (pruebas[i].equals(getCitas().getBq1().getText())) {
                getCitas().getBq1().setSelected(Constantes.TRUE);

            }
            if (pruebas[i].equals(getCitas().getHemo1().getText())) {
                getCitas().getHemo1().setSelected(Constantes.TRUE);

            }
            if (pruebas[i].equals(getCitas().getGaso1().getText())) {
                getCitas().getGaso1().setSelected(Constantes.TRUE);

            }
            if (pruebas[i].equals(getCitas().getSoh1().getText())) {
                getCitas().getSoh1().setSelected(Constantes.TRUE);

            }

        }
    }

    //inserta una solicitud
    @Override
    protected void insertar() {
        try {

            String codMed = String.valueOf(getCitas().getMediCombo().getSelectedItem().toString());
            String codUni = String.valueOf(getCitas().getUniCombo().getSelectedItem().toString());
            String codPac = String.valueOf(getCitas().getPaCombo().getSelectedItem().toString());
            String descrip = devolverChecks();
            SolicitudAnaliticaId sId = new SolicitudAnaliticaId(Integer.parseInt(codUni), Integer.parseInt(codPac), Integer.parseInt(codMed));
            SolicitudAnalitica solic = new SolicitudAnalitica(sId, descrip);
            getSoli().insert(solic);
            cargarTabla();

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(getCitas(), Constantes.FALTAN_DATOS);
        } catch (javax.persistence.PersistenceException e) {
            JOptionPane.showMessageDialog(getCitas(), Constantes.CLAVE_EXISTE);
        }

    }

    //modifica una solicitud
    @Override
    protected void modificar() {
        try {
            SolicitudAnaliticaId sId = new SolicitudAnaliticaId(Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.UNO).toString()),
                    Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.DOS).toString()),
                    Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.CERO).toString()));
            String descrip = devolverChecksB();
            SolicitudAnalitica sa = new SolicitudAnalitica(sId, descrip);
            getSoli().update(sa);
            cargarTabla();
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(getCitas(), Constantes.FALTA_SOLICITUD);

        }

    }

    //borra una solicitud
    @Override
    protected void borrar() {
        try {
            SolicitudAnaliticaId sId = new SolicitudAnaliticaId(Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.UNO).toString()),
                    Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.DOS).toString()),
                    Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.CERO).toString()));
            getSoli().delete(sId);
            cargarTabla();
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(getCitas(), Constantes.FALTA_SOLICITUD);

        }

    }

    //limpia la pantalla de solicitud
    @Override
    protected void limpiarPantalla() {
        getCitas().getUniMod().setText(Constantes.UNIDAD);
        getCitas().getPacMod().setText(Constantes.PACIENTE);
        getCitas().getMedMod().setText(Constantes.MEDICO);
        getCitas().getUniDel().setText(Constantes.UNIDAD);
        getCitas().getPacDel().setText(Constantes.PACIENTE);
        getCitas().getMeDel().setText(Constantes.MEDICO);
        getCitas().getAlfa1().setSelected(Constantes.FALSE);
        getCitas().getAlfa().setSelected(Constantes.FALSE);
        getCitas().getBq().setSelected(Constantes.FALSE);
        getCitas().getBq1().setSelected(Constantes.FALSE);
        getCitas().getCoag().setSelected(Constantes.FALSE);
        getCitas().getCoag1().setSelected(Constantes.FALSE);
        getCitas().getSoh().setSelected(Constantes.FALSE);
        getCitas().getSoh1().setSelected(Constantes.FALSE);
        getCitas().getHemo().setSelected(Constantes.FALSE);
        getCitas().getHemo1().setSelected(Constantes.FALSE);
        getCitas().getGaso().setSelected(Constantes.FALSE);
        getCitas().getGaso1().setSelected(Constantes.FALSE);
        getCitas().getCajaBusq().setText(Constantes.VACIO);

    }

    //carga los datos de la solicitud seleccionada en la tabla
    @Override
    protected void tocarFila() {

                limpiarPantalla();
                SolicitudAnaliticaId sId = new SolicitudAnaliticaId(Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.UNO).toString()),
                        Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.DOS).toString()),
                        Integer.parseInt(getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.CERO).toString()));
                String descrip = getCitas().getCitaTabla().getValueAt(getCitas().getCitaTabla().getSelectedRow(), Constantes.TRES).toString();
                comprobarChecks(descrip);
                getCitas().getUniMod().setText(String.valueOf(sId.getCodUni()));
                getCitas().getPacMod().setText(String.valueOf(sId.getNumPa()));
                getCitas().getMedMod().setText(String.valueOf(sId.getCodMed()));
                getCitas().getUniDel().setText(String.valueOf(sId.getCodUni()));
                getCitas().getPacDel().setText(String.valueOf(sId.getNumPa()));
                getCitas().getMeDel().setText(String.valueOf(sId.getCodMed()));

            }



}
