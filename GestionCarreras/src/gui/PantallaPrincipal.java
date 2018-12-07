/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import dto.Carrera;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import logic.Configuracion;
import logic.LogicaCarrera;
import logic.LogicaGuardado;
import net.sf.tinylaf.TinyLookAndFeel;
import org.openide.util.Exceptions;

/**
 *
 * @author silvia
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private HashMap<String, LookAndFeel> lookAndFeels;
    private static final String RUTA_LOGO = "/gui/img/icono.jpeg";
    private JFileChooser jfc;
    private Carrera carreraParaExportar;

    /**
     * Creates new form PantallaInicial
     *
     */
    public PantallaPrincipal() {
        initComponents();
        inicializarBarraMenu();
        inicializarJFileChooser();
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

        Configuracion configuracion = LogicaGuardado.getInstance().getConfiguracion();
        if (configuracion != null && configuracion.getLookAndFeel() != null) {
            cambiarLookAndFeel(configuracion.getLookAndFeel());
        }
        registrarAyuda();
    }

    private void registrarAyuda() {
        try {
            // Carga el fichero de ayuda que esta en src 
            URL ayuda = getClass().getResource("/help/help_set.hs");
            // Si necesitamos un file
            //File file = new File(ayuda.toUri());

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), ayuda);
            HelpBroker hb = helpset.createHelpBroker();

            // Sale la ayuda al pulsar en boton o item de menu
            // hb.enableHelpOnButton(ayudaMenuItem, "aplicacion", helpset);
            hb.enableHelpOnButton(jMenuItemAyuda, "aplicacion", helpset);

            // Si no hay foco y pulsan F1 sale ayuda principal
            hb.enableHelpKey(getRootPane(), "ventana_principal", helpset);

            // Si el foco lo tiene ese boton y pulsan F1 sale esa pantalla de la ayuda
            hb.enableHelpKey(jButtonVerCarreras, "carreras", helpset);
            hb.enableHelpKey(jButtonVerCorredores, "corredores", helpset);
            hb.enableHelpKey(jMenuArchivos, "archivos", helpset);
            hb.enableHelpKey(jMenuConfiguracion, "configuracion", helpset);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inicializarJFileChooser() {
        jfc = new JFileChooser();
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros CSV ", "csv"));
        jfc.setDialogType(SAVE_DIALOG);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setMultiSelectionEnabled(false);
    }

    private void inicializarBarraMenu() {
        for (UIManager.LookAndFeelInfo lookAndFeel : UIManager.getInstalledLookAndFeels()) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem();
            item.setText(lookAndFeel.getName());
            item.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cambiarLookAndFeel(lookAndFeel);
                    LogicaGuardado.getInstance().getConfiguracion().setLookAndFeel(lookAndFeel);
                }
            });
            jMenuLookAndFeel.add(item);
            buttonGroupLookAndFeels.add(item);
        }
        addLookAndFeels();
    }

    private void cambiarLookAndFeel(LookAndFeelInfo lookAndFeel) {
        if (lookAndFeel != null) {
            try {
                LogicaGuardado.getInstance().getConfiguracion().setLookAndFeel(lookAndFeel);
                UIManager.setLookAndFeel(lookAndFeel.getClassName());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    public void addLookAndFeels() {
        cargarNuevosLookAndFeel();
        for (Map.Entry<String, LookAndFeel> lookAndFeel : lookAndFeels.entrySet()) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem();
            item.setText(lookAndFeel.getKey());
            item.addActionListener((java.awt.event.ActionEvent evt) -> {
                try {
                    LogicaGuardado.getInstance().getConfiguracion().setLookAndFeel(
                            new LookAndFeelInfo(lookAndFeel.getValue().getName(), lookAndFeel.getValue().getClass().getName()));
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
        lookAndFeels.put("Pgs", new PgsLookAndFeel());
        lookAndFeels.put("Tiny", new TinyLookAndFeel());

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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLayeredPaneFondo = new javax.swing.JLayeredPane();
        jLabelFondo = new javax.swing.JLabel();
        jLayeredPaneBotones = new javax.swing.JLayeredPane();
        jButtonSalir = new javax.swing.JButton();
        jButtonVerCarreras = new javax.swing.JButton();
        jButtonVerCorredores = new javax.swing.JButton();
        jLayeredPaneTitulo = new javax.swing.JLayeredPane();
        jLabelTitulo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArchivos = new javax.swing.JMenu();
        jMenuItemExportarCarrera = new javax.swing.JMenuItem();
        jMenuItemExportarCorredores = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuConfiguracion = new javax.swing.JMenu();
        jMenuItemOpciones = new javax.swing.JMenuItem();
        jMenuLookAndFeel = new javax.swing.JMenu();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAyuda = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MarAppTon");
        setBounds(new java.awt.Rectangle(0, 0, 640, 480));
        setForeground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jLayeredPaneFondo.setMaximumSize(new java.awt.Dimension(640, 480));
        jLayeredPaneFondo.setMinimumSize(null);
        jLayeredPaneFondo.setPreferredSize(new java.awt.Dimension(640, 480));

        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/img/icono.png"))); // NOI18N
        jLabelFondo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelFondo.setAlignmentY(0.0F);
        jLabelFondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelFondo.setMaximumSize(new java.awt.Dimension(640, 480));
        jLabelFondo.setMinimumSize(new java.awt.Dimension(600, 460));
        jLabelFondo.setPreferredSize(new java.awt.Dimension(640, 480));

        jButtonSalir.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.setHideActionText(true);
        jButtonSalir.setMaximumSize(new java.awt.Dimension(127, 41));
        jButtonSalir.setMinimumSize(new java.awt.Dimension(127, 41));
        jButtonSalir.setPreferredSize(new java.awt.Dimension(127, 41));
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonVerCarreras.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N
        jButtonVerCarreras.setText("CARRERAS");
        jButtonVerCarreras.setMaximumSize(new java.awt.Dimension(127, 41));
        jButtonVerCarreras.setMinimumSize(new java.awt.Dimension(127, 41));
        jButtonVerCarreras.setPreferredSize(new java.awt.Dimension(127, 41));
        jButtonVerCarreras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVerCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCarrerasActionPerformed(evt);
            }
        });

        jButtonVerCorredores.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N
        jButtonVerCorredores.setText("CORREDORES");
        jButtonVerCorredores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVerCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCorredoresActionPerformed(evt);
            }
        });

        jLayeredPaneBotones.setLayer(jButtonSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneBotones.setLayer(jButtonVerCarreras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneBotones.setLayer(jButtonVerCorredores, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneBotonesLayout = new javax.swing.GroupLayout(jLayeredPaneBotones);
        jLayeredPaneBotones.setLayout(jLayeredPaneBotonesLayout);
        jLayeredPaneBotonesLayout.setHorizontalGroup(
            jLayeredPaneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneBotonesLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jButtonVerCorredores)
                .addGap(18, 18, 18)
                .addComponent(jButtonVerCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );

        jLayeredPaneBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonSalir, jButtonVerCarreras, jButtonVerCorredores});

        jLayeredPaneBotonesLayout.setVerticalGroup(
            jLayeredPaneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneBotonesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jLayeredPaneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPaneBotonesLayout.createSequentialGroup()
                        .addComponent(jButtonVerCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jLayeredPaneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonVerCorredores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLayeredPaneTitulo.setMaximumSize(new java.awt.Dimension(640, 100));
        jLayeredPaneTitulo.setMinimumSize(new java.awt.Dimension(640, 10));
        jLayeredPaneTitulo.setPreferredSize(new java.awt.Dimension(640, 34));

        jLabelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        jLabelTitulo.setFont(new java.awt.Font("Uroob", 1, 64)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(51, 0, 153));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("MarAppTon");

        jLayeredPaneTitulo.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneTituloLayout = new javax.swing.GroupLayout(jLayeredPaneTitulo);
        jLayeredPaneTitulo.setLayout(jLayeredPaneTituloLayout);
        jLayeredPaneTituloLayout.setHorizontalGroup(
            jLayeredPaneTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jLayeredPaneTituloLayout.setVerticalGroup(
            jLayeredPaneTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneTituloLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap())
        );

        jLayeredPaneFondo.setLayer(jLabelFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneFondo.setLayer(jLayeredPaneBotones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneFondo.setLayer(jLayeredPaneTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneFondoLayout = new javax.swing.GroupLayout(jLayeredPaneFondo);
        jLayeredPaneFondo.setLayout(jLayeredPaneFondoLayout);
        jLayeredPaneFondoLayout.setHorizontalGroup(
            jLayeredPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneFondoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jLayeredPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPaneTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jLayeredPaneBotones))
                .addGap(0, 0, 0))
            .addGroup(jLayeredPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPaneFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPaneFondoLayout.setVerticalGroup(
            jLayeredPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneFondoLayout.createSequentialGroup()
                .addComponent(jLayeredPaneTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                .addComponent(jLayeredPaneBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jLayeredPaneFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPaneFondoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jMenuBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuBar.setPreferredSize(new java.awt.Dimension(168, 36));

        jMenuArchivos.setText("Archivos");
        jMenuArchivos.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N

        jMenuItemExportarCarrera.setFont(new java.awt.Font("Uroob", 1, 18)); // NOI18N
        jMenuItemExportarCarrera.setText("Exportar resultado de Carrera");
        jMenuItemExportarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarCarreraActionPerformed(evt);
            }
        });
        jMenuArchivos.add(jMenuItemExportarCarrera);

        jMenuItemExportarCorredores.setFont(new java.awt.Font("Uroob", 1, 18)); // NOI18N
        jMenuItemExportarCorredores.setText("Exportar Corredores");
        jMenuItemExportarCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarCorredoresActionPerformed(evt);
            }
        });
        jMenuArchivos.add(jMenuItemExportarCorredores);

        jMenuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGuardar.setFont(new java.awt.Font("Uroob", 1, 18)); // NOI18N
        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuArchivos.add(jMenuItemGuardar);

        jMenuBar.add(jMenuArchivos);

        jMenuConfiguracion.setText("Configuracion");
        jMenuConfiguracion.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N

        jMenuItemOpciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpciones.setFont(new java.awt.Font("Uroob", 1, 18)); // NOI18N
        jMenuItemOpciones.setText("Frecuencia de guardado");
        jMenuItemOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpcionesActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuItemOpciones);

        jMenuLookAndFeel.setText("LookAndFeel");
        jMenuLookAndFeel.setFont(new java.awt.Font("Uroob", 1, 18)); // NOI18N
        jMenuConfiguracion.add(jMenuLookAndFeel);

        jMenuBar.add(jMenuConfiguracion);

        jMenuAyuda.setText("Ayuda");
        jMenuAyuda.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N

        jMenuItemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAyuda.setFont(new java.awt.Font("Uroob", 1, 18)); // NOI18N
        jMenuItemAyuda.setText("Ayuda");
        jMenuAyuda.add(jMenuItemAyuda);

        jMenuBar.add(jMenuAyuda);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPaneFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPaneFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        boolean guardadoOk = LogicaGuardado.getInstance().guardarDatos();
        if (guardadoOk) {
            JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente", "Datos guardados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ha habido un problema al guardar los datos. Inténtelo otra vez", "Error al guardar", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemExportarCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarCorredoresActionPerformed

        jfc.setDialogTitle("Elige el fichero CSV donde exportar los corredores");

        // Mostrar dialogo
        jfc.showSaveDialog(this);

        // Recoger el archivo elegido y exportar corredores
        File archivoCSV = jfc.getSelectedFile();

        if (archivoCSV == null) {
            JOptionPane.showMessageDialog(this, "Los datos no se han guardado. No has elegido ningun archivo", "Datos no guardados", JOptionPane.INFORMATION_MESSAGE);

        } else {
            boolean guardadoOk = LogicaGuardado.getInstance().exportarCorredoresCSV(archivoCSV);

            if (guardadoOk) {
                JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente", "Datos guardados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ha habido un problema al guardar los datos. Inténtelo otra vez", "Error al guardar", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemExportarCorredoresActionPerformed

    private void jMenuItemExportarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarCarreraActionPerformed

        // Genero lista con carreras terminadas
        ArrayList<Carrera> carrerasTerminadas = new ArrayList<>();
        for (Carrera carrera : LogicaCarrera.getInstance().getCarreras()) {
            if (carrera.isCarreraCerrada()) {
                carrerasTerminadas.add(carrera);
            }
        }

        // Compruebo que no este vacia
        if (carrerasTerminadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ninguna carrera terminada para exportar", "No hay carreras que exportar", JOptionPane.INFORMATION_MESSAGE);

        } else {

            // Abro el dialogo y le paso las carreras para que las muestre
            DialogoExportarCarrera dialogo = new DialogoExportarCarrera(this, true, carrerasTerminadas);
            dialogo.setVisible(true);

            // Cuando se cierra el dialogo compruebo si me ha mandado una carrera que guardar
            if (carreraParaExportar == null) {
                JOptionPane.showMessageDialog(this, "Los datos no se han guardado. No has elegido ninguna carrera", "Datos no guardados", JOptionPane.INFORMATION_MESSAGE);
            } else {

                // Mostrar dialogo para elegir fichero
                jfc.setDialogTitle("Elige el fichero CSV donde exportar la carrera");
                jfc.showSaveDialog(this);

                // Recoger el archivo elegido y exportar la carrera
                File archivoCSV = jfc.getSelectedFile();

                if (archivoCSV == null) {
                    JOptionPane.showMessageDialog(this, "Los datos no se han guardado. No has elegido ningun archivo", "Datos no guardados", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    boolean guardadoOk = false;
                    guardadoOk = LogicaGuardado.getInstance().exportarCarreraCSV(archivoCSV, carreraParaExportar);

                    if (guardadoOk) {
                        JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente", "Datos guardados", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ha habido un problema al guardar los datos. Inténtelo otra vez", "Error al guardar", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItemExportarCarreraActionPerformed

    private void jMenuItemOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpcionesActionPerformed
        DialogoOpciones dialogo = new DialogoOpciones(this, true);
        dialogo.setVisible(true);
    }//GEN-LAST:event_jMenuItemOpcionesActionPerformed

    /*
        CARGAR JAVADOC
    
    try {
            //Cargar una URI con ruta relativa
            //File file = new File("dist/javadoc/index.html");
            //Desktop.getDesktop().browse(file.toURI());

            //Cargar archivos que están dentro del jar
            //(Meter la carpeta javadoc en la carpeta src y aparecera junto a mis paquetes)
            Desktop.getDesktop().browse(getClass().getClassLoader().getResource("javadoc/index.html").toURI());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se encuentra el fichero Javadoc. Asegurate de haberlo generado.", "Javadoc no encontrado", JOptionPane.WARNING_MESSAGE);
        } catch (URISyntaxException ex) {
            Exceptions.printStackTrace(ex);
        }
    
     */
    public void setCarreraParaExportar(Carrera carreraParaExportar) {
        this.carreraParaExportar = carreraParaExportar;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLayeredPane jLayeredPaneBotones;
    private javax.swing.JLayeredPane jLayeredPaneFondo;
    private javax.swing.JLayeredPane jLayeredPaneTitulo;
    private javax.swing.JMenu jMenuArchivos;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAyuda;
    private javax.swing.JMenuItem jMenuItemExportarCarrera;
    private javax.swing.JMenuItem jMenuItemExportarCorredores;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemOpciones;
    private javax.swing.JMenu jMenuLookAndFeel;
    // End of variables declaration//GEN-END:variables

}
