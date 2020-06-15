package maincontador;

/**
 * @author Jordão
 */
public class ContadorEletricoBipartido extends ContadorEletrico {

    private static double custoVazio = 0.066;
    private static double custoFVazio = 0.14;
    private int consumoFVazio;

    public ContadorEletricoBipartido(String cliente, int consumoVazio, double potencia, int consumoFVazio) {
        super(cliente, consumoVazio, potencia);
        this.consumoFVazio = consumoFVazio;
    }

    public static double getCustoVazio() {
        return ContadorEletricoBipartido.custoVazio;
    }

    public static void setCustoVazio(double custoVazio) {
        ContadorEletricoBipartido.custoVazio = custoVazio;
    }

    public static double getCustoFVazio() {
        return ContadorEletricoBipartido.custoFVazio;
    }

    public static void setCustoFVazio(double custoFVazio) {
        ContadorEletricoBipartido.custoFVazio = custoFVazio;
    }

    public int getConsumoFVazio() {
        return this.consumoFVazio;
    }

    public void setConsumoFVazio(int consumoFVazio) {
        this.consumoFVazio = consumoFVazio;
    }

    @Override
    public String toString() {
        return String.format("%s Consumo Vazio: %d Consumo Fora do Vazio: %d",
                super.toString(), super.getConsumo(), this.getConsumoFVazio());
    }

    @Override
    public double calcularCusto() {
        return super.getConsumo() * ContadorEletricoBipartido.getCustoVazio()
                + this.getConsumoFVazio() * ContadorEletricoBipartido.getCustoFVazio();
    }
}
