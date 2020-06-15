package my.company.tp2;

/**
 * @author Jordão
 */
public class Endereco {

    /**
     * Nome da rua por omissão.
     */
    private static final String NOME_RUA_POR_OMISSAO = "sem rua";
    /**
     * Código Postal por omissão.
     */
    private static final String COD_POSTAL_POR_OMISSAO = "sem código postal";
    /**
     * Localidade por omissão.
     */
    private static final String LOCALIDADE_POR_OMISSAO = "sem localidade";
    /**
     * Nome da Rua.
     */
    private String nomeRua;
    /**
     * Código Postal.
     */
    private String codPostal;
    /**
     * Localidade.
     */
    private String localidade;

    /**
     * Constrói uma instância para o Endereço, recebendo como parâmetro o Nome
     * da Rua, Código Postal e a Localidade.
     *
     * @param nomeRua    Nome da Rua
     * @param codPostal  Código Postal
     * @param localidade Localidade
     */
    public Endereco(String nomeRua, String codPostal, String localidade) {
        this.nomeRua = nomeRua;
        this.codPostal = codPostal;
        this.localidade = localidade;
    }

    /**
     * Constrói uma instância para o Endereço atribuindo o Nome da Rua,
     * o Código Postal e a Localidade por omissão.
     */
    public Endereco() {
        this.nomeRua = NOME_RUA_POR_OMISSAO;
        this.codPostal = COD_POSTAL_POR_OMISSAO;
        this.localidade = LOCALIDADE_POR_OMISSAO;
    }

    /**
     * Devolve o Nome da Rua.
     *
     * @return Nome da Rua
     */
    public String getNomeRua() {
        return nomeRua;
    }

    /**
     * Modifica o Nome da Rua.
     *
     * @param nomeRua Nome da Rua
     */
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    /**
     * Devolve o Código Postal.
     *
     * @return Código Postal
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * Modifica o Código Postal.
     *
     * @param codPostal Código Postal
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * Devolve a Localidade.
     *
     * @return Localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Modifica a Localidade.
     *
     * @param localidade Localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Devolve a descrição textual do Endereço: Nome da Rua, Código Postal e a
     * Localidade.
     *
     * @return Endereço
     */
    @Override
    public String toString() {
        return String.format("%s, %s de %s", this.nomeRua, this.codPostal, this.localidade);
    }
}
