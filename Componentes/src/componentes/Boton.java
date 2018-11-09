/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author silvia
 */
public class Boton extends JButton implements Serializable {

    private String RUTA_DEFECTO = "log_click.txt";
    private File archivoGuardado;
    private int contadorClick;

    public Boton() {
        this.archivoGuardado = new File(RUTA_DEFECTO);
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contadorClick++;
                guardar_log();
            }
        });
    }

    public File getArchivoGuardado() {
        return archivoGuardado;
    }

    public void setArchivoGuardado(File archivoGuardado) {
        this.archivoGuardado = archivoGuardado;
    }

    private void guardar_log() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        PrintWriter pw;
        while (true) {
            try {
                pw = new PrintWriter(new FileWriter(archivoGuardado, true), true);
                pw.print("Pulsacion: " + contadorClick + "\t" + sdf.format(new Date()) + "\n");
                pw.flush();
                pw.close();
                return;
            } catch (FileNotFoundException ex) {
                this.archivoGuardado = new File(RUTA_DEFECTO);
                this.contadorClick = 1;
            } catch (IOException ex) {
                System.out.println("No se pudo acceder al fichero.");
            }
        }
    }

}
