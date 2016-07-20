package test;

import buscaminasprogra.Tablero;
import org.junit.Test;
import static org.junit.Assert.*;

public class tableroTest {

    @Test
    public void testCrearTablero() {
        Tablero tablero = new Tablero(1);
        boolean existeTablero = tablero.seCreoTablero(1);

        assertTrue(existeTablero);
    }

    @Test
    public void testCrearTableroSinTablero() {
        Tablero tablero = new Tablero(0);
        boolean existeTablero = tablero.seCreoTablero(0);

        assertFalse(existeTablero);
    }

    @Test
    public void testCrearTablero1() {
        Tablero tablero = new Tablero(1);
        boolean existeTablero = tablero.seCreoTablero(1);
        int tamanho = tablero.matriz.length;

        assertTrue(existeTablero);
        assertEquals(1, tamanho);
    }

    @Test
    public void testCrearTablero4() {
        Tablero tablero = new Tablero(4);
        int tamanho = tablero.matriz.length;

        assertEquals(4, tamanho);
    }

    @Test
    public void testTamanhoTableroValido() {
        Tablero tablero = new Tablero(-1);
        boolean posicionValida = tablero.seCreoTablero(-1);

        assertFalse(posicionValida);
    }
}
