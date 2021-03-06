package Infinity;

public abstract class Jugador {

    protected String name;
    protected int health;
    protected int position;
    protected int numcasillas;
    protected int meditar;

    public Jugador(String nombre, int numcasillas) {
        this.name = nombre;
        this.health = 15;
        this.position = 0;
        this.numcasillas = numcasillas;
        this.meditar = 5;
    }

    public void cambiarVida(int vida) {
        this.health = (this.health + vida);
        while (this.health > 15) {
            this.health = 15;
        }
        while (this.health < 0) {
            this.health = 0;
        }
    }

    public void cambiarPosicion(int posicion) {
        this.position = (this.position + posicion);
        if (this.position >= this.numcasillas) {
            this.position = this.numcasillas;
        }
        if (this.position < 0) {
            this.position = 0;
        }
    }

    public int getPosicion() {

        return this.position;
    }

    public void setPosicion(int lugar) {

        this.position = lugar;
    }

    public String getName() {

        return this.name;
    }

    public int getSalud() {
        return this.health;
    }

    public int restarMeditar() {
        this.meditar = (this.meditar - 1);
        if (this.meditar < 0) {
            this.meditar = 0;
        }
        return this.meditar;
    }

    public int getMeditar() {
        return this.meditar;
    }

    public abstract String getClase();
}
