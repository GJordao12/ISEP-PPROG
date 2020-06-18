package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Moradia.
 */
public class Moradia extends ImovelHabitacao implements Serializable {

    /**
     * A Área Exterior da Maradia.
     */
    private double areaExterior;

    /**
     * A Área Exterior da Maradia, por omissão.
     */
    private final double AREA_EXTERIOR_POR_OMISSAO = 0d;

    /**
     * Cria uma nova instânca de Moradia recebendo como parâmetro a Morada do Imóvel, a Localidade do Imóvel,
     * a Área Útil do Imóvel, o Preço do Imóvel, o Número de Quartos e a Área Exterior da Maradia.
     *
     * @param morada       Morada do Imóvel
     * @param localidade   Localidade do Imóvel
     * @param areaUtil     Área Útil do Imóvel
     * @param preco        Preço do Imóvel
     * @param numQuartos   Número de Quartos
     * @param areaExterior Área Exterior da Maradia
     */
    public Moradia(String morada, String localidade, Double areaUtil, double preco, int numQuartos, Double areaExterior) {
        super(morada, localidade, areaUtil, preco, numQuartos);
        this.areaExterior = areaExterior;
        if (super.getPreco() < 150000)
            super.setComissao(0.05);
        else
            super.setComissao(0.06);
    }

    /**
     * Cria uma nova instânca de Moradia colocando os atributos por omissão.
     */
    public Moradia() {
        super();
        this.areaExterior = AREA_EXTERIOR_POR_OMISSAO;
    }

    /**
     * Verifica se dois objetos Moradia são iguais.
     *
     * @param o Objeto Moradia
     * @return true se os objetos são iguais. false se os objetos são diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Moradia moradia = (Moradia) o;
        return Objects.equals(areaExterior, moradia.areaExterior);
    }

    /**
     * Descrição Textual da Moradia.
     *
     * @return Descrição Textual da Moradia
     */
    @Override
    public String toString() {
        return String.format("Apartamento: %s , Área Exterior: %.2f Comissão: %.2f%%", super.toString(), this.areaExterior, super.getComissao());
    }
}
