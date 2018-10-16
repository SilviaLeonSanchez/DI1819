package logic;

import utils.FicheroTexto;
import dto.Corredor;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;
import utils.ExcepcionesPropias;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class LogicaCorredor {

    // PATRON DE DISEÑO SINGLETON 
    // Para que solo se pueda crear una instancia
    private static LogicaCorredor INSTANCE;

    // Constructor privado
    public static LogicaCorredor getInstance() throws IOException, ExcepcionesPropias.CorredorRepetido {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCorredor();
        }
        return INSTANCE;
    }

    // ATRIBUTOS
    private ArrayList<Corredor> corredores;
    private FicheroTexto fichero_corredores;
    private final String separadorCSV;
    private final String[] opcionesOrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};

    // METODOS
    private LogicaCorredor(File fichero, String separadorCSV, boolean usarFichero) throws IllegalArgumentException, ExcepcionesPropias.CorredorRepetido {
        if (fichero.exists() & fichero.canRead() & fichero.canWrite()) {
            this.fichero_corredores = new FicheroTexto(fichero);
        } else {
            throw new IllegalArgumentException("El fichero no es valido o no existe.");
        }
        this.separadorCSV = separadorCSV;
        leerCorredores(usarFichero);
    }

    private LogicaCorredor() throws IOException, ExcepcionesPropias.CorredorRepetido {
        this.corredores = new ArrayList<>();
        File fichero = new File("fichero_corredores.csv");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        this.fichero_corredores = new FicheroTexto(fichero);
        this.separadorCSV = ";";
        leerCorredores(true);
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy"); // Meses en mayuscular porque sino cree que es minutos
        Corredor runner = null;
        try {
            runner = new Corredor(tokens.get(0), tokens.get(1),
                    sdf.parse(tokens.get(2)), tokens.get(3), tokens.get(4));
        } catch (ParseException ex) {
            System.out.println("Error al transformar la fecha del fichero");
        }
        return runner;
    }

    private String toStringCSV(Corredor corredor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy"); // Meses en mayuscular porque sino cree que es minutos
        String linea = corredor.getDni() + this.separadorCSV;
        linea += corredor.getNombre() + this.separadorCSV;
        linea += sdf.format(corredor.getFecha_nac()) + this.separadorCSV;
        linea += corredor.getDireccion() + this.separadorCSV;
        linea += corredor.getTelefono() + this.separadorCSV;
        return linea;
    }

    private void leerCSV() throws ExcepcionesPropias.CorredorRepetido {
        this.fichero_corredores.abrirLector();
        String linea = null;
        Corredor runner = null;
        while ((linea = this.fichero_corredores.leerString()) != null) {
            runner = toRunner(linea);
            if (!this.corredores.contains(runner)) {
                this.corredores.add(runner);
            } else {
                throw new ExcepcionesPropias.CorredorRepetido();
            }
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
