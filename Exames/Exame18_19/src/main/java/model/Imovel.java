package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * O Imóvel.
 */
public class Imovel implements Comparable<Imovel>, Serializable {

    /**
     * Morada do Imóvel.
     */
    private String morada;

    /**
     * Localidade do Imóvel.
     */
    private String localidade;

    /**
     * Área Útil do Imóvel.
     */
    private double areaUtil;

    /**
     * Preço do Imóvel.
     */
    private double preco;

    /**
     * Comissão do Imóvel.
     */
    private double comissao;

    /**
     * Morada do Imóvel, por omissão.
     */
    private final String MORADA_POR_OMISSAO = "sem morada";

    /**
     * Localidade do Imóvel, por omissão.
     */
    private final String LOCALIDADE_POR_OMISSAO = "sem localidade";

    /**
     * Área Útil do Imóvel, por omissão.
     */
    private final double AREA_UTIL_POR_OMISSAO = 0d;

    /**
     * Preço do Imóvel, por omissão.
     */
    private final double PRECO_POR_OMISSAO = 0d;

    /**
     * Cria uma nova instânca de Imóvel recebendo como parâmetro a Morada do Imóvel, a Localidade do Imóvel,
     * a Área Útil do Imóvel e o Preço do Imóvel.
     *
     * @param morada     Morada do Imóvel
     * @param localidade Localidade do Imóvel
     * @param areaUtil   Área Útil do Imóvel
     * @param preco      Preço do Imóvel
     */
    public Imovel(String morada, String localidade, double areaUtil, double preco) {
        this.morada = morada;
        this.localidade = localidade;
        this.areaUtil = areaUtil;
        this.preco = preco;
    }

    /**
     * Cria uma nova instânca de Imóvel colocando os atributos por omissão.
     */
    public Imovel() {
        this.morada = MORADA_POR_OMISSAO;
        this.localidade = LOCALIDADE_POR_OMISSAO;
        this.areaUtil = AREA_UTIL_POR_OMISSAO;
        this.preco = PRECO_POR_OMISSAO;
    }

    /**
     * Devolve a Morada do Imóvel.
     *
     * @return Morada do Imóvel
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Devolve a Localidade do Imóvel.
     *
     * @return Localidade do Imóvel
     */
    public String getLocalidade() {
        return this.localidade;
    }

    /**
     * Devolve a Área Útil do Imóvel.
     *
     * @return Área Útil do Imóvel
     */
    public double getAreaUtil() {
        return this.areaUtil;
    }

    /**
     * Devolve o Preço do Imóvel.
     *
     * @return Preço do Imóvel
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Devolve a Comissão do Imóvel.
     *
     * @return Comissão do Imóvel
     */
    public double getComissao() {
        return this.comissao;
    }

    /**
     * Modifica a Morada do Imóvel.
     *
     * @param morada Morada do Imóvel
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Modifica a Localidade do Imóvel.
     *
     * @param localidade Localidade do Imóvel
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Modifica a Área Útil do Imóvel.
     *
     * @param areaUtil Área Útil do Imóvel
     */
    public void setAreaUtil(double areaUtil) {
        this.areaUtil = areaUtil;
    }

    /**
     * Modifica o Preço do Imóvel.
     *
     * @param preco Preço do Imóvel
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Modifica a Comissão do Imóvel.
     *
     * @param comissao Comissão do Imóvel
     */
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    /**
     * Calcula a Venda do Imóvel.
     *
     * @return Venda do Imóvel
     */
    public double calcularVendaImovel() {
        return (this.getPreco() + (this.getPreco() * this.comissao));
    }

    /**
     * Verifica se dois objetos Imóvel são iguais.
     *
     * @param o Objeto Imóvel
     * @return true se os objetos são iguais. false se os objetos são diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return Objects.equals(morada, imovel.morada) &&
                Objects.equals(localidade, imovel.localidade) &&
                Objects.equals(areaUtil, imovel.areaUtil) &&
                Objects.equals(preco, imovel.preco);
    }

    /**
     * Descrição Textual do Imóvel.
     *
     * @return Descrição Textual do Imóvel.
     */
    @Override
    public String toString() {
        return String.format("Morada: %s , Localidade: %s , Área: %.2fm^2 , Preço : %.2f€", this.morada, this.localidade, this.areaUtil, this.preco);
    }

    /**
     * Compara dois Objetos Imóvel.
     *
     * @param o Objeto Imóvel
     * @return comparação
     */
    @Override
    public int compareTo(Imovel o) {
        if (localidade.equals(o.getLocalidade()))
            return Double.compare(o.getAreaUtil(),areaUtil);
        return localidade.compareTo(o.getLocalidade());
    }
}
