/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasources;

import dto.Carrera;
import java.util.ArrayList;
import logicaNegocio.Logica;

/**
 *
 * @author silvia
 */
public class CarrerasDataSource {
    
    public static ArrayList<Carrera> getCarrerasSinFinalizar(){
        ArrayList<Carrera> carrerasSinFinalizar = new ArrayList<>();
        Logica logica  = new Logica();
        
        for (Carrera carrera : logica.getCarreras()) {
            if (!carrera.isCarreraCerrada()){
                carrerasSinFinalizar.add(carrera);
            }
        }
        
        return carrerasSinFinalizar;
    } 
    
}
