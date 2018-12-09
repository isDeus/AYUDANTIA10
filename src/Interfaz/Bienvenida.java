package Interfaz;

import Infinity.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bienvenida extends JFrame implements ActionListener {

    private JLabel textoBienvenida;
    private JButton botonInicio;
    private CreacionIFGame creacionGame;

    public Bienvenida() {

        creacionGame = new CreacionIFGame();

        this.setTitle("Infinity Game");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        generarElementosBienvenida();
    }

    private void generarElementosBienvenida() {

        textoBienvenida = new JLabel("Bienvenido a InfinityGame, presione el botón para comenzar.");
        textoBienvenida.setFont(new Font("Serif", Font.PLAIN, 32));
        textoBienvenida.setBounds(0, 0, 800, 50);
        this.add(textoBienvenida);


        botonInicio = new JButton("Comenzar el juego");
        botonInicio.setBounds(300, 100, 150, 20);
        this.add(botonInicio);
        botonInicio.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonInicio ){
            int numeroJugadores = this.creacionGame.elegirCantidadJugadores();
            int numeroCasillas = this.creacionGame.elegirCantidadCasillas();
            ArrayList<Jugador> jugadores = this.creacionGame.ingresoJugadores(numeroJugadores, numeroCasillas);
            VentanaPrincipal vp = new VentanaPrincipal(numeroJugadores, numeroCasillas,jugadores);
            this.dispose();
        }

    }

    public static void main(String args[]) {
        Bienvenida vn = new Bienvenida();
    }

}
