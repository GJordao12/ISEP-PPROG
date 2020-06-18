package model;

import interfaces.Condominio;

import java.io.Serializable;

/**
 * O Apartamento.
 *
 * @author Jordão
 */
public class Apartamento extends ImovelHabitacao implements Condominio, Serializable {

    /**
     * Quantidade de Apartamentos.
     */
    private int qtdApartamentos = 0;

    /**
     * Taxa do Condomínio.
     */
    private double taxaCondominio = 0.5;

    /**
     * Cria uma nova instânca de Apartamento recebendo como parâmetro a Morada do Imóvel, a Localidade do Imóvel,
     * a Área Útil do Imóvel , o Preço do Imóvel e o Número de Quartos.
     *
     * @param morada     Morada do Imóvel
     * @param localidade Localidade do Imóvel
     * @param areaUtil   Área Útil do Imóvel
     * @param preco      Preço do Imóvel
     * @param numQuartos Número de Quartos
     */
    public Apartamento(String morada, String localidade, double areaUtil, double preco, int numQuartos) {
        super(morada, localidade, areaUtil, preco, numQuartos);
        super.setComissao(0.04);
        this.qtdApartamentos++;
    }

    /**
     * Cria uma nova instânca de Apartamento colocando os atributos por omissão.
     */
    public Apartamento() {
        super();
        this.qtdApartamentos++;
    }

    /**
     * Devolve a Quantidade de Apartamentos.
     *
     * @return Quantidade de Apartamentos
     */
    public int getQtdApartamentos() {
        return this.qtdApartamentos;
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
     * Verifica se dois objetos Apartamento são iguais.
     *
     * @param o Objeto Apartamento
     * @return true se os objetos são iguais. false se os objetos são diferentes.
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
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
     * Descrição Textual do Apartamento.
     *
     * @return Descrição Textual do Apartamento
     */
    @Override
    public String toString() {
        return String.format("Apartamento: %s , Comissão: %.2f%%", super.toString(), super.getComissao());
    }
}
