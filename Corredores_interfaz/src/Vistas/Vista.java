/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Logica.Teclado;

/**
 * @author silvia
 */
public abstract class Vista {

    public abstract void ver_menu_principal();

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

    // MENSAJES
    public void entrada_erronea() {
        System.out.println("La informacion introducida no es correcta");
    }

    public void modificado_correctamente(String elemento) {
        System.out.println("Modificacion correcta de " + elemento);
    }

    public void cambios_guardados() {
        System.out.println("Cambios guardados correctamente");
    }

    public void salir_menu() {
        System.out.println("Saliendo del menu");
    }

    public void salir_aplicacion() {
        System.out.println("Saliendo de la aplicacion");
    }

}
