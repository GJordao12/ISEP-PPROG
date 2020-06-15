package my.company.tp2;

/**
 * @author Jordão
 */
public class Automovel implements Alugavel, Vendivel {

    /**
     * Marca do automóvel por omissão.
     */
    private static final String MARCA_POR_OMISSAO = "sem marca";
    /**
     * Modelo do automóvel por omissão.
     */
    private static final String MODELO_POR_OMISSAO = "sem modelo";
    /**
     * Valor pelo qual o anunciante pretende que o automóvel seja vendido por omissão.
     */
    private static final float VALOR_VENDA_PRETENDIDO_POR_OMISSAO = 0;
    /**
     * Valor pelo qual o anunciante pretende que o automóvel seja alugado por omissão.
     */
    private static final float VALOR_ALUGUER_PRETENDIDO_POR_OMISSAO = 0;
    /**
     * Marca do automóvel.
     */
    private String marca;
    /**
     * Modelo do automóvel.
     */
    private String modelo;
    /**
     * Valor pelo qual o anunciante pretende que o automóvel seja vendido.
     */
    private float valorVendaPretendido;
    /**
     * Valor pelo qual o anunciante pretende que o automóvel seja alugado.
     */
    private float valorAluguerPretendido;

    /**
     * Constrói uma instância para o Automóvel, recebendo como parâmetro a marca
     * do automóvel, o respetivo modelo, o valor que o anunciante pretende receber pela
     * venda do automóvel e o valor que o anunciante pretende receber pelo aluguer
     * do automóvel.
     *
     * @param marca                  Marca do Automóvel
     * @param modelo                 Modelo do Automóvel
     * @param valorVendaPretendido   Valor que o anunciante pretende receber pela venda do automóvel
     * @param valorAluguerPretendido Valor que o anunciante pretende receber pela venda do automóvel
     */
    public Automovel(String marca, String modelo, float valorVendaPretendido, float valorAluguerPretendido) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorVendaPretendido = valorVendaPretendido;
        this.valorAluguerPretendido = valorAluguerPretendido;
    }

    /**
     * Constrói uma instância para o Automóvel atribuindo a marca do Automóvel,
     * o modelo, o valor de venda pretendido pelo anunciante e o valor de aluguer pretendido
     * pelo anunciante por omissão.
     */
    public Automovel() {
        this.marca = MARCA_POR_OMISSAO;
        this.modelo = MODELO_POR_OMISSAO;
        this.valorVendaPretendido = VALOR_VENDA_PRETENDIDO_POR_OMISSAO;
        this.valorAluguerPretendido = VALOR_ALUGUER_PRETENDIDO_POR_OMISSAO;
    }

    /**
     * Devolve a marca do Automóvel.
     *
     * @return Marca do Automóvel
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Modifica a Marca do Automóvel.
     *
     * @param marca Marca do Automóvel
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devolve o modelo do Automóvel.
     *
     * @return Modelo do Automóvel
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica o Modelo do Automóvel.
     *
     * @param modelo Marca do Automóvel
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devolve o valor que o anunciante pretende pela venda do automóvel.
     *
     * @return Valor de Venda Pretendido pelo Anunciante
     */
    public float getValorVendaPretendido() {
        return valorVendaPretendido;
    }

    /**
     * Modifica o Valor de Venda pretendido pelo Anunciante
     *
     * @param valorVendaPretendido Valor de Venda Pretendido
     */
    public void setValorVendaPretendido(float valorVendaPretendido) {
        this.valorVendaPretendido = valorVendaPretendido;
    }

    /**
     * Devolve o valor que o anunciante pretende pelo aluguer do automóvel.
     *
     * @return Valor de Aluguer pretendido pelo Anunciante
     */
    public float getValorAluguerPretendido() {
        return valorAluguerPretendido;
    }

    /**
     * Modifica o Valor de Aluguer pretendido pelo Anunciante
     *
     * @param valorAluguerPretendido Valor de Venda Pretendido
     */
    public void setValorAluguerPretendido(float valorAluguerPretendido) {
        this.valorAluguerPretendido = valorAluguerPretendido;
    }

    /**
     * Devolve a descrição textual do Automóvel: Marca, Modelo,
     * valor pretendido pela venda e valor pretendido pelo aluguer.
     *
     * @return Automóvel
     */
    @Override
    public String toString() {
        return String.format("Automóvel %s %s com custo de venda de %.2f€ e de aluguer de %.2f€", this.marca, this.modelo, this.getValorVenda(), this.getValorAluguer());
    }

    /**
     * Devolve o valor pelo qual o Automóvel será vendido, após as taxas.
     *
     * @return Valor de Venda do Automóvel após taxas
     */
    @Override
    public float getValorVenda() {
        return valorVendaPretendido * (1 + Vendivel.taxaDeVenda);
    }

    /**
     * Devolve o valor pelo qual o Automóvel será alugado, após as taxas.
     *
     * @return Valor de Aluguer do Automóvel após taxas
     */
    @Override
    public float getValorAluguer() {
        return valorAluguerPretendido * (1 + Alugavel.taxaDeAluguer);
    }
}
