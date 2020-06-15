package maincontador;

/**
 * @author Jordão
 */
public class MainContador {

    public static void main(String[] args) {

        // a)
        ContadorGas g1 = new ContadorGas("Pedro Moreira", 12);
        ContadorGas g2 = new ContadorGas("Tiago Ferreira", 17);
        ContadorGas g3 = new ContadorGas("Alexandra Silva", 10);
        ContadorEletricoSimples e1 = new ContadorEletricoSimples("Pedro Moreira", 1200, 5.7);
        ContadorEletricoBipartido e2 = new ContadorEletricoBipartido("Tiago Ferreira", 500, 10, 1000);
        ContadorEletricoSimples e3 = new ContadorEletricoSimples("Alexandra Silva", 1700, 7.8);

        Contador[] Contadores = new Contador[10];

        Contadores[0] = g1;
        Contadores[1] = g2;
        Contadores[2] = g3;
        Contadores[3] = e1;
        Contadores[4] = e2;
        Contadores[5] = e3;

        // b)
        System.out.println("#####Contadores####");
        for (int i = 0; i < Contadores.length && Contadores[i] != null; i++) {
            System.out.println(Contadores[i]);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // c)
        System.out.println("Total de contadores de eletricidade: " + ContadorEletrico.getNumContador());

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // d)
        System.out.println("####Contadores Bi-partidos####");
        for (Contador contador : Contadores) {
            if (contador instanceof ContadorEletricoBipartido) {
                System.out.println(contador.getId());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // e)
        System.out.println("####Custo de consumo por contador####");
        for (int i = 0; i < Contadores.length && Contadores[i] != null; i++) {
            System.out.printf("ID:%s Custo:%.2f€.%n", Contadores[i].getId(), Contadores[i].calcularCusto());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // f)
        int maiorConsumoGas = 0;
        for (int i = 0; i < Contadores.length && Contadores[i] != null; i++) {
            if (Contadores[i] instanceof ContadorGas && (Contadores[i].getConsumo() > maiorConsumoGas)) {
                maiorConsumoGas = Contadores[i].getConsumo();
            }
        }
        if (maiorConsumoGas != 0) {
            System.out.println("Maior consumo de gás: " + maiorConsumoGas);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // g) Listar o nome dos diferentes clientes*
        String[] clientes = new String[10];
        boolean guardar;
        int k = 0;
        for (int i = 0; i < Contadores.length && Contadores[i] != null; i++) {
            guardar = true;
            for (int j = 0; j < k; j++) {
                if (clientes[j].equalsIgnoreCase(Contadores[i].getCliente())) {
                    guardar = false;
                    break;
                }
            }
            if (guardar) {
                clientes[k] = Contadores[i].getCliente();
                k++;
            }
        }
        for (int i = 0; i < clientes.length && clientes[i] != null; i++) {
            System.out.println(clientes[i]);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
}
