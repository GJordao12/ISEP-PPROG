package mainimpostos;

/**
 * @author Jordão
 */
public abstract class Impostos {

    /**
     * O nome por omissão da pessoa.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * A morada por omissão da pessoa.
     */
    private static final String MORADA_POR_OMISSAO = "sem morada";
    /**
     * O nome da pessoa.
     */
    private String nome;
    /**
     * A morada da pessoa.
     */
    private String morada;

    /**
     * Inicia o nome do utilizador com o nome recebido.
     *
     * @param nome   Inicia a morada do utilizador com a morada recebida.
     * @param morada morada do utilizador
     */
    public Impostos(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    /**
     * Inicializa o nome do trabalhador com o nome por omissão. Inicializa a
     * morada do trabalhador com a morada por omissão.
     */
    public Impostos() {
        nome = NOME_POR_OMISSAO;
        morada = MORADA_POR_OMISSAO;
    }

    /**
     * Devolve o nome do trabalhador.
     *
     * @return nome do trabalhador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do trabalhador.
     *
     * @param nome o novo nome do trabalhador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve a morada do utilizador.
     *
     * @return morada do utilizador
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Modifica a morada do utilizador.
     *
     * @param morada morada do utilizador
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Devolve o nome e a morada do utilizador
     *
     * @return nome do utilizador mais a respetiva morada
     */
    @Override
    public String toString() {
        return String.format("Nome: %s%n Morada: %s%n", nome, morada);
    }


    public abstract float CalcularImpostos();
}
