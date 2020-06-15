package my.company.tp2;

/**
 * @author Jordão
 */
public class Telemovel implements Vendivel {

    /**
     * Designação do Telemóvel por omissão.
     */
    private static final String DESIGNACAO_POR_OMISSAO = "sem designação";
    /**
     * Valor de venda pretendido do Telemóvel por omissão.
     */
    private static final float VALOR_VENDA_PRETENDIDO_POR_OMISSAO = 0;
    /**
     * Designação do Telemóvel.
     */
    private String designacao;
    /**
     * Valor de venda pretendido do Telemóvel.
     */
    private float valorVendaPretendido;

    /**
     * Constrói uma instância para o Telemóvel, recebendo como parâmetro a designação
     * do telemóvel e o valor de venda pretendido do telemóvel.
     *
     * @param designacao           Designação do Telemóvel
     * @param valorVendaPretendido Valor de venda pretendido do Telemóvel
     */
    public Telemovel(String designacao, float valorVendaPretendido) {
        this.designacao = designacao;
        this.valorVendaPretendido = valorVendaPretendido;
    }

    /**
     * Constrói uma instância para o Telemóvel atribuindo a designação do telemóvel
     * e respetivo preço de venda pretendido por omissão.
     */
    public Telemovel() {
        this.designacao = DESIGNACAO_POR_OMISSAO;
        this.valorVendaPretendido = VALOR_VENDA_PRETENDIDO_POR_OMISSAO;
    }

    /**
     * Devolve a designação do telemóvel.
     *
     * @return Designação do Telemóvel
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Modifica a designação do Telemóvel.
     *
     * @param designacao Designação do Telemóvel
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Devolve o valor de venda pretendido pelo telemóvel.
     *
     * @return Designação do Telemóvel
     */
    public float getValorVendaPretendido() {
        return valorVendaPretendido;
    }

    /**
     * Modifica o valor de venda pretendido pelo Telemóvel.
     *
     * @param valorVendaPretendido Valor de venda pretendido pelo Telemóvel
     */
    public void setValorVendaPretendido(float valorVendaPretendido) {
        this.valorVendaPretendido = valorVendaPretendido;
    }

    /**
     * Devolve a descrição textual do Telemóvel: Designação e Valor de Venda.
     *
     * @return Telemóvel
     */
    @Override
    public String toString() {
        return String.format("Telemóvel %s por %.2f€", this.getDesignacao(), this.getValorVenda());
    }

    /**
     * Devolve o valor pelo qual o Telemóvel será vendido, após as taxas.
     *
     * @return Valor de Venda do Telemóvel após taxas
     */
    @Override
    public float getValorVenda() {
        return valorVendaPretendido * (1 + Vendivel.taxaDeVenda);
    }
}
