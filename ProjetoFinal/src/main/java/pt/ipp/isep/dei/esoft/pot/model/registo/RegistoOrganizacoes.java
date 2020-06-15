package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.interfaces.AlgoritmoGeradorPasswords;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Registo de Organizações.
 *
 * @author Jordão e António
 */
public class RegistoOrganizacoes implements AlgoritmoGeradorPasswords {

    private final AutorizacaoFacade m_oAutorizacao;
    private List<Organizacao> m_lstOrganizacoes;


    /**
     * Instancia um novo Registo de Organizações.
     *
     * @param m_oAutorizacao autorização
     */
    public RegistoOrganizacoes(AutorizacaoFacade m_oAutorizacao) {
        this.m_oAutorizacao = m_oAutorizacao;
        this.m_lstOrganizacoes = new ArrayList<>();
    }

    /**
     * Constrói uma nova Organização através do construtor da classe Organização.
     *
     * @param strNome     nome
     * @param strNIF      NIF
     * @param strWebsite  website
     * @param strTelefone telefone
     * @param strEmail    email
     * @param oMorada     morada
     * @param oGestor     gestor
     * @return organização
     */
    public Organizacao novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, String strEmail, EnderecoPostal oMorada, Colaborador oGestor) {
        return new Organizacao(strNome, strNIF, strWebsite, strTelefone, strEmail, oMorada, oGestor);
    }

    /**
     * Regista uma organização recebida por parâmetro.
     *
     * @param oOrganizacao organização
     * @return boolean
     */
    public boolean registaOrganizacao(Organizacao oOrganizacao) {
        if (this.validaOrganizacao(oOrganizacao)) {
            Colaborador oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            String strPwd = this.geraPassword(strNomeGestor, strEmailGestor);
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor, strEmailGestor, strPwd,
                    new String[]{Constantes.PAPEL_COLABORADOR_ORGANIZACAO})) //depois adicionar constante gestor em lapr
                return addOrganizacao(oOrganizacao);
        }
        return false;
    }

    /**
     * Adiciona à lista de organizações uma organização recebida por parâmetro.
     *
     * @param oOrganizacao organização
     * @return boolean
     */
    private boolean addOrganizacao(Organizacao oOrganizacao) {
        return this.m_lstOrganizacoes.add(oOrganizacao);
    }

    /**
     * Valida uma organização recebida por parâmetro.
     *
     * @param oOrganizacao organização
     * @return boolean
     */
    public boolean validaOrganizacao(Organizacao oOrganizacao) {
        boolean bRet = true;

        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail()))
            bRet = false;

        return bRet;
    }

    /**
     * Gera a password do Freelancer.
     *
     * @param strNomeGestor  nome do gestor
     * @param strEmailGestor email do gestor
     * @return password
     */
    public String geraPassword(String strNomeGestor, String strEmailGestor) {
        return strNomeGestor + "123";
    }

    /**
     * Devolve uma organização através do email.
     *
     * @param email email
     * @return organização
     */
    public Organizacao getOrganizacaoByEmailUtilizador(String email) {

        for (Organizacao org : this.m_lstOrganizacoes) {
            if (org.getListaColaboradores().getColaboradores().contains(org.getListaColaboradores().getColaboradorByEmail(email))) {
                return org;
            }
        }
        return null;
    }
}
