/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author silvia
 */
public class Fichero_csv {

    // ATRIBUTOS
    private File fichero;
    private PrintWriter pw;
    private BufferedReader br;

    // METODOS
    // CONSTRUCTOR    
    /**
     * Crea un objeto de tipo FicheroDeTexto y asigna el parametro al atributo
     * fichero.
     *
     * @param fichero abre el flujo de transferencia de
     * caracteres para leer o grabar en el.
     */
    public Fichero_csv(File fichero) {
        this.fichero = fichero;
    }

    // ABRIR FICHERO
    /**
     * Abre el flujo para grabar en el fichero. Si el fichero no existe lo crea,
     * si no puede devuelve un mensaje,
     *
     * @param anadir True para escribir la informacion al final de la existente,
     * False para sobrescribir.
     */
    public void abrirEscritor(boolean anadir) {
        try {
            pw = new PrintWriter(new FileWriter(fichero, anadir), true);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException ex) {
            System.out.println("No se pudo acceder al fichero.");
        }
    }

    /**
     * Abre el flujo para leer del fichero situando el puntero en la posicion
     * inicial. Devuelve un mensaje si el fichero no existe.
     */
    public void abrirLector() {
        try {
            br = new BufferedReader(new FileReader(fichero));
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe.");
        }
    }

    // CIERRAR FICHERO
    /**
     * Cierra el flujo de escritura abierto con el fichero.
     */
    public void cerrarEscritor() {
        pw.flush();
        pw.close();
    }

    /**
     * Cierra el flujo de lectura abierto con el fichero.
     */
    public void cerrarLector() {
        try {
            br.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido cerrar el fichero.");
        }
    }

    // GRABAR
    /**
     * Graba como caracteres en el fichero el valor del String introducido. Si
     * no puede grabarlo muestra un mensaje de error.
     *
     * @param x El String que se quiere grabar en el fichero.
     */
    public void print(String x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del String introducido y
     * despues salta de linea. Si no puede grabarlo muestra un mensaje de error.
     *
     * @param x El String que se quiere grabar en el fichero.
     */
    public void println(String x) {
        pw.println(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del float introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El float que se quiere grabar en el fichero.
     */
    public void print(float x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del int introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El int que se quiere grabar en el fichero.
     */
    public void print(int x) {
        pw.print(x);
        pw.flush();
    }

    /**
     * Graba como caracteres en el fichero el valor del byte introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El byte que se quiere grabar en el fichero.
     */
    public void print(byte x) {
        pw.print(x);
        pw.flush();
    }

    // LEER
    /**
     * Lee una linea del fichero y la devuelve. Si llega al final de fichero o
     * tiene un error devuelve null y muestra un mensaje.
     *
     * @return El String que ha leido del fichero.
     */
    public String leerString() {
        String linea = "";
        try {
            linea = br.readLine();
            return linea;
        } catch (IOException ex) {
            System.out.println("Error al leer la linea del fichero.");
            return null;
        }
    }

}
