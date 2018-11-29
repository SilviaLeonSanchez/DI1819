/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interfaces.ReceptorTiempoCronometro;
import interfaces.StartCronometro;
import interfaces.StopCronometro;
import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import interfaces.ListenerLlegada;

/**
 *
 * @author silvia
 */
public class PanelCronometro extends JPanel implements Serializable {

    // ATRIBUTOS
    private ArrayList<StopCronometro> listenersStopCronometro;
    private ArrayList<ListenerLlegada> listenersLlegada;
    private ArrayList<StartCronometro> listenersStartCronometro;

    private Timer timer;
    private Instant momentoStart;
    private volatile Duration tiempo;
    private volatile boolean running;

    // PROPIEDADES
    private boolean conDecimales;
    private String texto;
    private Color color;
    private File imagen;

    /**
     * Creates new form RelojDigital
     */
    public PanelCronometro() {
        initComponents();

        jLabelTexto.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        this.listenersStartCronometro = new ArrayList<>();
        this.listenersStopCronometro = new ArrayList<>();
        this.listenersLlegada = new ArrayList<>();

        this.tiempo = Duration.ZERO;
        setTiempoEnLabel(tiempo);
        
        this.timer = new Timer();
        this.running = false;

        jLabelTexto.setText(texto);
        if (color != null) {
            setBackground(color);
        }
        if (imagen != null) {
            try {
                jLabelTexto.setIcon(new ImageIcon(imagen.getAbsolutePath()));
            } catch (Exception ex) {
                System.out.println("No se ha podido mostrar la imagen del cronometro: " + ex.getMessage());
            }
        }
    }

    // GETTER Y SETTER
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
    public void addStopCronometrorListener(StopCronometro listener) {
        this.listenersStopCronometro.add(listener);
    }

    public void addStartCronometroListener(StartCronometro listener) {
        this.listenersStartCronometro.add(listener);
    }

    public void addLlegadaListener(ListenerLlegada listener) {
        this.listenersLlegada.add(listener);
    }

    public void start() {

        for (StartCronometro listener : listenersStartCronometro) {
            listener.startCronometro();
        }
        
        this.tiempo = Duration.ZERO;

        this.momentoStart = Instant.now();
        this.running = true;

        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tiempo = tiempo.plusMillis(100);
                setTiempoEnLabel(tiempo);
            }
        }, 100, 100);
    }

    public void stop() {
        if (this.running) {

            this.timer.cancel();
            this.running = false;

            for (StopCronometro listener : listenersStopCronometro) {
                listener.stopCronometro();
            }

            this.tiempo = Duration.between(this.momentoStart, Instant.now());
        }
    }

    public void llegada() {
        for (ListenerLlegada listenerLlegada : listenersLlegada) {
            ReceptorTiempoCronometro receptorTiempo = listenerLlegada.llegaReceptorACronometro();
            receptorTiempo.recibirTiempo(tiempo);
            listenerLlegada.vuelveReceptorDeCronometro(receptorTiempo);
        }
    }

    // TIEMPO
    private void setTiempoEnLabel(Duration tiempo) {
        String textoTiempo;
        if (conDecimales) {
             textoTiempo = String.format("%02d:%02d:%02d", (int) tiempo.toHours(), (int) tiempo.toMinutes(), (int) tiempo.getSeconds());
    } else {
            textoTiempo = String.format("%02d:%02d:%02d %01d", (int) tiempo.toHours(), (int) tiempo.toMinutes(), (int) tiempo.getSeconds(), (int) (tiempo.getNano()/100000000));
    }
        jLabelTiempo.setText(textoTiempo);
    }

    public Duration getTiempo() {
        return tiempo;
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
                    .addComponent(jLabelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(50, 50, 50)
                .addComponent(jLabelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonStart, jButtonStop});

    }// </editor-fold>//GEN-END:initComponents

    // BOTONES
    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        stop();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        start();
    }//GEN-LAST:event_jButtonStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JLabel jLabelTiempo;
    // End of variables declaration//GEN-END:variables
}
