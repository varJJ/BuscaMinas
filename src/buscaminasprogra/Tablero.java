package buscaminasprogra;

public class Tablero {

    public char matriz[][];

    public Tablero(int n) {
        matriz = new char[n][n];
    }

    public void imprimir() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
}
