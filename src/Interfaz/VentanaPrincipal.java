package Interfaz;

import Infinity.*;
import gestorDatos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class VentanaPrincipal extends JFrame implements ActionListener {

    private PanelTablero panelTablero;
    private PanelJugadores panelInferior;
    private JButton comenzarTurno;

    private Guardian guardian;

    private int numJug, numCasillas, jugadorActual;
    private ArrayList<Jugador> jugadores;
    private boolean estadoPartida;
    private char[] tableroCreado;

    public VentanaPrincipal(int numeroJugadores, int numeroCasillas, ArrayList<Jugador> jugadores) {
        this.numJug = numeroJugadores;
        this.numCasillas = numeroCasillas;
        this.jugadores = jugadores;
        this.guardian = new Guardian(numeroJugadores);
        inicializar();
    }

    private void inicializar() {

        this.comenzarTurno = new JButton("Hacer Jugada");
        this.add(this.comenzarTurno, BorderLayout.SOUTH);
        this.comenzarTurno.addActionListener(this);

        this.panelInferior = new PanelJugadores(this.numJug, this.jugadores);
        this.add(this.panelInferior);
        this.add(this.panelInferior, BorderLayout.WEST);

        this.panelTablero = new PanelTablero(this.numCasillas);
        this.add(this.panelTablero);
        this.add(this.panelTablero, BorderLayout.NORTH);
        this.tableroCreado = this.panelTablero.returnTableroCreado();

        this.setTitle("Infinity Game");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(400, 80);

        this.jugadorActual = 0;
        this.estadoPartida = false;
    }

    private void repintarJugadores() {
        this.panelInferior.removeAll();
        this.panelInferior.crear();
        this.panelInferior.revalidate();
        this.panelInferior.repaint();
    }

    private void AccionTurno() {

        if (this.jugadores.get(this.jugadorActual).getSalud() == 0) {
            this.jugadorActual += 1;
        }

        if (this.jugadorActual == this.jugadores.size()) {
            this.jugadorActual = 0;
        }

        habilidadGuardian();
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione su opción",
                "Seleccion de turno",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Tirar dados", "Meditar", "Hablidad Especial"},
                "Tirar dados");

        if (seleccion == 0) {
            lanzarDados();
        } else if (seleccion == 1) {
            meditar();
        } else if (seleccion == 2) {
            habilidadEespecial();
        }
        this.jugadorActual += 1;
        repintarJugadores();
    }

    private void habilidadGuardian() {
        int suerteGuardian = this.guardian.habilidadFuria(this.jugadores);
        if (suerteGuardian == 1) {
            JOptionPane.showMessageDialog(this, "El guardian ha activado su habilidad, se ha restado 1 de vida a todos los jugadores");
        }
    }

    private void lanzarDados() {
        Dado dado = new Dado();
        int resultado = dado.lanzarDado();
        JOptionPane.showMessageDialog(this, "El resultado de tus dados es de " + resultado);
        int resultadoReliquia = dado.probabilidadReliquia(this.jugadores.get(this.jugadorActual));
        if (resultadoReliquia == 1) {
            JOptionPane.showMessageDialog(this, "La reliquia ha sido activada, se ha restaurado a su vida original");
        }
        cambiarPosicion(resultado);
    }

    private void cambiarPosicion(int resultado) {
        Casilla casilla = new Casilla();
        this.jugadores.get(this.jugadorActual).cambiarPosicion(resultado);
        verificarGanador();
        if (this.jugadores.get(this.jugadorActual).getPosicion() == this.numCasillas - 1) {
            JOptionPane.showMessageDialog(this, "El jugador " + this.jugadores.get(this.jugadorActual).getName() + "es el ganador!");
            this.estadoPartida = true;
        }
        int posicion = this.jugadores.get(this.jugadorActual).getPosicion();
        char letra = this.tableroCreado[posicion];
        switch (letra) {
            case 'B':
                break;
            case 'P':
                JOptionPane.showMessageDialog(this, "Has caido en la casilla portal!");
                casilla.casillaPortal(this.jugadores.get(this.jugadorActual), this.tableroCreado);
                break;
            case 'S':
                JOptionPane.showMessageDialog(this, "Has caido en la casilla salud!");
                casilla.casillaSalud(this.jugadores.get(this.jugadorActual));
                break;
            case 'D':
                JOptionPane.showMessageDialog(this, "Has caido en la casilla desafio!");
                casilla.casillaDesafio(this.jugadorActual, this.jugadores);
                break;
            default:
                break;
        }
    }

    private void meditar() {
        int cantidadCasillas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la casilla hacia la que se desea mover"));
        this.jugadores.get(this.jugadorActual).cambiarPosicion(cantidadCasillas);
        this.jugadores.get(this.jugadorActual).restarMeditar();
    }

    private void habilidadEespecial() {
        if (this.jugadores.get(this.jugadorActual).getClase().equals("Guerrero")) {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador al cual le va a inflingir 1 de daño");
            Guerrero guerrero = (Guerrero) this.jugadores.get(this.jugadorActual);
            guerrero.enfurecerse(this.jugadores, nombre);
            JOptionPane.showMessageDialog(this, "Has activado tu habilidad de furia!");
        } else if (this.jugadores.get(this.jugadorActual).getClase().equals("Mago")) {
            Mago mago = (Mago) this.jugadores.get(this.jugadorActual);
            mago.concentracion(guardian);
            JOptionPane.showMessageDialog(this, "Has activado tu habilidad de concentracion!");
        }
    }

    private void verificarGanador() {
        int sumaVida = 0;
        for (int i = 0; i < this.numJug; i++) {
            sumaVida = sumaVida + this.jugadores.get(i).getSalud();
        }

        if ((sumaVida - this.jugadores.get(this.jugadorActual).getSalud()) == 0) {
            JOptionPane.showMessageDialog(this, "El ganador es :" + this.jugadores.get(this.jugadorActual).getName());
            crearArchivo();
            System.exit(0);
        }

        if (this.jugadores.get(this.jugadorActual).getPosicion() == this.numCasillas) {
            JOptionPane.showMessageDialog(this, "El ganador es :" + this.jugadores.get(this.jugadorActual).getName());
            crearArchivo();
            System.exit(0);
        }

    }

    private void crearArchivo() {
        registroDatos rg = new registroDatos(this.jugadores, this.numJug);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.comenzarTurno) {
            AccionTurno();
        }
    }
}
