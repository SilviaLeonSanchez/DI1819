package gui;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import logic.LogicaGuardado;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class DialogoOpciones extends javax.swing.JDialog {
    
    private int frecuenciaGuardado;


    /**
     * Creates new form FormularioCorredor
     *
     * @param parent
     * @param modal
     */
    public DialogoOpciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jSliderFrecuenciaGuardado.setPaintLabels(true);
        jSliderFrecuenciaGuardado.setLabelTable(jSliderFrecuenciaGuardado.createStandardLabels(5));
        jSliderFrecuenciaGuardado.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                frecuenciaGuardado = jSliderFrecuenciaGuardado.getValue();
                jLabelValorFrecuencia.setText(String.valueOf(frecuenciaGuardado));}
        });
        frecuenciaGuardado = LogicaGuardado.getInstance()
                .getConfiguracion().getIntervaloDeGuardado();
        jSliderFrecuenciaGuardado.setValue(frecuenciaGuardado);
        jLabelValorFrecuencia.setText(String.valueOf(frecuenciaGuardado));
    }

                
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotonesCarrera = new javax.swing.JPanel();
        jButtonGuardarOpciones = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelCamposCarrera = new javax.swing.JPanel();
        jLabelTextoFrecuenciaGuardado = new javax.swing.JLabel();
        jSliderFrecuenciaGuardado = new javax.swing.JSlider();
        jLabelValorFrecuencia = new javax.swing.JLabel();
        jLabelTextoMinutos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opciones");
        setForeground(java.awt.Color.darkGray);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));

        jPanelBotonesCarrera.setMinimumSize(new java.awt.Dimension(640, 100));
        jPanelBotonesCarrera.setPreferredSize(new java.awt.Dimension(640, 100));

        jButtonGuardarOpciones.setText("Guardar");
        jButtonGuardarOpciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarOpciones.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonGuardarOpciones.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonGuardarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarOpcionesActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setMinimumSize(new java.awt.Dimension(85, 40));
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(85, 40));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesCarreraLayout = new javax.swing.GroupLayout(jPanelBotonesCarrera);
        jPanelBotonesCarrera.setLayout(jPanelBotonesCarreraLayout);
        jPanelBotonesCarreraLayout.setHorizontalGroup(
            jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesCarreraLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jButtonGuardarOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanelBotonesCarreraLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonGuardarOpciones});

        jPanelBotonesCarreraLayout.setVerticalGroup(
            jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesCarreraLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelBotonesCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardarOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanelBotonesCarreraLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancelar, jButtonGuardarOpciones});

        getContentPane().add(jPanelBotonesCarrera, java.awt.BorderLayout.PAGE_END);

        jPanelCamposCarrera.setMaximumSize(null);
        jPanelCamposCarrera.setMinimumSize(new java.awt.Dimension(640, 130));
        jPanelCamposCarrera.setPreferredSize(new java.awt.Dimension(640, 130));

        jLabelTextoFrecuenciaGuardado.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelTextoFrecuenciaGuardado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTextoFrecuenciaGuardado.setText("Frecuencia de guardado");
        jLabelTextoFrecuenciaGuardado.setMinimumSize(new java.awt.Dimension(40, 12));
        jLabelTextoFrecuenciaGuardado.setPreferredSize(new java.awt.Dimension(40, 12));

        jSliderFrecuenciaGuardado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jSliderFrecuenciaGuardado.setMaximum(60);
        jSliderFrecuenciaGuardado.setMinimum(5);
        jSliderFrecuenciaGuardado.setPaintLabels(true);
        jSliderFrecuenciaGuardado.setValue(30);

        jLabelValorFrecuencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValorFrecuencia.setText("30");

        jLabelTextoMinutos.setText("MINUTOS");

        javax.swing.GroupLayout jPanelCamposCarreraLayout = new javax.swing.GroupLayout(jPanelCamposCarrera);
        jPanelCamposCarrera.setLayout(jPanelCamposCarreraLayout);
        jPanelCamposCarreraLayout.setHorizontalGroup(
            jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposCarreraLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderFrecuenciaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTextoFrecuenciaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
            .addGroup(jPanelCamposCarreraLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabelValorFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTextoMinutos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCamposCarreraLayout.setVerticalGroup(
            jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposCarreraLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jLabelTextoFrecuenciaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSliderFrecuenciaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCamposCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelValorFrecuencia, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabelTextoMinutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCamposCarrera, java.awt.BorderLayout.CENTER);
        jPanelCamposCarrera.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        Utiles.salirSinGuardar(this);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGuardarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarOpcionesActionPerformed
      LogicaGuardado.getInstance().setIntervaloGuardado(frecuenciaGuardado);
      dispose();
    }//GEN-LAST:event_jButtonGuardarOpcionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardarOpciones;
    private javax.swing.JLabel jLabelTextoFrecuenciaGuardado;
    private javax.swing.JLabel jLabelTextoMinutos;
    private javax.swing.JLabel jLabelValorFrecuencia;
    private javax.swing.JPanel jPanelBotonesCarrera;
    private javax.swing.JPanel jPanelCamposCarrera;
    private javax.swing.JSlider jSliderFrecuenciaGuardado;
    // End of variables declaration//GEN-END:variables
}