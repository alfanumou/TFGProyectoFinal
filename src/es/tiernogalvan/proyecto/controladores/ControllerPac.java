/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.controladores;

import es.tiernogalvan.proyecto.datos.persistencia.DAO.GenerDAO;
import es.tiernogalvan.proyecto.datos.persistencia.Factory.FactoryDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.PacienteDAO;
import es.tiernogalvan.proyecto.datos.persistencia.DAO.MedicoDAO;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Hospital;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Medico;
import es.tiernogalvan.proyecto.datos.persistencia.POJO.Paciente;
import es.tiernogalvan.proyecto.ui.Pacientes;
import es.tiernogalvan.proyecto.utilidades.Constantes;
import es.tiernogalvan.proyecto.utilidades.EntradaTecladoListener;
import es.tiernogalvan.proyecto.utilidades.ModeloTabla;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author vekto
 */
public class ControllerPac extends ControllerModelo {

    private Pacientes pacientes;
    private PacienteDAO pac;

    public ControllerPac(Pacientes pacientes, Hospital hospital) {
        super(hospital);
        pac =(PacienteDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.PAC_DAO);
        this.pacientes = pacientes;
    }

    public PacienteDAO getPac() {
        return pac;
    }

    public void setPac(PacienteDAO pac) {
        this.pac = pac;
    }

    //inicia la ventana pacientes
    @Override
    public void iniciarPantalla() {
        getPacientes().getTablaPac().getTableHeader().setReorderingAllowed(Constantes.FALSE);
        cargarTabla();
        getPacientes().addWindowListener(this);
        getPacientes().getCodInser().addKeyListener(new EntradaTecladoListener());
        getPacientes().getInsertar().addActionListener(this);
        getPacientes().getBorrar().addActionListener(this);
        getPacientes().getModificar().addActionListener(this);
        getPacientes().getBuscador().addActionListener(this);
        getPacientes().getTablaPac().addMouseListener(this);
        cargarComboMedicos(getPacientes().getComboMed());
        cargarComboMedicos(getPacientes().getComboMedMod());
        limpiarPantalla();
        pacientes.setVisible(Constantes.TRUE);

    }

    //limpia los datos de la pantalla
    @Override
    protected void limpiarPantalla() {
        getPacientes().getCodInser().setText(Constantes.VACIO);
        getPacientes().getNomInsert().setText(Constantes.VACIO);
        getPacientes().getCodMod().setText(Constantes.CODIGO);
        getPacientes().getCodDel().setText(Constantes.CODIGO);
        getPacientes().getNomModif().setText(Constantes.VACIO);
        getPacientes().getNomDel().setText(Constantes.NOMBRE);
        getPacientes().getCuadroBusq().setText(Constantes.VACIO);

    }

    public Pacientes getPacientes() {
        return this.pacientes;
    }

    //carga la tabla de pacientes
    @Override
    protected void cargarTabla() {
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_PAC);
        List<Paciente> lPac = getPac().selectAllHospi(getHospital().getIdhosp());
        for (Paciente paciente : lPac) {
            String[] rowPac = {String.valueOf(paciente.getNumPa()), paciente.getNombre(), String.valueOf(paciente.getMedico().getCodMed())};
            this.getDtf().addRow(rowPac);
        }
        getPacientes().getTablaPac().setModel(getDtf());
        getPacientes().getTablaPac().setShowGrid(Constantes.FALSE);

    }

    //filtra y carga la tabla de pacientes
    @Override
    protected void buscar() {
        String filtro = getPacientes().getCuadroBusq().getText().toUpperCase();
        setDtf(new ModeloTabla());
        getDtf().setColumnIdentifiers(Constantes.COL_PAC);
        List<Paciente> lPac = getPac().selectAllHospi(getHospital().getIdhosp());
        for (Paciente paciente : lPac) {
            if (paciente.getNombre().contains(filtro) || String.valueOf(paciente.getNumPa()).contains(filtro)) {
                String[] rowPac = {String.valueOf(paciente.getNumPa()), paciente.getNombre(), String.valueOf(paciente.getMedico().getCodMed())};
                this.getDtf().addRow(rowPac);
            }
        }
        getPacientes().getTablaPac().setModel(getDtf());
        getPacientes().getTablaPac().setShowGrid(Constantes.FALSE);

    }

    //carga un combobox de medicos
    private void cargarComboMedicos(JComboBox combo) {
        setDcm(new DefaultComboBoxModel());
        MedicoDAO am = (MedicoDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.MED_DAO);
        List<Medico> lMed = am.selectAllHospi(getHospital().getIdhosp());
        for (Medico medico : lMed) {
            getDcm().addElement(medico.getCodMed());
        }
        combo.setModel(getDcm());

    }

    //inserta un paciente
    @Override
    protected void insertar() {
        String codPa = getPacientes().getCodInser().getText();
        String nomPa = getPacientes().getNomInsert().getText().toUpperCase();
        try{
        String codMedPac = getPacientes().getComboMed().getSelectedItem().toString();
        MedicoDAO am = (MedicoDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.MED_DAO);
        if (!codPa.equals(Constantes.VACIO) && !nomPa.equals(Constantes.VACIO) && !codMedPac.equals(Constantes.VACIO)) {
            Medico medico = am.select(Integer.parseInt(codMedPac));
            Paciente paciente = new Paciente(Integer.parseInt(codPa), medico, nomPa);
            getPac().insert(paciente);
            cargarTabla();
        } else {

            JOptionPane.showMessageDialog(getPacientes(), Constantes.FALTAN_DATOS);

        }}catch(NullPointerException n){
            JOptionPane.showMessageDialog(getPacientes(), Constantes.NO_MED);
        }
        
    }

    //modifica un paciente
    @Override
    protected void modificar() {
        String codPa = getPacientes().getCodMod().getText();
        String nomPa = getPacientes().getNomModif().getText().toUpperCase();
        String codMedPac = getPacientes().getComboMedMod().getSelectedItem().toString();
        MedicoDAO am = (MedicoDAO) FactoryDAO.getFactoryDAO().getDAO(GenerDAO.MED_DAO);
        if (!codPa.equals(Constantes.CODIGO) && !nomPa.equals(Constantes.VACIO) && !codMedPac.equals(Constantes.VACIO)) {
            Medico medico = am.select(Integer.parseInt(codMedPac));
            Paciente paciente = new Paciente(Integer.parseInt(codPa), medico, nomPa);
            getPac().update(paciente);
            cargarTabla();
        } else {

            JOptionPane.showMessageDialog(getPacientes(), Constantes.FALTA_PACIENTE);

        }
        
    }

    //borra un paciente
    @Override
    protected void borrar() {
        String cod = String.valueOf(getPacientes().getCodDel().getText());
        if (!cod.equals(Constantes.CODIGO)) {
            getPac().delete(Integer.parseInt(cod));
            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(getPacientes(), Constantes.FALTA_PACIENTE);
        }

    }

    //carga los datos del paciente seleccionado de la tabla
    @Override
    protected void tocarFila() {
        Paciente paciente = getPac().select(Integer.parseInt(getPacientes().getTablaPac().getValueAt(getPacientes().getTablaPac().getSelectedRow(), Constantes.CERO).toString()));
        getPacientes().getCodDel().setText(String.valueOf(paciente.getNumPa()));
        getPacientes().getCodMod().setText(String.valueOf(paciente.getNumPa()));
        getPacientes().getNomDel().setText((paciente.getNombre()));
        getPacientes().getNomModif().setText(paciente.getNombre());
    }

}
