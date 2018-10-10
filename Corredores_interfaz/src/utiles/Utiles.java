/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

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
    
    public static class Sdf{
        
        private static final String FORMATO = "dd/MM/yy";
        private static final SimpleDateFormat SDF = new SimpleDateFormat(FORMATO);
        
        public static String format(Date fecha){
            return SDF.format(fecha);
        }
        
        public static Date parse(String fecha) throws ParseException{
            return SDF.parse(fecha);
        }
        
    }
    
    // Ejemplo de llamada a un JOptionPane desde otra clase 
    public static void salirSinGuardar(Window w){
        int result = JOptionPane.showConfirmDialog(w, "Los cambios no se guardarán. ¿Salir?", "Salir sin guardar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            w.dispose();
        }
    }
    
}
