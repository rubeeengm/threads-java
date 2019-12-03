package Carrera;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class GuiTools extends Thread{
    JProgressBar valor;
    JTextArea mensajes;
    JLabel nombre;
    static int FIN = 4;
    //velocidad por default
    float speed;

    public GuiTools(
        String str
        , JProgressBar valor
        , JTextArea mensajes
        , JLabel nombre
        , float speed
    ) {
        super(str);
        this.valor = valor;
        this.mensajes = mensajes;
        this.nombre = nombre;
        this.valor.setMinimum(0);
        this.valor.setMaximum(FIN);
        this.nombre.setText(str);
        this.speed = speed;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            valor.setValue(i);
            mensajes.append("Posición " + i + ": " + getName() + "\n");
            
            try {
                int speed = (int)((1 - (this.speed/10)) * 2000);
                sleep(speed);
                mensajes.append("El valor " + getName() + ", speed: " +speed+ "\n");
            } catch (InterruptedException e) {
                mensajes.append(String.valueOf(e) + "\n");
            }
        }
        
        mensajes.append("Fin de la carrera para: " + getName() + "\n");
    }
}
