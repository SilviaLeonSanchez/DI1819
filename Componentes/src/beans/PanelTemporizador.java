/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import listener.StartTemporizador;
import listener.StopTemporizador;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;

/**
 *
 * @author silvia
 */
public class PanelTemporizador extends JPanel implements Serializable {

    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    ArrayList<StopTemporizador> listenersStopTemporizador;
    ArrayList<StartTemporizador> listenersStartTemporizador;
    Timer timer;
    private Calendar tiempoInicial;
    private volatile Calendar tiempoRestante;
    private volatile boolean running;

    /**
     * Creates new form RelojDigital
     */
    public PanelTemporizador() {
        initComponents();
        this.listenersStartTemporizador = new ArrayList<>();
        this.listenersStopTemporizador = new ArrayList<>();

        this.tiempoInicial = Calendar.getInstance();
        this.tiempoRestante = Calendar.getInstance();

        inicializarSpinner();
        sincronizarTiempoSpinner();

        this.timer = new Timer();
        this.running = false;
    }

    // SPINNER
    public static SpinnerDateModel newSpinnerModelTiempoCero() {
        // Crear el tiempoInicial inicializado a cero
        Calendar tiempoInicial = Calendar.getInstance();
        tiempoInicial.set(Calendar.HOUR_OF_DAY, 0);
        tiempoInicial.set(Calendar.MINUTE, 0);
        tiempoInicial.set(Calendar.SECOND, 0);

        // Crear el modelo con el tiempoInicial inicial  
        SpinnerDateModel modelo = new SpinnerDateModel();
        modelo.setValue(tiempoInicial.getTime());
        return modelo;
    }

    private void inicializarSpinner() {
        // Crear el spinner con el modelo
        this.jSpinner.setModel(newSpinnerModelTiempoCero());

        // Darle formato al tiempoInicial mostrado
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this.jSpinner, "HH:mm:ss");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();

        // Permitir que se modifiquen las cifras pero no los separadores
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);

        this.jSpinner.setEditor(editor);
        this.jSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                sincronizarTiempoSpinner();
            }
        });
    }

    // LISTENER
    public void addFinTemporizadorListener(StopTemporizador listener) {
        this.listenersStopTemporizador.add(listener);
    }

    public void addInicioTemporizadorListener(StartTemporizador listener) {
        this.listenersStartTemporizador.add(listener);
    }

    // TIEMPO
    private void sincronizarTiempoSpinner() {
        this.jLabel.setText(sdf.format((Date) jSpinner.getValue()));
        this.tiempoInicial.setTime((Date) jSpinner.getValue());
        this.tiempoRestante.setTime((Date) jSpinner.getValue());
    }

    private boolean isFinTiempo() {
        boolean horaCero = tiempoRestante.get(Calendar.HOUR) == 0;
        boolean minutosCero = tiempoRestante.get(Calendar.MINUTE) == 0;
        boolean segundosCero = tiempoRestante.get(Calendar.SECOND) == 0;
        return (horaCero && minutosCero && segundosCero);
    }

    public Calendar getTiempoInicial() {
        return tiempoInicial;
    }

    public Calendar getTiempoRestante() {
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
        jLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jSpinner.setModel(PanelTemporizador.newSpinnerModelTiempoCero());

        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jSpinner, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonStart, jButtonStop});

    }// </editor-fold>//GEN-END:initComponents

    // BOTONES
    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        this.running = false;
        if (this.running) {
            this.timer.cancel();
        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed

        this.running = true;
        for (StartTemporizador listener : listenersStartTemporizador) {
            listener.startTemporizador();
        }

        this.timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (running && !isFinTiempo()) {
                    System.out.println(" running");
                    tiempoRestante.add(Calendar.SECOND, -1);
                    jLabel.setText(sdf.format(tiempoRestante.getTime()));
                } else {
                    System.out.println("stop");
                    running = false;
                    for (StopTemporizador listener : listenersStopTemporizador) {
                        listener.stopTemporizador();
                    }
                }
            }
        }, 0, 1000);

    }//GEN-LAST:event_jButtonStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabel;
    private javax.swing.JSpinner jSpinner;
    // End of variables declaration//GEN-END:variables
}
