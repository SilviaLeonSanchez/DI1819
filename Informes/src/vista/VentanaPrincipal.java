/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datasources.CarrerasDataSource;
import dto.Carrera;
import dto.Corredor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaNegocio.Logica;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author silvia
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Logica logica;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.logica = new Logica();
        inicializarButtonGroup();
        inicializarComboBox();
    }

    private void inicializarButtonGroup() {
        this.buttonGroup.add(this.jRadioButtonCarrerasSinFinalizar);
        this.buttonGroup.add(this.jRadioButtonCarrera);
        this.buttonGroup.add(this.jRadioButtonCarreraFinalizada);
        this.buttonGroup.add(this.jRadioButtonCorredor);
        this.buttonGroup.setSelected(this.jRadioButtonCarrerasSinFinalizar.getModel(), true);
    }

    private void inicializarComboBox() {
        for (Carrera c : logica.getCarreras()) {
            this.jComboBoxIdCarrera.addItem(c.getId());
        }
        this.jComboBoxIdCarrera.setSelectedIndex(0);

        for (Carrera c : logica.getCarreras()) {
            if (c.isCarreraCerrada()) {
                this.jComboBoxIdCarreraFinalizada.addItem(c.getId());
            }
        }
        this.jComboBoxIdCarreraFinalizada.setSelectedIndex(0);

        for (Corredor c : logica.getCorredores()) {
            this.jComboBoxDniCorredor.addItem(c.getDni());
        }
        this.jComboBoxIdCarreraFinalizada.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelRadioButtons = new javax.swing.JPanel();
        jRadioButtonCarrerasSinFinalizar = new javax.swing.JRadioButton();
        jRadioButtonCarrera = new javax.swing.JRadioButton();
        jRadioButtonCarreraFinalizada = new javax.swing.JRadioButton();
        jRadioButtonCorredor = new javax.swing.JRadioButton();
        jComboBoxIdCarrera = new javax.swing.JComboBox<>();
        jLabelIdCarreraFinalizada = new javax.swing.JLabel();
        jLabelIdCarrera = new javax.swing.JLabel();
        jComboBoxIdCarreraFinalizada = new javax.swing.JComboBox<>();
        jLabelDniCorredor = new javax.swing.JLabel();
        jComboBoxDniCorredor = new javax.swing.JComboBox<>();
        jButtonGenerarInforme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabelTitulo.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("INFORMES GESTIÓN CARRERAS");

        jRadioButtonCarrerasSinFinalizar.setFont(new java.awt.Font("Abyssinica SIL", 0, 18)); // NOI18N
        jRadioButtonCarrerasSinFinalizar.setText("Carreras sin finalizar");

        jRadioButtonCarrera.setFont(new java.awt.Font("Abyssinica SIL", 0, 18)); // NOI18N
        jRadioButtonCarrera.setText("Carrera");

        jRadioButtonCarreraFinalizada.setFont(new java.awt.Font("Abyssinica SIL", 0, 18)); // NOI18N
        jRadioButtonCarreraFinalizada.setText("Carrera finalizada");

        jRadioButtonCorredor.setFont(new java.awt.Font("Abyssinica SIL", 0, 18)); // NOI18N
        jRadioButtonCorredor.setText("Corredor");

        jComboBoxIdCarrera.setFont(new java.awt.Font("Abyssinica SIL", 0, 16)); // NOI18N

        jLabelIdCarreraFinalizada.setFont(new java.awt.Font("Abyssinica SIL", 0, 16)); // NOI18N
        jLabelIdCarreraFinalizada.setText("Id ");

        jLabelIdCarrera.setFont(new java.awt.Font("Abyssinica SIL", 0, 16)); // NOI18N
        jLabelIdCarrera.setText("Id ");

        jComboBoxIdCarreraFinalizada.setFont(new java.awt.Font("Abyssinica SIL", 0, 16)); // NOI18N

        jLabelDniCorredor.setFont(new java.awt.Font("Abyssinica SIL", 0, 16)); // NOI18N
        jLabelDniCorredor.setText("Dni");

        jComboBoxDniCorredor.setFont(new java.awt.Font("Abyssinica SIL", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanelRadioButtonsLayout = new javax.swing.GroupLayout(jPanelRadioButtons);
        jPanelRadioButtons.setLayout(jPanelRadioButtonsLayout);
        jPanelRadioButtonsLayout.setHorizontalGroup(
            jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRadioButtonsLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRadioButtonsLayout.createSequentialGroup()
                        .addComponent(jRadioButtonCarrerasSinFinalizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRadioButtonsLayout.createSequentialGroup()
                        .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jRadioButtonCarreraFinalizada, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jRadioButtonCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdCarreraFinalizada)
                            .addComponent(jLabelIdCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDniCorredor))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxIdCarreraFinalizada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxDniCorredor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxIdCarrera, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39))))
        );
        jPanelRadioButtonsLayout.setVerticalGroup(
            jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRadioButtonsLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jRadioButtonCarrerasSinFinalizar)
                .addGap(18, 18, 18)
                .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCarrera)
                    .addComponent(jComboBoxIdCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCarreraFinalizada)
                    .addComponent(jLabelIdCarreraFinalizada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxIdCarreraFinalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRadioButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCorredor)
                    .addComponent(jLabelDniCorredor)
                    .addComponent(jComboBoxDniCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        jButtonGenerarInforme.setFont(new java.awt.Font("Abyssinica SIL", 1, 18)); // NOI18N
        jButtonGenerarInforme.setText("GENERAR INFORME");
        jButtonGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jButtonGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelRadioButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRadioButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarInformeActionPerformed

        Map parametros = new HashMap();
        String ruta;    // Llamar el JFileChooser

        try {

            if (this.jRadioButtonCarrerasSinFinalizar.isSelected()) {

                ArrayList<Carrera> carrerasSinFinalizar = CarrerasDataSource.getCarrerasSinFinalizar();
                JRDataSource dataSource = new JRBeanCollectionDataSource(carrerasSinFinalizar);
                JasperPrint print = JasperFillManager.fillReport("informes/InformeCarrerasSinFinalizar.jasper", parametros, dataSource);
                JasperExportManager.exportReportToPdfFile(print, "informes/InformeCarrerasSinFinalizar.pdf");

            } else if (this.jRadioButtonCarrera.isSelected()) {
                Carrera carreraElegida = logica.getCarreras().get(this.jComboBoxIdCarrera.getSelectedIndex());
                logica.setCarreraElegida(carreraElegida);
                
                System.out.println(carreraElegida);
                
                ArrayList<Carrera> carrera = CarrerasDataSource.getCarrera();
                JRDataSource dataSource = new JRBeanCollectionDataSource(carrera);
                JasperPrint print = JasperFillManager.fillReport("informes/CarreraElegida.jasper", parametros, dataSource);
                JasperExportManager.exportReportToPdfFile(print, "informes/InformeCarrera_"+carreraElegida.getId()+".pdf");

                
            } else if (this.jRadioButtonCarreraFinalizada.isSelected()) {
                
            } else if (this.jRadioButtonCorredor.isSelected()) {
                
            }
        } catch (JRException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGenerarInformeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButtonGenerarInforme;
    private javax.swing.JComboBox<String> jComboBoxDniCorredor;
    private javax.swing.JComboBox<String> jComboBoxIdCarrera;
    private javax.swing.JComboBox<String> jComboBoxIdCarreraFinalizada;
    private javax.swing.JLabel jLabelDniCorredor;
    private javax.swing.JLabel jLabelIdCarrera;
    private javax.swing.JLabel jLabelIdCarreraFinalizada;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRadioButtons;
    private javax.swing.JRadioButton jRadioButtonCarrera;
    private javax.swing.JRadioButton jRadioButtonCarreraFinalizada;
    private javax.swing.JRadioButton jRadioButtonCarrerasSinFinalizar;
    private javax.swing.JRadioButton jRadioButtonCorredor;
    // End of variables declaration//GEN-END:variables
}
