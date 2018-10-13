package gui;

import java.io.IOException;
import java.util.Date;
import logic.LogicaCarrera;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class FormularioCarreras extends javax.swing.JDialog {

    /**
     * Creates new form FormularioCorredor
     *
     * @param parent
     * @param modal
     */
    public FormularioCarreras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTituloCarrera = new javax.swing.JPanel();
        jLabelTituloCarrera = new javax.swing.JLabel();
        jPanelBotonesCarrera = new javax.swing.JPanel();
        jButtonEnviarCarrera = new javax.swing.JButton();
        jButtonLimpiarCarrera = new javax.swing.JButton();
        jButtonCancelarCorredor = new javax.swing.JButton();
        jPanelCamposCarrera = new javax.swing.JPanel();
        jLabelNombreCarrera = new javax.swing.JLabel();
        jTextFieldNombreCarrera = new javax.swing.JTextField();
        jLabelPlazasCarrera = new javax.swing.JLabel();
        jTextFieldPlazasCarrera = new javax.swing.JTextField();
        jLabelLugarCarrera = new javax.swing.JLabel();
        jTextFieldLugarCarrera = new javax.swing.JTextField();
        jLabelFechaCarrera = new javax.swing.JLabel();
        jSpinnerFechaCarrera = new javax.swing.JSpinner();
        jLabelDireccionCarrera = new javax.swing.JLabel();
        jTextFieldDireccionCarrera = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Corredor");
        setForeground(java.awt.Color.darkGray);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setModal(true);
        setSize(new java.awt.Dimension(640, 480));

        jPanelTituloCarrera.setMinimumSize(new java.awt.Dimension(640, 90));
        jPanelTituloCarrera.setPreferredSize(new java.awt.Dimension(640, 90));

        jLabelTituloCarrera.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelTituloCarrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloCarrera.setText("Informacion de la carrera");
        jLabelTituloCarrera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTituloCarrera.setMaximumSize(new java.awt.Dimension(400, 70));
        jLabelTituloCarrera.setMinimumSize(new java.awt.Dimension(400, 70));
        jLabelTituloCarrera.setPreferredSize(new java.awt.Dimension(400, 70));

        javax.swing.GroupLayout jPanelTituloCarreraLayout = new javax.swing.GroupLayout(jPanelTituloCarrera);
        jPanelTituloCarrera.setLayout(jPanelTituloCarreraLayout);
        jPanelTituloCarreraLayout.setHorizontalGroup(
            jPanelTituloCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloCarreraLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jLabelTituloCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanelTituloCarreraLayout.setVerticalGroup(
            jPanelTituloCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloCarreraLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabelTituloCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelTituloCarrera, java.awt.BorderLayout.PAGE_START);

        jPanelBotonesCarrera.setMinimumSize(new java.awt.Dimension(640, 100));
        jPanelBotonesCarrera.setPreferredSize(new java.awt.Dimension(640, 100));

        jButtonEnviarCarrera.setText("Enviar");
        jButtonEnviarCarrera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEnviarCarrera.setMaximumSize(null);
        jButtonEnviarCarrera.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonEnviarCarrera.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonEnviarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarCarreraActionPerformed(evt);
            }
        });

        jButtonLimpiarCarrera.setText("Limpiar");
        jButtonLimpiarCarrera.setMaximumSize(null);
        jButtonLimpiarCarrera.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonLimpiarCarrera.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonLimpiarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarCarreraActionPerformed(evt);
            }
        });

        jButtonCancelarCorredor.setText("Cancelar");
        jButtonCancelarCorredor.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonCancelarCorredor.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonCancelarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCorredorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesCarreraLayout = new javax.swing.GroupLayout(jPanelBotonesCarrera);
        jPanelBotonesCarrera.setLayout(jPanelBotonesCarreraLayout);
        jPanelBotonesCarreraLayout.setHorizontalGroup(
            jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesCarreraLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jButtonEnviarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonLimpiarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonCancelarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanelBotonesCarreraLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelarCorredor, jButtonEnviarCarrera, jButtonLimpiarCarrera});

        jPanelBotonesCarreraLayout.setVerticalGroup(
            jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesCarreraLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jButtonEnviarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpiarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCancelarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanelBotonesCarreraLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancelarCorredor, jButtonEnviarCarrera, jButtonLimpiarCarrera});

        getContentPane().add(jPanelBotonesCarrera, java.awt.BorderLayout.PAGE_END);

        jPanelCamposCarrera.setMaximumSize(null);
        jPanelCamposCarrera.setMinimumSize(new java.awt.Dimension(640, 130));
        jPanelCamposCarrera.setPreferredSize(new java.awt.Dimension(640, 130));

        jLabelNombreCarrera.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelNombreCarrera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombreCarrera.setText("Nombre");

        jTextFieldNombreCarrera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabelPlazasCarrera.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelPlazasCarrera.setText("Plazas");
        jLabelPlazasCarrera.setMinimumSize(new java.awt.Dimension(40, 12));
        jLabelPlazasCarrera.setPreferredSize(new java.awt.Dimension(40, 12));

        jTextFieldPlazasCarrera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabelLugarCarrera.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelLugarCarrera.setText("Lugar");

        jTextFieldLugarCarrera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabelFechaCarrera.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelFechaCarrera.setText("Fecha de la carrera");

        jSpinnerFechaCarrera.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jSpinnerFechaCarrera.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_MONTH));

        jLabelDireccionCarrera.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelDireccionCarrera.setText("Direccion");

        jTextFieldDireccionCarrera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanelCamposCarreraLayout = new javax.swing.GroupLayout(jPanelCamposCarrera);
        jPanelCamposCarrera.setLayout(jPanelCamposCarreraLayout);
        jPanelCamposCarreraLayout.setHorizontalGroup(
            jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamposCarreraLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCamposCarreraLayout.createSequentialGroup()
                        .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNombreCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDireccionCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombreCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldDireccionCarrera)))
                    .addComponent(jLabelFechaCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCamposCarreraLayout.createSequentialGroup()
                        .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLugarCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPlazasCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldLugarCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextFieldPlazasCarrera)))
                    .addComponent(jSpinnerFechaCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelCamposCarreraLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldDireccionCarrera, jTextFieldLugarCarrera, jTextFieldNombreCarrera, jTextFieldPlazasCarrera});

        jPanelCamposCarreraLayout.setVerticalGroup(
            jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposCarreraLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlazasCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPlazasCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelDireccionCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccionCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLugarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLugarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFechaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        jPanelCamposCarreraLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelDireccionCarrera, jLabelLugarCarrera, jTextFieldDireccionCarrera, jTextFieldLugarCarrera});

        jPanelCamposCarreraLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelNombreCarrera, jLabelPlazasCarrera, jTextFieldNombreCarrera, jTextFieldPlazasCarrera});

        jPanelCamposCarreraLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelFechaCarrera, jSpinnerFechaCarrera});

        getContentPane().add(jPanelCamposCarrera, java.awt.BorderLayout.CENTER);
        jPanelCamposCarrera.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarCarreraActionPerformed
        this.jTextFieldDireccionCarrera.setText("");
        this.jTextFieldLugarCarrera.setText("");
        this.jTextFieldNombreCarrera.setText("");
        this.jTextFieldPlazasCarrera.setText("");
    }//GEN-LAST:event_jButtonLimpiarCarreraActionPerformed

    private void jButtonCancelarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCorredorActionPerformed
        Utiles.salirSinGuardar(this);
    }//GEN-LAST:event_jButtonCancelarCorredorActionPerformed

    private void jButtonEnviarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarCarreraActionPerformed
        try {
            LogicaCarrera.getInstance().altaCarrera(
                    jTextFieldNombreCarrera.getText(),
                    (Date) jSpinnerFechaCarrera.getValue(),
                    jTextFieldLugarCarrera.getText(),
                    Integer.parseInt(jTextFieldPlazasCarrera.getText())
            );

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonEnviarCarreraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarCorredor;
    private javax.swing.JButton jButtonEnviarCarrera;
    private javax.swing.JButton jButtonLimpiarCarrera;
    private javax.swing.JLabel jLabelDireccionCarrera;
    private javax.swing.JLabel jLabelFechaCarrera;
    private javax.swing.JLabel jLabelLugarCarrera;
    private javax.swing.JLabel jLabelNombreCarrera;
    private javax.swing.JLabel jLabelPlazasCarrera;
    private javax.swing.JLabel jLabelTituloCarrera;
    private javax.swing.JPanel jPanelBotonesCarrera;
    private javax.swing.JPanel jPanelCamposCarrera;
    private javax.swing.JPanel jPanelTituloCarrera;
    private javax.swing.JSpinner jSpinnerFechaCarrera;
    private javax.swing.JTextField jTextFieldDireccionCarrera;
    private javax.swing.JTextField jTextFieldLugarCarrera;
    private javax.swing.JTextField jTextFieldNombreCarrera;
    private javax.swing.JTextField jTextFieldPlazasCarrera;
    // End of variables declaration//GEN-END:variables
}
