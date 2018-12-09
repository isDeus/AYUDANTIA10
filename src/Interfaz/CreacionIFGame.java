package Interfaz;

import Infinity.Guerrero;
import Infinity.Jugador;
import Infinity.Mago;

import javax.swing.*;
import java.util.ArrayList;

public class CreacionIFGame {

    public int elegirCantidadCasillas(){
        int cantidadCasillas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de casillas"));
        return cantidadCasillas;
    }

    public int elegirCantidadJugadores(){
        int cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
        return cantidadJugadores;
    }

    private String ingresarNombreJugador(){
        String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
        return nombreJugador;
    }

    private String elegirClaseJugador(){
        Object clase = JOptionPane.showInputDialog(null,
                "Seleccione la clase correspondiente",
                "Selector de clases",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Guerrero", "Mago"},
                "Seleccion");
        return clase.toString();
    }

    public ArrayList<Jugador> ingresoJugadores(int cantidadJugadores, int numeroCasillas){
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        for(int i = 0; i < cantidadJugadores; i++){
            String nombre = ingresarNombreJugador();
            String clase = elegirClaseJugador();

            if(clase.equals("Guerrero")){
                jugadores.add(new Guerrero(nombre, numeroCasillas));
            } else if (clase.equals("Mago")){
                jugadores.add(new Mago(nombre, numeroCasillas));
            }
        }
        return jugadores;
    }
}


