package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.model.registo.*;

/**
 * Plataforma.
 *
 * @author Jordão e António
 */
public class Plataforma {
    private final AutorizacaoFacade m_oAutorizacao;
    private final RegistoOrganizacoes m_oRegistoOrganizacoes;
    private final RegistoAreasAtividade m_oRegistoAreasAtividade;
    private final RegistoCompetenciasTecnicas m_oRegistoCompetenciasTecnicas;
    private final RegistoCategorias m_oRegistoCategorias;
    private final RegistoFreelancer m_oRegistoFreelancer;
    private final RegistoAnuncios m_oRegistoAnuncios;
    private final RegistoTiposRegimento m_oRegistoTiposRegimento;
    private String m_strDesignacao;

    /**
     * Instancia uma nova Plataforma.
     *
     * @param strDesignacao designação
     */
    public Plataforma(String strDesignacao) {
        if ((strDesignacao == null) ||
                (strDesignacao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strDesignacao = strDesignacao;

        this.m_oAutorizacao = new AutorizacaoFacade();

        this.m_oRegistoOrganizacoes = new RegistoOrganizacoes(this.getAutorizacaoFacade());
        this.m_oRegistoAreasAtividade = new RegistoAreasAtividade();
        this.m_oRegistoCompetenciasTecnicas = new RegistoCompetenciasTecnicas();
        this.m_oRegistoCategorias = new RegistoCategorias();
        this.m_oRegistoFreelancer = new RegistoFreelancer(this.getAutorizacaoFacade());
        this.m_oRegistoAnuncios = new RegistoAnuncios();
        this.m_oRegistoTiposRegimento = new RegistoTiposRegimento();
    }

    /**
     * Devolve a Autorização Facade.
     *
     * @return autorização facade
     */
    public AutorizacaoFacade getAutorizacaoFacade() {
        return this.m_oAutorizacao;
    }

    /**
     * Devolve o Registo das organizações.
     *
     * @return registo organizações
     */
    public RegistoOrganizacoes getRegistoOrganizacoes() {
        return this.m_oRegistoOrganizacoes;
    }

    /**
     * Devolve o Registo de Categorias.
     *
     * @return registo categorias
     */
    public RegistoCategorias getRegistoCategorias() {
        return this.m_oRegistoCategorias;
    }

    /**
     * Devolve o Registo de Areas de Atividade.
     *
     * @return registo areas atividade
     */
    public RegistoAreasAtividade getRegistoAreaAtividade() {
        return this.m_oRegistoAreasAtividade;
    }

    /**
     * Devolve o Registo de Competências Técnicas.
     *
     * @return registo competências técnicas
     */
    public RegistoCompetenciasTecnicas getRegistoCT() {
        return this.m_oRegistoCompetenciasTecnicas;
    }

    /**
     * Devolve o Registo do Freelancer.
     *
     * @return registo freelancer
     */
    public RegistoFreelancer getRegistoFreelancer() {
        return this.m_oRegistoFreelancer;
    }

    /**
     * Devolve o Registo de Anúncios.
     *
     * @return registo anúncios
     */
    public RegistoAnuncios getRegistoAnuncios() {
        return this.m_oRegistoAnuncios;
    }

    /**
     * Devolve o Registo dos tipos de regimento.
     *
     * @return registo tipos regimento
     */
    public RegistoTiposRegimento getRegistoTiposRegimento() {
        return this.m_oRegistoTiposRegimento;
    }
}
