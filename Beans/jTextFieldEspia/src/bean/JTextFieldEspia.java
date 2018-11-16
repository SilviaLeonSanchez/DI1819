/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import utiles.PalabraEncontrada;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import utiles.FicheroDeTexto;

/**
 *
 * @author silvia
 */
public class JTextFieldEspia extends JTextField implements Serializable {

    // ATRIBUTOS
    private List<String> palabrasProhibidas;
    private List<PalabraEncontrada> listenersPalabraEncontrada;
    private File fileLog;

    // PROPIEDADES
    private String ficheroLog;

    // METODOS
    public JTextFieldEspia() {
        addListener();
        palabrasProhibidas = new ArrayList<>();
        listenersPalabraEncontrada = new ArrayList<>();        
    }
    
    public String getFicheroLog() {
        return ficheroLog;
    }

    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
        if (!ficheroLog.isEmpty()) {
            fileLog = new File(ficheroLog);
            if (!fileLog.exists()) {
                try {
                    fileLog.createNewFile();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
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
                        guardarPalabraEncontada(palabraProhibida);
                        for (PalabraEncontrada listener : listenersPalabraEncontrada) {
                            listener.palabraEncontrada(palabraProhibida);
                        }
                    }
                }

            }

        });
    }

    private void guardarPalabraEncontada(String palabraProhibida) {
        if (ficheroLog != null) {
            FicheroDeTexto printer = new FicheroDeTexto(fileLog);
            printer.abrirEscritor(true);
            printer.println((new SimpleDateFormat("dd/MM/yy hh:mm")).format(new Date()) + " " + palabraProhibida);
            printer.cerrarEscritor();
        }
    }

    // LISTENER INTERFACE
    public boolean insertarListener(PalabraEncontrada listener) {
        return (this.listenersPalabraEncontrada.contains(listener)) ? false : this.listenersPalabraEncontrada.add(listener);
    }

    public boolean eliminarListener(PalabraEncontrada listener) {
        return this.listenersPalabraEncontrada.remove(listener);
    }

    // LISTA PALABRAS
    public boolean insertarPalabraProhibida(String palabraProhibida) {
        return (this.palabrasProhibidas.contains(palabraProhibida)) ? false : this.palabrasProhibidas.add(palabraProhibida);
    }

    public boolean eliminarPalabraProhibida(String palabraProhibida) {
        return this.palabrasProhibidas.remove(palabraProhibida);
    }

}
