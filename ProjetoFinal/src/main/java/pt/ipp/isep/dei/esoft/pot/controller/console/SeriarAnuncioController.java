package pt.ipp.isep.dei.esoft.pot.controller.console;

import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.lista.ListaCandidaturas;
import pt.ipp.isep.dei.esoft.pot.model.lista.ListaColaboradores;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoAnuncios;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoOrganizacoes;

import java.util.List;

/**
 * Seriar Anúncio Controller.
 *
 * @author Jordão e António
 */
public class SeriarAnuncioController {

    private final Plataforma m_oPlataforma;
    private RegistoOrganizacoes rorgs;
    private RegistoAnuncios ra;
    private Anuncio m_oAnuncio;
    private Colaborador colab;
    private ProcessoSeriacao ps;

    /**
     * Instancia um novo Seriar Anúncio Controller.
     */
    public SeriarAnuncioController() {

        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rorgs = this.m_oPlataforma.getRegistoOrganizacoes();
        this.ra = this.m_oPlataforma.getRegistoAnuncios();
    }

    /**
     * Devolve anúncios para Seriar automáticos.
     *
     * @return anúncios para seriar automáticos
     */
    public List<Anuncio> getAnunciosParaSeriarAutomaticos() {
        AplicacaoPOT app = AplicacaoPOT.getInstance();
        SessaoUtilizador sessao = app.getSessaoAtual();
        String strEmailUtilizador = sessao.getEmailUtilizador();
        Organizacao org = this.rorgs.getOrganizacaoByEmailUtilizador(strEmailUtilizador);
        ListaColaboradores lstColabs = org.getListaColaboradores();
        this.colab = lstColabs.getColaboradorByEmail(strEmailUtilizador);
        return this.ra.getAnunciosParaSeriarAutomaticos(this.colab);
    }

    /**
     * Devolve uma lista de candidaturas.
     *
     * @param anuncioId anuncio id
     * @return candidaturas
     */
    public List<Candidatura> getCandidaturas(String anuncioId) {
        this.m_oAnuncio = this.ra.getAnuncioByIdEColab(anuncioId, this.colab);
        ListaCandidaturas listaCand = this.m_oAnuncio.getM_oListaCandidaturas();
        this.ps = this.m_oAnuncio.novoProcessoSeriacao(this.colab);
        return listaCand.getCandidaturas();
    }

    /**
     * Devolve a lista Ordenada.
     *
     * @return lista ordenada
     */
    public List<Candidatura> getListaOrdenada() {
        Regimento reg = this.m_oAnuncio.getRegT();
        return reg.Seriar(this.m_oAnuncio);
    }

    /**
     * Regista a seriação.
     *
     * @return boolean
     */
    public boolean registaSeriacao() {
        return this.m_oAnuncio.registaProcessoSeriacao(this.ps);
    }

    /**
     * Devolve a Seriação.
     *
     * @return toString da Seriação
     */
    public String getSeriacaoString() {
        return this.ps.toString();
    }
}

