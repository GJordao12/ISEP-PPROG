package mainimpostos;

/**
 * @author Jordão
 */
public class MainImpostos {

    public static void main(String[] args) {

        Desempregado u1 = new Desempregado("João", "Rua Carmo 112", 1000);
        Desempregado u2 = new Desempregado("José", "Rua Camões 43", 900);
        Reformado u3 = new Reformado("Rute", "Rua 25 Abril 56", 2300, 1100);
        Reformado u4 = new Reformado("Rute", "Rua 25 Abril 78", 1200, 1500);
        TrabalhadorPorContaOutrem u5 = new TrabalhadorPorContaOutrem("Madalena", "Rua Silvestre 12", 35000, 5000);
        TrabalhadorPorContaOutrem u6 = new TrabalhadorPorContaOutrem("Manel", "Rui São Sebastião 789", 23460, 7000);
        TrabalhadorPorContaPropria u7 = new TrabalhadorPorContaPropria("Afonso", "Rua Ali", 55765, 3400);
        TrabalhadorPorContaPropria u8 = new TrabalhadorPorContaPropria("Rita", "Rua Elisa", 40000, 7000);

        Impostos[] Utilizadores = new Impostos[15];
        Utilizadores[0] = u1;
        Utilizadores[1] = u2;
        Utilizadores[2] = u3;
        Utilizadores[3] = u4;
        Utilizadores[4] = u5;
        Utilizadores[5] = u6;
        Utilizadores[6] = u7;
        Utilizadores[7] = u8;

        for (int i = 0; i < Utilizadores.length && Utilizadores[i] != null; i++) {
            System.out.println(Utilizadores[i]);
        }

        System.out.println("------------------------------------------------------");

        for (int i = 0; i < Utilizadores.length && Utilizadores[i] != null; i++) {
            if (Utilizadores[i] instanceof Desempregado) {
                System.out.println("O/A " + Utilizadores[i].getNome() + " tem de pagar de imposto extraordinário " + Utilizadores[i].CalcularImpostos() + "€.");
            }
        }

        System.out.println("------------------------------------------------------");

        Desempregado.setTaxa_OR(0.05f);

        for (int i = 0; i < Utilizadores.length && Utilizadores[i] != null; i++) {
            if (Utilizadores[i] instanceof Desempregado) {
                System.out.println("O/A " + Utilizadores[i].getNome() + " tem de pagar de imposto extraordinário " + Utilizadores[i].CalcularImpostos() + "€.");
            }
        }
        System.out.println("------------------------------------------------------");
    }
}
