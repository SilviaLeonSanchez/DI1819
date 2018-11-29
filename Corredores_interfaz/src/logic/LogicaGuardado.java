/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.Corredor;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import utils.FicheroDeObjetos;
import utils.FicheroDeTexto;

/**
 *
 * @author silvia
 */
public class LogicaGuardado {

    private transient Timer timer;
    private int intervaloGuardado;
    
    private LogicaGuardado INSTANCE;
    
    public LogicaGuardado getInstance(){
        if ()
    }
    
    
    private final boolean usarFichero = true;
    
    private FicheroDeObjetos<LogicaCarrera> gestorFicheroCarreras;
    private final File ficheroCarreras = new File("fichero_carreras.dat");
    
    private FicheroDeObjetos<LogicaCorredor> gestorFicheroCorredores;
    private final File ficheroCorredores = new File("fichero_corredores.dat");
    
    private FicheroDeTexto gestorCSVCorredores;
    private final File ficheroCSVCorredores = new File("fichero_corredores.csv");
    
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
            leerLogicaCarreras();
            leerLogicaCorredores();
        } else {
            // BASE DE DATOS
        }
    }

    public void guardarDatos() {
        if (usarFichero) {
            guardarLogicaCarreras();
            guardarLogicaCorredores();
            guardarCorredoresCSV();
        } else {
            // BASE DE DATOS
        }
    }

    
    // FICHERO CARRERAS
    private boolean leerLogicaCarreras() {
        if (checkFicheroCarreras()) {
            LogicaCarrera logicaCarreras = null;
            if (ficheroCarreras.length() > 0) {
                this.gestorFicheroCarreras.abrirLector();
                logicaCarreras = gestorFicheroCarreras.leerObjeto();
                this.gestorFicheroCarreras.cerrarLector();
            }
            LogicaCarrera.setInstance(logicaCarreras);
            return true;
        } else {
            return false;
        }
    }

    private boolean guardarLogicaCarreras() {
        if (checkFicheroCarreras()) {
            gestorFicheroCarreras.abrirEscritor(false);
            gestorFicheroCarreras.grabarPrimerObjeto(LogicaCarrera.getInstance());
            gestorFicheroCarreras.cerrarEscritor();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFicheroCarreras() {
        if (!ficheroCarreras.exists()) {
            try {
                ficheroCarreras.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        this.gestorFicheroCarreras = new FicheroDeObjetos<>(ficheroCarreras);
        return true;
    }

    //  FICHERO CORREDORES
    private boolean leerLogicaCorredores() {
        if (checkFicheroCorredores()) {
            LogicaCorredor logicaCorredores = null;
            if (ficheroCorredores.length() > 0) {
                this.gestorFicheroCorredores.abrirLector();
                logicaCorredores = gestorFicheroCorredores.leerObjeto();
                this.gestorFicheroCorredores.cerrarLector();
            }
            LogicaCorredor.setInstance(logicaCorredores);
            return true;
        } else {
            return false;
        }
    }

    private boolean guardarLogicaCorredores() {
        if (checkFicheroCorredores()) {
            gestorFicheroCorredores.abrirEscritor(false);
            gestorFicheroCorredores.grabarPrimerObjeto(LogicaCorredor.getInstance());
            gestorFicheroCorredores.cerrarEscritor();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFicheroCorredores() {
        if (!ficheroCorredores.exists()) {
            try {
                ficheroCorredores.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        this.gestorFicheroCorredores = new FicheroDeObjetos<>(ficheroCorredores);
        return true;
    }
    
    // CSV CORREDORES
    private boolean guardarCorredoresCSV(){
        if (!ficheroCSVCorredores.exists()) {
            try {
                ficheroCSVCorredores.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        this.gestorCSVCorredores = new FicheroDeTexto(ficheroCSVCorredores);
        this.gestorCSVCorredores.abrirEscritor(false);
        
        // CABECERA
        for(String nombreAtributo : Corredor.DATOS){
            gestorCSVCorredores.print(nombreAtributo+",");
        }
        gestorCSVCorredores.print("\n");
        
        // CORREDORES
        for (Corredor corredor : LogicaCorredor.getInstance().getCorredores()){
            for (String atributo : corredor.toArray()){
                gestorCSVCorredores.print(atributo+",");
            }
            gestorCSVCorredores.print("\n");
        }
        
        this.gestorCSVCorredores.cerrarEscritor();
        return true;
    }

}
