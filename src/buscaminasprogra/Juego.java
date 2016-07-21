/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasprogra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jota
 */
public class Juego {

    private static Tablero tablero;
    private static BufferedReader a;

    public static void main(String Args[]) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        a = new BufferedReader(r);
        System.out.println();
        empezarJuego();
    }

    public static void empezarJuego() throws IOException {
        System.out.println("Ingrese el tamaño del tablero");
        int tamaño = Integer.parseInt(a.readLine());
        tablero = new Tablero(tamaño);
        if (tablero.existeTablero) {
            System.out.println("Ingrese la cantidad de minas que desea:");
            int cantidadMinas = Integer.parseInt(a.readLine());
            tablero.minar(cantidadMinas);
            tablero.llenarMatrizConNumeros();
            jugada(cantidadMinas);
        } else {
            empezarJuego();
        }
    }

    public static void jugada(int cantidaMinas) throws IOException {
        int posX;
        int posY;

        boolean perdio = false;
        while (!perdio) {
            System.out.println("Ingrese una fila");
            posX = Integer.parseInt(a.readLine());
            System.out.println("Ingrese una columna");
            posY = Integer.parseInt(a.readLine());
            tablero.imprimir();
            if (tablero.matriz[posX][posY] == '*') {
                System.out.println("Perdio!5");
                perdio = true;
            } else {
                System.out.println(tablero.matriz[posX][posY]);
            }
        }
    }
}
