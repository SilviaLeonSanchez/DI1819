package gui;

import dto.Carrera;
import dto.TiemposCorredor;
import gui.VistaCarreras.TableModelTiemposCorredor;
import interfaces.ListenerLlegada;
import interfaces.ReceptorTiempoCronometro;
import java.awt.Component;
import java.awt.Frame;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author silvia
 */
public class InicioCarrera extends javax.swing.JDialog {

    private Component pantallaPrincipal;
    private TableRowSorter<TableModelTiemposCorredor> sorterCorredoresInicio;
    private List<TiemposCorredor> corredoresInicio;

    private TableRowSorter<TableModelTiemposCorredor> sorterCorredoresFin;
    private List<TiemposCorredor> corredoresFin;
    private final Carrera carrera;

    /**
     * Creates new form PantallaCorredor
     *
     * @param parent
     * @param modal
     */
    public InicioCarrera(java.awt.Frame parent, boolean modal, Carrera carrera) {
        super(parent, modal);
        this.pantallaPrincipal = (PantallaPrincipal) parent;
        initComponents();
        setLocationRelativeTo(null);
        this.carrera = carrera;
        setTitle("CARRERA " + carrera.getNombre().toUpperCase());
        jLabelTituloVerCarreras.setText("CARRERA " + carrera.getNombre().toUpperCase());
        rellenarComboBoxesFiltros();

        jTableTiemposCorredoresInicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.corredoresInicio = carrera.getListaCorredores();
        this.corredoresFin = new ArrayList<TiemposCorredor>();

        refrescarTablaTiemposCorredoresInicio(corredoresInicio);
        refrescarTablaTiemposCorredoresFin(corredoresFin);

        aniadirListenerCronometro(parent);

        jButtonLlegada.setEnabled(false);
        jButtonStop.setEnabled(false);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    private void aniadirListenerCronometro(Frame parent) {
        cronometro.addLlegadaListener(new ListenerLlegada() {
            @Override
            public ReceptorTiempoCronometro llegaReceptorACronometro() {

                int seleccionTabla = jTableTiemposCorredoresInicio.getSelectedRow();
                if (seleccionTabla == -1) {
                    JOptionPane.showMessageDialog(parent, "Tienes que seleccionar el corredor que ha llegado", "Selecciona corredor", JOptionPane.INFORMATION_MESSAGE);
                    return null;
                } else {

                    int corredorSeleccionado = jTableTiemposCorredoresInicio.convertRowIndexToModel(seleccionTabla);
                    TiemposCorredor corredorLlegada = corredoresInicio.get(corredorSeleccionado);
                    corredorLlegada.setTiempo(cronometro.getTiempo());
                    corredoresInicio.remove(corredorLlegada);
                    corredoresFin.add((TiemposCorredor) corredorLlegada);
                    return corredorLlegada;
                }
            }

            @Override
            public void vuelveReceptorDeCronometro(ReceptorTiempoCronometro corredorLlegada) {
                if (corredorLlegada != null) {
                    refrescarTablaTiemposCorredoresInicio(corredoresInicio);
                    refrescarTablaTiemposCorredoresFin(corredoresFin);
                }
            }
        });
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
        jPanelTablas = new javax.swing.JPanel();
        jScrollPaneCorredores = new javax.swing.JScrollPane();
        jTableTiemposCorredoresFin = new javax.swing.JTable();
        jButtonFiltrarCorredoresFin = new javax.swing.JButton();
        jComboBoxFiltroCorredoresFin = new javax.swing.JComboBox<>();
        jTextFieldFiltrarCorredoresFin = new javax.swing.JTextField();
        jScrollPaneCorredores1 = new javax.swing.JScrollPane();
        jTableTiemposCorredoresInicio = new javax.swing.JTable();
        jComboBoxFiltroCorredoresInicio = new javax.swing.JComboBox<>();
        jTextFieldFiltrarCorredoresInicio = new javax.swing.JTextField();
        jButtonFiltrarCorredoresInicio = new javax.swing.JButton();
        cronometro = new beans.Cronometro();
        jButtonStop = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jButtonLlegada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanelTituloVerCarreras.setMaximumSize(new java.awt.Dimension(600, 75));
        jPanelTituloVerCarreras.setMinimumSize(new java.awt.Dimension(600, 75));
        jPanelTituloVerCarreras.setPreferredSize(new java.awt.Dimension(600, 75));

        jLabelTituloVerCarreras.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelTituloVerCarreras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloVerCarreras.setText("CARRERA");
        jLabelTituloVerCarreras.setMinimumSize(new java.awt.Dimension(400, 70));
        jLabelTituloVerCarreras.setPreferredSize(new java.awt.Dimension(400, 70));

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTituloVerCarrerasLayout = new javax.swing.GroupLayout(jPanelTituloVerCarreras);
        jPanelTituloVerCarreras.setLayout(jPanelTituloVerCarrerasLayout);
        jPanelTituloVerCarrerasLayout.setHorizontalGroup(
            jPanelTituloVerCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloVerCarrerasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver)
                .addGap(33, 33, 33)
                .addComponent(jLabelTituloVerCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanelTituloVerCarrerasLayout.setVerticalGroup(
            jPanelTituloVerCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloVerCarrerasLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelTituloVerCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloVerCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanelTituloVerCarreras, java.awt.BorderLayout.PAGE_START);

        jPanelTablas.setMaximumSize(new java.awt.Dimension(800, 475));
        jPanelTablas.setMinimumSize(new java.awt.Dimension(800, 475));
        jPanelTablas.setPreferredSize(new java.awt.Dimension(800, 450));

        jTableTiemposCorredoresFin.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTiemposCorredoresFin.setMaximumSize(new java.awt.Dimension(190, 190));
        jTableTiemposCorredoresFin.setMinimumSize(new java.awt.Dimension(100, 190));
        jTableTiemposCorredoresFin.setPreferredSize(new java.awt.Dimension(190, 190));
        jTableTiemposCorredoresFin.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTableTiemposCorredoresFin.setSelectionForeground(new java.awt.Color(51, 0, 51));
        jTableTiemposCorredoresFin.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTiemposCorredoresFin.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCorredores.setViewportView(jTableTiemposCorredoresFin);
        if (jTableTiemposCorredoresFin.getColumnModel().getColumnCount() > 0) {
            jTableTiemposCorredoresFin.getColumnModel().getColumn(0).setResizable(false);
            jTableTiemposCorredoresFin.getColumnModel().getColumn(1).setResizable(false);
            jTableTiemposCorredoresFin.getColumnModel().getColumn(2).setResizable(false);
            jTableTiemposCorredoresFin.getColumnModel().getColumn(3).setResizable(false);
            jTableTiemposCorredoresFin.getColumnModel().getColumn(4).setResizable(false);
            jTableTiemposCorredoresFin.getColumnModel().getColumn(5).setResizable(false);
            jTableTiemposCorredoresFin.getColumnModel().getColumn(6).setResizable(false);
        }

        jButtonFiltrarCorredoresFin.setText("Filtrar");
        jButtonFiltrarCorredoresFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarCorredoresFinActionPerformed(evt);
            }
        });

        jComboBoxFiltroCorredoresFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTableTiemposCorredoresInicio.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTiemposCorredoresInicio.setMaximumSize(new java.awt.Dimension(190, 190));
        jTableTiemposCorredoresInicio.setMinimumSize(new java.awt.Dimension(100, 190));
        jTableTiemposCorredoresInicio.setPreferredSize(new java.awt.Dimension(190, 190));
        jTableTiemposCorredoresInicio.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTableTiemposCorredoresInicio.setSelectionForeground(new java.awt.Color(51, 0, 51));
        jTableTiemposCorredoresInicio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTiemposCorredoresInicio.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCorredores1.setViewportView(jTableTiemposCorredoresInicio);
        if (jTableTiemposCorredoresInicio.getColumnModel().getColumnCount() > 0) {
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(0).setResizable(false);
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(1).setResizable(false);
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(2).setResizable(false);
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(3).setResizable(false);
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(4).setResizable(false);
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(5).setResizable(false);
            jTableTiemposCorredoresInicio.getColumnModel().getColumn(6).setResizable(false);
        }

        jComboBoxFiltroCorredoresInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonFiltrarCorredoresInicio.setText("Filtrar");
        jButtonFiltrarCorredoresInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarCorredoresInicioActionPerformed(evt);
            }
        });

        cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cronometro.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N

        jButtonStop.setText("STOP");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonStart.setText("START");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonLlegada.setText("LLEGADA");
        jButtonLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLlegadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTablasLayout = new javax.swing.GroupLayout(jPanelTablas);
        jPanelTablas.setLayout(jPanelTablasLayout);
        jPanelTablasLayout.setHorizontalGroup(
            jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTablasLayout.createSequentialGroup()
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelTablasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTablasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneCorredores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                            .addComponent(jScrollPaneCorredores1)))
                    .addGroup(jPanelTablasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelTablasLayout.createSequentialGroup()
                                .addComponent(jComboBoxFiltroCorredoresFin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFiltrarCorredoresFin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFiltrarCorredoresFin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTablasLayout.createSequentialGroup()
                                .addComponent(jComboBoxFiltroCorredoresInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFiltrarCorredoresInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFiltrarCorredoresInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );
        jPanelTablasLayout.setVerticalGroup(
            jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablasLayout.createSequentialGroup()
                .addComponent(jScrollPaneCorredores1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrarCorredoresInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFiltrarCorredoresInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFiltroCorredoresInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTablasLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPaneCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrarCorredoresFin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFiltrarCorredoresFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFiltroCorredoresFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelTablas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        if (cronometro.isRunning()) {
            int resultado = JOptionPane.showConfirmDialog(this,
                    "Si sales se parará el cronómetro y se perderán los tiempos de los corredores. ¿Continuar?", 
                    "¿Abandonar carrera?", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resultado == JOptionPane.YES_OPTION) {
                this.cronometro.stop();
                
                // Poner los tiempos de los corredores a 0
                for (TiemposCorredor corredor : carrera.getListaCorredores()) {
                    corredor.setTiempo(Duration.ZERO);
                }
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "La carrera continuará sin cambios", "Continua la carrera", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButtonVolverActionPerformed

    // TABLA TIEMPOS CORREDORES
    private void refrescarTablaTiemposCorredoresInicio(List<TiemposCorredor> corredoresInicio) {

        // Modelo de la tabla
        TableModelTiemposCorredor model = new TableModelTiemposCorredor(corredoresInicio);
        this.jTableTiemposCorredoresInicio.setModel(model);

        // Sorter para las filas
        sorterCorredoresInicio = new TableRowSorter<>(model);
        this.jTableTiemposCorredoresInicio.setRowSorter(sorterCorredoresInicio);

        // Ordenar por defecto
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorterCorredoresInicio.setSortKeys(sortKeys);

    }

    private void refrescarTablaTiemposCorredoresFin(List<TiemposCorredor> corredoresFin) {

        // Modelo de la tabla
        TableModelTiemposCorredor model = new TableModelTiemposCorredor(corredoresFin);
        this.jTableTiemposCorredoresFin.setModel(model);

        // Sorter para las filas
        sorterCorredoresFin = new TableRowSorter<>(model);
        this.jTableTiemposCorredoresFin.setRowSorter(sorterCorredoresFin);

        // Ordenar por defecto
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorterCorredoresFin.setSortKeys(sortKeys);

    }

    private void rellenarComboBoxesFiltros() {
        this.jComboBoxFiltroCorredoresFin.setModel(new DefaultComboBoxModel<>(TiemposCorredor.DATOS));
        this.jComboBoxFiltroCorredoresInicio.setModel(new DefaultComboBoxModel<>(TiemposCorredor.DATOS));
    }

    private void jButtonFiltrarCorredoresFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarCorredoresFinActionPerformed
        RowFilter<TableModelTiemposCorredor, Integer> rowfilter;
        rowfilter = RowFilter.regexFilter(jTextFieldFiltrarCorredoresFin.getText(), jComboBoxFiltroCorredoresFin.getSelectedIndex());
        sorterCorredoresFin.setRowFilter(rowfilter);
    }//GEN-LAST:event_jButtonFiltrarCorredoresFinActionPerformed

    private void jButtonFiltrarCorredoresInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarCorredoresInicioActionPerformed
        RowFilter<TableModelTiemposCorredor, Integer> rowfilter;
        rowfilter = RowFilter.regexFilter(jTextFieldFiltrarCorredoresInicio.getText(), jComboBoxFiltroCorredoresInicio.getSelectedIndex());
        sorterCorredoresInicio.setRowFilter(rowfilter);
    }//GEN-LAST:event_jButtonFiltrarCorredoresInicioActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        carrera.setFecha(new Date());
        cronometro.start();
        jButtonStart.setEnabled(false);
        jButtonLlegada.setEnabled(true);
        jButtonStop.setEnabled(true);
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLlegadaActionPerformed
        cronometro.llegada();
    }//GEN-LAST:event_jButtonLlegadaActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        int resultado = JOptionPane.showConfirmDialog(pantallaPrincipal, "Si paras el cronometro se acabará la carrera. ¿Estas seguro?", "Fin de la carrera", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            cronometro.stop();
            carrera.cerrarCarrera();
            this.jButtonLlegada.setEnabled(false);
            this.jButtonStop.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonStopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private beans.Cronometro cronometro;
    private javax.swing.JButton jButtonFiltrarCorredoresFin;
    private javax.swing.JButton jButtonFiltrarCorredoresInicio;
    private javax.swing.JButton jButtonLlegada;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxFiltroCorredoresFin;
    private javax.swing.JComboBox<String> jComboBoxFiltroCorredoresInicio;
    private javax.swing.JLabel jLabelTituloVerCarreras;
    private javax.swing.JPanel jPanelTablas;
    private javax.swing.JPanel jPanelTituloVerCarreras;
    private javax.swing.JScrollPane jScrollPaneCorredores;
    private javax.swing.JScrollPane jScrollPaneCorredores1;
    private javax.swing.JTable jTableTiemposCorredoresFin;
    private javax.swing.JTable jTableTiemposCorredoresInicio;
    private javax.swing.JTextField jTextFieldFiltrarCorredoresFin;
    private javax.swing.JTextField jTextFieldFiltrarCorredoresInicio;
    // End of variables declaration//GEN-END:variables
}
