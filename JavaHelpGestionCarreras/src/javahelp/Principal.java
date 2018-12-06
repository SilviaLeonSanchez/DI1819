package javahelp;

import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author silvia
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        registrarAyuda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAyuda = new javax.swing.JButton();
        jButtonCorredores = new javax.swing.JButton();
        jButtonCarreras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAyuda.setText("Ayuda");

        jButtonCorredores.setText("Corredores");

        jButtonCarreras.setText("Carreras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButtonAyuda))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButtonCorredores)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCarreras)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jButtonAyuda)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCorredores)
                    .addComponent(jButtonCarreras))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonCarreras;
    private javax.swing.JButton jButtonCorredores;
    // End of variables declaration//GEN-END:variables

    private void registrarAyuda() {
        try {
            // Carga el fichero de ayuda (si esta en la carpeta del proyecto)
            //File fichero = new File("help" + File.separator + "help_set.hs");
            //URL ayuda = fichero.toURI().toURL();
            
            // Si lo queremos meter en src para que lo compile dentro del jar 
            // metemos la carpeta help en src y lo cargamos asi
            URL ayuda = getClass().getResource("/help/help_set.hs");
            // Si necesitamos un file
            //File file = new File(ayuda.toUri());
            
            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), ayuda);
            HelpBroker hb = helpset.createHelpBroker();

            // Sale la ayuda al pulsar en boton o item de menu
            // hb.enableHelpOnButton(ayudaMenuItem, "aplicacion", helpset);
            hb.enableHelpOnButton(jButtonAyuda, "aplicacion", helpset);
            hb.enableHelpKey(jButtonCarreras, "carreras", helpset);
            hb.enableHelpKey(jButtonCorredores, "corredores", helpset);
            
            // Si no hay foco y pulsan F1 sale ayuda principal
            hb.enableHelpKey(getRootPane(), "ventana_principal", helpset);
            // Si el foco esta en ese boton y pulsan F1 sale ayuda principal
            hb.enableHelpKey(jButtonAyuda, "ventana_principal", helpset);
            
            // Si el foco lo tiene ese boton y pulsan F1 sale esa pantalla de la ayuda
            hb.enableHelpKey(jButtonCarreras, "carreras", helpset);
            hb.enableHelpKey(jButtonCorredores, "corredores", helpset);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}