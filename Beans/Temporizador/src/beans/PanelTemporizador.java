/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interfaces.StartTemporizador;
import interfaces.StopTemporizador;
import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;

/**
 *
 * @author silvia
 */
public class PanelTemporizador extends JPanel implements Serializable {

    /*
    
3. propiedad boolean que permita mostrar el contador con 1 o 0 decimales
    
4. propiedad File que nos permita mostrar una imagen en el componente al acabar la cuenta
atrás
    
     */
    // ATRIBUTOS
    private final SimpleDateFormat sdf;
    private final String formatoSinDecimales = "HH:mm:ss";
    private final String formatoConDecimales = "HH:mm:ss S";

    private ArrayList<StopTemporizador> listenersStopTemporizador;
    private ArrayList<StartTemporizador> listenersStartTemporizador;

    private Timer timer;
    private Date tiempoInicial;
    private volatile Date tiempoRestante;
    private volatile boolean running;

    // PROPIEDADES
    private boolean conDecimales;
    private String texto;
    private Color color;
    private File imagen;

    /**
     * Creates new form RelojDigital
     */
    public PanelTemporizador() {
        initComponents();

        jLabelTexto.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.listenersStartTemporizador = new ArrayList<>();
        this.listenersStopTemporizador = new ArrayList<>();

        this.sdf = new SimpleDateFormat((conDecimales) ? formatoConDecimales : formatoSinDecimales);

        this.tiempoInicial = new Date(0);
        this.tiempoInicial.setHours(0);
        this.tiempoRestante = new Date(0);
        this.tiempoRestante.setHours(0);

        inicializarSpinner();
        sincronizarTiempoSpinner();

        this.timer = new Timer();
        this.running = false;
    }

    public boolean isConDecimales() {
        return conDecimales;
    }

    public void setConDecimales(boolean conDecimales) {
        this.conDecimales = conDecimales;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    // LISTENER
    public void addFinTemporizadorListener(StopTemporizador listener) {
        this.listenersStopTemporizador.add(listener);
    }

    public void addInicioTemporizadorListener(StartTemporizador listener) {
        this.listenersStartTemporizador.add(listener);
    }

    // TIEMPO
    private void inicializarSpinner() {
        // Crear el modelo con el tiempo inicial
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(tiempoInicial);
        jSpinner.setModel(model);

        // Darle formato al tiempoInicial mostrado
        String formato = (conDecimales) ? formatoConDecimales : formatoSinDecimales;
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this.jSpinner, formato);
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();

        // Permitir que se modifiquen las cifras pero no los separadores
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);
        formatter.setFormat(sdf);

        this.jSpinner.setEditor(editor);
        this.jSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                sincronizarTiempoSpinner();
            }
        });
    }

    private void sincronizarTiempoSpinner() {
        if (!this.running) {
            setTiempoEnLabel((Date) jSpinner.getValue());
            this.tiempoInicial = (Date) jSpinner.getValue();
            this.tiempoRestante = (Date) jSpinner.getValue();
        }
    }

    private void setTiempoEnLabel(Date tiempo) {
        String textoTiempo = sdf.format(tiempo);
        if (conDecimales) {
            if (textoTiempo.length() > 9) {
                jLabelTiempo.setText(textoTiempo.subSequence(0, 9).toString());
            }
        } else {
            jLabelTiempo.setText(textoTiempo.subSequence(0, 8).toString());
        }
    }

    private boolean isFinTiempo() {
        boolean horaCero = tiempoRestante.getHours() == 0;
        boolean minutosCero = tiempoRestante.getMinutes() == 0;
        boolean segundosCero = tiempoRestante.getSeconds() == 0;
        return (horaCero && minutosCero && segundosCero);
    }

    public Date getTiempoInicial() {
        return tiempoInicial;
    }

    public Date getTiempoRestante() {
        return tiempoRestante;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jSpinner = new javax.swing.JSpinner();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelTexto = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(172, 196));
        setMinimumSize(new java.awt.Dimension(172, 196));
        setPreferredSize(new java.awt.Dimension(172, 196));

        jButtonStart.setText("START");
        jButtonStart.setMaximumSize(new java.awt.Dimension(32, 18));
        jButtonStart.setMinimumSize(new java.awt.Dimension(32, 18));
        jButtonStart.setPreferredSize(new java.awt.Dimension(32, 18));
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText("STOP");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jSpinner.setMaximumSize(new java.awt.Dimension(38, 26));

        jLabelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelTexto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTexto.setMaximumSize(new java.awt.Dimension(38, 26));
        jLabelTexto.setMinimumSize(new java.awt.Dimension(38, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonStop)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonStart, jButtonStop});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonStart, jButtonStop});

    }// </editor-fold>//GEN-END:initComponents

    // BOTONES
    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        if (this.running) {
            this.running = false;
            this.timer.cancel();
        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        sincronizarTiempoSpinner();

        this.running = true;
        for (StartTemporizador listener : listenersStartTemporizador) {
            listener.startTemporizador();
        }

        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (isFinTiempo()) {
                    running = false;
                    timer.cancel();
                }
                if (running) {
                    tiempoRestante.setTime(tiempoRestante.getTime() - 100);
                    jLabelTiempo.setText(sdf.format(tiempoRestante.getTime()));
                } else {
                    jLabelTexto.setText(texto);
                    if (color != null) {
                        setBackground(color);
                    }
                    if (imagen != null) {
                        try {
                            jLabelTexto.setIcon(new ImageIcon(imagen.getAbsolutePath()));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(PanelTemporizador.this, ex.getMessage(), "No se ha podido mostrar la imagen", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    for (StopTemporizador listener : listenersStopTemporizador) {
                        listener.stopTemporizador();
                    }
                }

            }
        }, 0, 100);

    }//GEN-LAST:event_jButtonStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JSpinner jSpinner;
    // End of variables declaration//GEN-END:variables
}
