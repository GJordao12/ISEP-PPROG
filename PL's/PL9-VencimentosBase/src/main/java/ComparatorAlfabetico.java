import java.util.Comparator;

/**
 * @author Jordão
 */
public class ComparatorAlfabetico implements Comparator<Trabalhador> {

    @Override
    public int compare(Trabalhador t1, Trabalhador t2) {
        return t1.getNome().compareTo(t2.getNome());
    }
}