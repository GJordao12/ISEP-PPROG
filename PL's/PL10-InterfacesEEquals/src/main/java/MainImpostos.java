import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jordão
 */
public class MainImpostos {

    public static void main(String[] args) {

        //1. Na classe principal, crie um contentor do tipo ArrayList<Contribuinte> chamado contribuintes.
        List<Impostos> contribuintes = new ArrayList<Impostos>();

        //2. Adicione contribuintes ao contentor, usando o seguinte código:
        contribuintes.add(new Desempregado("Lito Vidal", "Lisboa", 230));
        contribuintes.add(new Reformado("Valter Cubilhas", "Olival", 600, 400));
        contribuintes.add(new Desempregado("Paulo Santos", "Braga", 150));
        contribuintes.add(new TrabalhadorPorContaOutrem("Ana", "Ovar", 1800, 300));
        contribuintes.add(new Reformado("Jaime Magalhães", "Porto", 1500, 100));
        contribuintes.add(new TrabalhadorPorContaOutrem("Salvio", "Seixal", 8000, 1000));
        contribuintes.add(new TrabalhadorPorContaPropria("Mário", "Guarda", 1500, 300));
        contribuintes.add(new Reformado("Aníbal Silva", "Coimbra", 1000, 500));
        contribuintes.add(new TrabalhadorPorContaOutrem("João", "Lisboa", 800, 100));
        contribuintes.add(new TrabalhadorPorContaPropria("Carla", "Porto", 15000, 1000));
        contribuintes.add(new Desempregado("Maria Sá", "Afife", 230));

        //3. Programe uma listagem dos contribuintes do contentor.
        System.out.println("############CONTRIBUINTES############");
        listar(contribuintes);

        //4. Programe a eliminação do desempregado "Lito Vidal" do contentor. Para o efeito use o método remove(Object o) do contentor e, passando por parâmetro, uma nova instância equivalente à que se pretende eliminar.
        contribuintes.remove(new Desempregado("Lito Vidal", "Lisboa", 230.00f));

        //5. Programe uma nova listagem dos contribuintes do contentor e verifique que a eliminação do desempregado do contentor não foi efetuada.
        System.out.println("");
        System.out.println("############CONTRIBUINTES############");
        listar(contribuintes);

        //7. Invoque novamente a eliminação do desempregado e verifique que foi realizada.
        contribuintes.remove(0);
        System.out.println("");
        System.out.println("############CONTRIBUINTES############");
        listar(contribuintes);

        //8. Invoque o método equals verificando a equivalência de:
        //a) Duas instâncias com características iguais.
        System.out.println("");
        System.out.println(contribuintes.get(8).equals(contribuintes.get(8)));

        //b) Duas instâncias do mesmo tipo com características diferentes.
        System.out.println("");
        System.out.println(contribuintes.get(0).equals(contribuintes.get(2)));

        //c) Duas instâncias de tipos diferentes.
        System.out.println("");
        System.out.println(contribuintes.get(0).equals(contribuintes.get(1)));

        //9. Programe as seguintes listagens dos contribuintes armazenados no contentor:
        //a) Ordem alfabética inversa dos tipos de contribuintes.
        System.out.println("\n### Ordem Alfabética do Tipo de Contribuinte Inversa ###");
        Comparator<Impostos> alfabeticamente = new Comparator<Impostos>() {

            public int compare(Impostos contribuinte, Impostos outroContribuintes) {
                String cont1 = contribuinte.getClass().getName();
                String cont2 = outroContribuintes.getClass().getName();
                return cont1.compareTo(cont2);
            }
        };
        contribuintes.sort(Collections.reverseOrder(alfabeticamente));
        listar(contribuintes);

        //b) Ordem alfabética dos tipos de contribuintes e, em cada tipo de contribuinte, os contribuintes apresentados por ordem alfabética dos seus nomes.
        System.out.println("\n### Ordem por tipo de contribuinte e alfabéticamente: ###");
        Comparator<Impostos> alfabeticamente2 = new Comparator<Impostos>() {

            public int compare(Impostos c1, Impostos c2) {
                return ((c1.getClass().getName() + " " + c1.getNome()).compareTo(c2.getClass().getName() + " " + c2.getNome()));
            }
        };
        contribuintes.sort(alfabeticamente2);
        listar(contribuintes);
    }

    private static void listar(List<Impostos> contribuintes) {
        for (Impostos contribuinte : contribuintes) {
            if (contribuinte != null) {
                System.out.printf("%s, impostos = %.2f€, %s%n", contribuinte.getNome(), contribuinte.CalcularImpostos(), contribuinte.getClass());
            }
        }
    }
}
