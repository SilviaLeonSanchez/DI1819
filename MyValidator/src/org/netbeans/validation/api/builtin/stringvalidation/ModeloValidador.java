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
public class ModeloValidador extends StringValidator{

    @Override
    public void validate(Problems problems, String string, String nombreComponente) {
        if (string.equals(" ")){
        String msg = NbBundle.getMessage(ModeloValidador.class, "NOMBRE_MSG", nombreComponente);
        problems.add(msg);
        }
        
    
    }
    
}
