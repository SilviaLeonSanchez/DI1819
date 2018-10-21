/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Corredor;
import logic.LogicaCorredor;
import java.util.Date;
import javax.swing.JOptionPane;
import utils.ExcepcionesPropias;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class FormularioCorredores extends javax.swing.JDialog {

    private boolean modificar;
    private Corredor c_original;

    /**
     * Creates new form FormularioCorredor
     *
     * @param parent
     * @param modal
     */
    public FormularioCorredores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modificar = false;
    }

    public FormularioCorredores(java.awt.Frame parent, boolean modal, Corredor corredor) {
        super(parent, modal);
        initComponents();
        c_original = corredor;
        jTextFieldDniCorredor.setText(corredor.getDni());
        jTextFieldNombreCorredor.setText(corredor.getNombre());
        jTextFieldDireccionCorredor.setText(corredor.getDireccion());
        jTextFieldTelefonoCorredor.setText(corredor.getTelefono());
        jSpinnerFechaNacimientoCorredor.setValue(corredor.getFecha_nac());
        modificar = true;
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
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanelTituloCorredor = new javax.swing.JPanel();
        jLabelTituloCorredor = new javax.swing.JLabel();
        jPanelBotonesCorredor = new javax.swing.JPanel();
        jButtonEnviarCorredor = new javax.swing.JButton();
        jButtonLimpiarCorredor = new javax.swing.JButton();
        jButtonCancelarCorredor = new javax.swing.JButton();
        jPanelCamposCorredor = new javax.swing.JPanel();
        jLabelNombreCorredor = new javax.swing.JLabel();
        jTextFieldNombreCorredor = new javax.swing.JTextField();
        jLabelTelefonoCorredor = new javax.swing.JLabel();
        jTextFieldTelefonoCorredor = new javax.swing.JTextField();
        jLabelDniCorredor = new javax.swing.JLabel();
        jTextFieldDniCorredor = new javax.swing.JTextField();
        jLabelFechaNacimientoCorredor = new javax.swing.JLabel();
        jSpinnerFechaNacimientoCorredor = new javax.swing.JSpinner();
        jLabelDireccionCorredor = new javax.swing.JLabel();
        jTextFieldDireccionCorredor = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Corredor");
        setForeground(java.awt.Color.darkGray);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setModal(true);
        setSize(new java.awt.Dimension(640, 480));

        jPanelTituloCorredor.setMinimumSize(new java.awt.Dimension(640, 90));
        jPanelTituloCorredor.setPreferredSize(new java.awt.Dimension(640, 90));

        jLabelTituloCorredor.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelTituloCorredor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloCorredor.setText("Informacion del corredor");
        jLabelTituloCorredor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTituloCorredor.setMinimumSize(new java.awt.Dimension(400, 50));
        jLabelTituloCorredor.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanelTituloCorredorLayout = new javax.swing.GroupLayout(jPanelTituloCorredor);
        jPanelTituloCorredor.setLayout(jPanelTituloCorredorLayout);
        jPanelTituloCorredorLayout.setHorizontalGroup(
            jPanelTituloCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloCorredorLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabelTituloCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(133, 133, 133))
        );
        jPanelTituloCorredorLayout.setVerticalGroup(
            jPanelTituloCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloCorredorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTituloCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelTituloCorredor, java.awt.BorderLayout.PAGE_START);

        jPanelBotonesCorredor.setMinimumSize(new java.awt.Dimension(640, 100));
        jPanelBotonesCorredor.setPreferredSize(new java.awt.Dimension(640, 100));

        jButtonEnviarCorredor.setText("Enviar");
        jButtonEnviarCorredor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEnviarCorredor.setMaximumSize(null);
        jButtonEnviarCorredor.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonEnviarCorredor.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonEnviarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarCorredorActionPerformed(evt);
            }
        });

        jButtonLimpiarCorredor.setText("Limpiar");
        jButtonLimpiarCorredor.setMaximumSize(null);
        jButtonLimpiarCorredor.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonLimpiarCorredor.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonLimpiarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarCorredorActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelBotonesCorredorLayout = new javax.swing.GroupLayout(jPanelBotonesCorredor);
        jPanelBotonesCorredor.setLayout(jPanelBotonesCorredorLayout);
        jPanelBotonesCorredorLayout.setHorizontalGroup(
            jPanelBotonesCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesCorredorLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jButtonEnviarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonLimpiarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonCancelarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanelBotonesCorredorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelarCorredor, jButtonEnviarCorredor, jButtonLimpiarCorredor});

        jPanelBotonesCorredorLayout.setVerticalGroup(
            jPanelBotonesCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesCorredorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelBotonesCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonEnviarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanelBotonesCorredorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancelarCorredor, jButtonEnviarCorredor, jButtonLimpiarCorredor});

        getContentPane().add(jPanelBotonesCorredor, java.awt.BorderLayout.PAGE_END);

        jPanelCamposCorredor.setMaximumSize(null);
        jPanelCamposCorredor.setMinimumSize(new java.awt.Dimension(640, 130));
        jPanelCamposCorredor.setPreferredSize(new java.awt.Dimension(640, 130));

        jLabelNombreCorredor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelNombreCorredor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNombreCorredor.setText("Nombre");

        jTextFieldNombreCorredor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabelTelefonoCorredor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelTelefonoCorredor.setText("Telefono");
        jLabelTelefonoCorredor.setMinimumSize(new java.awt.Dimension(40, 12));
        jLabelTelefonoCorredor.setPreferredSize(new java.awt.Dimension(40, 12));

        jTextFieldTelefonoCorredor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabelDniCorredor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelDniCorredor.setText("Dni");

        jTextFieldDniCorredor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabelFechaNacimientoCorredor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelFechaNacimientoCorredor.setText("Fecha de nacimiento");

        jSpinnerFechaNacimientoCorredor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jSpinnerFechaNacimientoCorredor.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(970255800000L), new java.util.Date(-1617507000000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jLabelDireccionCorredor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelDireccionCorredor.setText("Direccion");

        jTextFieldDireccionCorredor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanelCamposCorredorLayout = new javax.swing.GroupLayout(jPanelCamposCorredor);
        jPanelCamposCorredor.setLayout(jPanelCamposCorredorLayout);
        jPanelCamposCorredorLayout.setHorizontalGroup(
            jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamposCorredorLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCamposCorredorLayout.createSequentialGroup()
                        .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNombreCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDireccionCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombreCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTextFieldDireccionCorredor)))
                    .addComponent(jLabelFechaNacimientoCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCamposCorredorLayout.createSequentialGroup()
                        .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDniCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTelefonoCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDniCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextFieldTelefonoCorredor)))
                    .addComponent(jSpinnerFechaNacimientoCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelCamposCorredorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldDireccionCorredor, jTextFieldDniCorredor, jTextFieldNombreCorredor, jTextFieldTelefonoCorredor});

        jPanelCamposCorredorLayout.setVerticalGroup(
            jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposCorredorLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelNombreCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefonoCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefonoCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelDireccionCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccionCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDniCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDniCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelCamposCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNacimientoCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFechaNacimientoCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        jPanelCamposCorredorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelDireccionCorredor, jLabelDniCorredor, jTextFieldDireccionCorredor, jTextFieldDniCorredor});

        jPanelCamposCorredorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelNombreCorredor, jLabelTelefonoCorredor, jTextFieldNombreCorredor, jTextFieldTelefonoCorredor});

        jPanelCamposCorredorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelFechaNacimientoCorredor, jSpinnerFechaNacimientoCorredor});

        getContentPane().add(jPanelCamposCorredor, java.awt.BorderLayout.CENTER);
        jPanelCamposCorredor.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonLimpiarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarCorredorActionPerformed
        this.jTextFieldDireccionCorredor.setText("");
        this.jTextFieldDniCorredor.setText("");
        this.jTextFieldNombreCorredor.setText("");
        this.jTextFieldTelefonoCorredor.setText("");
    }//GEN-LAST:event_jButtonLimpiarCorredorActionPerformed

    private void jButtonEnviarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarCorredorActionPerformed
        if (!modificar) {
            enviar();
        } else {
            enviarParaModificar();
        }
    }//GEN-LAST:event_jButtonEnviarCorredorActionPerformed

    private void enviar() {
        try {
            LogicaCorredor.getInstance().altaCorredor(
                    this.jTextFieldDniCorredor.getText(),
                    this.jTextFieldNombreCorredor.getText(),
                    (Date) this.jSpinnerFechaNacimientoCorredor.getValue(),
                    this.jTextFieldDireccionCorredor.getText(),
                    this.jTextFieldTelefonoCorredor.getText()
            );
            LogicaCorredor.getInstance().guardarCorredores();
            this.dispose();
        } catch (ExcepcionesPropias.CorredorRepetido ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "El corredor ya exite", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void enviarParaModificar() {
        try {
            LogicaCorredor.getInstance().bajaCorredor(c_original);
            LogicaCorredor.getInstance().altaCorredor(
                    this.jTextFieldDniCorredor.getText(),
                    this.jTextFieldNombreCorredor.getText(),
                    (Date) this.jSpinnerFechaNacimientoCorredor.getValue(),
                    this.jTextFieldDireccionCorredor.getText(),
                    this.jTextFieldTelefonoCorredor.getText()
            );
            LogicaCorredor.getInstance().guardarCorredores();
            this.dispose();
        } catch (ExcepcionesPropias.CorredorRepetido ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "El corredor ya exite", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionesPropias.CorredorNoEsta ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "El corredor no exite", JOptionPane.ERROR_MESSAGE);
        } 
    }


    private void jButtonCancelarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCorredorActionPerformed
        Utiles.salirSinGuardar(this);
    }//GEN-LAST:event_jButtonCancelarCorredorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarCorredor;
    private javax.swing.JButton jButtonEnviarCorredor;
    private javax.swing.JButton jButtonLimpiarCorredor;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabelDireccionCorredor;
    private javax.swing.JLabel jLabelDniCorredor;
    private javax.swing.JLabel jLabelFechaNacimientoCorredor;
    private javax.swing.JLabel jLabelNombreCorredor;
    private javax.swing.JLabel jLabelTelefonoCorredor;
    private javax.swing.JLabel jLabelTituloCorredor;
    private javax.swing.JPanel jPanelBotonesCorredor;
    private javax.swing.JPanel jPanelCamposCorredor;
    private javax.swing.JPanel jPanelTituloCorredor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerFechaNacimientoCorredor;
    private javax.swing.JTextField jTextFieldDireccionCorredor;
    private javax.swing.JTextField jTextFieldDniCorredor;
    private javax.swing.JTextField jTextFieldNombreCorredor;
    private javax.swing.JTextField jTextFieldTelefonoCorredor;
    // End of variables declaration//GEN-END:variables
}
