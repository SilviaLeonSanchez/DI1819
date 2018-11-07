package gui;

import dto.Carrera;
import dto.Corredor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import logic.LogicaCarrera;
import logic.LogicaCorredor;
import utils.ExcepcionesPropias;

/**
 *
 * @author silvia
 */
public class VistaCorredores extends javax.swing.JDialog {

    private PantallaPrincipal pantallaPrincipal;
    private TableRowSorter<TableModelCorredor> sorterCorredores;
    private Carrera carreraParaAniadir;

    /**
     * Creates new form PantallaCorredor
     *
     * @param parent
     * @param modal
     */
    public VistaCorredores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        inicializarPantalla(parent);
        this.jButtonAniadirACarrera.setVisible(false);
    }

    public VistaCorredores(java.awt.Frame parent, boolean modal, Carrera carreraParaAniadir) {
        super(parent, modal);
        inicializarPantalla(parent);
        this.carreraParaAniadir = carreraParaAniadir;
        this.jButtonAniadirACarrera.setVisible(true);
    }

    private void inicializarPantalla(java.awt.Frame parent) {
        pantallaPrincipal = (PantallaPrincipal) parent;
        initComponents();
        setTitle("Corredores");
        setLocationRelativeTo(null);
        refrescarTablaCorredores();
        rellenarComboBoxFiltrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTituloVerCorredores = new javax.swing.JPanel();
        jLabelTituloVerCorredores = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jPanelListaCorredores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCorredores = new javax.swing.JTable();
        jPanelBotonesListaCorredores = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldFiltrar = new javax.swing.JTextField();
        jComboBoxFiltrar = new javax.swing.JComboBox<>();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonNuevoCorredor = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonAniadirACarrera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanelTituloVerCorredores.setMaximumSize(new java.awt.Dimension(32767, 75));
        jPanelTituloVerCorredores.setMinimumSize(new java.awt.Dimension(640, 75));
        jPanelTituloVerCorredores.setPreferredSize(new java.awt.Dimension(640, 75));

        jLabelTituloVerCorredores.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelTituloVerCorredores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloVerCorredores.setText("CORREDORES");
        jLabelTituloVerCorredores.setMinimumSize(new java.awt.Dimension(400, 70));
        jLabelTituloVerCorredores.setPreferredSize(new java.awt.Dimension(400, 70));

        jButtonVolver.setText("<--");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTituloVerCorredoresLayout = new javax.swing.GroupLayout(jPanelTituloVerCorredores);
        jPanelTituloVerCorredores.setLayout(jPanelTituloVerCorredoresLayout);
        jPanelTituloVerCorredoresLayout.setHorizontalGroup(
            jPanelTituloVerCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloVerCorredoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jLabelTituloVerCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanelTituloVerCorredoresLayout.setVerticalGroup(
            jPanelTituloVerCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloVerCorredoresLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelTituloVerCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTituloVerCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanelTituloVerCorredores, java.awt.BorderLayout.PAGE_START);

        jTableCorredores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCorredores.setMaximumSize(new java.awt.Dimension(2147483647, 190));
        jTableCorredores.setMinimumSize(new java.awt.Dimension(190, 190));
        jTableCorredores.setName(""); // NOI18N
        jTableCorredores.setPreferredSize(new java.awt.Dimension(300, 190));
        jTableCorredores.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTableCorredores.setSelectionForeground(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(jTableCorredores);
        if (jTableCorredores.getColumnModel().getColumnCount() > 0) {
            jTableCorredores.getColumnModel().getColumn(0).setResizable(false);
            jTableCorredores.getColumnModel().getColumn(1).setResizable(false);
            jTableCorredores.getColumnModel().getColumn(2).setResizable(false);
            jTableCorredores.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanelBotonesListaCorredores.setMaximumSize(new java.awt.Dimension(800, 150));
        jPanelBotonesListaCorredores.setMinimumSize(new java.awt.Dimension(800, 150));
        jPanelBotonesListaCorredores.setPreferredSize(new java.awt.Dimension(800, 150));

        jComboBoxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(jComboBoxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextFieldFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxFiltrar)))
                .addContainerGap())
        );

        jButtonNuevoCorredor.setText("Nuevo");
        jButtonNuevoCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoCorredorActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonAniadirACarrera.setText("Añadir a carrera");
        jButtonAniadirACarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirACarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesListaCorredoresLayout = new javax.swing.GroupLayout(jPanelBotonesListaCorredores);
        jPanelBotonesListaCorredores.setLayout(jPanelBotonesListaCorredoresLayout);
        jPanelBotonesListaCorredoresLayout.setHorizontalGroup(
            jPanelBotonesListaCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesListaCorredoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelBotonesListaCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelBotonesListaCorredoresLayout.createSequentialGroup()
                        .addComponent(jButtonNuevoCorredor, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAniadirACarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 23, Short.MAX_VALUE))
        );

        jPanelBotonesListaCorredoresLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBorrar, jButtonModificar, jButtonNuevoCorredor});

        jPanelBotonesListaCorredoresLayout.setVerticalGroup(
            jPanelBotonesListaCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesListaCorredoresLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelBotonesListaCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAniadirACarrera)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonNuevoCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanelBotonesListaCorredoresLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAniadirACarrera, jButtonBorrar, jButtonModificar, jButtonNuevoCorredor});

        javax.swing.GroupLayout jPanelListaCorredoresLayout = new javax.swing.GroupLayout(jPanelListaCorredores);
        jPanelListaCorredores.setLayout(jPanelListaCorredoresLayout);
        jPanelListaCorredoresLayout.setHorizontalGroup(
            jPanelListaCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaCorredoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jPanelBotonesListaCorredores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelListaCorredoresLayout.setVerticalGroup(
            jPanelListaCorredoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaCorredoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotonesListaCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelListaCorredores, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // SALIR
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    // TABLA
    private void refrescarTablaCorredores() {
        TableModelCorredor model = new TableModelCorredor();
        this.jTableCorredores.setModel(model);

        this.sorterCorredores = new TableRowSorter<>(model);
        this.jTableCorredores.setRowSorter(sorterCorredores);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorterCorredores.setSortKeys(sortKeys);
    }

    // BOTONES
    private void jButtonNuevoCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoCorredorActionPerformed
        FormularioCorredores ventanaCorredor = new FormularioCorredores(pantallaPrincipal, true);
        ventanaCorredor.setVisible(true);
        refrescarTablaCorredores();
    }//GEN-LAST:event_jButtonNuevoCorredorActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        int seleccionado[] = jTableCorredores.getSelectedRows();
        if (seleccionado.length == 0) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar un corredor", "Selecciona corredor", JOptionPane.INFORMATION_MESSAGE);
        } else if (seleccionado.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecciona un solo corredor para modificar", "Demasiados corredores seleccionados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Corredor corredor = LogicaCorredor.getInstance().getCorredores().get(jTableCorredores.convertRowIndexToModel(seleccionado[0]));
            FormularioCorredores ventanaCorredor = new FormularioCorredores(pantallaPrincipal, true, corredor);
            ventanaCorredor.setVisible(true);
            refrescarTablaCorredores();
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        int seleccionado[] = jTableCorredores.getSelectedRows();
        if (seleccionado.length == 0) {
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar un corredor", "Selecciona corredor", JOptionPane.INFORMATION_MESSAGE);
        } else if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrar los corredores seleccionados?", "Confirmación de borrado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            try {
                Corredor corredor = LogicaCorredor.getInstance().getCorredores().get(jTableCorredores.convertRowIndexToModel(seleccionado[0]));
                LogicaCorredor.getInstance().bajaCorredor(corredor);
                LogicaCarrera.bajaCorredorCarreras(corredor);
                refrescarTablaCorredores();
            } catch (ExcepcionesPropias.CorredorNoEsta ex) {
                JOptionPane.showMessageDialog(this, "El corredor no existe", "Corredor no existe", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha borrado ningun corredor", "Borrado candelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonAniadirACarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirACarreraActionPerformed
        if (carreraParaAniadir == null) {
            JOptionPane.showMessageDialog(this, "No se ha podido añadir ningun corredor. La carrera es nula", "Carrera nula", JOptionPane.ERROR_MESSAGE);
        } else {
            List<Corredor> corredoresParaAniadir = new ArrayList<>();
            for (int i : this.jTableCorredores.getSelectedRows()) {
                corredoresParaAniadir.add(LogicaCorredor.getInstance().getCorredores().get(jTableCorredores.convertRowIndexToModel(i)));
            }
            if (corredoresParaAniadir.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tienes que seleccionar un corredor", "Corredor no seleccionado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    if (LogicaCarrera.getInstance().addCorredores(carreraParaAniadir, corredoresParaAniadir)) {
                        JOptionPane.showMessageDialog(this, "Corredores añadidos correctamente", "Corredores añadidos", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se ha podido añadir ningun corredor", "Corredores no añadidos", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ExcepcionesPropias.CarreraCerrada ex) {
                    JOptionPane.showMessageDialog(this, "La carrera está cerrada y no se pueden añadir corredores", "Carrera cerrada", JOptionPane.INFORMATION_MESSAGE);
                } catch (ExcepcionesPropias.DemasiadosCorredores ex) {
                    JOptionPane.showMessageDialog(this, "No se puede superar el número máximo de corredores para la carrera", "Demasiados corredores", JOptionPane.INFORMATION_MESSAGE);
                } catch (ExcepcionesPropias.CorredorRepetido ex) {
                    JOptionPane.showMessageDialog(this, "El corredor ya esta incluido en la lista de corredores de la carrera", "Corredor repetido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_jButtonAniadirACarreraActionPerformed

    private void rellenarComboBoxFiltrar() {
        this.jComboBoxFiltrar.setModel(new DefaultComboBoxModel<>(Corredor.DATOS));
    }

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        RowFilter<TableModelCorredor, Integer> rowfilter;
        rowfilter = RowFilter.regexFilter(jTextFieldFiltrar.getText(), jComboBoxFiltrar.getSelectedIndex());
        sorterCorredores.setRowFilter(rowfilter);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    //  MODELO DE TABLA
    public static class TableModelCorredor extends AbstractTableModel {

        @Override
        public String getColumnName(int column) {
            return Corredor.DATOS[column];
        }

        @Override
        public int getRowCount() {
            return LogicaCorredor.getInstance().getCorredores().size();
        }

        @Override
        public int getColumnCount() {
            return Corredor.DATOS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return LogicaCorredor.getInstance().getCorredores().get(rowIndex).toArray()[columnIndex];
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAniadirACarrera;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevoCorredor;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxFiltrar;
    private javax.swing.JLabel jLabelTituloVerCorredores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotonesListaCorredores;
    private javax.swing.JPanel jPanelListaCorredores;
    private javax.swing.JPanel jPanelTituloVerCorredores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCorredores;
    private javax.swing.JTextField jTextFieldFiltrar;
    // End of variables declaration//GEN-END:variables
}
