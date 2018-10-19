/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import dto.Carrera;
import java.util.Map;
import java.util.TreeMap;
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
    private Map<Integer,Carrera> carreras;
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
        this.carreras = new TreeMap<>();
        File fichero = new File("fichero_carreras.dat");
        this.ficheroCarreras = new FicheroObjetos(fichero);
        if (!fichero.exists() || fichero.length()==0) {
            fichero.createNewFile();
        } else {
            leerCarreras(true);
        }

    }

    // COLECCION
    public Map<Integer,Carrera> getCarreras() {
        return carreras;
    }

    public boolean altaCarrera(Carrera c) throws ExcepcionesPropias.CarreraRepetida, IOException {
        if (this.carreras.putIfAbsent(c.getId(),c)==null) {
            return true;
        } else {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
    }

    public boolean bajaCarrera(Carrera carrera) throws ExcepcionesPropias.CorredorNoEsta, ExcepcionesPropias.CarreraNoEsta {
        if (carreras.remove(carrera.getId())==null) {
            throw new ExcepcionesPropias.CarreraNoEsta();
        }
        return true;
    }

    public boolean modificarCarrera(Carrera c_original, Carrera c_modificada) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.CarreraNoEsta, ExcepcionesPropias.CarreraRepetida {
        if (c_original.isCarreraCerrada()) {
            throw new ExcepcionesPropias.CarreraCerrada();

        } else if (!carreras.containsKey(c_original.getId())) {
            throw new ExcepcionesPropias.CarreraNoEsta();

        } else if ((!c_original.equals(c_modificada)) && carreras.containsKey(c_modificada.getId())) {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
        carreras.remove(c_original);
        carreras.put(c_modificada.getId(), c_modificada);
        return true;
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
        Iterator it = carreras.values().iterator();
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
            if (!carreras.containsKey(c.getId())) {
                carreras.put(c.getId(), c);
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
