package isep.mavenproject1;

/**
 *
 * @author Gonçalo Jordão & António Barbosa
 */
public class CreditoHabitacao extends Credito {

    /**
     * Spread (taxa de juro aplicada pelos bancos que funciona como a taxa de
     * lucro dos bancos) dado pelo banco.
     */
    private float spread;

    /**
     * Taxa Euribor, que por definição é 0,1% mas que pode ser alterada.
     */
    private float taxaEuribor = 0.1f;

    /**
     * Variável auxiliar de contagem para saber o total de Créditos de
     * Habitação.
     */
    private static int totalCreditoHabitacao = 0;

    /**
     * Taxa de Juro Anual.
     */
    private float taxaJuroAnual;
    /**
     * Valor do Spread (taxa de juro aplicada pelos bancos que funciona como a
     * taxa de lucro dos bancos) por omissão.
     */

    private static final int SPREAD_POR_OMISSAO = 0;

    /**
     * Constrói uma instância para o Cliente com Credito Habitação recebendo
     * como parâmetro o nome do Cliente, profissão, montante, prazo de
     * financiamento e o spread.
     *
     * @param nome Nome do Cliente
     * @param profissao Profissão do Cliente
     * @param montante Montante, em euros, do Crédito
     * @param prazoF Prazo de Financiamento, em meses, do Crédito
     * @param spread (taxa de juro aplicada pelos bancos que funciona como a
     * taxa de lucro dos bancos) dado pelo banco.
     */
    public CreditoHabitacao(String nome, String profissao, float montante, int prazoF, float spread) {
        super(nome, profissao, montante, prazoF);
        this.spread = spread;
        totalCreditoHabitacao++;
    }

    /**
     * Constrói uma instância do Crédito Habitação recebendo como parâmetro
     * recebendo o nome do Cliente, a profissão, o montante e o prazo
     * financiamento do Crédito e atribuindo o spread por omissão.
     *
     * @param nome Nome do Cliente
     * @param profissao Profissão do Cliente
     * @param montante Montante, em euros, do Crédito
     * @param prazoF Prazo de Financiamento, em meses, do Crédito
     */
    public CreditoHabitacao(String nome, String profissao, float montante, int prazoF) {
        super(nome, profissao, montante, prazoF);
        this.spread = SPREAD_POR_OMISSAO;
        totalCreditoHabitacao++;
    }

    /**
     * Constrói uma instância de Crédito Habitação atribuindo o nome do Cliente,
     * a profissão, o montante, o prazo de financiamento e o período de carência
     * por omissão.
     */
    public CreditoHabitacao() {
        super();
        this.spread = SPREAD_POR_OMISSAO;
        totalCreditoHabitacao++;
    }

    /**
     * Devolve o spread.
     *
     * @return Spread
     */
    public float getSpread() {
        return spread;
    }

    /**
     * Devolve o total de créditos à Habitação efetuados.
     *
     * @return totalCreditoHabitacao
     */
    public static int getTotalCreditoHabitacao() {
        return totalCreditoHabitacao;
    }

    /**
     * Devolve a Taxa Euribor.
     *
     * @return Taxa Euribor
     */
    public float getTaxaEuribor() {
        return taxaEuribor;
    }

    /**
     * Modifica o spread.
     *
     * @param spread spread
     */
    public void setSpread(float spread) {
        this.spread = spread;
    }

    /**
     * Modifica a Taxa Euribor.
     *
     * @param taxaEuribor Taxa Euribor
     */
    public void setTaxaEuribor(float taxaEuribor) {
        this.taxaEuribor = taxaEuribor;
    }

    /**
     * Calcular a Taxa de Juro Anual
     *
     * @return Taxa de Juro Anual
     */
    public float calcularTaxaJuroAnual() {
        return this.taxaJuroAnual = this.spread + this.taxaEuribor;
    }

    /**
     * Calcular o valor de juro mensal
     *
     * @param capitalEmDivida capital em divida
     * @return Valor Juro Mensal
     */
    public float calcularJuroMensal(float capitalEmDivida) {
        return capitalEmDivida * ((taxaEuribor / 100 / 12) + (spread / 100 / 12));
    }

    @Override
    public String toString() {
        return super.toString() + String.format("SPREAD: %.2f%%%nMONTANTE TOTAL DE JUROS: %.2f€%nMONTANTE A PAGAR PELO CRÉDITO: %.2f€%n", this.getSpread(), this.calcularMontanteTotalJuros(), this.calcularMontanteAReceberPorCadaCredito());
    }

    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        if (super.getPrazoF() == 0) {
            return 0;
        } else {
            float capitalAmortizar = super.getMontante() / super.getPrazoF();
            float prestacaoMensal = calcularJuroMensal(super.getMontante()) + capitalAmortizar;
            float capitalEmDivida = super.getMontante() - capitalAmortizar;

            for (int i = 1; i < super.getPrazoF(); i++) {
                float juro = calcularJuroMensal(capitalEmDivida);
                prestacaoMensal = prestacaoMensal + juro + capitalAmortizar;
                capitalEmDivida = capitalEmDivida - capitalAmortizar;
            }
            return prestacaoMensal;
        }
    }

    @Override
    public float calcularMontanteTotalJuros() {
        return calcularMontanteAReceberPorCadaCredito() - super.getMontante();
    }
}
