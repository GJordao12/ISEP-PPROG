package isep.mavenproject1;

/**
 * @author Gonçalo Jordão & António Barbosa
 */
public class CreditoAutomovel extends Credito {

    /**
     * Variável auxiliar de contagem para saber o total de Créditos Automóvel.
     */
    private static int totalCreditoAutomovel = 0;
    /**
     * Taxa de Juro Anual (Valor sobre o qual se calcula o que o cliente
     * pagará).
     */
    private float taxaJuroAnual = 6;
    /**
     * Desconto a aplicar caso o período de financiamento seja igual ou menor a
     * 24 meses.
     */
    private float desconto = 1;

    /**
     * Constrói uma instância para o Cliente com Credito Automóvel, recebendo
     * como parâmetro o nome do Cliente, profissão, montante e o prazo de
     * financiamento.
     *
     * @param nome      Nome do Cliente
     * @param profissao Profissão do Cliente
     * @param montante  Montante, em euros, do Crédito
     * @param prazoF    Prazo de Financiamento, em meses, do Crédito
     */
    public CreditoAutomovel(String nome, String profissao, float montante, int prazoF) {
        super(nome, profissao, montante, prazoF);
        totalCreditoAutomovel++;
    }

    /**
     * Constrói uma instância de Crédito Automóvel atribuindo o nome do Cliente,
     * a profissão, o montante e o prazo de financiamento.
     */
    public CreditoAutomovel() {
        super();
        totalCreditoAutomovel++;
    }

    /**
     * Devolve o Total de Créditos Automóvel.
     *
     * @return Total de Créditos Automóvel
     */
    public static int getTotalCreditoAutomovel() {
        return totalCreditoAutomovel;
    }

    /**
     * Devolve a Taxa de Juro Anual.
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
     * Devolve o desconto.
     *
     * @return desconto.
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * Modifica o desconto.
     *
     * @param desconto desconto
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("TAXA DE JURO ANUAL: %.2f%%%nMONTANTE TOTAL DE JUROS: %.2f€%nMONTANTE A PAGAR PELO CRÉDITO: %.2f€%n", this.getTaxaJuroAnual(), this.calcularMontanteTotalJuros(), this.calcularMontanteAReceberPorCadaCredito());
    }

    @Override
    public float calcularMontanteTotalJuros() {

        float juros = 0;
        float valorAmortizacao = this.getMontante() / this.getPrazoF();
        float montante = this.getMontante();
        for (int i = 0; i < this.getPrazoF(); i++) {
            if (this.getPrazoF() <= 24) {
                juros = juros + (montante * (this.getTaxaJuroAnual() / 100 / 12)) - ((this.getDesconto() / 100) * (valorAmortizacao + (this.getTaxaJuroAnual() / 100 / 12) * montante));
                montante = montante - valorAmortizacao;
            } else {
                juros = juros + ((this.getTaxaJuroAnual() / 100 / 12) * montante);
                montante = montante - valorAmortizacao;
            }
        }
        return juros;
    }

    /**
     * Devolve o Montante a Receber por Cada Crédito Automóvel.
     *
     * @return Montante a Receber por Cada Crédito Automóvel
     */
    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        return this.getMontante() + this.calcularMontanteTotalJuros();
    }
}
