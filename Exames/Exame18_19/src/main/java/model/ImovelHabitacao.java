package model;

import java.io.Serializable;

/**
 * O Imóvel de Habitação.
 *
 * @author Jordão
 */
public class ImovelHabitacao extends Imovel implements Serializable {

    /**
     * Número de Quartos do Imóvel de Habitação.
     */
    private int numQuartos;

    /**
     * Número de Quartos do Imóvel de Habitação, por omissão.
     */
    private final int NUMQUARTOS_POR_OMISSAO = 0;

    /**
     * Cria uma nova instânca de Imóvel Habitação recebendo como parâmetro a Morada do Imóvel, a Localidade do Imóvel,
     * a Área Útil do Imóvel , o Preço do Imóvel e o Número de Quartos.
     *
     * @param morada     Morada do Imóvel
     * @param localidade Localidade do Imóvel
     * @param areaUtil   Área Útil do Imóvel
     * @param preco      Preço do Imóvel
     * @param numQuartos Número de Quartos
     */
    public ImovelHabitacao(String morada, String localidade, double areaUtil, double preco, int numQuartos) {
        super(morada, localidade, areaUtil, preco);
        this.numQuartos = numQuartos;
    }

    /**
     * Cria uma nova instânca de Imóvel Habitação colocando os atributos por omissão.
     */
    public ImovelHabitacao() {
        super();
        this.numQuartos = NUMQUARTOS_POR_OMISSAO;
    }

    /**
     * Devolve o Número de Quartos do Imóvel de Habitação.
     *
     * @return Número de Quartos do Imóvel de Habitação
     */
    public int getNumQuartos() {
        return this.numQuartos;
    }

    /**
     * Modifica o Número de Quartos do Imóvel de Habitação.
     *
     * @param numQuartos Número de Quartos do Imóvel de Habitação
     */
    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    /**
     * Verifica se dois objetos Imóvel Habitação são iguais.
     *
     * @param o Objeto Imóvel Habitação
     * @return true se os objetos são iguais. false se os objetos são diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ImovelHabitacao that = (ImovelHabitacao) o;
        return numQuartos == that.numQuartos;
    }

    /**
     * Descrição Textual do Imóvel Habitação.
     *
     * @return Descrição Textual do Imóvel Habitação.
     */
    @Override
    public String toString() {
        return String.format("%s , Número de Quartos: %d", super.toString(), this.numQuartos);
    }
}
