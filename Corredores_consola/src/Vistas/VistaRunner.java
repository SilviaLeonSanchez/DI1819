/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Logica.LogicaAplicacion;
import Modelos.Runner;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author silvia
 */
public class VistaRunner extends Vista {

    private LogicaAplicacion logica;

    public VistaRunner(File fichero, String separador) {
        this.logica = new LogicaAplicacion(fichero, separador);
        this.logica.volcar_de_csv();
    }

    public VistaRunner() throws IOException {
        this.logica = new LogicaAplicacion();
        this.logica.volcar_de_csv();
    }

    // MENUS
    @Override
    public void ver_menu_principal() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("MENU PRINCIPAL:");
        System.out.println("1. Alta");
        System.out.println("2. Baja");
        System.out.println("3. Modificacion");
        System.out.println("4. Ver corredores");
        System.out.println("5. Buscar corredor");
        System.out.println("6. Salir");
        System.out.println("------------------------------");
    }

    public void menu_principal() {
        Runner r = null;
        byte opcion = 1;
        while (opcion != 6) {
            ver_menu_principal();
            opcion = pedirByte("Introduce una opcion: ");
            if (opcion < 1 | opcion > 6) {
                entrada_erronea();
            } else {
                switch (opcion) {
                    case 1:
                        if (logica.alta_corredor(pedir_dni(), pedir_nombre(), pedir_fecha_nac(), pedir_dir(), pedir_tfn())) {
                            corredor_creado();
                        } else {
                            ya_existe();
                        }
                        break;
                    case 2:
                        if (logica.baja_corredor(pedir_dni())) {
                            corredor_borrado();
                        } else {
                            no_existe();
                        }
                        break;
                    case 3:
                        r = logica.buscar_corredor(pedir_dni());
                        if (r == null) {
                            no_existe();
                        } else {
                            ver_corredor(r);
                            menu_modificar(r);
                        }
                        break;
                    case 4:
                        menu_ordenar();
                        break;
                    case 5:
                        r = logica.buscar_corredor(pedir_dni());
                        if (r == null) {
                            no_existe();
                        } else {
                            ver_corredor(r);
                        }
                        break;
                }
            }
        }
        //logica.volcar_a_csv();
        salir_aplicacion();
    }

    public void ver_menu_modificar() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("MODIFICAR:");
        System.out.println("1. Dni");
        System.out.println("2. Nombre");
        System.out.println("3. Direccion");
        System.out.println("4. Telefono");
        System.out.println("5. Fecha de nacimiento");
        System.out.println("6. Ver cambios");
        System.out.println("7. Guardar cambios");
        System.out.println("8. Salir");
        System.out.println("------------------------------");
    }

    private void menu_modificar(Runner c) {
        Runner c_mod = (Runner) c.clone();
        byte opcion = 1;
        while (opcion != 8) {
            ver_menu_modificar();
            opcion = pedirByte("Introduce una opcion: ");
            if (opcion < 1 | opcion > 8) {
                entrada_erronea();
            } else {
                switch (opcion) {
                    case 1:
                        if (logica.modificar_dni(c_mod, pedir_dni())) {
                            corredor_modificado();
                        } else {
                            ya_existe();
                        }
                        break;
                    case 2:
                        logica.modificar_nombre(c_mod, pedir_nombre());
                        modificado_correctamente("nombre");
                        break;
                    case 3:
                        logica.modificar_direccion(c_mod, pedir_dir());
                        modificado_correctamente("direccion");
                        break;
                    case 4:
                        logica.modificar_tfn(c_mod, pedir_tfn());
                        modificado_correctamente("telefono");
                        break;
                    case 5:
                        logica.modificar_fecha_nac(c_mod, pedir_fecha_nac());
                        modificado_correctamente("fecha de nacimiento");
                        break;
                    case 6:
                        ver_corredor(c_mod);
                        break;
                    case 7:
                        logica.guardar_cambios(c, c_mod);
                        logica.volcar_a_csv();
                        cambios_guardados();
                }
            }
        }
        salir_menu();
    }

    public void ver_menu_ordenar() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("ORDENAR:");
        System.out.println("1. Dni");
        System.out.println("2. Nombre");
        System.out.println("3. Fecha de nacimiento");
        System.out.println("4. Salir");
        System.out.println("------------------------------");
    }

    public void menu_ordenar() {
        byte opcion = 1;
        while (opcion != 4) {
            ver_menu_ordenar();
            opcion = pedirByte("Introduce una opcion: ");
            if (opcion < 1 | opcion > 4) {
                entrada_erronea();
            } else {
                switch (opcion) {
                    case 1:

                        break;
                    case 2:
                        ver_corredores(logica.getCorredores());
                        break;
                    case 3:

                        break;
                }
            }
        }
        salir_menu();
    }

    // ENTRADA DATOS
    public String pedir_dni() {
        while (true) {
            try {
                String dni = pedirString("Introduce el Dni del corredor: ").toUpperCase();
                if ((!es_letra(dni.charAt(dni.length() - 1))) | (dni.length() != 9)) {
                    throw new IllegalArgumentException();
                }
                for (byte i = 0; i <= 7; i++) {
                    if (!es_num(dni.charAt(i))) {
                        throw new IllegalArgumentException();
                    }
                }
                return dni;
            } catch (IllegalArgumentException ex) {
                entrada_erronea();
            }
        }
    }

    public String pedir_nombre() {
        String nombre = pedirString("Introduce el nombre del corredor: ");
        while (true) {
            try {
                for (char letra : nombre.toCharArray()) {
                    if (!es_letra(letra)) {
                        throw new IllegalArgumentException("El nombre debe contener solo letras");
                    }
                }
                return nombre;
            } catch (IllegalArgumentException ex) {
                entrada_erronea();
            }
        }
    }

    public String pedir_dir() {
        return super.pedirString("Introduce la direccion del corredor: ");
    }

    public String pedir_tfn() {
        while (true) {
            try {
                String tfn = pedirString("Introduce el telefono del corredor: ");
                if (tfn.length() != 9) {
                    throw new IllegalArgumentException();
                }
                for (char c : tfn.toCharArray()) {
                    if (!es_num(c)) {
                        throw new IllegalArgumentException();
                    }
                }
                return tfn;
            } catch (IllegalArgumentException ex) {
                entrada_erronea();
            }
        }
    }

    public Date pedir_fecha_nac() {
        while (true) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
                String f = pedirString("Introduce la fecha de nacimiento del corredor (dd/mm/aa): ");
                return sdf.parse(f);
            } catch (ParseException ex) {
                entrada_erronea();
            }
        }
    }

    // CHECK
    public boolean es_num(char c) {
        return (c >= 48 & c <= 57);
    }

    public boolean es_letra(char c) {
        return ((c >= 97 & c <= 122) | (c >= 65 & c <= 90));
    }

    // VISTA CORREDOR
    public void ver_corredor(Runner c) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
            System.out.println();
            System.out.println("DNI:\t\t" + c.getDni());
            System.out.println("Nombre:\t\t" + c.getNombre());
            System.out.println("Fecha de nacimiento:\t" + sdf.format(c.getFecha_nac()));
            System.out.println("Direccion:\t\t" + c.getDireccion());
            System.out.println("Telefono:\t\t" + c.getTelefono());
        } catch (NullPointerException ex) {
            System.out.println("El corredor es null\n");
        }
    }

    public void ver_corredores(List<Runner> corredores) {
        try {
            if (corredores.isEmpty()) {
                throw new NullPointerException();
            }
            System.out.println("\nCORREDORES:");
            for (Runner c : corredores) {
                ver_corredor(c);
            }
        } catch (NullPointerException ex) {
            System.out.println("No hay corredores\n");
        }
    }

    // MENSAJES
    public void corredor_creado() {
        System.out.println("Corredor creado correctamente");
    }

    public void corredor_borrado() {
        System.out.println("Se ha borrado correctamente el corredor");
    }

    public void corredor_modificado() {
        System.out.println("Corredor modificado correctamente");
    }

    public void no_existe() {
        System.out.println("No hay ningun corredor con esa informacion\n");
    }

    public void ya_existe() {
        System.out.println("Ya hay un corredor con esa informacion\n");
    }

}
