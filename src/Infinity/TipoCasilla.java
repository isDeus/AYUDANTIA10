package Infinity;

public enum TipoCasilla {

    BLANCO('B'),
    PORTAL('P'),
    SALUD('S'),
    DESAFIO('D');

    private final char tipo;

    private TipoCasilla(char a) {
        this.tipo = a;
    }

    public char getTipo() {
        return tipo;
    }
}
