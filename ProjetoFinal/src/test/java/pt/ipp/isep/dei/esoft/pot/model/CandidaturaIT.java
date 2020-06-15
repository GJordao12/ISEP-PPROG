package pt.ipp.isep.dei.esoft.pot.model;

import org.junit.Test;
import pt.ipp.isep.dei.esoft.leitura.StartLeituraFicheiros;
import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;

import static org.junit.Assert.assertEquals;

/**
 * Testes.
 *
 * @author Jordão e António
 */
public class CandidaturaIT {

    /**
     * Teste do método Calcular Média da classe Candidatura.
     */
    @Test
    public void testCalcularMedia() {
        System.out.println("calcularMedia");
        lerFicheiros();
        Anuncio anun = AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnuncioById("12345");
        Candidatura c = AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnuncioById("12345").getM_oListaCandidaturas().getCandidaturas().get(0);
        double expResult = 2.5;
        double result = c.calcularMedia(c, anun);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Teste do método Calcular Desvio Padrão da classe Candidatura.
     */
    @Test
    public void testCalcularDesvioPadrao() {
        System.out.println("calcularDesvioPadrao");
        lerFicheiros();
        Anuncio anun = AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnuncioById("12345");
        Candidatura c = AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnuncioById("12345").getM_oListaCandidaturas().getCandidaturas().get(0);
        double expResult = Math.sqrt(0.25);
        double result = c.calcularDesvioPadrao(c, anun);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Lê Ficheiros.
     */
    public void lerFicheiros() {
        StartLeituraFicheiros uiStarLeitura = new StartLeituraFicheiros();
        uiStarLeitura.run();
    }
}
