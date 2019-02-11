/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasources;

import dto.Carrera;
import dto.TiemposCorredor;
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
    
    public static ArrayList<Carrera> getCarrera(){
        Logica logica  = new Logica();
        ArrayList<Carrera> arrayList = new ArrayList<>();
        arrayList.add(logica.getCarreras().get(0));  // Para pruebas con Preview en iReport
        //arrayList.add(logica.getCarreraElegida());
        return arrayList;
    } 
    
    public static ArrayList<TiemposCorredor> getCorredoresCarreraElegida(){
        return getCarrera().get(0).getListaCorredores();
    }
    
}
