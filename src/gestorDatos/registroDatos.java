package gestorDatos;

import Infinity.Jugador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class registroDatos {

    ArrayList<Jugador> players;
    int cantJug;

    public registroDatos(ArrayList<Jugador> players, int cantidadJugadores) {
        this.players = players;
        this.cantJug = cantidadJugadores;
        guardarArchivo();
    }

    private void guardarArchivo() {
        try {
            FileWriter filew = new FileWriter("registroInfinity.txt", true);
            BufferedWriter buffw = new BufferedWriter(filew);
            Date fecha = new Date();
            buffw.write(fecha.toString());
            buffw.newLine();

            for (int i = 0; i < cantJug; i++) {
                buffw.write("Jugador: " + this.players.get(i).getName() + '\t' + "Posicion: " + this.players.get(i).getPosicion() + '\t' + "Salud: " + this.players.get(i).getSalud());
                buffw.newLine();
            }
            buffw.close();
            filew.close();
        } catch (IOException e) {

        }
    }
}
