/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.Carrera;
import dto.Corredor;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import utils.FicheroDeObjetos;

/**
 *
 * @author silvia
 */
public class LogicaGuardado {

    private final boolean usarFichero = true;
    private static LogicaGuardado INSTANCE;

    public static LogicaGuardado getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogicaGuardado();
        }
        return INSTANCE;
    }

    // PERSISTENCIA
    public void cargarDatos() {
        if (usarFichero) {
            leerCarrerasFichero();
            leerCorredoresFichero();
        } else {
            // BASE DE DATOS
        }
    }

    public void guardarDatos() {
        if (usarFichero) {
            guardarCarrerasEnFichero();
            guardarCorredoresFichero();
        } else {
            // BASE DE DATOS
        }
    }

    
    // CARRERAS
    private FicheroDeObjetos<Carrera> gestorFicheroCarreras;
    private final File ficheroCarreras = new File("fichero_carreras.dat");

    // FICHERO
    private void leerCarrerasFichero() {
        // Comprobar si existe el fichero
        if (!ficheroCarreras.exists()) {
            try {
                ficheroCarreras.createNewFile();
                this.gestorFicheroCarreras = new FicheroDeObjetos<>(ficheroCarreras);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            this.gestorFicheroCarreras = new FicheroDeObjetos<>(ficheroCarreras);

            // Abrir el fichero para leer las carreras
            this.gestorFicheroCarreras.abrirLector();
            Carrera c;
            while ((c = gestorFicheroCarreras.leerObjeto()) != null) {

                // Añadir cada carrera a la collecion de carreras de la logica
                LogicaCarrera.getInstance().getCarreras().add(c);
            }
            this.gestorFicheroCarreras.cerrarLector();
        }
    }

    private void guardarCarrerasEnFichero() {
        gestorFicheroCarreras.abrirEscritor(false);
        Iterator<Carrera> it = LogicaCarrera.getInstance().getCarreras().iterator();
        if (it.hasNext()) {
            gestorFicheroCarreras.grabarPrimerObjeto(it.next());
        }
        while (it.hasNext()) {
            gestorFicheroCarreras.grabarObjeto(it.next());
        }
        gestorFicheroCarreras.cerrarEscritor();
    }

    
    // CORREDORES
    private FicheroDeObjetos<Corredor> gestorFicheroCorredores;
    private final File ficheroCorredores = new File("fichero_corredores.dat");

    // FICHERO
    private void leerCorredoresFichero() {
        // Comprobar si existe el fichero
        if (!ficheroCorredores.exists()) {
            try {
                ficheroCorredores.createNewFile();
                this.gestorFicheroCorredores = new FicheroDeObjetos<>(ficheroCorredores);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            this.gestorFicheroCorredores = new FicheroDeObjetos<>(ficheroCorredores);

            // Abrir el fichero para leer las carreras
            this.gestorFicheroCorredores.abrirLector();
            Corredor c;
            while ((c = gestorFicheroCorredores.leerObjeto()) != null) {

                // Añadir cada carrera a la collecion de carreras de la logica
                LogicaCorredor.getInstance().getCorredores().add(c);
            }
            this.gestorFicheroCorredores.cerrarLector();
        }
    }

    private void guardarCorredoresFichero() {
        gestorFicheroCorredores.abrirEscritor(false);
        Iterator<Corredor> it = LogicaCorredor.getInstance().getCorredores().iterator();
        if (it.hasNext()) {
            gestorFicheroCorredores.grabarPrimerObjeto(it.next());
        }
        while (it.hasNext()) {
            gestorFicheroCorredores.grabarObjeto(it.next());
        }
        gestorFicheroCorredores.cerrarEscritor();
    }

}
