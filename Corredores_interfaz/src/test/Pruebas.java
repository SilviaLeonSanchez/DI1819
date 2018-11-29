/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.time.Duration;
import java.time.Instant;
import utils.Duracion;

/**
 *
 * @author silvia
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Instant instante = Instant.now();
        
        Duration duracion = Duration.between(instante, instante);
        
        
        
        System.out.println(Duracion.verDuracionFormatoCorto(duracion));
        
        
    }
    
}
