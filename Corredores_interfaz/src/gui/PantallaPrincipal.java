/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import br.com.paulocanedo.pc9.laf.PC9LookAndFeel;
import com.alee.laf.WebLookAndFeel;
import com.birosoft.liquid.LiquidLookAndFeel;
import com.bulenkov.darcula.DarculaLaf;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import com.pagosoft.plaf.PgsLookAndFeel;
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import logic.LogicaGuardado;
import napkin.NapkinLookAndFeel;
import net.sf.tinylaf.TinyLookAndFeel;
import org.openide.util.Exceptions;

/**
 *
 * @author silvia
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private HashMap<String, LookAndFeel> lookAndFeels;
    private static final String RUTA_LOGO = "/gui/img/icono.jpeg";

    /**
     * Creates new form PantallaInicial
     *
     */
    public PantallaPrincipal() {
        initComponents();
        inicializarBarraMenu();
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LogicaGuardado.getInstance().guardarDatos();
            }
        });
        setTitle("MarAppTon");
        try {
            setIconImage(new ImageIcon(getClass().getResource(RUTA_LOGO)).getImage());
        } catch (NullPointerException ex) {
        }
        setLocationRelativeTo(null);
        LogicaGuardado.getInstance().cargarDatos();
    }

    private void inicializarBarraMenu() {
        for (UIManager.LookAndFeelInfo lookAndFeel : UIManager.getInstalledLookAndFeels()) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem();
            item.setText(lookAndFeel.getName());
            item.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cambiarLookAndFeel(lookAndFeel);
                }
            });
            jMenuLookAndFeel.add(item);
            buttonGroupLookAndFeels.add(item);
        }
        addLookAndFeels();
    }

    private void cambiarLookAndFeel(LookAndFeelInfo lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel.getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public void addLookAndFeels() {
        cargarNuevosLookAndFeel();
        for (Map.Entry<String, LookAndFeel> lookAndFeel : lookAndFeels.entrySet()) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem();
            item.setText(lookAndFeel.getKey());
            item.addActionListener((java.awt.event.ActionEvent evt) -> {
                try {
                    UIManager.setLookAndFeel(lookAndFeel.getValue());
                    SwingUtilities.updateComponentTreeUI(PantallaPrincipal.this);
                } catch (UnsupportedLookAndFeelException ex) {
                    Exceptions.printStackTrace(ex);
                }
            });
            jMenuLookAndFeel.add(item);
            buttonGroupLookAndFeels.add(item);
        }
    }

    private void cargarNuevosLookAndFeel() {
        lookAndFeels = new HashMap<>();
        lookAndFeels.put("Darcula", new DarculaLaf());
        lookAndFeels.put("Liquid", new LiquidLookAndFeel());
        lookAndFeels.put("Acryl", new AcrylLookAndFeel());
        lookAndFeels.put("Aero", new AeroLookAndFeel());
        lookAndFeels.put("Aluminium", new AluminiumLookAndFeel());
        lookAndFeels.put("Berstein", new BernsteinLookAndFeel());
        lookAndFeels.put("Fast", new FastLookAndFeel());
        lookAndFeels.put("Graphite", new GraphiteLookAndFeel());
        lookAndFeels.put("Hifi", new HiFiLookAndFeel());
        lookAndFeels.put("Luna", new LunaLookAndFeel());
        lookAndFeels.put("McWin", new McWinLookAndFeel());
        lookAndFeels.put("Mint", new MintLookAndFeel());
        lookAndFeels.put("Mint", new MintLookAndFeel());
        lookAndFeels.put("Noire", new NoireLookAndFeel());
        lookAndFeels.put("Smart", new SmartLookAndFeel());
        lookAndFeels.put("Texture", new TextureLookAndFeel());
        lookAndFeels.put("PC9", new PC9LookAndFeel());
        lookAndFeels.put("Napkin", new NapkinLookAndFeel());
        lookAndFeels.put("Pgs", new PgsLookAndFeel());
        lookAndFeels.put("Tiny", new TinyLookAndFeel());
        lookAndFeels.put("Web", new WebLookAndFeel());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLookAndFeels = new javax.swing.ButtonGroup();
        jPanelBotones = new javax.swing.JPanel();
        jButtonVerCorredores = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonVerCarreras = new javax.swing.JButton();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelIcono = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuConfiguracion = new javax.swing.JMenu();
        jMenuLookAndFeel = new javax.swing.JMenu();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemJavadoc = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MarAppTon");
        setBounds(new java.awt.Rectangle(0, 0, 640, 480));
        setForeground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanelBotones.setForeground(new java.awt.Color(51, 51, 51));
        jPanelBotones.setMaximumSize(new java.awt.Dimension(32767, 150));
        jPanelBotones.setPreferredSize(new java.awt.Dimension(814, 150));

        jButtonVerCorredores.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jButtonVerCorredores.setText("CORREDORES");
        jButtonVerCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCorredoresActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.setHideActionText(true);
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonVerCarreras.setFont(new java.awt.Font("DejaVu Sans", 1, 16)); // NOI18N
        jButtonVerCarreras.setText("CARRERAS");
        jButtonVerCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCarrerasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButtonVerCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVerCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );

        jPanelBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonSalir, jButtonVerCarreras, jButtonVerCorredores});

        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonVerCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonVerCorredores))
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jPanelBotonesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonSalir, jButtonVerCarreras, jButtonVerCorredores});

        jPanelTitulo.setForeground(new java.awt.Color(51, 51, 51));

        jLabelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(51, 0, 153));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("MarAppTon");

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/icono.jpeg"))); // NOI18N
        jLabelIcono.setAlignmentY(0.0F);
        jLabelIcono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTituloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelTituloLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuBar.setPreferredSize(new java.awt.Dimension(168, 36));

        jMenuConfiguracion.setText("Configuracion");
        jMenuConfiguracion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuLookAndFeel.setText("LookAndFeel");
        jMenuConfiguracion.add(jMenuLookAndFeel);

        jMenuBar.add(jMenuConfiguracion);

        jMenuAyuda.setText("Ayuda");
        jMenuAyuda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItemJavadoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemJavadoc.setText("Javadoc");
        jMenuItemJavadoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJavadocActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemJavadoc);

        jMenuBar.add(jMenuAyuda);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCorredoresActionPerformed
        VistaCorredores ventanaCorredores = new VistaCorredores(this, true);
        ventanaCorredores.setVisible(true);
    }//GEN-LAST:event_jButtonVerCorredoresActionPerformed

    private void jButtonVerCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCarrerasActionPerformed
        VistaCarreras ventanaCarreras = new VistaCarreras(this, true);
        ventanaCarreras.setVisible(true);
    }//GEN-LAST:event_jButtonVerCarrerasActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        LogicaGuardado.getInstance().guardarDatos();
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jMenuItemJavadocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJavadocActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("file:///home/silvia/Documentos/DI1819/Corredores_interfaz/dist/javadoc/index.html"));
        } catch (IOException | URISyntaxException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jMenuItemJavadocActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Locale.setDefault(new Locale("es", "ES"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLookAndFeels;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonVerCarreras;
    private javax.swing.JButton jButtonVerCorredores;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JMenuItem jMenuItemJavadoc;
    private javax.swing.JMenu jMenuLookAndFeel;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelTitulo;
    // End of variables declaration//GEN-END:variables
}
