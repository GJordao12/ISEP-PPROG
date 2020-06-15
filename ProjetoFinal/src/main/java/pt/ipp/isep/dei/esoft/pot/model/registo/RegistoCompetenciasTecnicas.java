package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;

import java.util.ArrayList;
import java.util.List;

/**
 * Registo de Competências Técnicas.
 *
 * @author Jordão e António
 */
public class RegistoCompetenciasTecnicas {

    private List<CompetenciaTecnica> m_lstCompetenciasTecnicas;

    /**
     * Instancia um novo Registo de Competências Técnicas.
     */
    public RegistoCompetenciasTecnicas() {
        this.m_lstCompetenciasTecnicas = new ArrayList<>();
    }

    /**
     * Constrói uma nova Competência Técnica através do construtor da classe CompetenciaTecnica.
     *
     * @param cod     código
     * @param dsBreve descrição breve
     * @param dsDet   descrição detalhada
     * @param area    area atividade
     * @return competência técnica
     */
    public CompetenciaTecnica novaCompetenciaTecnica(String cod, String dsBreve, String dsDet, AreaAtividade area) {
        return new CompetenciaTecnica(cod, dsBreve, dsDet, area);
    }

    /**
     * Regista uma competência técnica recebida por parâmetro.
     *
     * @param oCt competência técnica
     * @return boolean
     */
    public boolean registaCompetenciaTecnica(CompetenciaTecnica oCt) {
        if (this.validaCompetenciaTecnica(oCt)) {
            return addCompetenciaTecnica(oCt);
        }
        return false;
    }

    /**
     * Adiciona a Competência Técnica à Lista de Competências Técnicas.
     *
     * @param oCt Competência Técnica
     * @return boolean
     */
    private boolean addCompetenciaTecnica(CompetenciaTecnica oCt) {
        return this.m_lstCompetenciasTecnicas.add(oCt);
    }

    /**
     * Valida uma Competência Técnica recebida por parâmetro.
     *
     * @param oCt competência técnica
     * @return boolean
     */
    public boolean validaCompetenciaTecnica(CompetenciaTecnica oCt) {
        boolean bRet = true;

        if (this.m_lstCompetenciasTecnicas.contains(oCt)) {
            bRet = false;
        }

        return bRet;
    }

    /**
     * Devolve uma Competência Técnica através do ID.
     *
     * @param ctCod competência técnica código
     * @return competência técnica
     */
    public CompetenciaTecnica getCompetenciaTecnicaById(String ctCod) {
        for (CompetenciaTecnica ct : this.m_lstCompetenciasTecnicas)
            if (ct.getM_strId().equals(ctCod)) {
                return ct;
            }
        return null;
    }
}
