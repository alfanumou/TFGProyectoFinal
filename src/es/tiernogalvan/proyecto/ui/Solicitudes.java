/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tiernogalvan.proyecto.ui;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author vekto
 */
public class Solicitudes extends javax.swing.JFrame  {

    /**
     * Creates new form Citas
     */
    public Solicitudes() {
        super();
        initComponents();
    }

    public JButton getBuscador() {
        return buscador;
    }

    public void setBuscador(JButton buscador) {
        this.buscador = buscador;
    }

    public JTextField getCajaBusq() {
        return cajaBusq;
    }

    public void setCajaBusq(JTextField cajaBusq) {
        this.cajaBusq = cajaBusq;
    }

    public JButton getBorrar() {
        return borrar;
    }

    public void setBorrar(JButton borrar) {
        this.borrar = borrar;
    }
    

    public JLabel getMeDel() {
        return meDel;
    }

    public void setMeDel(JLabel meDel) {
        this.meDel = meDel;
    }

    public JLabel getPacDel() {
        return pacDel;
    }

    public void setPacDel(JLabel pacDel) {
        this.pacDel = pacDel;
    }

    public JLabel getPacMod() {
        return pacMod;
    }

    public void setPacMod(JLabel pacMod) {
        this.pacMod = pacMod;
    }

    public JLabel getUniDel() {
        return uniDel;
    }

    public void setUniDel(JLabel uniDel) {
        this.uniDel = uniDel;
    }

    public JLabel getUniMod() {
        return uniMod;
    }

    public void setUniMod(JLabel uniMod) {
        this.uniMod = uniMod;
    }

    public JLabel getMedMod() {
        return medMod;
    }

    public void setMedMod(JLabel medMod) {
        this.medMod = medMod;
    }
    
    @Override
    public void setDefaultCloseOperation(int i) {
        super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        citaTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        insertar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mediCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        uniCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        paCombo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        alfa = new javax.swing.JCheckBox();
        hemo = new javax.swing.JCheckBox();
        bq = new javax.swing.JCheckBox();
        soh = new javax.swing.JCheckBox();
        gaso = new javax.swing.JCheckBox();
        coag = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        modificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        alfa1 = new javax.swing.JCheckBox();
        hemo1 = new javax.swing.JCheckBox();
        bq1 = new javax.swing.JCheckBox();
        soh1 = new javax.swing.JCheckBox();
        gaso1 = new javax.swing.JCheckBox();
        coag1 = new javax.swing.JCheckBox();
        uniMod = new javax.swing.JLabel();
        pacMod = new javax.swing.JLabel();
        medMod = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();
        uniDel = new javax.swing.JLabel();
        pacDel = new javax.swing.JLabel();
        meDel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        buscador = new javax.swing.JButton();
        cajaBusq = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        citaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(citaTabla);

        jLabel1.setText("Lista citas analisis clinico");

        insertar.setText("Insertar");

        jLabel2.setText("Medico");

        mediCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Unidad");

        uniCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Paciente");

        paCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Pruebas");

        alfa.setText("Alfa1-anti");

        hemo.setText("HemoBasico");

        bq.setText("BqBasico");

        soh.setText("SOH");
        soh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sohActionPerformed(evt);
            }
        });

        gaso.setText("Gasomet");

        coag.setText("HemosEsp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alfa)
                                    .addComponent(bq)
                                    .addComponent(gaso))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coag)
                                    .addComponent(soh)
                                    .addComponent(hemo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mediCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uniCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(insertar)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mediCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(uniCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(paCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alfa)
                    .addComponent(hemo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bq)
                    .addComponent(soh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaso)
                    .addComponent(coag))
                .addGap(57, 57, 57)
                .addComponent(insertar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Insertar", jPanel2);

        modificar.setText("Modificar");

        jLabel6.setText("Pruebas");

        alfa1.setText("Alfa1-anti");

        hemo1.setText("HemoBasico");

        bq1.setText("BqBasico");

        soh1.setText("SOH");
        soh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soh1ActionPerformed(evt);
            }
        });

        gaso1.setText("Gasomet");

        coag1.setText("HemosEsp");

        uniMod.setText("unidad");

        pacMod.setText("paciente");

        medMod.setText("medico");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alfa1)
                                    .addComponent(bq1)
                                    .addComponent(gaso1))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coag1)
                                    .addComponent(soh1)
                                    .addComponent(hemo1)))
                            .addComponent(jLabel6)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(uniMod)
                                .addGap(18, 18, 18)
                                .addComponent(pacMod)
                                .addGap(18, 18, 18)
                                .addComponent(medMod))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(modificar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uniMod)
                    .addComponent(pacMod)
                    .addComponent(medMod))
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alfa1)
                    .addComponent(hemo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bq1)
                    .addComponent(soh1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gaso1)
                    .addComponent(coag1))
                .addGap(73, 73, 73)
                .addComponent(modificar)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modificar", jPanel4);

        borrar.setText("Borrar");

        uniDel.setText("Unidad");

        pacDel.setText("Paciente");

        meDel.setText("Medico");

        jLabel10.setText("Codigo cita:");

        buscador.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cajaBusq, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscador))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(borrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel10)
                                .addGap(53, 53, 53)
                                .addComponent(uniDel)
                                .addGap(64, 64, 64)
                                .addComponent(pacDel)
                                .addGap(67, 67, 67)
                                .addComponent(meDel)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscador)
                            .addComponent(cajaBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uniDel)
                            .addComponent(pacDel)
                            .addComponent(meDel)
                            .addComponent(jLabel10))
                        .addGap(63, 63, 63)
                        .addComponent(borrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sohActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sohActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sohActionPerformed

    private void soh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soh1ActionPerformed

    public JCheckBox getAlfa() {
        return alfa;
    }

    public JCheckBox getAlfa1() {
        return alfa1;
    }

    public void setAlfa1(JCheckBox alfa1) {
        this.alfa1 = alfa1;
    }

    public JCheckBox getBq1() {
        return bq1;
    }

    public void setBq1(JCheckBox bq1) {
        this.bq1 = bq1;
    }

    public JCheckBox getCoag1() {
        return coag1;
    }

    public void setCoag1(JCheckBox coag1) {
        this.coag1 = coag1;
    }

    public JCheckBox getGaso1() {
        return gaso1;
    }

    public void setGaso1(JCheckBox gaso1) {
        this.gaso1 = gaso1;
    }

    public JCheckBox getHemo1() {
        return hemo1;
    }

    public void setHemo1(JCheckBox hemo1) {
        this.hemo1 = hemo1;
    }

    public JButton getModificar() {
        return modificar;
    }

    public void setModificar(JButton modificar) {
        this.modificar = modificar;
    }

    public JCheckBox getSoh1() {
        return soh1;
    }

    public void setSoh1(JCheckBox soh1) {
        this.soh1 = soh1;
    }

    public void setAlfa(JCheckBox alfa) {
        this.alfa = alfa;
    }

    public JCheckBox getBq() {
        return bq;
    }

    public void setBq(JCheckBox bq) {
        this.bq = bq;
    }

    public JCheckBox getCoag() {
        return coag;
    }

    public void setCoag(JCheckBox coag) {
        this.coag = coag;
    }

    public JCheckBox getGaso() {
        return gaso;
    }

    public void setGaso(JCheckBox gaso) {
        this.gaso = gaso;
    }

    public JCheckBox getHemo() {
        return hemo;
    }

    public void setHemo(JCheckBox hemo) {
        this.hemo = hemo;
    }

    public JComboBox<String> getMediCombo() {
        return mediCombo;
    }

    public void setMediCombo(JComboBox<String> mediCombo) {
        this.mediCombo = mediCombo;
    }

    public JComboBox<String> getPaCombo() {
        return paCombo;
    }

    public void setPaCombo(JComboBox<String> paCombo) {
        this.paCombo = paCombo;
    }

    public JCheckBox getSoh() {
        return soh;
    }

    public void setSoh(JCheckBox soh) {
        this.soh = soh;
    }

    public JComboBox<String> getUniCombo() {
        return uniCombo;
    }

    public void setUniCombo(JComboBox<String> uniCombo) {
        this.uniCombo = uniCombo;
    }

    public JTable getCitaTabla() {
        return citaTabla;
    }

    public void setCitaTabla(JTable citaTabla) {
        this.citaTabla = citaTabla;
    }

    public JButton getInsertar() {
        return insertar;
    }

    public void setInsertar(JButton insertar) {
        this.insertar = insertar;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox alfa;
    private javax.swing.JCheckBox alfa1;
    private javax.swing.JButton borrar;
    private javax.swing.JCheckBox bq;
    private javax.swing.JCheckBox bq1;
    private javax.swing.JButton buscador;
    private javax.swing.JTextField cajaBusq;
    private javax.swing.JTable citaTabla;
    private javax.swing.JCheckBox coag;
    private javax.swing.JCheckBox coag1;
    private javax.swing.JCheckBox gaso;
    private javax.swing.JCheckBox gaso1;
    private javax.swing.JCheckBox hemo;
    private javax.swing.JCheckBox hemo1;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel meDel;
    private javax.swing.JLabel medMod;
    private javax.swing.JComboBox<String> mediCombo;
    private javax.swing.JButton modificar;
    private javax.swing.JComboBox<String> paCombo;
    private javax.swing.JLabel pacDel;
    private javax.swing.JLabel pacMod;
    private javax.swing.JCheckBox soh;
    private javax.swing.JCheckBox soh1;
    private javax.swing.JComboBox<String> uniCombo;
    private javax.swing.JLabel uniDel;
    private javax.swing.JLabel uniMod;
    // End of variables declaration//GEN-END:variables
}
