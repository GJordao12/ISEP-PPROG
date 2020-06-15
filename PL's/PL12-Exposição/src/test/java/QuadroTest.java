import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jordão
 */
class QuadroTest {

    /**
     * Test of compareTo method, of class Quadro.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Quadro outroQuadro = new Quadro("Sem Campeonatos", "Sporting", 2021);
        Quadro instance = new Quadro("Autoretrato", "Salvador Dali", 1920);
        int expResult = 1;
        int result = instance.compareTo(outroQuadro);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Quadro.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Quadro("Sem Campeonatos", "Sporting", 2021);
        Quadro instance = new Quadro("O Grito", "Edvard Munch", 1893);
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
}