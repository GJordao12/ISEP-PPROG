package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.lista.ListaColaboradores;
import pt.ipp.isep.dei.esoft.pot.model.lista.ListaTarefas;

import java.util.Objects;

/**
 * Organização.
 *
 * @author paulomaio
 */
public class Organizacao {

    private String m_strNome;
    private String m_strNIF;
    private EnderecoPostal m_oEnderecoPostal;
    private String m_strWebsite;
    private String m_strTelefone;
    private String m_strEmail;
    private Colaborador m_oGestor;
    private ListaColaboradores m_ListaColaboradores;
    private ListaTarefas m_ListaTarefas;

    /**
     * Instancia uma nova Organização.
     *
     * @param strNome      nome
     * @param strNIF       NIF
     * @param strWebsite   website
     * @param strTelefone  telefone
     * @param strEmail     email
     * @param oMorada      morada
     * @param oColaborador colaborador
     */
    public Organizacao(String strNome, String strNIF, String strWebsite, String strTelefone,
                       String strEmail, EnderecoPostal oMorada, Colaborador oColaborador) {
        if ((strNome == null) || (strNIF == null) || (strTelefone == null) ||
                (strEmail == null) || (oMorada == null) || (oColaborador == null) ||
                (strNome.isEmpty()) || (strNIF.isEmpty()) || (strTelefone.isEmpty()) ||
                (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_oEnderecoPostal = oMorada;
        this.m_strWebsite = strWebsite;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
        this.m_oGestor = oColaborador;

        this.m_ListaColaboradores = new ListaColaboradores();
        this.m_ListaColaboradores.addColaborador(oColaborador);
        this.m_ListaTarefas = new ListaTarefas();
    }

    /**
     * Cria um novo endereço postal através do construtor da classe EnderecoPostal.
     *
     * @param strLocal      local
     * @param strCodPostal  código postal
     * @param strLocalidade localidade
     * @return endereço postal
     */
    public static EnderecoPostal novoEnderecoPostal(String strLocal, String strCodPostal, String strLocalidade) {
        return new EnderecoPostal(strLocal, strCodPostal, strLocalidade);
    }

    /**
     * Cria um novo colaborador através do construtor da classe Colaborador.
     *
     * @param strNome     nome
     * @param strFuncao   função
     * @param strTelefone telefone
     * @param strEmail    email
     * @return colaborador
     */
    public static Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        return new Colaborador(strNome, strFuncao, strTelefone, strEmail);
    }

    /**
     * Devolve o gestor de organização.
     *
     * @return gestor de organização
     */
    public Colaborador getGestor() {
        return this.m_oGestor;
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
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
        Organizacao obj = (Organizacao) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    /**
     * Devolve a descrição textual da Organização.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Nome: %s , NIF: %s , Website: %s , Telefone: %s , Email: %s , Endereço: %s , Gestor: %s", this.m_strNome, this.m_strNIF, this.m_strWebsite, this.m_strTelefone, this.m_strEmail, this.m_oEnderecoPostal.toString(), this.m_oGestor.toString());
    }

    /**
     * Devolve a lista de tarefas.
     *
     * @return lista tarefas
     */
    public ListaTarefas getListaTarefas() {
        return this.m_ListaTarefas;
    }

    /**
     * Devolve a lista de colaboradores.
     *
     * @return lista colaboradores
     */
    public ListaColaboradores getListaColaboradores() {
        return this.m_ListaColaboradores;
    }

    /**
     * Devolve o colaborador através do email.
     *
     * @param email email
     * @return colaborador
     */
    public Colaborador getColaboradorByEmailUtilizador(String email) {
        for (Colaborador colab : this.m_ListaColaboradores.getColaboradores()) {
            if (colab.getEmail().equals(email)) {
                return colab;
            }
        }
        return null;
    }
}
