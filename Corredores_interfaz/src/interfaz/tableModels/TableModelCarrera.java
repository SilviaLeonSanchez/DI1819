/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.tableModels;

import javax.swing.table.AbstractTableModel;
import utiles.Utiles.Sdf;

/**
 *
 * @author silvia
 */
public class TableModelCarrera extends AbstractTableModel {

    /*
    private final List<Runner> listaCarreras;
    //private final String[] columnas = Runner.DATOS;
    
    public TableModelCarrera(List<Runner> listaCorredores) {
    this.listaCorredores = listaCorredores;
    }
    
     */
    
    @Override
    public int getRowCount() {
        //return listaCorredores.size();
        return 0;
    }
    
    @Override
    public int getColumnCount() {
        //return columnas.length;
        return 0;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        /*switch (columnIndex) {
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
        }*/
        return null;
    }
}
