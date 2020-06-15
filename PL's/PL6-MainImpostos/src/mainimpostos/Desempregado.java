package mainimpostos;

/**
 * @author Jordão
 */
public class Desempregado extends Impostos {

    /**
     * Os outro rendimentos por omissão do utilizador.
     */
    public static final float OR_POR_OMISSAO = 0;
    /**
     * Taxa sobre os outros rendimentos do utilizador;
     */
    public static float taxa_OR = 0.02f;
    /**
     * Os outros rendimentos do utilizador.
     */
    public float OR;

    /**
     * Constrói uma instância de Desempregado recebendo como parâmetro o nome, a
     * morada e os outros rendimentos do utilizador.
     *
     * @param nome   nome do utilizador
     * @param morada morada do utilizador
     * @param OR     outros rendimentos do utilizador
     */
    public Desempregado(String nome, String morada, float OR) {
        super(nome, morada);
        this.OR = OR;
    }

    /**
     * Constrói uma instância de Desempregado recebendo como parâmetro o nome, a
     * morada e colocando como zero os outros rendimentos do utilizador.
     *
     * @param nome nome do desempregado
     * @param morada nome da morada
     */
    public Desempregado(String nome, String morada) {
        super(nome, morada);
        OR = OR_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Desempregado colocando o nome,a morada, e o
     * outros rendimentos por omissão;
     */
    public Desempregado() {
        super();
        OR = OR_POR_OMISSAO;
    }

    /**
     * Devolve a taxa aplicada sobre os outros rendimentos do utilizador.
     *
     * @return taxa aplicada sobre outros rendimentos
     */
    public static float getTaxa_OR() {
        return taxa_OR;
    }

    /**
     * Modifica o valor da taxa aplicada sobre os outros rendimentos do
     * utilizador.
     *
     * @param taxa_OR o valor da taxa aplicada sobre os outros rendimentos
     */
    public static void setTaxa_OR(float taxa_OR) {
        Desempregado.taxa_OR = taxa_OR;
    }

    /**
     * Devolve os outros rendimentos do utilizador.
     *
     * @return outros rendimentos do utilizador
     */
    public float getOR() {
        return OR;
    }

    /**
     * Modifica os outros rendimentos do utilizador.
     *
     * @param OR outros rendimentos do utilizador.
     */
    public void setOR(float OR) {
        this.OR = OR;
    }

    @Override
    public String toString() {
        return String.format("##Desempregado##%n %s Outros Rendimentos: %.2f€", super.toString(), OR);
    }

    @Override
    public float CalcularImpostos() {
        return OR * taxa_OR;
    }
}
