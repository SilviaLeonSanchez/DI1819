/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import dto.Carrera;
import javax.swing.table.AbstractTableModel;
import utils.ExcepcionesPropias;
import utils.FicheroObjetos;
import utils.Utiles;

/**
 *
 * @author silvia
 */
public class LogicaCarrera {

    private static LogicaCarrera INSTANCE;

    // Constructor privado
    public static LogicaCarrera getInstance() throws IOException, ExcepcionesPropias.CarreraRepetida {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCarrera();
        }
        return INSTANCE;
    }

    // ATRIBUTOS
    private List<Carrera> carreras;
    private FicheroObjetos ficheroCarreras;
    private final String[] opcionesOrdenCarreras = {"Fecha", "Limite participantes", "Numero participantes"};

    // METODOS
    private LogicaCarrera(File fichero, boolean usarFichero) throws IllegalArgumentException, ExcepcionesPropias.CarreraRepetida {
        if (fichero.exists() & fichero.canRead() & fichero.canWrite()) {
            this.ficheroCarreras = new FicheroObjetos(fichero);
        } else {
            throw new IllegalArgumentException("El fichero no es valido o no existe.");
        }
        leerCarreras(usarFichero);
    }

    private LogicaCarrera() throws IOException, ExcepcionesPropias.CarreraRepetida {
        this.carreras = new ArrayList<>();
        File fichero = new File("fichero_carreras.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        this.ficheroCarreras = new FicheroObjetos(fichero);
        leerCarreras(true);
    }

    // COLECCION
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public boolean altaCarrera(Carrera c) throws ExcepcionesPropias.CarreraRepetida, IOException {
        if (!LogicaCarrera.getInstance().getCarreras().contains(c)) {
            return LogicaCarrera.getInstance().altaCarrera(c);
        } else {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
    }

    public boolean bajaCarrera(Carrera carrera) throws ExcepcionesPropias.CorredorNoEsta, ExcepcionesPropias.CarreraNoEsta {
        if (!carreras.contains(carrera)) {
            throw new ExcepcionesPropias.CarreraNoEsta();
        }
        return carreras.remove(carrera);
    }

    public boolean modificarCarrera(Carrera c_original, Carrera c_modificada) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.CarreraNoEsta, ExcepcionesPropias.CarreraRepetida {
        if (c_original.isCarreraCerrada()) {
            throw new ExcepcionesPropias.CarreraCerrada();

        } else if (!carreras.contains(c_original)) {
            throw new ExcepcionesPropias.CarreraNoEsta();

        } else if ((!c_original.equals(c_modificada)) && carreras.contains(c_modificada)) {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
        carreras.remove(c_original);
        return carreras.add(c_modificada);
    }

    // PERSISTENCIA
    public void guardarCarreras(boolean usarFichero) {
        if (usarFichero) {
            guardarEnFichero();
        } else {
            // BASE DE DATOS
        }
    }

    public void leerCarreras(boolean usarFichero) throws ExcepcionesPropias.CarreraRepetida {
        if (usarFichero) {
            leerDeFichero();
        } else {
            // BASE DE DATOS
        }
    }

    // FICHERO
    private void guardarEnFichero() {
        ficheroCarreras.abrirEscritor(false);
        Iterator it = carreras.iterator();
        ficheroCarreras.grabarPrimerObjeto(it.next());
        while (it.hasNext()) {
            ficheroCarreras.grabarObjeto(it.next());
        }
        ficheroCarreras.cerrarEscritor();
    }

    private void leerDeFichero() throws ExcepcionesPropias.CarreraRepetida {
        ficheroCarreras.abrirLector();
        Carrera c;
        while ((c = (Carrera) ficheroCarreras.leerObjeto()) != null) {
            if (!carreras.contains(c)) {
                carreras.add(c);
            } else {
                throw new ExcepcionesPropias.CarreraRepetida();
            }
        }
        ficheroCarreras.cerrarLector();
    }

    // ORDENACION    
    public String[] getOpcionesOrdenCarreras() {
        return opcionesOrdenCarreras;
    }

    public void ordenarFecha() {
        Collections.sort(carreras, (Carrera o1, Carrera o2) -> o1.getFecha().compareTo(o2.getFecha()));
    }

    public void ordenarMaxCorredores() {
        Collections.sort(carreras, (Carrera o1, Carrera o2) -> Integer.compare(o1.getMaxCorredores(), o2.getMaxCorredores()));
    }

    public void ordenarNumCorredores() {
        Collections.sort(carreras, (Carrera o1, Carrera o2) -> Integer.compare(o1.getListaCorredores().size(), o2.getListaCorredores().size()));
    }

    public static class TableModelCarrera extends AbstractTableModel {

        private final List<Carrera> listaCarreras;

        public TableModelCarrera(List<Carrera> listaCarreras) {
            this.listaCarreras = listaCarreras;
        }

        @Override
        public String getColumnName(int column) {
            return Carrera.DATOS[column];
        }

        @Override
        public int getRowCount() {
            return listaCarreras.size();
        }

        @Override
        public int getColumnCount() {
            return Carrera.DATOS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return listaCarreras.get(rowIndex).getId();
                case 1:
                    return listaCarreras.get(rowIndex).getNombre();
                case 2:
                    return Utiles.Sdf.format(listaCarreras.get(rowIndex).getFecha());
                case 3:
                    return listaCarreras.get(rowIndex).getLugar();
                case 4:
                    return listaCarreras.get(rowIndex).getMaxCorredores();
                case 5:
                    return (listaCarreras.get(rowIndex).isCarreraCerrada()) ? ("SI") : ("NO");
                default:
                    return null;
            }
        }

    }

}
