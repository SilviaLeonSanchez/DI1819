/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import dto.Carrera;
import java.util.Comparator;
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
    public static LogicaCarrera getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCarrera();
        }
        return INSTANCE;
    }

    // ATRIBUTOS
    private TreeMap<Integer, Carrera> carreras;
    private FicheroObjetos ficheroCarreras;
    private final String[] opcionesOrdenCarreras = {"Id", "Fecha", "Limite participantes", "Numero participantes"};

    // METODOS
    private LogicaCarrera() {
        this.carreras = new TreeMap<>();
        File fichero = new File("fichero_carreras.dat");
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            leerCarreras(true);
        }
        this.ficheroCarreras = new FicheroObjetos(fichero);
    }

    // COLECCION
    public Map<Integer, Carrera> getCarreras() {
        return carreras;
    }

    public boolean altaCarrera(Carrera c) throws ExcepcionesPropias.CarreraRepetida {
        if (this.carreras.putIfAbsent(c.getId(), c) == null) {
            return true;
        } else {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
    }

    public boolean bajaCarrera(Carrera carrera) throws ExcepcionesPropias.CarreraNoEsta {
        if (carreras.remove(carrera.getId()) == null) {
            return true;
        } else {
            throw new ExcepcionesPropias.CarreraNoEsta();
        }
    }

    public boolean modificarCarrera(Carrera c_original, Carrera c_modificada) throws ExcepcionesPropias.CarreraCerrada, ExcepcionesPropias.CarreraNoEsta, ExcepcionesPropias.CarreraRepetida {
        if (c_original.isCarreraCerrada()) {
            throw new ExcepcionesPropias.CarreraCerrada();

        } else if (!carreras.containsKey(c_original.getId())) {
            throw new ExcepcionesPropias.CarreraNoEsta();

        } else if ((!c_original.equals(c_modificada)) && carreras.containsKey(c_modificada.getId())) {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
        carreras.remove(c_original.getId());
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

    public void leerCarreras(boolean usarFichero){
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

    private void leerDeFichero() {
        ficheroCarreras.abrirLector();
        Carrera c;
        while ((c = (Carrera) ficheroCarreras.leerObjeto()) != null) {
            carreras.put(c.getId(), c);
        }
        ficheroCarreras.cerrarLector();
    }

    // ORDENACION    
    public String[] getOpcionesOrdenCarreras() {
        return opcionesOrdenCarreras;
    }
    
    public void ordenarId() {
        this.carreras = new TreeMap(this.carreras);
    }

    public void ordenarFecha() {
        this.carreras = new TreeMap(new Comparator<Carrera>() {
            @Override
            public int compare(Carrera o1, Carrera o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
    }

    public void ordenarMaxCorredores() {
        this.carreras = new TreeMap(new Comparator<Carrera>() {
            @Override
            public int compare(Carrera o1, Carrera o2) {
                return Integer.compare(o1.getMaxCorredores(), o2.getMaxCorredores());
            }
        });
    }

    public void ordenarNumCorredores() {
        this.carreras = new TreeMap(new Comparator<Carrera>() {
            @Override
            public int compare(Carrera o1, Carrera o2) {
                return Integer.compare(o1.getListaCorredores().size(), o2.getListaCorredores().size());
            }
        });
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
