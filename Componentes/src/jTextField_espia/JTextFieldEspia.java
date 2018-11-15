/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jTextField_espia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author silvia
 */
public class JTextFieldEspia extends JTextField implements Serializable {

    // ATRIBUTOS
    private List<String> palabrasProhibidas;
    private List<PalabraEncontrada> listenersPalabraEncontrada;

    // METODOS
    public JTextFieldEspia() {
        addListener();
        palabrasProhibidas = new ArrayList<>();
        listenersPalabraEncontrada = new ArrayList<>();
    }

    // LISTENER ESTADO
    private void addListener() {
        super.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTexto();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTexto();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTexto();
            }

            private void checkTexto() {

                for (String palabraProhibida : palabrasProhibidas) {
                    if (getText().contains(palabraProhibida)) {
                        for (PalabraEncontrada listener : listenersPalabraEncontrada) {
                            listener.palabraEncontrada(palabraProhibida);
                        }
                    }
                }

            }

        });
    }

    // LISTENER INTERFACE
    public void setListenersPalabraEncontrada(List<PalabraEncontrada> listenersPalabraEncontrada) {
        this.listenersPalabraEncontrada = listenersPalabraEncontrada;
    }

    public List<PalabraEncontrada> getListenersPalabraEncontrada() {
        return listenersPalabraEncontrada;
    }

    public boolean insertarListener(PalabraEncontrada listener) {
        return (this.listenersPalabraEncontrada.contains(listener)) ? false : this.listenersPalabraEncontrada.add(listener);
    }

    public boolean eliminarListener(PalabraEncontrada listener) {
        return this.listenersPalabraEncontrada.remove(listener);
    }

    // LISTA PALABRAS
    public void setPalabrasProhibidas(List<String> palabrasProhibidas) {
        this.palabrasProhibidas = palabrasProhibidas;
    }

    public List<String> getPalabrasProhibidas() {
        return palabrasProhibidas;
    }

    public boolean insertarPalabraProhibida(String palabraProhibida) {
        return (this.palabrasProhibidas.contains(palabraProhibida)) ? false : this.palabrasProhibidas.add(palabraProhibida);
    }

    public boolean eliminarPalabraProhibida(String palabraProhibida) {
        return this.palabrasProhibidas.remove(palabraProhibida);
    }

}
