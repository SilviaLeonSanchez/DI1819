/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author silvia
 */
public class ExcepcionesPropias {
    
    public static class CarreraCerrada extends Exception{
        
        public CarreraCerrada(){
            super("La carrera esta cerrada");
        }
        
    }
    
    public static class DemasiadosCorredores extends Exception{
        
        public DemasiadosCorredores(){
            super("No se puede exceder el numero máximo de participantes en la carrera");
        }
        
    }
    
    public static class CorredorRepetido extends Exception{
        
        public CorredorRepetido(){
            super("El corredor no puede estar repetido");
        }
        
    }
    
    public static class CorredorNoEsta extends Exception{
        
        public CorredorNoEsta(){
            super("No se encuentra el corredor");
        }
        
    }
    
    public static class CarreraNoEsta extends Exception{
        
        public CarreraNoEsta(){
            super("No se encuentra la carrera");
        }
        
    }
    
    public static class CarreraRepetida extends Exception{
        
        public CarreraRepetida(){
            super("La carrera no puede estar repetida");
        }
        
    }
    
    
    
}
