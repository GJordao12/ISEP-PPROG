package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.interfaces.AlgoritmoGeradorPasswords;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Registo de Freelancer.
 *
 * @author Jordão e António
 */
public class RegistoFreelancer implements AlgoritmoGeradorPasswords {

    private final AutorizacaoFacade m_oAutorizacao;
    private List<Freelancer> m_lstFreelancers;

    /**
     * Instancia um novo Registo de um Freelancer.
     *
     * @param m_oAutorizacao autorização
     */
    public RegistoFreelancer(AutorizacaoFacade m_oAutorizacao) {
        this.m_oAutorizacao = m_oAutorizacao;
        this.m_lstFreelancers = new ArrayList<>();
    }

    /**
     * Constrói um novo Freelancer através do construtor da classe Freelancer.
     *
     * @param nome      nome
     * @param nif       NIF
     * @param endPostal endereço postal
     * @param tele      telemóvel
     * @param email     email
     * @return freelancer
     */
    public Freelancer novoFreelancer(String nome, int nif, EnderecoPostal endPostal, int tele, String email) {
        return new Freelancer(nome, nif, endPostal, tele, email);
    }

    /**
     * Adiciona um freelancer recebido por parâmetro à lista de Freelancers.
     *
     * @param fr freelancer
     * @return boolean
     */
    public boolean addFreelancer(Freelancer fr) {
        return this.m_lstFreelancers.add(fr);
    }

    /**
     * Regista um freelancer recebido por parâmetro.
     *
     * @param fr freelancer
     * @return boolean
     */
    public boolean registaFreelancer(Freelancer fr) {

        if (validaFreelancer(fr)) {
            String nome = fr.getM_oNome();
            String email = fr.getM_oEmail();
            String strPwd = this.geraPassword(nome, email);
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(nome, email, strPwd,
                    new String[]{Constantes.PAPEL_FREELANCER}))
                return addFreelancer(fr);
        }
        return false;
    }

    /**
     * Valida um freelancer recebido por parâmetro.
     *
     * @param freelancer freelancer
     * @return boolean
     */
    public boolean validaFreelancer(Freelancer freelancer) {
        boolean bRet = true;

        if (this.m_oAutorizacao.existeUtilizador(freelancer.getM_oEmail())) {
            bRet = false;
        }
        return bRet;
    }

    /**
     * Gera a password do Freelancer.
     *
     * @param nome  Nome do Freelancer
     * @param email Email do Freelancer
     * @return password
     */
    public String geraPassword(String nome, String email) {
        return nome + "123";
    }

    /**
     * Devolve um freelancer através do email.
     *
     * @param email email
     * @return freelancer
     */
    public Freelancer getFreelancerByEmail(String email) {
        for (Freelancer free : this.m_lstFreelancers) {
            if (free.getM_oEmail().equals(email)) {
                return free;
            }
        }
        return null;
    }
}
