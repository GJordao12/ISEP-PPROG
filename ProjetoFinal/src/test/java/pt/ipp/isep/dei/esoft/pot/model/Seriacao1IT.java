package pt.ipp.isep.dei.esoft.pot.model;

import org.junit.Test;
import pt.ipp.isep.dei.esoft.leitura.StartLeituraFicheiros;
import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Teste para a Seriação 1.
 *
 * @author Jordão e António
 */
public class Seriacao1IT {

    /**
     * Teste do método Seriar da classe Seriação 1.
     */
    @Test
    public void testSeriar() {
        System.out.println("Seriar1");
        lerFicheiros();
        Anuncio anun = AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnuncioById("32145");
        List<Candidatura> auxiliar = new ArrayList<>(AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnuncioById("32145").getM_oListaCandidaturas().getCandidaturas());
        Candidatura[] expResult = new Candidatura[5];
        expResult[0] = auxiliar.get(1);
        expResult[1] = auxiliar.get(0);
        expResult[2] = auxiliar.get(4);
        expResult[3] = auxiliar.get(2);
        expResult[4] = auxiliar.get(3);
        anun.getM_oListaCandidaturas().setListaParaTestes(anun.getM_oListaCandidaturas().getCandidaturas().subList(0, 5));
        List<Candidatura> result = anun.getRegT().Seriar(anun);
        assertEquals(Arrays.asList(expResult), result);
    }

    /**
     * Lê Ficheiros.
     */
    public void lerFicheiros() {
        StartLeituraFicheiros uiStarLeitura = new StartLeituraFicheiros();
        uiStarLeitura.run();
    }
}
