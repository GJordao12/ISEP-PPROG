package model;

import interfaces.Condominio;

import java.io.Serializable;

/**
 * O Escritorio.
 *
 * @author Jordão
 */
public class Escritorio extends Imovel implements Condominio, Serializable {

    /**
     * Taxa do Condomínio.
     */
    private double taxaCondominio = 0.4;

    /**
     * Cria uma nova instânca de Escritório recebendo como parâmetro a Morada do Imóvel, a Localidade do Imóvel,
     * a Área Útil do Imóvel e o Preço do Imóvel.
     *
     * @param morada     Morada do Imóvel
     * @param localidade Localidade do Imóvel
     * @param areaUtil   Área Útil do Imóvel
     * @param preco      Preço do Imóvel
     */
    public Escritorio(String morada, String localidade, double areaUtil, Double preco) {
        super(morada, localidade, areaUtil, preco);
        super.setComissao(0.07);
    }

    /**
     * Cria uma nova instânca de Escritório colocando os atributos por omissão.
     */
    public Escritorio() {
        super();
    }

    /**
     * Devolve a Taxa de Condomínio.
     *
     * @return Taxa de Condomínio
     */
    public double getTaxaCondominio() {
        return this.taxaCondominio;
    }

    /**
     * Modifica a Taxa do Condomínio.
     *
     * @param taxaCondominio Taxa do Condomínio
     */
    public void setTaxaCondominio(double taxaCondominio) {
        this.taxaCondominio = taxaCondominio;
    }

    /**
     * Calcula o Total a Pagar por mês ao Condomínio.
     *
     * @return Total a Pagar por mês ao Condomínio
     */
    @Override
    public double calcularCondominio() {
        return super.getAreaUtil() * this.taxaCondominio;
    }

    /**
     * Descrição Textual do Escritório.
     *
     * @return Descrição Textual do Escritório
     */
    @Override
    public String toString() {
        return String.format("Escritório: %s , Comissão: %.2f%%", super.toString(), super.getComissao());
    }
}
