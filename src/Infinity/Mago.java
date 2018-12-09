package Infinity;

public class Mago extends Jugador {

    int mana;

    public Mago(String nombre, int numCasillas) {
        super(nombre, numCasillas);
        this.meditar = 7;
        this.mana = 5;
    }

    public void concentracion(Guardian guardian) {
        if (this.mana > 0) {
            guardian.restarVida(2);
            this.mana -= 1;
        }

    }

    public String getClase() {
        return "Mago";
    }
}
