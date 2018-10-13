/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import modelo.Carrera;
import modelo.Corredor;
import utiles.ExcepcionesPropias;
import utiles.FicheroObjetos;
import utiles.FicheroTexto;

/**
 *
 * @author silvia
 */
public class LogicaCarrera {

    private static LogicaCarrera INSTANCE;

    // Constructor privado
    public static LogicaCarrera getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new LogicaCarrera();
        }
        return INSTANCE;
    }

    // ATRIBUTOS
    private HashSet<Carrera> carreras;
    private FicheroObjetos ficheroCarreras;
    private final String[] opcionesOrdenCarreras = {"Fecha", "Limite participantes", "Numero participantes"};

    // METODOS
    private LogicaCarrera(File fichero, boolean usarFichero) throws IllegalArgumentException {
        if (fichero.exists() & fichero.canRead() & fichero.canWrite()) {
            this.ficheroCarreras = new FicheroObjetos(fichero);
        } else {
            throw new IllegalArgumentException("El fichero no es valido o no existe.");
        }
        leerCarreras(usarFichero);
    }

    private LogicaCarrera() throws IOException {
        this.carreras = new HashSet<>();
        File fichero = new File("fichero_corredores.csv");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        this.ficheroCarreras = new FicheroObjetos(fichero);
        leerCarreras(true);
    }

    // COLECCION
    public List<Corredor> getCarreras() {
        return new ArrayList(carreras);
    }

    public boolean altaCarrera(String nombre, Date fecha, String lugar, int maxCorredores) {
        return carreras.add(new Carrera(nombre, fecha, lugar, maxCorredores));
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

    public void leerCarreras(boolean usarFichero) {
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

    private void leerDeFichero() {
        ficheroCarreras.abrirLector();
        Carrera c;
        while ((c = (Carrera) ficheroCarreras.leerObjeto()) != null) {
            carreras.add(c);
        }
        ficheroCarreras.cerrarLector();
    }

    // ORDENACION    
    public String[] getOpcionesOrdenCarreras() {
        return opcionesOrdenCarreras;
    }

    public List<Carrera> ordenarFecha() {
        List<Carrera> lista_ordenada = new ArrayList(carreras);
        Collections.sort(lista_ordenada, (Carrera o1, Carrera o2) -> o1.getFecha().compareTo(o2.getFecha()));
        return lista_ordenada;
    }

    public List<Carrera> ordenarMaxCorredores() {
        List<Carrera> lista_ordenada = new ArrayList(carreras);
        Collections.sort(lista_ordenada, (Carrera o1, Carrera o2) -> Integer.compare(o1.getMaxCorredores(), o2.getMaxCorredores()));
        return lista_ordenada;
    }

    public List<Carrera> ordenarNumCorredores() {
        List<Carrera> lista_ordenada = new ArrayList(carreras);
        Collections.sort(lista_ordenada, (Carrera o1, Carrera o2) -> Integer.compare(o1.getListaCorredores().size(), o2.getListaCorredores().size()));
        return lista_ordenada;
    }

}
