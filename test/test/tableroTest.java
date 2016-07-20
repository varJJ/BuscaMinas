package test;

import buscaminasprogra.Tablero;
import org.junit.Test;
import static org.junit.Assert.*;

public class tableroTest {

    @Test
    public void testCrearTablero() {
        Tablero tablero = new Tablero(1);
        boolean existeTablero = tablero.seCreoTablero();

        assertTrue(existeTablero);
    }

    @Test
    public void testCrearTableroSinTablero() {
        Tablero tablero = new Tablero(0);
        boolean existeTablero = tablero.seCreoTablero();

        assertFalse(existeTablero);
    }

    @Test
    public void testCrearTablero1() {
        Tablero tablero = new Tablero(1);
        boolean existeTablero = tablero.seCreoTablero();
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
    public void testColocarMina() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(1, 1);
        char mina = tablero.matriz[1][1];

        assertEquals('*', mina);
    }

    public void metodovacio() {
    }

    @Test
    public void testContar1MinaEnTablero() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(1, 1);
        int minas = tablero.contarMinas();

        assertEquals(1, minas);
    }

    @Test
    public void testContar5MinasEnTablero() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(1, 1);
        tablero.colocarMina(1, 4);
        tablero.colocarMina(2, 4);
        tablero.colocarMina(1, 3);
        tablero.colocarMina(3, 4);
        int minas = tablero.contarMinas();

        assertEquals(5, minas);
    }

    @Test
    public void testMinarAletoriamente() {
        Tablero tablero = new Tablero(6);
        tablero.minar(7);

        int minas = tablero.contarMinas();
        assertEquals(7, minas);
    }

    @Test
    public void testContarUnaMinaCercana() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(0, 1);

        int minasCercanas = tablero.minasCercanas(0, 0);
        assertEquals(1, minasCercanas);
    }

    @Test
    public void testContar3MinasCercanas() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(0, 1);
        tablero.colocarMina(1, 0);
        tablero.colocarMina(1, 1);

        int minasCercanas = tablero.minasCercanas(0, 0);
        assertEquals(3, minasCercanas);
    }

    @Test
    public void testContar6MinasCercanas() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(3, 4);
        tablero.colocarMina(4, 3);
        tablero.colocarMina(4, 4);
        tablero.colocarMina(4, 2);
        tablero.colocarMina(3, 2);
        tablero.colocarMina(2, 2);

        int minasCercanas = tablero.minasCercanas(3, 3);
        assertEquals(6, minasCercanas);
    }

    @Test
    public void testContar8Minas() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(3, 4);
        tablero.colocarMina(4, 3);
        tablero.colocarMina(4, 4);
        tablero.colocarMina(4, 2);
        tablero.colocarMina(3, 2);
        tablero.colocarMina(2, 2);
        tablero.colocarMina(2, 3);
        tablero.colocarMina(2, 4);

        tablero.imprimir();
        int minasCercanas = tablero.minasCercanas(3, 3);
        assertEquals(8, minasCercanas);
    }

}
