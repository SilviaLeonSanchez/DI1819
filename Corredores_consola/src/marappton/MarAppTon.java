/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marappton;

import Vistas.VistaRunner;
import java.io.IOException;

/**
 *
 * @author silvia
 */
public class MarAppTon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VistaRunner vista;
        try {
            vista = new VistaRunner();
            vista.menu_principal();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el fichero de almacenamiento");
        }

    }

}