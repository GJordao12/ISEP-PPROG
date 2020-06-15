package maincontador;

/**
 * @author Jordão
 */
public class ContadorGas extends Contador {

    private static final String ID = "GAZ-";
    private static double custo = 0.8;
    private static int numContGas = 1;

    public ContadorGas(String cliente, int consumo) {
        super(ContadorGas.ID + (ContadorGas.numContGas + 1), cliente, consumo);
        ContadorGas.numContGas++;
    }

    public static double getCustoUnitario() {
        return ContadorGas.custo;
    }

    public static void setCustoUnitario(double custoUnitario) {
        ContadorGas.custo = custoUnitario;
    }

    public static int getNumContador() {
        return ContadorGas.numContGas;
    }

    @Override
    public String toString() {
        return String.format("%s Consumo Gás: %d", super.toString(), super.getConsumo());
    }

    @Override
    public double calcularCusto() {
        return ContadorGas.custo * super.getConsumo();
    }
}
