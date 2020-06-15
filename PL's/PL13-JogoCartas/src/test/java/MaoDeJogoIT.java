import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaoDeJogoIT {

    @Test
    public void testTiposDeCarta() {
        System.out.println("tipos de cartas");
        Carta.Tipo tipo = Carta.Tipo.Terno;
        MaoDeJogo instance = new MaoDeJogo();
        int expresult = instance.contarCartasDoTipo(tipo);
        int result = instance.contarCartasDoTipo(tipo);
        assertEquals(expresult, result);
    }

    @Test
    public void testContarCartasDoTipo() {
        System.out.println("Contar cartas tipo");
        Carta.Tipo tipo = Carta.Tipo.Terno;
        MaoDeJogo instance = new MaoDeJogo();
        int expresult = 0;
        int result = instance.contarCartasDoTipo(tipo);
        assertEquals(expresult, result);
    }

    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        Carta.Tipo tipo = Carta.Tipo.Terno;
        MaoDeJogo instance = new MaoDeJogo();
        int expresult = instance.contarCartasDoTipo(tipo);
        int result = instance.contarCartasDoTipo(tipo);
        assertEquals(expresult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        MaoDeJogo instance = new MaoDeJogo();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
}