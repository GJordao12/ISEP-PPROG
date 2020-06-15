package isep.mavenproject1;

/**
 * @author Gonçalo Jordão & António Barbosa
 */
public class CreditoEducacao extends Credito {

    /**
     * Período de Carência (número de meses em que o cliente só paga juros sobre
     * o montante total do empréstimo) acordado entre a instituição bancária e o
     * cliente, por omissão.
     */
    private static final int PERIODODECARENCIA_POR_OMISSAO = 0;
    /**
     * Variável auxiliar para saber o total de Créditos de Educação.
     */
    private static int totalCreditoEducacao = 0;
    /**
     * Taxa Juro Anual do Crédito, em percentagem.
     */
    private float taxaJuroAnual = 0.02f;
    /**
     * Período de Carência (número de meses em que o cliente só paga juros sobre
     * o montante total do empréstimo) acordado entre a instituição bancária e o
     * cliente.
     */
    private int periodoDeCarencia;

    /**
     * Constrói uma instância para o Cliente com Credito Educação recebendo como
     * parâmetro o nome do Cliente, profissão, montante, prazo de financiamento
     * e o periodo de carência.
     *
     * @param nome              Nome do Cliente
     * @param profissao         Profissão do Cliente
     * @param montante          Montante, em euros, do Crédito
     * @param prazoF            Prazo de Financiamento, em meses, do Crédito
     * @param periodoDeCarencia Período de Carência (número de meses em que o
     *                          cliente só paga juros sobre o montante total do empréstimo) acordado
     *                          entre a instituição bancária e o cliente
     */
    public CreditoEducacao(String nome, String profissao, float montante, int prazoF, int periodoDeCarencia) {
        super(nome, profissao, montante, prazoF);
        this.periodoDeCarencia = periodoDeCarencia;
        totalCreditoEducacao++;
    }

    /**
     * Constrói uma instância do Crédito Educação recebendo como parâmetro o
     * nome do Cliente, a profissão, o montante e o prazo financiamento do
     * Crédito e atribuindo o prazo de carência por omissão.
     *
     * @param nome      Nome do Cliente
     * @param profissao Profissão do Cliente
     * @param montante  Montante, em euros, do Crédito
     * @param prazoF    Prazo de Financiamento, em meses, do Crédito
     */
    public CreditoEducacao(String nome, String profissao, float montante, int prazoF) {
        super(nome, profissao, montante, prazoF);
        periodoDeCarencia = PERIODODECARENCIA_POR_OMISSAO;
        totalCreditoEducacao++;
    }

    /**
     * Constrói uma instância de Crédito Educação atribuindo o nome do Cliente,
     * a profissão, o montante, o prazo de financiamento e o período de carência
     * por omissão.
     */
    public CreditoEducacao() {
        super();
        periodoDeCarencia = PERIODODECARENCIA_POR_OMISSAO;
        totalCreditoEducacao++;
    }

    /**
     * Devolve o Total de Créditos Educação.
     *
     * @return Total de Créditos Educação
     */
    public static int getTotalCreditosEducacao() {
        return totalCreditoEducacao;
    }

    /**
     * Devolve a Taxa de Juro Anual, em percentagem.
     *
     * @return Taxa de Juro Anual
     */
    public float getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    /**
     * Modifica a Taxa de Juro Anual.
     *
     * @param taxaJuroAnual Taxa de Juro Anual
     */
    public void setTaxaJuroAnual(float taxaJuroAnual) {
        this.taxaJuroAnual = taxaJuroAnual;
    }

    /**
     * Devolve o Período de Carência do Crédito.
     *
     * @return Período de Carência do Crédito
     */
    public int getPeriodoDeCarencia() {
        return periodoDeCarencia;
    }

    /**
     * Modifica o Período de Carência do Crédito.
     *
     * @param periodoDeCarencia Período de Carência
     */
    public void setPeriodoDeCarencia(int periodoDeCarencia) {
        this.periodoDeCarencia = periodoDeCarencia;
    }

    /**
     * Calcula o Capital a Amortizar do Cliente.
     *
     * @return Capital a Amortizar
     */
    public float calcularCapitalAmortizar() {
        return (super.getMontante()) / (super.getPrazoF() - this.getPeriodoDeCarencia());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("TAXA DE JURO ANUAL: %.2f%%%nPERÍODO DE CARÊNCIA: %d meses%nMONTANTE TOTAL DE JUROS: %.2f€%nMONTANTE A PAGAR PELO CRÉDITO: %.2f€%n", this.getTaxaJuroAnual() * 100, this.getPeriodoDeCarencia(), this.calcularMontanteTotalJuros(), this.calcularMontanteAReceberPorCadaCredito());
    }

    @Override
    public float calcularMontanteTotalJuros() {
        float montante = super.getMontante();
        float montanteTotalJuros = 0;
        montante = montante - this.calcularCapitalAmortizar();
        for (int i = getPeriodoDeCarencia() + 2; i <= super.getPrazoF(); i++) { //getPeriodoDeCarencia()+2, porque os juros só deixam de ser uma "constante" no 2 mês após o Período de Carência.
            montanteTotalJuros = montante * (this.getTaxaJuroAnual() / 12) + montanteTotalJuros;
            montante = montante - this.calcularCapitalAmortizar();
        }
        return ((((super.getMontante() * (this.getTaxaJuroAnual() / 12))) * (this.getPeriodoDeCarencia() + 1)) + montanteTotalJuros);
    }

    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        return super.getMontante() + this.calcularMontanteTotalJuros();
    }
}
