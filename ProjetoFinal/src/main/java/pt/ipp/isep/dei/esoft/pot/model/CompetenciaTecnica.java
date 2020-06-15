package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Competência Técnica.
 *
 * @author Jordão e António
 */
public class CompetenciaTecnica {
    private String m_strId;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;
    private AreaAtividade m_oAreaAtividade;
    private List<GrauProficiencia> m_lstGraus;


    /**
     * Instancia uma nova Competência técnica.
     *
     * @param strId                 id
     * @param strDescricaoBreve     descrição breve
     * @param strDescricaoDetalhada descrição detalhada
     * @param oArea                 área
     */
    public CompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada, AreaAtividade oArea) {
        if ((strId == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) ||
                (oArea == null) || (strId.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
        this.m_oAreaAtividade = oArea;
        this.m_lstGraus = new ArrayList<>();
    }

    /**
     * Devolve o id.
     *
     * @return id
     */
    public String getM_strId() {
        return this.m_strId;
    }

    /**
     * Verifica se tem id.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
        return hash;
    }

    /**
     * Verifica se dois objetos são iguais.
     *
     * @param o objeto
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }

    /**
     * Adiciona à lista de graus de proficiência.
     *
     * @param valor      valor
     * @param designacao designação
     */
    public void addGrauProficiencia(int valor, String designacao) {
        GrauProficiencia gp = new GrauProficiencia(valor, designacao);
        this.m_lstGraus.add(gp);
    }

    /**
     * Devolve a descrição textual da competência técnica.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("%s , %s , %s  - Area Atividade: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada, this.m_oAreaAtividade.toString());
    }

    /**
     * Devolve o grau de proficiência através do valor do grau.
     *
     * @param valorGrau valor grau
     * @return grau proficiência by valor
     */
    public GrauProficiencia getGrauProficienciaByValor(int valorGrau) {
        for (GrauProficiencia gp : this.m_lstGraus) {
            if (gp.getM_intValor() == valorGrau) {
                return gp;
            }
        }
        return null;
    }
}
