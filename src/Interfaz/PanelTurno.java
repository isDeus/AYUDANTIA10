package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Infinity.Dado;
import Infinity.Guardian;

public class PanelTurno extends JPanel implements ActionListener {

    private JButton comenzarTurno;
    int jugadorActual;

    public PanelTurno() {
        iniciar();
    }

    private void iniciar() {
        this.comenzarTurno = new JButton("Hacer Jugada");
        this.add(this.comenzarTurno);
        this.comenzarTurno.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.comenzarTurno) {
        }
    }
}
