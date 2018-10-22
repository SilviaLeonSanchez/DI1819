package logic;

import dto.Corredor;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.table.AbstractTableModel;
import org.openide.util.Exceptions;
import utils.ExcepcionesPropias;
import utils.FicheroDeObjetos;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class LogicaCorredor {

    private static LogicaCorredor INSTANCE;

    // ATRIBUTOS
    private List<Corredor> corredores;
    private final String[] opcionesOrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};

    private final boolean usarFichero = true;
    private final File fichero = new File("fichero_corredores.dat");
    private FicheroDeObjetos<Corredor> fichero_corredores;

    // METODOS
    public static LogicaCorredor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCorredor();
        }
        return INSTANCE;
    }

    private LogicaCorredor() {
        this.corredores = new ArrayList<>();

        if (fichero.exists() && fichero.length() > 0) {
            this.fichero_corredores = new FicheroDeObjetos<>(fichero);
            leerCorredores();
            fichero.delete();
        }
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        this.fichero_corredores = new FicheroDeObjetos<>(fichero);
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
    public void guardarCorredores() {
        if (usarFichero) {
            guardarFichero();
        } else {
            // BASE DE DATOS
        }
    }

    public void leerCorredores() {
        if (usarFichero) {
            leerFichero();
        } else {
            // BASE DE DATOS
        }
    }

    // FICHERO
    private void leerFichero() {
        this.fichero_corredores.abrirLector();
        Corredor c = null;
        while ((c = this.fichero_corredores.leerObjeto()) != null) {
            this.corredores.add(c);
        }
        this.fichero_corredores.cerrarLector();
    }

    private void guardarFichero() {
        this.fichero_corredores.abrirEscritor(false);
        Iterator<Corredor> it = corredores.iterator();
        fichero_corredores.grabarPrimerObjeto(it.next());
        for (Corredor runner : corredores) {
            fichero_corredores.grabarObjeto(runner);
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
