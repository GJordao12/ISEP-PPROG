package my.company.tp2;

/**
 * @author Jordão
 */
public interface Vendivel {

    /**
     * Taxa de Venda da Plataforma.
     */
    float taxaDeVenda = 0.03f;

    /**
     * Devolve o Valor de Venda do artigo.
     *
     * @return Valor de Venda
     */
    float getValorVenda();
}
