package pt.ipp.isep.dei.esoft.pot.model.lista;

import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Lista de Candidaturas.
 *
 * @author Jordão e António
 */
public class ListaCandidaturas {

    private List<Candidatura> m_lstCandidaturas;

    /**
     * Instancia uma nova Lista de candidaturas.
     */
    public ListaCandidaturas() {
        this.m_lstCandidaturas = new ArrayList<>();
    }

    /**
     * Devolve a lista de candidaturas.
     *
     * @return candidaturas
     */
    public List<Candidatura> getCandidaturas() {
        return this.m_lstCandidaturas;
    }

    /**
     * Constrói uma nova candidatura através do construtor da classe Candidatura.
     *
     * @param free     freelancer
     * @param dataCand data candidatura
     * @param valorPrt valor pretendido
     * @param nDias    número de dias
     * @param txtApres texto apresentativo
     * @param txtMotiv texto motivacional
     * @return candidatura
     */
    public Candidatura novaCandidatura(Freelancer free, Date dataCand, double valorPrt, int nDias, String txtApres, String txtMotiv) {
        return new Candidatura(free, valorPrt, dataCand, nDias, txtApres, txtMotiv);
    }

    /**
     * Valida a candidatura.
     *
     * @param cand candidatura
     * @return boolean
     */
    public boolean validaCandidatura(Candidatura cand) {

        boolean bRet = true;

        if (this.m_lstCandidaturas.contains(cand) || cand == null)
            bRet = false;

        return bRet;
    }

    /**
     * Regista a candidatura.
     *
     * @param cand candidatura
     * @return boolean
     */
    public boolean registaCandidatura(Candidatura cand) {
        if (this.validaCandidatura(cand)) {

            return (addCandidatura(cand));
        }
        return false;
    }

    /**
     * Adiciona a Candidatura à lista de candidaturas.
     *
     * @param cand candidatura
     * @return boolean
     */
    private boolean addCandidatura(Candidatura cand) {
        return this.m_lstCandidaturas.add(cand);
    }

    /**
     * Modifica a lista para que possa ser utilizada nos testes unitários.
     *
     * @param listaParaTestes lista adaptada para testes
     */
    public void setListaParaTestes(List<Candidatura> listaParaTestes) {
        this.m_lstCandidaturas = listaParaTestes;
    }
}
