package isep.mavenproject1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Gonçalo Jordão & António Barbosa
 */
public class CreditoHabitacaoIT {

    /**
     * Test of calcularTaxaJuroAnual method, of class CreditoHabitacao.
     */
    @Test
    public void testCalcularTaxaJuroAnual() {
        System.out.println("calcularTaxaJuroAnual");
        CreditoHabitacao instance = new CreditoHabitacao("Maria", "Contabilista", 120000, 240, 1);
        float expResult = 1.1F;
        float result = instance.calcularTaxaJuroAnual();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularJuroMensal method, of class CreditoHabitacao.
     */
    @Test
    public void testCalcularJuroMensal() {
        System.out.println("calcularJuroMensal");
        float capitalEmDivida = 120000F;
        CreditoHabitacao instance = new CreditoHabitacao("Maria", "Contabilista", 120000, 240, 1);
        float expResult = 110F;
        float result = instance.calcularJuroMensal(capitalEmDivida);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class
     * CreditoHabitacao.
     */
    @Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoHabitacao instance = new CreditoHabitacao("Maria", "Contabilista", 120000, 240, 1);
        float expResult = 133255F;
        float result = instance.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoHabitacao.
     */
    @Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoHabitacao instance = new CreditoHabitacao("Maria", "Contabilista", 120000, 240, 1);
        float expResult = 13255F;
        float result = instance.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.0);
    }
}
