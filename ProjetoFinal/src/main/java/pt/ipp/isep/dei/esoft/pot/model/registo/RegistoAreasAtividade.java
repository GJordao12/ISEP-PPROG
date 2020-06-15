package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;

import java.util.ArrayList;
import java.util.List;

/**
 * Registo de Areas de Atividade.
 *
 * @author Jordão e António
 */
public class RegistoAreasAtividade {

    private List<AreaAtividade> m_lstAreasAtividade;

    /**
     * Instancia um novo Registo de Areas de atividade.
     */
    public RegistoAreasAtividade() {
        this.m_lstAreasAtividade = new ArrayList<>();
    }

    /**
     * Constrói uma nova Area de Atividade através do construtor da classe AreaAtividade.
     *
     * @param strcod   código
     * @param strdescB descrição breve
     * @param strdescC descrição completa
     * @return área atividade
     */
    public AreaAtividade novaAreaAtividade(String strcod, String strdescB, String strdescC) {
        return new AreaAtividade(strcod, strdescB, strdescC);
    }

    /**
     * Regista uma área de atividade recebida por parâmetro.
     *
     * @param oArea área atividade
     * @return boolean
     */
    public boolean registaAreaAtividade(AreaAtividade oArea) {
        if (this.validaAreaAtividade(oArea)) {
            return addAreaAtividade(oArea);
        }
        return false;
    }

    /**
     * Adiciona a Area de Atividade à lista de Areas de Atividade.
     *
     * @param oArea área de atividade
     * @return boolean
     */
    private boolean addAreaAtividade(AreaAtividade oArea) {
        return this.m_lstAreasAtividade.add(oArea);
    }

    /**
     * Valida uma área de atividade recebida por parâmetro.
     *
     * @param oArea área atividade
     * @return boolean
     */
    public boolean validaAreaAtividade(AreaAtividade oArea) {
        boolean bRet = true;

        if (this.m_lstAreasAtividade.contains(oArea)) {
            bRet = false;
        }

        return bRet;
    }

    /**
     * Devolve a área de atividade através do código.
     *
     * @param strcod codigo
     * @return area atividade
     */
    public AreaAtividade getAreaAtividadeByCod(String strcod) {
        for (AreaAtividade area : this.m_lstAreasAtividade) {
            if (area.getCodigo().equals(strcod)) {
                return area;
            }
        }
        return null;
    }

}
