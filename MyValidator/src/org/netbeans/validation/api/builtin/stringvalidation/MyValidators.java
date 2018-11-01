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
        public void validate(Problems problemas, String nombreComponente, String dni) {

            if ((dni.length() != 9)) {
                String msg = NbBundle.getMessage(DniValidator.class, "INVALID_LONGITUDE", nombreComponente, "9");
                problemas.add(msg);
            } else {

                char ultimoCaracter = dni.charAt(dni.length() - 1);
                if (!Character.isLetter(ultimoCaracter)) {
                    String msg = NbBundle.getMessage(DniValidator.class, "MAY_END_WITH_LETTER", nombreComponente);
                    problemas.add(msg);
                }

                String numerosDni = dni.substring(0, 7);
                try {
                    Integer.parseInt(numerosDni);
                } catch (NumberFormatException ex) {
                    String msg = NbBundle.getMessage(DniValidator.class, "NOT_A_NUMBER", numerosDni, nombreComponente);
                    problemas.add(msg);
                }

            }
        }

    }

    public static class TelephoneValidator extends StringValidator {

        @Override
        public void validate(Problems problemas, String nombreComponente, String tfn) {

            if (tfn.length() != 9) {
                String msg = NbBundle.getMessage(TelephoneValidator.class, "INVALID_LONGITUDE", nombreComponente, "9");
                problemas.add(msg);
            } else {
                try {
                    int number = Integer.parseInt(tfn);
                    if (number < 0) {
                        String msg = NbBundle.getMessage(TelephoneValidator.class, "ERR_NEGATIVE_NUMBER", tfn);
                        problemas.add(msg);
                    }
                } catch (NumberFormatException ex) {
                    String msg = NbBundle.getMessage(TelephoneValidator.class, "ERR_NOT_INTEGER", tfn);
                    problemas.add(msg);
                }
            }
        }
    }

    public static class OnlyLetter extends StringValidator {

        @Override
        public void validate(Problems problemas, String nombreComponente, String texto) {

            boolean ok = true;
            if (texto.length() == 0) {
                String msg = NbBundle.getMessage(OnlyLetter.class, "MSG_MAY_NOT_BE_EMPTY", nombreComponente);
                problemas.add(msg);
            } else {
                for (int i = 0; i < texto.length(); i++) {
                    if (!Character.isAlphabetic(texto.charAt(i))) {
                        ok = false;
                    }
                }
                if (!ok) {
                    String msg = NbBundle.getMessage(OnlyLetter.class, "ONLY_LETTERS", nombreComponente);
                    problemas.add(msg);
                }
            }
        }
    }

}
