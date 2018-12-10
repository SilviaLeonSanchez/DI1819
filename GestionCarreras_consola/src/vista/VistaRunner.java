/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import logica.LogicaAplicacion;
import logica.Teclado;
import modelo.Runner;
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
public class VistaRunner{

    private LogicaAplicacion logica;

    public VistaRunner(File fichero, String separador) {
        this.logica = new LogicaAplicacion(fichero, separador);
        this.logica.leerCSV();
    }

    public VistaRunner() throws IOException {
        this.logica = new LogicaAplicacion();
        this.logica.leerCSV();
    }

    // MENUS
    public void verMenuPrincipal() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("MENU PRINCIPAL:");
        System.out.println("1. Alta");
        System.out.println("2. Baja");
        System.out.println("3. Modificacion");
        System.out.println("4. Ver corredores");
        System.out.println("5. Buscar corredor");
        System.out.println("6. Guardar");
        System.out.println("7. Salir");
        System.out.println("------------------------------");
    }

    public void menuPrincipal() {
        Runner runner = null;
        byte opcion = 1;
        while (opcion != 7) {
            verMenuPrincipal();
            opcion = pedirByte("Introduce una opcion: ");
            if (opcion < 1 | opcion > 7) {
                entradaErronea();
            } else {
                switch (opcion) {
                    case 1:
                        if (logica.altaCorredor(pedirDni(), pedirNombre(),
                                pedirFechaNac(), pedirDir(), pedirTfn())) {
                            corredorCreado();
                        } else {
                            yaExiste();
                        }
                        break;
                    case 2:
                        if (logica.bajaCorredor(pedirDni())) {
                            corredorBorrado();
                        } else {
                            noExiste();
                        }
                        break;
                    case 3:
                        runner = logica.buscarCorredor(pedirDni());
                        if (runner == null) {
                            noExiste();
                        } else {
                            verCorredor(runner);
                            menuModificar(runner);
                        }
                        break;
                    case 4:
                        if (this.logica.getCorredores().size() != 0) {
                            menuOrdenar();
                        } else {
                            System.out.println("No hay corredores\n");
                        }
                        break;
                    case 5:
                        runner = logica.buscarCorredor(pedirDni());
                        if (runner == null) {
                            noExiste();
                        } else {
                            verCorredor(runner);
                        }
                        break;
                    case 6:
                        logica.grabarCSV();
                }
            }
        }
        logica.grabarCSV();
        salirAplicacion();
    }

    public void verMenuModificar() {
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

    private void menuModificar(Runner runner) {
        Runner runner_aux = (Runner) runner.clone();
        byte opcion = 1;
        while (opcion != 8) {
            verMenuModificar();
            opcion = pedirByte("Introduce una opcion: ");
            if (opcion < 1 | opcion > 8) {
                entradaErronea();
            } else {
                switch (opcion) {
                    case 1:
                        if (logica.modificarDni(runner_aux, pedirDni())) {
                            corredorModificado();
                        } else {
                            yaExiste();
                        }
                        break;
                    case 2:
                        logica.modificarNombre(runner_aux, pedirNombre());
                        modificadoCorrectamente("nombre");
                        break;
                    case 3:
                        logica.modificarDireccion(runner_aux, pedirDir());
                        modificadoCorrectamente("direccion");
                        break;
                    case 4:
                        logica.modificarTfn(runner_aux, pedirTfn());
                        modificadoCorrectamente("telefono");
                        break;
                    case 5:
                        logica.modificarFechaNac(runner_aux, pedirFechaNac());
                        modificadoCorrectamente("fecha de nacimiento");
                        break;
                    case 6:
                        verCorredor(runner_aux);
                        break;
                    case 7:
                        logica.guardarCambios(runner, runner_aux);
                        logica.grabarCSV();
                        cambiosGuardados();
                }
            }
        }
        salirMenu();
    }

    public void verMenuOrdenar() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("VER ORDENADOS POR:");
        System.out.println("1. Dni");
        System.out.println("2. Nombre");
        System.out.println("3. Fecha de nacimiento");
        System.out.println("4. Salir");
        System.out.println("------------------------------");
    }

    public void menuOrdenar() {
        byte opcion = 1;
        while (opcion != 4) {
            verMenuOrdenar();
            opcion = pedirByte("Introduce una opcion: ");
            if (opcion < 1 | opcion > 4) {
                entradaErronea();
            } else {
                switch (opcion) {
                    case 1:
                        verCorredores(logica.ordenarDni());
                        break;
                    case 2:
                        verCorredores(logica.ordenarNombre());
                        break;
                    case 3:
                        verCorredores(logica.ordenarFechaNac());
                        break;
                }
            }
        }
        salirMenu();
    }

    // ENTRADA DATOS
    public String pedirDni() {
        while (true) {
            try {
                String dni = pedirString("Introduce el Dni del corredor: ").toUpperCase();
                if ((!esLetra(dni.charAt(dni.length() - 1))) | (dni.length() != 9)) {
                    throw new IllegalArgumentException();
                }
                for (byte i = 0; i <= 7; i++) {
                    if (!esNum(dni.charAt(i))) {
                        throw new IllegalArgumentException();
                    }
                }
                return dni;
            } catch (IllegalArgumentException ex) {
                entradaErronea();
            }
        }
    }

    public String pedirNombre() {
        String nombre;
        while (true) {
            nombre = pedirString("Introduce el nombre del corredor: ");
            try {
                for (char letra : nombre.toCharArray()) {
                    if ((letra != ' ') & (!esLetra(letra))) {
                        throw new IllegalArgumentException("El nombre debe contener solo letras");
                    }
                }
                return nombre;
            } catch (IllegalArgumentException ex) {
                entradaErronea();
            }
        }
    }

    public String pedirDir() {
        return pedirString("Introduce la direccion del corredor: ");
    }

    public String pedirTfn() {
        while (true) {
            try {
                String tfn = pedirString("Introduce el telefono del corredor: ");
                if (tfn.length() != 9) {
                    throw new IllegalArgumentException();
                }
                for (char c : tfn.toCharArray()) {
                    if (!esNum(c)) {
                        throw new IllegalArgumentException();
                    }
                }
                return tfn;
            } catch (IllegalArgumentException ex) {
                entradaErronea();
            }
        }
    }

    public Date pedirFechaNac() {
        while (true) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
                String f = pedirString("Introduce la fecha de nacimiento del corredor (dd/mm/aa): ");
                return sdf.parse(f);
            } catch (ParseException ex) {
                entradaErronea();
            }
        }
    }

    // CHECK
    public boolean esNum(char c) {
        return (c >= 48 & c <= 57);
    }

    public boolean esLetra(char c) {
        return ((c >= 97 & c <= 122) | (c >= 65 & c <= 90));
    }

    // VISTA CORREDOR
    public void verCorredor(Runner c) {
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

    public void verCorredores(List<Runner> corredores) {
        try {
            if (corredores.isEmpty()) {
                throw new NullPointerException();
            }
            System.out.println("\nCORREDORES:");
            for (Runner c : corredores) {
                verCorredor(c);
            }
        } catch (NullPointerException ex) {
            System.out.println("No hay corredores\n");
        }
    }

    // MENSAJES
    public void corredorCreado() {
        System.out.println("Corredor creado correctamente");
    }

    public void corredorBorrado() {
        System.out.println("Se ha borrado correctamente el corredor");
    }

    public void corredorModificado() {
        System.out.println("Corredor modificado correctamente");
    }

    public void noExiste() {
        System.out.println("No hay ningun corredor con esa informacion\n");
    }

    public void yaExiste() {
        System.out.println("Ya hay un corredor con esa informacion\n");
    }
    
    public void entradaErronea() {
        System.out.println("La informacion introducida no es correcta");
    }

    public void modificadoCorrectamente(String elemento) {
        System.out.println("Modificacion correcta de " + elemento);
    }

    public void cambiosGuardados() {
        System.out.println("Cambios guardados correctamente");
    }

    public void salirMenu() {
        System.out.println("Saliendo del menu");
    }

    public void salirAplicacion() {
        System.out.println("Saliendo de la aplicacion");
    }
    
      // ENTRADA DATOS
    public String pedirString(String mensaje) {
        System.out.println(mensaje);
        return Teclado.leerString();
    }

    public int pedirInt(String mensaje) {
        System.out.println(mensaje);
        return Teclado.leerInt();
    }

    public byte pedirByte(String mensaje) {
        System.out.println(mensaje);
        return Teclado.leerByte();
    }


}
