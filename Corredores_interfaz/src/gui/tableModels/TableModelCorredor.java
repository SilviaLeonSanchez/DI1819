/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import dto.Corredor;
import utils.Utiles.Sdf;

/**
 *
 * @author silvia
 */
public class TableModelCorredor extends AbstractTableModel {

    private final List<Corredor> listaCorredores;

    public TableModelCorredor(List<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    @Override
    public String getColumnName(int column) {
        return Corredor.DATOS[column];
    }

    @Override
    public int getRowCount() {
        return listaCorredores.size();
    }

    @Override
    public int getColumnCount() {
        return Corredor.DATOS.length;
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
