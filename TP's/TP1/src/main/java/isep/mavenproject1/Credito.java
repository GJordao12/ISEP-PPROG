package isep.mavenproject1;

/**
 *
 * @author Gonçalo Jordão & António Barbosa
 */
public abstract class Credito {

    /**
     * Nome do Cliente.
     */
    private String nome;

    /**
     * Profissão do Cliente.
     */
    private String profissao;

    /**
     * Montante, em euros, do Crédito.
     */
    private float montante;

    /**
     * Prazo de Financiamento, em meses, do Crédito.
     */
    private int prazoF;

    /**
     * Nome do Cliente por omissão.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";

    /**
     * Profissão do Cliente por omissão.
     */
    private static final String PROFISSAO_POR_OMISSAO = "sem profissão";

    /**
     * Montante, em euros, do Crédito por omissão.
     */
    private static final float MONTANTE_POR_OMISSAO = 0;

    /**
     * Prazo de Financiamento, em meses, do Crédito por omissão.
     */
    private static final int PRAZOF_POR_OMISSAO = 0;

    /**
     * Constrói uma instância do Crédito Bancário recebendo como parâmetro o
     * nome do Cliente, a profissão, o montante e o prazo de financiamento do
     * Crédito.
     *
     * @param nome Nome do Cliente
     * @param profissao Profissão do Cliente
     * @param montante Montante, em euros, do Crédito
     * @param prazoF Prazo de Financiamento, em meses, do Crédito
     */
    public Credito(String nome, String profissao, float montante, int prazoF) {
        this.nome = nome;
        this.profissao = profissao;
        this.montante = montante;
        this.prazoF = prazoF;
    }

    /**
     * Constrói uma instância do Crédito Bancário colocando no nome do Cliente,
     * a profissão, o montante e o prazo de financiamento do Crédito por
     * omissão.
     */
    public Credito() {
        nome = NOME_POR_OMISSAO;
        profissao = PROFISSAO_POR_OMISSAO;
        montante = MONTANTE_POR_OMISSAO;
        prazoF = PRAZOF_POR_OMISSAO;
    }

    /**
     * Devolve o nome do Cliente.
     *
     * @return nome do Cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a profissão do Cliente.
     *
     * @return profissao do Cliente
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Devolve o montante, em euros, do Crédito.
     *
     * @return montante do Crédito
     */
    public float getMontante() {
        return montante;
    }

    /**
     * Devolve o prazo de financiamento, em meses, do Crédito.
     *
     * @return prazo de financiamento do Crédito
     */
    public int getPrazoF() {
        return prazoF;
    }

    /**
     * Modifica o nome do Cliente.
     *
     * @param nome novo nome do Cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica a profissão do Cliente.
     *
     * @param profissao nova profissao do Cliente
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Modifica o montante do Crédito.
     *
     * @param montante novo montante do Crédito
     */
    public void setMontante(float montante) {
        this.montante = montante;
    }

    /**
     * Modifica o prazo de financiamento do Cliente.
     *
     * @param prazoF novo prazo de financiamento do Crédito
     */
    public void setPrazoF(int prazoF) {
        this.prazoF = prazoF;
    }

    @Override
    /**
     * Devolve a descrição textual do Crédito: titular, profissão, montante,
     * prazo de financiamento.
     *
     * @return Dados do Crédito
     */
    public String toString() {
        return String.format("NOME: %s%nPROFISSÃO: %s%nMONTANTE: %.2f€%nPRAZO FINANCIAMENTO: %d meses %n", nome, profissao, montante, prazoF);
    }

    public abstract float calcularMontanteAReceberPorCadaCredito();

    public abstract float calcularMontanteTotalJuros();
}
