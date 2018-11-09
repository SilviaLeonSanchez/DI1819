/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosaschachis;

import java.io.Serializable;

/**
 *
 * @author silvia
 */
public class JavaBean implements Serializable {

    public JavaBean() {
    }

    /*
    
    Todos los componentes visuales son JavaBeans y tienen que cumplir :
        - Constructor sin parametros (para poder incluirlo en la paleta), OJO no vacio
        - Implementar serializable (para que Netbeans pueda guardar el estado del componente)
        - Getter y setter por defecto para todos los atributos (para que pueda llamarlos en el initComponents() )
    
    Podemos tener atributos (no tienen getter ni setter) y propiedades 
    (estan expuestas al exterior: visible, texto, color...)
    
    Para no tener que crearlo desde cero podemos utilizar la herencia y 
    extender de un componente que nos interese
    
    Hay que incorporarlo a la paleta (Add to palette en herramientas)
    
    Si tenemos un error en el constructor no podemos ver el componente en la 
    vista diseño porque para mostrarlo netbeans promero lo compila y no va a poder.
    Si queremos depurar tenemos que crear a mano el componente en el codigo fuente (sin vista diseño) y depurar
    
    Si ponemos propiedades la paleta viene preparada para trabajar con det tipos:
        boolean
        int
        float
        String
        Color
        Font
        File
    
    
     */
}
