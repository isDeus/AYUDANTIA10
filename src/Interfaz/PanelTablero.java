package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Infinity.Tablero;

public class PanelTablero extends JPanel {

    private Tablero tablero;
    private int numeroCasillas;
    private char[] tableroCreado;
    private ArrayList<JButton> casillas;

    public PanelTablero(int cantidadCasillas){

        tablero = new Tablero(cantidadCasillas);
        this.numeroCasillas = cantidadCasillas;

        creacionTablero();
    }

    private void creacionTablero(){
        tablero.llenadoTablero();
        this.tableroCreado = tablero.getTablero();
        generarElementos();
    }

    private void generarElementos(){
        int alto = 6;
        int ancho = this.numeroCasillas / alto;

        this.setLayout(new GridLayout(alto, ancho));
        casillas = new ArrayList<>();
        for (int i = 0; i < this.numeroCasillas; i++){
            JButton casilla = null;
            if (i != 0 && i != this.numeroCasillas - 1){
                casilla = asignarColor(i);
            } else if (i == 0){
                casilla = new JButton("" + i);
                casilla.setBackground(Color.WHITE);
            } else if (i == this.numeroCasillas - 1){
                casilla = new JButton("" + i);
                casilla.setBackground(Color.BLACK);
                casilla.setForeground(Color.WHITE);
            }
            casillas.add(casilla);
            this.add(this.casillas.get(i));
        }
    }

    public char[] returnTableroCreado(){
        return this.tableroCreado;
    }

    private JButton asignarColor(int i){
        JButton casilla = new JButton("" + i);
        if(this.tableroCreado[i] == 'P'){
            casilla.setBackground(Color.CYAN);
        } else if (this.tableroCreado[i] == 'S'){
            casilla.setBackground(Color.GREEN);
        } else if (this.tableroCreado[i] == 'D'){
            casilla.setBackground(Color.RED);
        }
        return casilla;
    }
}
