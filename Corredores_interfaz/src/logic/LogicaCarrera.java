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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import utils.ExcepcionesPropias;
import utils.FicheroDeObjetos;
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
    private List<Carrera> carreras;
    private final String[] opcionesOrdenCarreras = {"Id", "Fecha", "Limite participantes", "Numero participantes"};

    private final boolean usarFichero = true;
    private final File fichero = new File("fichero_carreras.dat");
    private FicheroDeObjetos<Carrera> ficheroCarreras;

    // METODOS
    private LogicaCarrera() {
        this.carreras = new ArrayList<>();
        if (fichero.exists() && fichero.length() > 0) {
            this.ficheroCarreras = new FicheroDeObjetos<>(fichero);
            leerCarreras();
            fichero.delete();
        }
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        this.ficheroCarreras = new FicheroDeObjetos<>(fichero);
    }

    // COLECCION
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public boolean altaCarrera(String nombre, Date fecha, String lugar, int plazas) throws ExcepcionesPropias.CarreraRepetida {
        List<Carrera> ordenId = new ArrayList<>(carreras);
        Collections.sort(ordenId);
        int id = ordenId.isEmpty() ? (1) : (ordenId.get(ordenId.size() - 1).getId() + 1);
        Carrera c = new Carrera(id, nombre, fecha, lugar, plazas);
        if (!this.carreras.contains(c)) {
            return this.carreras.add(c);
        } else {
            throw new ExcepcionesPropias.CarreraRepetida();
        }
    }

    public boolean bajaCarrera(Carrera carrera) throws ExcepcionesPropias.CarreraNoEsta {
        if (!this.carreras.contains(carrera)) {
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
        carreras.add(c_modificada);
        return true;
    }

    // PERSISTENCIA
    public void guardarCarreras() {
        if (usarFichero) {
            guardarEnFichero();
        } else {
            // BASE DE DATOS
        }
    }

    public void leerCarreras() {
        if (usarFichero) {
            leerDeFichero();
        } else {
            // BASE DE DATOS
        }
    }

    // FICHERO
    private void guardarEnFichero() {
        ficheroCarreras.abrirEscritor(false);
        Iterator<Carrera> it = carreras.iterator();
        ficheroCarreras.grabarPrimerObjeto(it.next());
        while (it.hasNext()) {
            ficheroCarreras.grabarObjeto(it.next());
        }
        ficheroCarreras.cerrarEscritor();
    }

    private void leerDeFichero() {
        ficheroCarreras.abrirLector();
        Carrera c;
        while ((c = ficheroCarreras.leerObjeto()) != null) {
            carreras.add(c);
        }
        ficheroCarreras.cerrarLector();
    }

    // ORDENACION    
    public String[] getOpcionesOrdenCarreras() {
        return opcionesOrdenCarreras;
    }

    public void ordenarId() {
        Collections.sort(carreras);
    }

    public void ordenarFecha() {
        this.carreras.sort((Carrera o1, Carrera o2) -> o1.getFecha().compareTo(o2.getFecha()));
    }

    public void ordenarMaxCorredores() {
        this.carreras.sort((Carrera o1, Carrera o2) -> Integer.compare(o1.getMaxCorredores(), o2.getMaxCorredores()));
    }

    public void ordenarNumCorredores() {
        this.carreras.sort((Carrera o1, Carrera o2) -> Integer.compare(o1.getListaCorredores().size(), o2.getListaCorredores().size()));
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
