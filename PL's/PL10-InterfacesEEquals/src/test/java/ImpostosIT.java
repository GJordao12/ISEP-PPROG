import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jordão
 */
public class ImpostosIT {

    /**
     * Test of CalcularImpostos method, of class Impostos.
     */
    @Test
    public void testCalcularImpostosD() {
        System.out.println("CalcularImpostos");
        Desempregado instance = new Desempregado("Lito Vidal", "Lisboa", 230);
        float expResult = 4.60F;
        float result = instance.CalcularImpostos();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of CalcularImpostos method, of class Impostos.
     */
    @Test
    public void testCalcularImpostosR() {
        System.out.println("CalcularImpostos");
        Reformado instance = new Reformado("Valter Cubilhas", "Olival", 600, 400);
        float expResult = 18F;
        float result = instance.CalcularImpostos();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of CalcularImpostos method, of class Impostos.
     */
    @Test
    public void testCalcularImpostosCO() {
        System.out.println("CalcularImpostos");
        TrabalhadorPorContaOutrem instance = new TrabalhadorPorContaOutrem("Ana", "Ovar", 1800, 300);
        float expResult = 24F;
        float result = instance.CalcularImpostos();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of CalcularImpostos method, of class Impostos.
     */
    @Test
    public void testCalcularImpostosCP() {
        System.out.println("CalcularImpostos");
        TrabalhadorPorContaPropria instance = new TrabalhadorPorContaPropria("Mário", "Guarda", 1500, 300);
        float expResult = 51F;
        float result = instance.CalcularImpostos();
        assertEquals(expResult, result, 0.0);
    }
}
