package pt.ipp.isep.dei.esoft.pot.controller.scene;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Regimento;

import java.util.List;

/**
 * Seriar Anúncio Controller.
 *
 * @author Jordão e António
 */
public class SeriarAnuncioController {

    /**
     * Devolve a lista de candidaturas ordenada.
     *
     * @param anun Anúncio
     * @return lista de candidaturas ordenada
     */
    public List<Candidatura> getListaOrdenada(Anuncio anun) {
        Regimento reg = anun.getRegT();
        return reg.Seriar(anun);
    }

    /**
     * Devolve a lista de candidaturas de um Anúncio.
     *
     * @param anun Anúncio
     * @return lista de candidaturas de um Anúncio
     */
    public List<Candidatura> getCandidaturas(Anuncio anun) {
        return anun.getM_oListaCandidaturas().getCandidaturas();
    }

    /**
     * Devolve a lista de Anúncios.
     *
     * @return lista de Anúncios
     */
    public List<Anuncio> getAnuncios() {
        Colaborador colab = AplicacaoPOT.getInstance().getPlataforma().getRegistoOrganizacoes().getOrganizacaoByEmailUtilizador(AplicacaoPOT.getInstance().getSessaoAtual().getEmailUtilizador()).getListaColaboradores().getColaboradorByEmail(AplicacaoPOT.getInstance().getSessaoAtual().getEmailUtilizador());
        return AplicacaoPOT.getInstance().getPlataforma().getRegistoAnuncios().getAnunciosParaSeriarAutomaticos(colab);
    }
}
