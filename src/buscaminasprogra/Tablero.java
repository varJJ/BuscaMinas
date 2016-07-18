package buscaminasprogra;

public class Tablero {

    public char matriz[][];

    public Tablero(int n) {
        matriz = new char[n][n];
    }

    public boolean seCreoTablero() {
        boolean existeTablero = false;
        if (matriz.length != 0) {
            existeTablero = true;
        }
        return existeTablero;
    }

    public void colocarMina(int i, int j) {
        matriz[i][j] = '*';
    }

    public int contarMinas() {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == '*') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void minar(int i) {
        while (contarMinas() < i) {
            colocarMina((int) (Math.random() * matriz.length),
                    (int) (Math.random() * matriz.length));
        }
    }

    public int minasCercanas(int i, int j) {
        int contador = 0;
        if (i + 1 != matriz.length && matriz[i + 1][j] == '*') {
            //verifica si hay mina abajo de [i][j]
            contador++;
        }
        if (j + 1 != matriz.length && matriz[i][j + 1] == '*') {
            //verifica si hay mina a la
            contador++;               //derecha de [i][j]
        }
        if (i + 1 != matriz.length
                && j + 1 != matriz.length && matriz[i + 1][j + 1] == '*') {//verifica si hay mina en la
            contador++;                 // esquina inferior derecha de [i][j]
        }
        if (j - 1 != -1 && i + 1 != matriz.length && matriz[i + 1][j - 1] == '*') {//verificar si hay mina en esquina
            contador++;                   // inferior izquierda [i][j]
        }
        if (j - 1 != -1 && matriz[i][j - 1] == '*') { //verifica si hay mina a la izquierda
            contador++;
        }
        if (i - 1 != -1 && j - 1 != -1 && matriz[i - 1][j - 1] == '*') {//verifica si hay mina en la esquina
            contador++;                   //superior izquierda [i][j]
        }
        return contador;
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
