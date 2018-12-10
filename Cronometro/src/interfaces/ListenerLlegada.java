/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;



/**
 *
 * @author ubuntu
 */
public interface ListenerLlegada {
    
    public ReceptorTiempoCronometro llegaReceptorACronometro();
    
    public void vuelveReceptorDeCronometro(ReceptorTiempoCronometro receptor);
    
}
