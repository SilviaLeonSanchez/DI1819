/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author silvia
 */
public class Utiles {

    public static class Sdf {

        private static final String FORMATO_FECHA = "dd/MM/yy";
        private static final String FORMATO_HORA = "hh:mm:ss S";
        private static SimpleDateFormat SDF;

        public static String formatFecha(Date fecha) {
            SDF = new SimpleDateFormat(FORMATO_FECHA);
            return SDF.format(fecha);
        }

        public static Date parseFecha(String fecha) throws ParseException {
            SDF = new SimpleDateFormat(FORMATO_FECHA);
            return SDF.parse(fecha);
        }
        
        public static String formatHora(Date hora) {
            SDF = new SimpleDateFormat(FORMATO_HORA);
            return SDF.format(hora);
        }

        public static Date parseHora(String hora) throws ParseException {
            SDF = new SimpleDateFormat(FORMATO_HORA);
            return SDF.parse(hora);
        }

    }

    // Ejemplo de llamada a un JOptionPane desde otra clase 
    public static void salirSinGuardar(Window w) {
        int result = JOptionPane.showConfirmDialog(w, "Los cambios no se guardarán. ¿Salir?", "Salir sin guardar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            w.dispose();
        }
    }

}
