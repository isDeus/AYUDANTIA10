package Infinity;

import java.util.ArrayList;

public class Casilla {

    private char casilla;
    private char tipo;

    public Casilla(String Tipo) {
        TipoCasilla elTipo = Enum.valueOf(TipoCasilla.class, Tipo);
        this.tipo = elTipo.getTipo();
    }

    public Casilla() {

    }

    public char devolverTipoCasilla() {

        return this.tipo;
    }

    public void casillaDesafio(int indice, ArrayList<Jugador> players) {
        //Dos tipos de desafios, 0 es avanzar o retroceder y 1 es agregar o quitar vida
        int desafio = (int) (Math.random() * 2);
        switch (desafio) {
            case 0:
                int direccion = (int) (Math.random() * 2); //0 negativo, 1 positivo
                int cantidad = (int) ((Math.random() * 6) + 1);//cantidad de posiciones
                switch (direccion) {
                    case 0:
                        players.get(indice).cambiarPosicion(-cantidad);
                        break;
                    case 1:
                        players.get(indice).cambiarPosicion(cantidad);
                        break;
                }
                break;
            case 1:
                int cantidadVida = (int) ((Math.random() * 5) + 1);//cantidad de vida
                int signo = (int) (Math.random() * 2);
                switch (signo) {
                    case 0:
                        for (int i = 0; i < players.size(); i++) {
                            players.get(i).cambiarVida(-cantidadVida);
                        }
                        players.get(indice).cambiarVida(+cantidadVida);
                        break;
                    case 1:
                        for (int i = 0; i < players.size(); i++) {
                            players.get(i).cambiarVida(cantidadVida);
                        }
                        players.get(indice).cambiarVida(-cantidadVida);
                        break;
                }
                break;
        }
    }

    public void casillaPortal(Jugador players, char tablero[]) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == 'P') {
                if (i > players.getPosicion()) {
                    players.setPosicion(i);
                    break;
                }
            }
        }
    }

    public void casillaSalud(Jugador players) {
        int vida = (int) ((Math.random() * 4) + 1);
        int signo = (int) (Math.random() * 2);
        if (signo == 0) {
            players.cambiarVida(-vida);
        } else if (signo == 1) {
            players.cambiarVida(vida);
        }
    }


}
