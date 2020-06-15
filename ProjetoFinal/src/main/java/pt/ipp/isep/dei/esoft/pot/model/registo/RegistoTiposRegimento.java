package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.pot.model.Regimento;

import java.util.ArrayList;
import java.util.List;

/**
 * Registo de tipos de regimento.
 *
 * @author Jordão e António
 */
public class RegistoTiposRegimento {

    private List<Regimento> m_lstTiposRegimento;

    /**
     * Instancia um novo Registo de tipos de regimento.
     */
    public RegistoTiposRegimento() {
        this.m_lstTiposRegimento = new ArrayList<>();
    }

    /**
     * Regista um tipo de regimento recebido por parâmetro.
     *
     * @param oRegimento regimento
     * @return boolean
     */
    public boolean registaTipoRegimento(Regimento oRegimento) {

        if (this.validaTipoRegimento(oRegimento)) {
            return addTipoRegimento(oRegimento);
        }
        return false;
    }

    /**
     * Adiciona à lista de tipos de regimento um tipo de regimento recebido por parâmetro.
     *
     * @param oRegimento regimento
     * @return boolean
     */
    private boolean addTipoRegimento(Regimento oRegimento) {

        return this.m_lstTiposRegimento.add(oRegimento);
    }

    /**
     * Valida um tipo de regimento recebido por parâmetro.
     *
     * @param oRegimento regimento
     * @return boolean
     */
    public boolean validaTipoRegimento(Regimento oRegimento) {

        boolean bRet = true;
        if (this.m_lstTiposRegimento.contains(oRegimento))
            bRet = false;

        return bRet;
    }

    /**
     * Devolve um tipo de regimento através da descrição.
     *
     * @param desTR descrição tipo de regimento
     * @return tipo regimento by desc
     */
    public Regimento getTipoRegimentoByDesc(String desTR) {
        for (Regimento rg : this.m_lstTiposRegimento) {
            if (rg.getM_strDesignacao().equals(desTR)) {
                return rg;
            }
        }
        return null;
    }
}
