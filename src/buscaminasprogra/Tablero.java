package buscaminasprogra;

public class Tablero {

    public char matriz[][];
    public boolean existeTablero;

    public Tablero(int n) {
        this.existeTablero = false;
        seCreoTablero(n);
    }

    public boolean seCreoTablero(int n) {
        if (n > 0) {
            existeTablero = true;
            matriz = new char[n][n];
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
        return buscarMinaAbajo(i, j) + buscarMinaAbajoDerecha(i, j)
                + buscarMinaAbajoIzquierda(i, j) + buscarMinaIzquierda(i, j)
                + buscarMinaDerecha(i, j) + buscarMinaArribaIzquierda(i, j)
                + buscarMinaArriba(i, j) + buscarMinaArribaDerecha(i, j);
    }

    // Empezamos a refactorizar
    public int buscarMinaAbajo(int i, int j) {
        if (i + 1 != matriz.length && matriz[i + 1][j] == '*') {
            //verifica si hay mina abajo de [i][j]
            return 1;
        } else {
            return 0;
        }
    }

    public int buscarMinaDerecha(int i, int j) {
        if (j + 1 != matriz.length && matriz[i][j + 1] == '*') {
            //verifica si hay mina a la
            return 1;               //derecha de [i][j]
        } else {
            return 0;
        }
    }

    public int buscarMinaAbajoDerecha(int i, int j) {
        if (i + 1 != matriz.length
                && j + 1 != matriz.length && matriz[i + 1][j + 1] == '*') {//verifica si hay mina en la
            return 1;                 // esquina inferior derecha de [i][j]
        } else {
            return 0;
        }
    }

    public int buscarMinaAbajoIzquierda(int i, int j) {
        if (j - 1 != -1 && i + 1 != matriz.length && matriz[i + 1][j - 1] == '*') {
            //verificar si hay mina en esquina
            return 1;                   // inferior izquierda [i][j]
        } else {
            return 0;
        }
    }

    public int buscarMinaIzquierda(int i, int j) {
        if (j - 1 != -1 && matriz[i][j - 1] == '*') { //verifica si hay mina a la izquierda
            return 1;
        } else {
            return 0;
        }
    }

    public int buscarMinaArribaIzquierda(int i, int j) {
        if (i - 1 != -1
                && j - 1 != -1 && matriz[i - 1][j - 1] == '*') { //verifica si hay mina a la izquierda
            return 1;
        } else {
            return 0;
        }
    }

    public int buscarMinaArriba(int i, int j) {
        if (i - 1 != -1 && matriz[i - 1][j] == '*') {
            return 1;
        } else {
            return 0;
        }
    }

    public int buscarMinaArribaDerecha(int i, int j) {
        if (j + 1 != matriz.length && i - 1 != -1 && matriz[i - 1][j + 1] == '*') {
            return 1;
        } else {
            return 0;
        }
    }

    public void numerarCasilla(int i, int j) {
        matriz[i][j] = Integer.toString(minasCercanas(i, j)).charAt(0);
    }

    public void imprimir() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean MatrizLlena() {
        boolean respuesta = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == '\u0000') {
                    respuesta = false;
                }
            }
        }
        return respuesta;
    }

    public void llenarMatrizConNumeros() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != '*') {
                    numerarCasilla(i, j);
                }
            }
        }
    }
}
