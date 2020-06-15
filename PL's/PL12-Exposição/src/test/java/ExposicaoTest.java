import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jordão
 */
class ExposicaoTest {

    /**
     * Test of compareTo method, of class Exposição.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Exposicao outraExposicao = new Exposicao("ExpoNor", 1900);
        Exposicao instance = new Exposicao("ExpoSul", 1990);
        int expResult = -1;
        int result = instance.compareTo(outraExposicao);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Exposição.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Exposicao("ExpoNor", 1900);
        Exposicao instance = new Exposicao("ExpoSul", 1990);
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarQuadro method, of class Exposição.
     */
    @Test
    public void testAdicionarQuadro() {
        System.out.println("adicionarQuadro");
        Quadro quadro = new Quadro("Sem Campeonatos", "Sporting", 2021);
        Exposicao instance = new Exposicao("ExpoNor", 1900);
        boolean expResult = true;
        boolean result = instance.addQuadro(quadro);
        assertEquals(expResult, result);
    }

    /**
     * Test of removerQuadro method, of class Exposição.
     */
    @Test
    public void testRemoverQuadro() {
        System.out.println("removerQuadro");
        Quadro quadro = new Quadro("Sem Campeonatos", "Sporting", 2021);
        Exposicao instance = new Exposicao("ExpoNor", 1900);
        instance.addQuadro(quadro);
        boolean expResult = true;
        boolean result = instance.removeQuadro(quadro);
        assertEquals(expResult, result);
    }
}