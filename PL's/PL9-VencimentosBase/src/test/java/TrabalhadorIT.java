import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jordão
 */
public class TrabalhadorIT {

    @Test
    public void testCalcularVencimentoHora() {
        System.out.println("calcularVencimento");
        TrabalhadorHora instance = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        float expResult = 560F;
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalcularVencimentoComissao() {
        System.out.println("calcularVencimento");
        TrabalhadorComissao instance = new TrabalhadorComissao("Susana Ferreira", 500.0f, 1500.0f, 6f);
        float expResult = 590F;
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCalcularVencimentoPeca() {
        System.out.println("calcularVencimento");
        TrabalhadorPeca instance = new TrabalhadorPeca("Jorge Silva", 20, 30);
        float expResult = 910F;
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCompareToNegative() {
        System.out.println("compareTo");
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        int expResult = -1;
        int result = th.compareTo(tp);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCompareToPositives() {
        System.out.println("compareTo");
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        int expResult = 1;
        int result = tp.compareTo(th);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToZero() {
        System.out.println("compareTo");
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorPeca tl = new TrabalhadorPeca("Carlos Oliveira", 20, 30);
        int expResult = 0;
        int result = tp.compareTo(tl);
        assertEquals(expResult, result);
    }
}
