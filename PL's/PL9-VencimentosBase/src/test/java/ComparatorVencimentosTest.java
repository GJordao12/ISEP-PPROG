import org.junit.Test;

import static org.junit.Assert.*;

public class ComparatorVencimentosTest {

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
}