import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jordão
 */
public class MainVencimentos {

    public static void main(String[] args) {

        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira", 500.0f, 1500.0f, 6f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);

        List<Trabalhador> trabs = new ArrayList<Trabalhador>();
        trabs.add(tc);
        trabs.add(tp);
        trabs.add(th);

        //USAR O COMPARABLE
        System.out.println("### Trabalhadores ###");
        listar(trabs);

        System.out.println("\n###### Ordenação de Vencimentos Comparable ######");

        System.out.println("\n#Trabalhadores por Ordem Crescente de Vencimentos#");
        Collections.sort(trabs);
        listar(trabs);

        System.out.println("\n###### Ordenação de Vencimentos Comparable ######");

        System.out.println("\n#Trabalhadores por Ordem Decrescente de Vencimentos#");
        Collections.reverse(trabs);
        listar(trabs);

        //UTILIZAR O COMPARATOR
        System.out.println("");
        System.out.println("\n###### Ordenação de Vencimentos Comparator ######");

        System.out.println("\n#Trabalhadores por Ordem Crescente de Vencimentos#");
        ComparatorVencimentos a = new ComparatorVencimentos();
        trabs.sort(a);
        listar(trabs);

        System.out.println("\n###### Ordenação de Vencimentos Comparator ######");

        System.out.println("\n#Trabalhadores por Ordem Decrescente de Vencimentos#");
        trabs.sort(Collections.reverseOrder(a));
        listar(trabs);

        System.out.println("\n###### Ordenação Alfabética Comparator ######");
        System.out.println("\n#Trabalhadores por Ordem Alfabética#");
        ComparatorAlfabetico c = new ComparatorAlfabetico();
        trabs.sort(c);
        listar(trabs);
    }

    private static void listar(List<Trabalhador> trabs) {
        for (Trabalhador trab : trabs) {
            if (trab != null) {
                System.out.printf("%s, vencimento = %.2f€%n", trab.getNome(),
                        trab.calcularVencimento());
            }
        }
    }
}
