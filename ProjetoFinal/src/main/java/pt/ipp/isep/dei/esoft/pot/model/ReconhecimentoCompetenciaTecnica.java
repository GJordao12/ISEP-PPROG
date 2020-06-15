package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;

/**
 * Reconhecimento de Competência Técnica.
 *
 * @author Jordão e António
 */
public class ReconhecimentoCompetenciaTecnica {

    private Date m_oData;
    private CompetenciaTecnica m_oCT;
    private GrauProficiencia m_oGP;

    /**
     * Instancia um novo Reconhecimento de Competência Técnica.
     *
     * @param data data
     * @param ct   competência técnica
     * @param gp   grau proficiência
     */
    public ReconhecimentoCompetenciaTecnica(Date data, CompetenciaTecnica ct, GrauProficiencia gp) {
        if (data == null || ct == null || gp == null) {
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
        } else {
            this.m_oData = data;
            this.m_oCT = ct;
            this.m_oGP = gp;
        }
    }

    /**
     * Devolve o grau de proficiência.
     *
     * @return grau proficiência
     */
    public GrauProficiencia getM_oGP() {
        return this.m_oGP;
    }

    /**
     * Devolve a Competência Técnica.
     *
     * @return competência técnica
     */
    public CompetenciaTecnica getM_oCT() {
        return this.m_oCT;
    }

    /**
     * Devolve a descrição textual do Reconhecimento da Competência Técnica.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Data: %s , Competência Técnica: %s , Grau Proficiência: %s" + this.m_oData, this.m_oCT, this.m_oGP);
    }
}
