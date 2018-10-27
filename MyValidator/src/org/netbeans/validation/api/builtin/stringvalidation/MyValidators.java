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
public class MyValidators {

    public static class DniValidator extends StringValidator {

        @Override
        public void validate(Problems problems, String string, String nombreComponente) {
            /*
            boolean valid = false;
            
            if (!valid) {
            String msg = NbBundle.getMessage(ModeloValidador.class, "NOMBRE_MSG", nombreComponente);
            problems.add(msg);
            }
            
            if ((!esLetra(dni.charAt(dni.length() - 1))) | (dni.length() != 9)) {
            throw new IllegalArgumentException();
            }
            for (byte i = 0; i <= 7; i++) {
            if (!esNum(dni.charAt(i))) {
            throw new IllegalArgumentException();
            }
            }*/
        }

    }

    public static class TelephoneValidator extends StringValidator {

        @Override
        public void validate(Problems prblms, String string, String t) {
            /*
            if (tfn.length() != 9) {
            throw new IllegalArgumentException();
            }
            for (char c : tfn.toCharArray()) {
            if (!esNum(c)) {
            throw new IllegalArgumentException();
            }
            }
             */
        }
    }

}
