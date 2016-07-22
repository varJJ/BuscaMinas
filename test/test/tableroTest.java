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
        tablero.imprimir();

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

    @Test
    public void testColocarNumero8() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(3, 4);
        tablero.colocarMina(4, 3);
        tablero.colocarMina(4, 4);
        tablero.colocarMina(4, 2);
        tablero.colocarMina(3, 2);
        tablero.colocarMina(2, 2);
        tablero.colocarMina(2, 3);
        tablero.colocarMina(2, 4);

        tablero.numerarCasilla(3, 3);

        char numero = tablero.matriz[3][3];
        assertEquals('8', numero);
    }

    @Test
    public void testColocarNumero3() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(3, 4);
        tablero.colocarMina(4, 3);
        tablero.colocarMina(4, 4);

        tablero.numerarCasilla(3, 3);

        char numero = tablero.matriz[3][3];
        assertEquals('3', numero);
    }

    @Test
    public void testMatrizLLenaParcialmente() {
        Tablero tablero = new Tablero(5);

        tablero.colocarMina(3, 4);
        tablero.colocarMina(4, 3);
        tablero.colocarMina(4, 4);

        boolean lleno = tablero.MatrizLlena();
        assertFalse(lleno);
    }

    @Test
    public void testMatrizLLena() {
        Tablero tablero = new Tablero(5);
        tablero.minar(7);
        tablero.llenarMatrizConNumeros();
        tablero.imprimir();

        boolean lleno = tablero.MatrizLlena();

        assertTrue(lleno);
    }

    @Test
    public void testBuscarMinaDerecha() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(3, 4);

        int minas = tablero.minasCercanas(3, 3);

        assertEquals(1, minas);
    }

    @Test
    public void testBuscarMinaIzquierda() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(3, 2);

        int minas = tablero.minasCercanas(3, 3);

        assertEquals(1, minas);
    }

    @Test
    public void testBuscaMinaAbajo() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(4, 3);

        int minas = tablero.minasCercanas(3, 3);
        assertEquals(1, minas);
    }

    @Test
    public void testBuscaMinaAbajoIzquierda() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(4, 2);

        int minas = tablero.minasCercanas(3, 3);
        assertEquals(1, minas);
    }

    @Test
    public void testBuscaMinaAbajoDerecha() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(4, 4);

        int minas = tablero.minasCercanas(3, 3);
        assertEquals(1, minas);
    }

    @Test
    public void testBuscaMinaArribaIzquierda() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(2, 2);

        int minas = tablero.minasCercanas(3, 3);
        assertEquals(1, minas);
    }
    @Test
    public void testBuscaMinaArriba() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(2, 3);

        int minas = tablero.minasCercanas(3, 3);
        assertEquals(1, minas);
    }
    @Test
    public void testBuscaMinaArribaDerecha() {
        Tablero tablero = new Tablero(5);
        tablero.colocarMina(2, 4);

        int minas = tablero.minasCercanas(3, 3);
        assertEquals(1, minas);
    }
}
