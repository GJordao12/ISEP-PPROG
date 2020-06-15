import java.util.List;

/**
 * @author ISEP-DEI-PPROG
 */
public class Main {

    public static void main(String[] args) {

        // Criar o baralho e baralhar as cartas
        Baralho b = new Baralho(Baralho.Tipo.BAR_40);
        b.baralhar();

        // Retirar um conjunto de 10 cartas do baralho, criando uma mão de jogo
        MaoDeJogo jogo = new MaoDeJogo(b.primeirasCartas(10));
        System.out.println("\n>>> Mão de jogo:\n" + jogo.toString());

        // Determinar os tipos de carta existentes na mão de jogo
        List<Carta.Tipo> tipos = jogo.tiposDeCarta();
        System.out.println("Nesta mão de jogo há os tipos: " + tipos);

        // Calcular o número de cartas, por tipo de carta, na mão de jogo
        for (Carta.Tipo t : tipos)
            System.out.println("Nesta mão de jogo há " +
                    jogo.contarCartasDoTipo(t) +
                    " carta(s) do tipo " +
                    t);

        // Ordenar a mão de jogo
        jogo.ordenar();
        System.out.println("\n>>> Mão de jogo ordenada:\n" + jogo.toString());
    }
}
