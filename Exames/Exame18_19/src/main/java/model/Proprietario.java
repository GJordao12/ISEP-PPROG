package model;

import exceptions.ArgumentoInvalidoException;

import java.util.Objects;

/**
 * O Proprietário.
 *
 * @author Jordão
 */
public class Proprietario {

    /**
     * Nome do Proprietário.
     */
    private String nome;

    /**
     * NIF do Proprietário.
     */
    private int nif;

    /**
     * Email do Proprietário.
     */
    private String email;

    /**
     * Número de Telefone do Proprietário.
     */
    private int numTelefone;

    /**
     * Nome por omissão do Proprietário.
     */
    private final String NOME_POR_OMISSAO = "sem nome";

    /**
     * NIF por omissão do Proprietário.
     */
    private final int NIF_POR_OMISSAO = 0;

    /**
     * Email por omissão do Proprietário.
     */
    private final String EMAIL_POR_OMISSAO = "sem email";

    /**
     * Número de Telefone por omissão do Proprietário.
     */
    private final int NUMTELEFONE_POR_OMISSAO = 0;

    /**
     * Cria uma nova instânca de Proprietário recebendo como parâmtro o Nome do Proprietário, NIF do Proprietário,
     * Email do Proprietário e Número de Telefone do Proprietário.
     *
     * @param nome        Nome do Proprietário
     * @param nif         NIF do Proprietário
     * @param email       Email do Proprietário
     * @param numTelefone Número de Telefone do Proprietário
     */
    public Proprietario(String nome, int nif, String email, int numTelefone) {
        this.nome = nome;
        this.nif = nif;
        this.email = email;
        setNumTelefone(numTelefone);
    }

    /**
     * Cria uma nova instânca de Proprietario colocando os atributos por omissão.
     */
    public Proprietario() {
        this.nome = NOME_POR_OMISSAO;
        this.nif = NIF_POR_OMISSAO;
        this.email = EMAIL_POR_OMISSAO;
        this.numTelefone = NUMTELEFONE_POR_OMISSAO;
    }

    /**
     * Devolve o Nome do Proprietário.
     *
     * @return Nome do Proprietário
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve o NIF do Proprietário.
     *
     * @return NIF do Proprietário
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * Devolve o Email do Proprietário.
     *
     * @return Email do Proprietário
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Devolve o Número de Telefone do Proprietário.
     *
     * @return Número de Telefone do Proprietário
     */
    public int getNumTelefone() {
        return this.numTelefone;
    }

    /**
     * Modifica o Nome do Proprietário.
     *
     * @param nome Nome do Proprietário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o NIF do Proprietário.
     *
     * @param nif NIF do Proprietário
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Modifica o Email do Proprietário.
     *
     * @param email Email do Proprietário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Modifica o Número de Telefone do Proprietário.
     *
     * @param numTelefone Número de Telefone do Proprietário
     */
    private void setNumTelefone(int numTelefone) {
        if (String.valueOf(numTelefone).length() != 9)
            throw new ArgumentoInvalidoException();
        this.numTelefone = numTelefone;
    }

    /**
     * Verifica se dois objetos Proprietário são iguais.
     *
     * @param o Objeto Proprietario
     * @return true se os objetos são iguais. false se os objetos são diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietario that = (Proprietario) o;
        return nif == that.nif &&
                numTelefone == that.numTelefone &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email);
    }

    /**
     * Descrição Textual do Proprietário.
     *
     * @return Descrição Textual do Proprietário
     */
    @Override
    public String toString() {
        return String.format("Proprietário -> Nome: %s , Email: %s , NIF: %d , Número de Telefone: %d", this.nome, this.email, this.nif, this.numTelefone);
    }
}
