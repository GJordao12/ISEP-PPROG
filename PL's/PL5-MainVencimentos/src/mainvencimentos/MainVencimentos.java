package mainvencimentos;

/**
 * @author Jordão
 */
public class MainVencimentos {

    public static void main(String[] args) {

        TrabalhadorPeca Trabalhador1 = new TrabalhadorPeca("Jorge Silva", 53, 62);
        TrabalhadorComissao Trabalhador2 = new TrabalhadorComissao("Susana Ferreira", 650, (float) 2731.50, (float) 4.25);
        TrabalhadorHora Trabalhador3 = new TrabalhadorHora("Carlos Miguel", 168, (float) 4.50);

        Trabalhador[] Trabalhador = new Trabalhador[10];
        Trabalhador[0] = Trabalhador1;
        Trabalhador[1] = Trabalhador2;
        Trabalhador[2] = Trabalhador3;

        System.out.println("###################TRABALHADORES###################");
        for (int i = 0; i < Trabalhador.length && Trabalhador[i] != null; i++) {
            System.out.println(Trabalhador[i]);
        }

        System.out.println();
        System.out.println("###############TRABALHADORES Á HORA###############");

        for (int i = 0; i < 3; i++) {
            if (Trabalhador[i] instanceof TrabalhadorHora) {
                System.out.println(Trabalhador[i].toString());
            }
        }

        System.out.println();
        System.out.println("###################VENCIMENTOS####################");

        for (int i = 0; i < Trabalhador.length && Trabalhador[i] != null; i++) {
            System.out.printf("O/A %s tem um vencimento de %.2f€.%n", Trabalhador[i].getNome(), Trabalhador[i].calcularVencimento());
        }
    }
}
