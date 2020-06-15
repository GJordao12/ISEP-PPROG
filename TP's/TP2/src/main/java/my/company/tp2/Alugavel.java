package my.company.tp2;

/**
 * @author Jordão
 */
public interface Alugavel {

    /**
     * Taxa de Aluguer da Plataforma.
     */
    float taxaDeAluguer = 0.05f;

    /**
     * Devolve o Valor de Aluguer do artigo.
     *
     * @return Valor de Aluguer
     */
    float getValorAluguer();
}
