package logic;

import utils.FicheroTexto;
import dto.Corredor;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import utils.ExcepcionesPropias;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class LogicaCorredor {

    private static LogicaCorredor INSTANCE;

    // ATRIBUTOS
    private List<Corredor> corredores;
    private FicheroTexto fichero_corredores;
    private final String separadorCSV;
    private final String[] opcionesOrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};
    private final boolean persistenciaEnFichero = true;

    // METODOS
    public static LogicaCorredor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCorredor();
        }
        return INSTANCE;
    }

    private LogicaCorredor() {
        this.separadorCSV = ";";
        this.corredores = new ArrayList<>();
        File fichero = new File("fichero_corredores.csv");
        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            this.fichero_corredores = new FicheroTexto(fichero);
            leerCorredores(true);
        } catch (IOException | ExcepcionesPropias.CorredorRepetido ex) {
            System.out.println(ex.getMessage());
        }
    }

    // COLECCION
    public List<Corredor> getCorredores() {
        return corredores;
    }

    public Corredor buscarCorredor(Corredor c) {
        return this.corredores.get(this.corredores.indexOf(c));
    }

    public boolean altaCorredor(String dni, String nombre, Date fecha_nac, String dir, String tfn) throws ExcepcionesPropias.CorredorRepetido {
        Corredor c = new Corredor(dni, nombre, fecha_nac, dir, tfn);
        if (!this.corredores.contains(c)) {
            corredores.add(c);
            return true;
        } else {
            throw new ExcepcionesPropias.CorredorRepetido();
        }
    }

    public boolean bajaCorredor(Corredor c) throws ExcepcionesPropias.CorredorNoEsta {
        if (!corredores.contains(c)) {
            throw new ExcepcionesPropias.CorredorNoEsta();
        }
        return corredores.remove(c);
    }

    public void modificarCorredor(Corredor c_original, Corredor c_modificado) {
        corredores.remove(c_original);
        corredores.add(c_modificado);
    }

    // PERSISTENCIA
    public void guardarCorredores(boolean usarFichero) {
        if (usarFichero) {
            guardarCSV();
        } else {
            // BASE DE DATOS
        }
    }

    public void leerCorredores(boolean usarFichero) throws ExcepcionesPropias.CorredorRepetido {
        if (usarFichero) {
            leerCSV();
        } else {
            // BASE DE DATOS
        }
    }

    // FICHERO
    private Corredor toRunner(String linea) {
        if (linea == null) {
            throw new IllegalArgumentException("No se puede convertir a string un objeto null");
        }
        StringTokenizer st = new StringTokenizer(linea, this.separadorCSV);
        ArrayList<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        Corredor runner = null;
        try {
            runner = new Corredor(tokens.get(0), tokens.get(1),
                    Utiles.Sdf.parse(tokens.get(2)), tokens.get(3), tokens.get(4));
        } catch (ParseException ex) {
            System.out.println("Error al transformar la fecha del fichero");
        }
        return runner;
    }

    private String toStringCSV(Corredor corredor) {
        String linea = "";
        for (String string : corredor.toArray()) {
            linea = linea.concat(string + this.separadorCSV);
        }
        return linea;
    }

    private void leerCSV() {
        this.fichero_corredores.abrirLector();
        String linea = null;
        while ((linea = this.fichero_corredores.leerString()) != null) {
            this.corredores.add(toRunner(linea));
        }
        this.fichero_corredores.cerrarLector();
    }

    private void guardarCSV() {
        this.fichero_corredores.abrirEscritor(false);
        for (Corredor runner : corredores) {
            fichero_corredores.println(toStringCSV(runner));
        }
        this.fichero_corredores.cerrarEscritor();
    }

    // BBDD
    // ORDENACION    
    public String[] getOpcionesOrdenCorredores() {
        return opcionesOrdenCorredores;
    }

    public void ordenarDni() {
        Collections.sort(this.corredores);
    }

    public void ordenarFechaNac() {
        Collections.sort(corredores, (Corredor o1, Corredor o2) -> o1.getFecha_nac().compareTo(o2.getFecha_nac()));
    }

    public void ordenarNombre() {
        Collections.sort(corredores, (Corredor o1, Corredor o2) -> o1.getNombre().compareTo(o2.getNombre()));
    }

    public static class TableModelCorredor extends AbstractTableModel {

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
                    return Utiles.Sdf.format(listaCorredores.get(rowIndex).getFecha_nac());
                case 3:
                    return listaCorredores.get(rowIndex).getDireccion();
                case 4:
                    return listaCorredores.get(rowIndex).getTelefono();
                default:
                    return null;
            }
        }

    }

}
