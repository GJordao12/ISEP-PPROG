package isep.mavenproject1;

import static org.junit.Assert.assertEquals;

/**
 * @author Gonçalo Jordão & António Barbosa
 */
public class CreditoEducacaoIT {

    @org.junit.Test
    public void testCalcularCapitalAmortizar() {
        System.out.println("calcularCapitalAmortizar");
        CreditoEducacao instance = new CreditoEducacao("Gonçalo Jordão", "Pescador", 18000, 60, 24);
        float expResult = 500;
        float result = instance.calcularCapitalAmortizar();
        assertEquals(expResult, result, 0.0);
    }

    @org.junit.Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoEducacao instance = new CreditoEducacao("Gonçalo Jordão", "Pescador", 18000, 60, 24);
        float expResult = 1275;
        float result = instance.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.0);
    }

    @org.junit.Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoEducacao instance = new CreditoEducacao("Gonçalo Jordão", "Pescador", 18000, 60, 24);
        float expResult = 19275;
        float result = instance.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.0);
    }
}
