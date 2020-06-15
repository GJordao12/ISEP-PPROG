import java.util.Comparator;

/**
 * @author Jordão
 */
public class ComparatorVencimentos implements Comparator<Trabalhador> {

    @Override
    public int compare(Trabalhador t1, Trabalhador t2) {
        if (t1.calcularVencimento() > t2.calcularVencimento()) {
            return 1;
        } else if (t1.calcularVencimento() < t2.calcularVencimento()) {
            return -1;
        }
        return 0;
    }
}
