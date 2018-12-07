package gui;

import dto.Carrera;
import dto.TiemposCorredor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import logic.LogicaCarrera;
import utils.ExcepcionesPropias;

/**
 *
 * @author silvia
 */
public class VistaCarreras extends javax.swing.JDialog {

    private PantallaPrincipal pantallaPrincipal;
    private TableRowSorter<TableModelTiemposCorredor> sorterCorredores;
    private TableRowSorter<TableModelCarrera> sorterCarreras;
    private Carrera carreraSeleccionada;

    /**
     * Creates new form PantallaCorredor
     *
     * @param parent
     * @param modal
     */
    public VistaCarreras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.pantallaPrincipal = (PantallaPrincipal) parent;
        initComponents();
        setTitle("Carreras");
        setLocationRelativeTo(null);
        jTableCarreras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refrescarTablaCarreras();
        rellenarComboBoxFiltroCarreras();
        refrescarTablaTiemposCorredores();
        rellenarComboBoxFiltroCorredores();
    }

    public Carrera getCarreraSeleccionada() {
        return carreraSeleccionada;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTituloVerCarreras = new javax.swing.JPanel();
        jLabelTituloVerCarreras = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jButtonIniciarCarrera = new javax.swing.JButton();
        jPanelTablas = new javax.swing.JPanel();
        jScrollPaneCarreras = new javax.swing.JScrollPane();
        jTableCarreras = new javax.swing.JTable();
        jScrollPaneCorredores = new javax.swing.JScrollPane();
        jTableTiemposCorredores = new javax.swing.JTable();
        jButtonNuevaCarrera = new javax.swing.JButton();
        jButtonModificarCarrera = new javax.swing.JButton();
        jButtonBorrarCarrera = new javax.swing.JButton();
        jButtonInsertarCorredor = new javax.swing.JButton();
        jButtonBorrarCorredor = new javax.swing.JButton();
        jComboBoxFiltroCarreras = new javax.swing.JComboBox<>();
        jTextFieldFiltrarCarreras = new javax.swing.JTextField();
        jButtonFiltrarCarreras = new javax.swing.JButton();
        jButtonFiltrarCorredores = new javax.swing.JButton();
        jComboBoxFiltroCorredores = new javax.swing.JComboBox<>();
        jTextFieldFiltrarCorredores = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanelTituloVerCarreras.setMaximumSize(new java.awt.Dimension(600, 75));
        jPanelTituloVerCarreras.setMinimumSize(new java.awt.Dimension(600, 75));
        jPanelTituloVerCarreras.setPreferredSize(new java.awt.Dimension(600, 75));

        jLabelTituloVerCarreras.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelTituloVerCarreras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloVerCarreras.setText("CARRERAS");
        jLabelTituloVerCarreras.setMinimumSize(new java.awt.Dimension(400, 70));
        jLabelTituloVerCarreras.setPreferredSize(new java.awt.Dimension(400, 70));

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonIniciarCarrera.setText("Iniciar");
        jButtonIniciarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTituloVerCarrerasLayout = new javax.swing.GroupLayout(jPanelTituloVerCarreras);
        jPanelTituloVerCarreras.setLayout(jPanelTituloVerCarrerasLayout);
        jPanelTituloVerCarrerasLayout.setHorizontalGroup(
            jPanelTituloVerCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloVerCarrerasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver)
                .addGap(110, 110, 110)
                .addComponent(jLabelTituloVerCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButtonIniciarCarrera)
                .addGap(18, 18, 18))
        );
        jPanelTituloVerCarrerasLayout.setVerticalGroup(
            jPanelTituloVerCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloVerCarrerasLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelTituloVerCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIniciarCarrera)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloVerCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelTituloVerCarrerasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonIniciarCarrera, jButtonVolver});

        getContentPane().add(jPanelTituloVerCarreras, java.awt.BorderLayout.PAGE_START);

        jPanelTablas.setMaximumSize(new java.awt.Dimension(800, 475));
        jPanelTablas.setMinimumSize(new java.awt.Dimension(800, 475));
        jPanelTablas.setPreferredSize(new java.awt.Dimension(800, 450));

        jTableCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCarreras.setMaximumSize(new java.awt.Dimension(190, 190));
        jTableCarreras.setMinimumSize(new java.awt.Dimension(100, 190));
        jTableCarreras.setPreferredSize(new java.awt.Dimension(190, 190));
        jTableCarreras.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTableCarreras.setSelectionForeground(new java.awt.Color(51, 0, 51));
        jTableCarreras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCarreras.getTableHeader().setReorderingAllowed(false);
        jTableCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCarrerasMouseClicked(evt);
            }
        });
        jScrollPaneCarreras.setViewportView(jTableCarreras);
        if (jTableCarreras.getColumnModel().getColumnCount() > 0) {
            jTableCarreras.getColumnModel().getColumn(0).setResizable(false);
            jTableCarreras.getColumnModel().getColumn(1).setResizable(false);
            jTableCarreras.getColumnModel().getColumn(2).setResizable(false);
            jTableCarreras.getColumnModel().getColumn(3).setResizable(false);
            jTableCarreras.getColumnModel().getColumn(4).setResizable(false);
        }

        jTableTiemposCorredores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTiemposCorredores.setMaximumSize(new java.awt.Dimension(190, 190));
        jTableTiemposCorredores.setMinimumSize(new java.awt.Dimension(100, 190));
        jTableTiemposCorredores.setPreferredSize(new java.awt.Dimension(190, 190));
        jTableTiemposCorredores.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTableTiemposCorredores.setSelectionForeground(new java.awt.Color(51, 0, 51));
        jTableTiemposCorredores.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableTiemposCorredores.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCorredores.setViewportView(jTableTiemposCorredores);
        if (jTableTiemposCorredores.getColumnModel().getColumnCount() > 0) {
            jTableTiemposCorredores.getColumnModel().getColumn(0).setResizable(false);
            jTableTiemposCorredores.getColumnModel().getColumn(1).setResizable(false);
            jTableTiemposCorredores.getColumnModel().getColumn(2).setResizable(false);
            jTableTiemposCorredores.getColumnModel().getColumn(3).setResizable(false);
            jTableTiemposCorredores.getColumnModel().getColumn(4).setResizable(false);
            jTableTiemposCorredores.getColumnModel().getColumn(5).setResizable(false);
            jTableTiemposCorredores.getColumnModel().getColumn(6).setResizable(false);
        }

        jButtonNuevaCarrera.setText("Nueva");
        jButtonNuevaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaCarreraActionPerformed(evt);
            }
        });

        jButtonModificarCarrera.setText("Modificar");
        jButtonModificarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarCarreraActionPerformed(evt);
            }
        });

        jButtonBorrarCarrera.setText("Borrar");
        jButtonBorrarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCarreraActionPerformed(evt);
            }
        });

        jButtonInsertarCorredor.setText("Insertar Corredor");
        jButtonInsertarCorredor.setMaximumSize(new java.awt.Dimension(74, 31));
        jButtonInsertarCorredor.setMinimumSize(new java.awt.Dimension(74, 31));
        jButtonInsertarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarCorredorActionPerformed(evt);
            }
        });

        jButtonBorrarCorredor.setText("Borrar");
        jButtonBorrarCorredor.setMaximumSize(new java.awt.Dimension(74, 31));
        jButtonBorrarCorredor.setMinimumSize(new java.awt.Dimension(74, 31));
        jButtonBorrarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCorredorActionPerformed(evt);
            }
        });

        jComboBoxFiltroCarreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonFiltrarCarreras.setText("Filtrar");
        jButtonFiltrarCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarCarrerasActionPerformed(evt);
            }
        });

        jButtonFiltrarCorredores.setText("Filtrar");
        jButtonFiltrarCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarCorredoresActionPerformed(evt);
            }
        });

        jComboBoxFiltroCorredores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelTablasLayout = new javax.swing.GroupLayout(jPanelTablas);
        jPanelTablas.setLayout(jPanelTablasLayout);
        jPanelTablasLayout.setHorizontalGroup(
            jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPaneCorredores)
                        .addGroup(jPanelTablasLayout.createSequentialGroup()
                            .addComponent(jComboBoxFiltroCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldFiltrarCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonFiltrarCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonInsertarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonBorrarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelTablasLayout.createSequentialGroup()
                            .addComponent(jComboBoxFiltroCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldFiltrarCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonFiltrarCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNuevaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonModificarCarrera)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonBorrarCarrera))
                        .addComponent(jScrollPaneCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanelTablasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBorrarCarrera, jButtonBorrarCorredor, jButtonModificarCarrera, jButtonNuevaCarrera});

        jPanelTablasLayout.setVerticalGroup(
            jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablasLayout.createSequentialGroup()
                .addComponent(jScrollPaneCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNuevaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonModificarCarrera)
                        .addComponent(jButtonBorrarCarrera))
                    .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFiltrarCarreras)
                        .addComponent(jTextFieldFiltrarCarreras)
                        .addComponent(jComboBoxFiltroCarreras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonInsertarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBorrarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFiltrarCorredores)
                        .addComponent(jTextFieldFiltrarCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxFiltroCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelTablasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBorrarCarrera, jButtonBorrarCorredor, jButtonInsertarCorredor, jButtonModificarCarrera, jButtonNuevaCarrera});

        jPanelTablasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxFiltroCarreras, jComboBoxFiltroCorredores});

        getContentPane().add(jPanelTablas, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    // TABLA CARRERAS
    private void refrescarTablaCarreras() {
        if (jTableCarreras.getSelectedRow() == -1) {
            this.carreraSeleccionada = null;
        }
        TableModelCarrera model = new TableModelCarrera();
        this.jTableCarreras.setModel(model);

        this.sorterCarreras = new TableRowSorter<>(model);
        this.jTableCarreras.setRowSorter(sorterCarreras);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorterCarreras.setSortKeys(sortKeys);
    }

    // BOTONES
    private void jButtonNuevaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaCarreraActionPerformed
        FormularioCarreras ventanaCarrera = new FormularioCarreras(pantallaPrincipal, true);
        ventanaCarrera.setVisible(true);
        refrescarTablaCarreras();
        refrescarTablaTiemposCorredores();
    }//GEN-LAST:event_jButtonNuevaCarreraActionPerformed

    private void jButtonModificarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarCarreraActionPerformed
        if (this.carreraSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una carrera", "Selecciona carrera", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.carreraSeleccionada.isCarreraCerrada()) {
            JOptionPane.showMessageDialog(this, "No puedes modificar la carrera porque ya está cerrada", "Carrera cerrada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Coger posicion de carrera seleccionada
            int posCarreraSeleccionada = jTableCarreras.getSelectedRow();
            
            FormularioCarreras ventanaCarrera = new FormularioCarreras(pantallaPrincipal, true, this.carreraSeleccionada);
            ventanaCarrera.setVisible(true);
            refrescarTablaCarreras();
            refrescarTablaTiemposCorredores();
            
            // Seleccionar la carrera otra vez
            ListSelectionModel selectionModel
                    = jTableCarreras.getSelectionModel();
            selectionModel.setSelectionInterval(posCarreraSeleccionada, posCarreraSeleccionada);
        }
    }//GEN-LAST:event_jButtonModificarCarreraActionPerformed

    private void jButtonBorrarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCarreraActionPerformed
        if (this.carreraSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una carrera", "Selecciona carrera", JOptionPane.INFORMATION_MESSAGE);
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrar la/s carrera/s seleccionadas?", "Confirmación de borrado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            try {
                LogicaCarrera.getInstance().bajaCarrera(this.carreraSeleccionada);
                this.carreraSeleccionada = null;
            } catch (ExcepcionesPropias.CarreraNoEsta ex) {
                JOptionPane.showMessageDialog(this, "La carrera no esta en la lista de carreras", "Carrera no existe", JOptionPane.ERROR_MESSAGE);
            }
            refrescarTablaCarreras();
            refrescarTablaTiemposCorredores();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha borrado ninguna carrera", "Borrado candelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBorrarCarreraActionPerformed

    // TABLA TIEMPOS CORREDORES
    private void refrescarTablaTiemposCorredores() {
        List<TiemposCorredor> corredores = (this.carreraSeleccionada == null) ? (new ArrayList<>()) : (this.carreraSeleccionada.getListaCorredores());

        // Modelo de la tabla
        TableModelTiemposCorredor model = new TableModelTiemposCorredor(corredores);
        this.jTableTiemposCorredores.setModel(model);

        // Sorter para las filas
        sorterCorredores = new TableRowSorter<>(model);
        this.jTableTiemposCorredores.setRowSorter(sorterCorredores);

        // Ordenar por defecto
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorterCorredores.setSortKeys(sortKeys);
    }

    private void jButtonInsertarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarCorredorActionPerformed
        if (this.carreraSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una carrera", "Carrera no seleccionada", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.carreraSeleccionada.isCarreraCerrada()) {
            JOptionPane.showMessageDialog(this, "No puedes añadir corredores porque la carrera ya está cerrada", "Carrera cerrada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Coger posicion de carrera seleccionada
            int posCarreraSeleccionada = jTableCarreras.getSelectedRow();

            // Abrir ventana de corredores
            VistaCorredores ventanaCorredores = new VistaCorredores(pantallaPrincipal, true, this.carreraSeleccionada);
            ventanaCorredores.setVisible(true);

            refrescarTablaCarreras();
            refrescarTablaTiemposCorredores();
            
            // Seleccionar la carrera otra vez
            ListSelectionModel selectionModel
                    = jTableCarreras.getSelectionModel();
            selectionModel.setSelectionInterval(posCarreraSeleccionada, posCarreraSeleccionada);
        }
    }//GEN-LAST:event_jButtonInsertarCorredorActionPerformed

    // ENLACE TABLAS
    private void jTableCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCarrerasMouseClicked
        try {
            this.carreraSeleccionada = LogicaCarrera.getInstance().getCarreras().get(this.jTableCarreras.convertRowIndexToModel(this.jTableCarreras.getSelectedRow()));
            habilitarBotones(!this.carreraSeleccionada.isCarreraCerrada());
            refrescarTablaTiemposCorredores();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una carrera", "Selecciona carrera", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jTableCarrerasMouseClicked

    // CORREDORES
    private void jButtonBorrarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCorredorActionPerformed
        if (this.carreraSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una carrera", "Carrera no seleccionada", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.carreraSeleccionada.isCarreraCerrada()) {
            JOptionPane.showMessageDialog(this, "No puedes borrar corredores porque la carrera ya está cerrada", "Carrera cerrada", JOptionPane.INFORMATION_MESSAGE);
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrar los corredores seleccionados de la carrera?", "Confirmación de borrado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            try {
                List<TiemposCorredor> corredores = new ArrayList<>();
                for (int i : this.jTableTiemposCorredores.getSelectedRows()) {
                    corredores.add(this.carreraSeleccionada.getListaCorredores().get(jTableTiemposCorredores.convertRowIndexToModel(i)));
                }
                if (corredores.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tienes que seleccionar un corredor", "Corredor no seleccionado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    LogicaCarrera.getInstance().delCorredores(this.carreraSeleccionada, corredores);
                    refrescarTablaTiemposCorredores();
                    refrescarTablaCarreras();
                }
            } catch (ExcepcionesPropias.CarreraCerrada ex) {
                JOptionPane.showMessageDialog(this, "La carrera está cerrada y no se pueden borrar corredores", "Carrera cerrada", JOptionPane.INFORMATION_MESSAGE);
            } catch (ExcepcionesPropias.CorredorNoEsta ex) {
                JOptionPane.showMessageDialog(this, "El corredor no se encuentra en la lista de la carrera", "Corredor no esta", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha borrado ningun corredor de la carrera", "Borrado candelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBorrarCorredorActionPerformed

    private void rellenarComboBoxFiltroCorredores() {
        this.jComboBoxFiltroCorredores.setModel(new DefaultComboBoxModel<>(TiemposCorredor.DATOS));
    }

    private void jButtonFiltrarCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarCorredoresActionPerformed
        RowFilter<TableModelTiemposCorredor, Integer> rowfilter;
        rowfilter = RowFilter.regexFilter(jTextFieldFiltrarCorredores.getText(), jComboBoxFiltroCorredores.getSelectedIndex());
        sorterCorredores.setRowFilter(rowfilter);
    }//GEN-LAST:event_jButtonFiltrarCorredoresActionPerformed

    private void rellenarComboBoxFiltroCarreras() {
        this.jComboBoxFiltroCarreras.setModel(new DefaultComboBoxModel<>(Carrera.DATOS));
    }

    private void jButtonFiltrarCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarCarrerasActionPerformed
        RowFilter<TableModelCarrera, Integer> rowfilter;
        rowfilter = RowFilter.regexFilter(jTextFieldFiltrarCarreras.getText(), jComboBoxFiltroCarreras.getSelectedIndex());
        sorterCarreras.setRowFilter(rowfilter);
    }//GEN-LAST:event_jButtonFiltrarCarrerasActionPerformed

    private void jButtonIniciarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarCarreraActionPerformed
        if (this.carreraSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una carrera", "Carrera no seleccionada", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.carreraSeleccionada.getListaCorredores().size() == 0) {
            JOptionPane.showMessageDialog(this, "Tienes que añadir corredores a la carrera", "Carrera sin corredores", JOptionPane.INFORMATION_MESSAGE);
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, "¿Seguro que quieres iniciar la carrera?", "Confirmación de inicio de carrera", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {
           // Coger posicion de carrera seleccionada
            int posCarreraSeleccionada = jTableCarreras.getSelectedRow();

            // Abrir ventana de corredores
            InicioCarrera inicioCarrera = new InicioCarrera(pantallaPrincipal, true, this.carreraSeleccionada);
            inicioCarrera.setVisible(true);

            habilitarBotones(!carreraSeleccionada.isCarreraCerrada());
            refrescarTablaCarreras();
            refrescarTablaTiemposCorredores();
            
            // Seleccionar la carrera otra vez
            ListSelectionModel selectionModel = jTableCarreras.getSelectionModel();
            selectionModel.setSelectionInterval(posCarreraSeleccionada, posCarreraSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha iniciado la carrera", "Inicio candelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIniciarCarreraActionPerformed

    // HABILITAR BOTONES
    private void habilitarBotones(boolean habilitar) {
        this.jButtonIniciarCarrera.setEnabled(habilitar);
        this.jButtonModificarCarrera.setEnabled(habilitar);
        this.jButtonInsertarCorredor.setEnabled(habilitar);
        this.jButtonBorrarCorredor.setEnabled(habilitar);
    }

    // MODELOS DE TABLA
    public static class TableModelCarrera extends AbstractTableModel {

        private List<Carrera> carreras;

        public TableModelCarrera() {
            this.carreras = LogicaCarrera.getInstance().getCarreras();
        }

        public TableModelCarrera(List<Carrera> carreras) {
            this.carreras = carreras;
        }
        
        @Override
        public String getColumnName(int column) {
            return Carrera.DATOS[column];
        }

        @Override
        public int getRowCount() {
            return carreras.size();
        }

        @Override
        public int getColumnCount() {
            return Carrera.DATOS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String array[] = carreras.get(rowIndex).toArray();
            return array[columnIndex];
        }

    }

    public static class TableModelTiemposCorredor extends AbstractTableModel {

        private final List<TiemposCorredor> corredoresCarreraSeleccionada;

        public TableModelTiemposCorredor(List<TiemposCorredor> listaCorredores) {
            this.corredoresCarreraSeleccionada = listaCorredores;
        }

        @Override
        public String getColumnName(int column) {
            return TiemposCorredor.DATOS[column];
        }

        @Override
        public int getRowCount() {
            return corredoresCarreraSeleccionada.size();
        }

        @Override
        public int getColumnCount() {
            return TiemposCorredor.DATOS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return corredoresCarreraSeleccionada.get(rowIndex).toArray()[columnIndex];
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrarCarrera;
    private javax.swing.JButton jButtonBorrarCorredor;
    private javax.swing.JButton jButtonFiltrarCarreras;
    private javax.swing.JButton jButtonFiltrarCorredores;
    private javax.swing.JButton jButtonIniciarCarrera;
    private javax.swing.JButton jButtonInsertarCorredor;
    private javax.swing.JButton jButtonModificarCarrera;
    private javax.swing.JButton jButtonNuevaCarrera;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxFiltroCarreras;
    private javax.swing.JComboBox<String> jComboBoxFiltroCorredores;
    private javax.swing.JLabel jLabelTituloVerCarreras;
    private javax.swing.JPanel jPanelTablas;
    private javax.swing.JPanel jPanelTituloVerCarreras;
    private javax.swing.JScrollPane jScrollPaneCarreras;
    private javax.swing.JScrollPane jScrollPaneCorredores;
    private javax.swing.JTable jTableCarreras;
    private javax.swing.JTable jTableTiemposCorredores;
    private javax.swing.JTextField jTextFieldFiltrarCarreras;
    private javax.swing.JTextField jTextFieldFiltrarCorredores;
    // End of variables declaration//GEN-END:variables
}
