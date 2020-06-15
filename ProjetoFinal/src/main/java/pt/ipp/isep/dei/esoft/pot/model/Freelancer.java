package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Freelancer.
 *
 * @author Jordão e António
 */
public class Freelancer {

    private String m_oNome;
    private int m_oNif;
    private EnderecoPostal m_oEndPostal;
    private int m_oTele;
    private String m_oEmail;
    private ReconhecimentoCompetenciaTecnica rct;
    private List<ReconhecimentoCompetenciaTecnica> m_lstReconhecimentoCT;
    private List<CompetenciaTecnica> m_lstCt;

    /**
     * Instancia um novo Freelancer.
     *
     * @param nome      nome
     * @param nif       NIF
     * @param endPostal endereço postal
     * @param tele      telefone
     * @param email     email
     */
    public Freelancer(String nome, int nif, EnderecoPostal endPostal, int tele, String email) {
        if ((nome == null || nif == 0 || endPostal == null || tele == 0 || email == null || nome.isEmpty() || email.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
        } else {
            this.m_oNome = nome;
            this.m_oNif = nif;
            this.m_oEndPostal = endPostal;
            this.m_oTele = tele;
            this.m_oEmail = email;
            this.m_lstReconhecimentoCT = new ArrayList<>();
            this.m_lstCt = new ArrayList<>();
        }
    }

    /**
     * Devolve o nome do Freelancer.
     *
     * @return nome do Freelancer
     */
    public String getM_oNome() {
        return this.m_oNome;
    }

    /**
     * Devolve o email do Freelancer.
     *
     * @return email do Freelancer
     */
    public String getM_oEmail() {
        return this.m_oEmail;
    }

    /**
     * Cria um novo Reconhecimento de Competência Técnica através do construtor da classe ReconhecimentoCompetenciaTecnica.
     *
     * @param data data
     * @param ct   competência técnica
     * @param gp   grau proficiência
     * @return reconhecimento competência técnica
     */
    public ReconhecimentoCompetenciaTecnica novaReconhecimentoCT(Date data, CompetenciaTecnica ct, GrauProficiencia gp) {
        this.rct = new ReconhecimentoCompetenciaTecnica(data, ct, gp);
        if (validaReconhecimentoCT(this.rct)) {
            addReconhecimentoCT(this.rct);
        }
        return this.rct;
    }

    /**
     * Adiciona o reconhecimento da competência técnica.
     *
     * @param rct reconhecimento competência técnica
     * @return boolean
     */
    public boolean addReconhecimentoCT(ReconhecimentoCompetenciaTecnica rct) {
        return this.m_lstReconhecimentoCT.add(rct);
    }

    /**
     * Valida o reconhecimento da competência técnica.
     *
     * @param rct reconhecimento competência técnica
     * @return boolean
     */
    public boolean validaReconhecimentoCT(ReconhecimentoCompetenciaTecnica rct) {
        boolean bRet = true;

        if (this.m_lstReconhecimentoCT.contains(rct)) {
            bRet = false;
        }
        return bRet;
    }

    /**
     * Devolve a lista de Reconhecimentos da competência técnica.
     *
     * @return lista reconhecimento competência técnica
     */
    public List<ReconhecimentoCompetenciaTecnica> getM_lstReconhecimentoCT() {
        return this.m_lstReconhecimentoCT;
    }

    /**
     * Devolve a descrição textual de um Freelancer.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Nome: %s , NIF: %d , Endereço Postal: %s , Telefone: %d , Email: %s", this.m_oNome, this.m_oNif, this.m_oEndPostal, this.m_oTele, m_oEmail);
    }
}