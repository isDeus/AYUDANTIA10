package Interfaz;

import Infinity.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelJugadores extends JPanel {

    private ArrayList<Jugador> players;
    private int cantidadJugadores;

    public PanelJugadores(int cantidadJugadores, ArrayList<Jugador> jugadores) {
        this.players = jugadores;
        this.cantidadJugadores = cantidadJugadores;
        crear();
    }

    public void crear(){
        inicializar(this.cantidadJugadores);
    }

    private void inicializar(int cantidadJugadores) {
        int alto = cantidadJugadores;
        int ancho = 6;

        JPanel[][] panelHolder = new JPanel[alto][ancho];

        this.setLayout(new GridLayout(alto, ancho));

        for (int m = 0; m < alto; m++) {
            for (int n = 0; n < ancho; n++) {
                panelHolder[m][n] = new JPanel();
                this.add(panelHolder[m][n]);
            }
        }

        for (int i = 0; i < cantidadJugadores; i++) {
            JTextField jugador = new JTextField("Jugador: " + i);
            jugador.setEditable(false);
            panelHolder[i][0].add(jugador);
        }

        for (int j = 0; j < cantidadJugadores; j++) {
            String name = this.players.get(j).getName();
            JTextField nombreJugador = new JTextField("Nombre : " + name );
            nombreJugador.setEditable(false);
            panelHolder[j][1].add(nombreJugador);
        }

        for (int k = 0; k < cantidadJugadores; k++) {
            String clase = this.players.get(k).getClase();
            JTextField claseJugador = new JTextField("Clase : " + clase );
            claseJugador.setEditable(false);
            panelHolder[k][2].add(claseJugador);
        }

        for (int l = 0; l < cantidadJugadores; l++) {
            int vida = this.players.get(l).getSalud();
            JTextField vidaJugador = new JTextField("Vida : " + vida );
            vidaJugador.setEditable(false);
            panelHolder[l][3].add(vidaJugador);
        }

        for (int o = 0; o < cantidadJugadores; o++) {
            int posicion = this.players.get(o).getPosicion();
            JTextField posicionJugador = new JTextField("Posicion : " + posicion );
            posicionJugador.setEditable(false);
            panelHolder[o][4].add(posicionJugador);
        }

        for (int p = 0; p < cantidadJugadores; p++) {
            int meditacion = this.players.get(p).getMeditar();
            JTextField meditacionJugador = new JTextField("Meditacion : " + meditacion );
            meditacionJugador.setEditable(false);
            panelHolder[p][5].add(meditacionJugador);
        }
    }
}
