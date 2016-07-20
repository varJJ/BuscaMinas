package buscaminasprogra;

public class Tablero {

    public char matriz[][];

    public Tablero(int n) {
        seCreoTablero(n);
    }

    public boolean seCreoTablero(int n) {
        boolean existeTablero = false;
        if (n > 0) {
            existeTablero = true;
            matriz = new char[n][n];
        }
        return existeTablero;
    }
}
