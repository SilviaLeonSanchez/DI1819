/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Runner;
import utiles.Utiles.Sdf;

/**
 *
 * @author silvia
 */
public class TableModelCorredor extends AbstractTableModel {

    private final List<Runner> listaCorredores;
    private final String[] columnas = Runner.DATOS;

    public TableModelCorredor(List<Runner> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    @Override
    public int getRowCount() {
        return listaCorredores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaCorredores.get(rowIndex).getDni();
            case 1:
                return listaCorredores.get(rowIndex).getNombre();
            case 2:
                return Sdf.format(listaCorredores.get(rowIndex).getFecha_nac());
            case 3:
                return listaCorredores.get(rowIndex).getDireccion();
            case 4:
                return listaCorredores.get(rowIndex).getTelefono();
            default:
                return null;
        }
    }

}
