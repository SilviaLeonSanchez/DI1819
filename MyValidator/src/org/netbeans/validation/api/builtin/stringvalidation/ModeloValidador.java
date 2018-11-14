/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 *
 * @author silvia
 */
public class ModeloValidador {

    /* El nombre del componente lo coge del campo Name, hay que añadirlo en los atributos */
 /* Para que coja los mensajes del españos añadimos en el metodo run
            Locale.setDefault(new Locale("es", "ES"));
     */
    public class EjemploValidador extends StringValidator {

        @Override
        public void validate(Problems problems, String nombreComponente, String textoAValidar) {

            /* Cuidado, al principio estara vacio */
            if (textoAValidar.equals(" ")) {

                /* NOMBRE_MSG es para recuperar del bundle el mensaje, o es de la libreria, 
                o lo he creado yo y lo recupero indicando el nombre.
                Despues indico los parametros que me pide el mensaje si los hay*/
                String msg = NbBundle.getMessage(ModeloValidador.class, "NOMBRE_MSG", nombreComponente);
                problems.add(msg);
            }

        }
    }

}
