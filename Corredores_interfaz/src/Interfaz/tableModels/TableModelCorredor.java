/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Runner;

/**
 *
 * @author silvia
 */
public class TableModelCorredor extends AbstractTableModel {

    private final List<Runner> listaAlumnos;
    private final String[] columnas = Runner.DATOS;

    public TableModelCorredor(List<Runner> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public int getRowCount() {
        return listaAlumnos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                li
        }
        
        
        
        
        
    }

}
