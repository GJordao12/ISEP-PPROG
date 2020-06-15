package my.company.tp2;

/**
 * @author Jordão
 */
public class Apartamento implements Alugavel {

    /**
     * Área do Apartamento por omissão.
     */
    private static final float AREA_POR_OMISSAO = 0;
    /**
     * Valor de Aluguer pretendido do Apartamento por omissão.
     */
    private static final float VALOR_ALUGUER_PRETENDIDO_POR_OMISSAO = 0;
    /**
     * Endereço do Apartamento.
     */
    private Endereco endereco;
    /**
     * Área do Apartamento.
     */
    private float area;
    /**
     * Valor de Aluguer pretendido do Apartamento.
     */
    private float valorAluguerPretendido;

    /**
     * Constrói uma instância para o Apartamento, recebendo como parâmetro o endereço,
     * a área do apartamento e o valor de aluguer pretendido pelo apartamento.
     *
     * @param endereco     Endereço do Apartamento
     * @param area         Área do apartamento
     * @param valorAluguer Valor que o anunciante pretende receber pelo aluguer do apartamento
     */
    public Apartamento(Endereco endereco, float area, float valorAluguer) {
        this.endereco = new Endereco(endereco.getNomeRua(), endereco.getCodPostal(), endereco.getLocalidade());
        this.area = area;
        this.valorAluguerPretendido = valorAluguer;
    }

    /**
     * Constrói uma instância para o Apartamento atribuindo o endereço do apartamento, a
     * área e o valor pretendido pelo aluguer por omissão.
     */
    public Apartamento() {
        this.endereco = new Endereco();
        this.area = AREA_POR_OMISSAO;
        this.valorAluguerPretendido = VALOR_ALUGUER_PRETENDIDO_POR_OMISSAO;
    }

    /**
     * Devolve o Endereço do Apartamento.
     *
     * @return Endereço do Apartamento
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Modifica o Endereço do Apartamento.
     *
     * @param endereco Endereço do Apartamento
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = new Endereco(endereco.getNomeRua(), endereco.getCodPostal(), endereco.getLocalidade());
    }

    /**
     * Devolve a Área do Apartamento.
     *
     * @return Área do Apartamento
     */
    public float getArea() {
        return area;
    }

    /**
     * Modifica a área do Apartamento.
     *
     * @param area Área do Apartamento
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * Devolve o valor pretendido pelo Aluguer do Apartamento.
     *
     * @return Valor pretendido pelo Aluguer do Apartamento
     */
    public float getValorAluguerPretendido() {
        return valorAluguerPretendido;
    }

    /**
     * Devolve a descrição textual do Apartamento: Endereço, Área e custo de aluguer.
     *
     * @return Apartamento
     */
    @Override
    public String toString() {
        return String.format("Apartamento localizado em %s, com área %.2fm^2 e custo de aluguer %.2f€", this.endereco, this.area, this.getValorAluguer());
    }

    /**
     * Devolve o valor pelo qual o Apartamento será alugado, após as taxas.
     *
     * @return Valor de Aluguer do Apartamento após taxas
     */
    @Override
    public float getValorAluguer() {
        return valorAluguerPretendido * (1 + Alugavel.taxaDeAluguer);
    }

    /**
     * Modifica o valor pelo qual o Anunciante pretende que o apartamento seja alugado.
     *
     * @param valorAluguer Valor Aluguer
     */
    public void setValorAluguer(float valorAluguer) {
        this.valorAluguerPretendido = valorAluguer;
    }
}
