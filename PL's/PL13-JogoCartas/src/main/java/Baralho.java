import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Representa um baralho de cartas.
 *
 * @author ISEP-DEI-PPROG
 */
public class Baralho {

    /**
     * Tipo de baralho por omissão.
     */
    private static final Tipo BARALHO_POR_OMISSAO = Tipo.BAR_40;
    /**
     * O baralho de cartas.
     */
    private List<Carta> baralho;

    ;

    /**
     * Constrói uma instância de {@code Baralho} recebendo o tipo de baralho.
     *
     * @param tipoDeBaralho o tipo de baralho.
     */
    public Baralho(Tipo tipoDeBaralho) {
        baralho = criarBaralho(tipoDeBaralho);
    }

    /**
     * Constrói uma instância de {@code Baralho} com o baralho por omissão.
     */
    public Baralho() {
        baralho = criarBaralho(BARALHO_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de {@code Baralho} com as mesmas caraterísticas
     * do baralho recebido por parâmetro.
     *
     * @param outroBaralho o baralho com as características a copiar.
     */
    public Baralho(Baralho outroBaralho) {
        baralho = new ArrayList<Carta>(outroBaralho.baralho.size());
        for (Carta c : outroBaralho.baralho) {
            baralho.add(new Carta(c));
        }
    }

    /**
     * Devolve a descrição textual do baralho (uma carta por linha).
     *
     * @return caraterísticas das cartas do baralho.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Carta c : baralho) {
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Permuta as cartas do baralho de um modo aleatório.
     */
    public void baralhar() {
        Collections.shuffle(baralho);
    }

    /**
     * Parte ao meio o baralho de cartas.
     */
    public void partir() {

        // Reserva a primeira metade das cartas do baralho
        List<Carta> mbar = new ArrayList<Carta>(baralho.subList(0, baralho.size() / 2));

        // Remove a primeira metade das cartas do baralho
        baralho.removeAll(mbar);

        // Coloca no final a primeira metade das cartas do baralho
        baralho.addAll(mbar);
    }

    /**
     * Remove e devolve as primeiras n cartas do baralho.
     *
     * @param n o número de cartas a remover e devolver.
     * @return {@code List} com as primeiras n cartas do baralho.
     */
    public List<Carta> primeirasCartas(int n) {

        // Reserva as primeiras n cartas do baralho
        List<Carta> mbar = new ArrayList<Carta>(
                baralho.subList(0, (Math.min(n, baralho.size()))));

        // Remove as primeiras n cartas do baralho
        baralho.removeAll(mbar);

        return mbar;
    }

    /**
     * Remove e devolve as últimas n cartas do baralho.
     *
     * @param n o número de cartas a remover e devolver.
     * @return {@code List} com as últimas n cartas do baralho.
     */
    public List<Carta> ultimasCartas(int n) {
        // Reserva as últimas n cartas do baralho
        List<Carta> mbar = new ArrayList<Carta>(
                baralho.subList((n > baralho.size() ? 0 : baralho.size() - n),
                        baralho.size()));

        // Remove as últimas n cartas do baralho
        baralho.removeAll(mbar);

        return mbar;
    }

    /**
     * Devolve um baralho do tipo recebido por parâmetro.
     *
     * @param tipoDeBaralho o tipo de baralho.
     */
    private List<Carta> criarBaralho(Tipo tipoDeBaralho) {
        List<Carta> baralho = (tipoDeBaralho == Tipo.BAR_40 ? new ArrayList<Carta>(40)
                : new ArrayList<Carta>(52));
        for (Carta.Naipe n : Carta.Naipe.values()) {
            for (Carta.Tipo t : Carta.Tipo.values()) {
                if (tipoDeBaralho == Tipo.BAR_40
                        && t.compareTo(Carta.Tipo.Sena) > 0
                        && t.compareTo(Carta.Tipo.Dama) < 0) {
                    continue;
                }
                baralho.add(new Carta(t, n));
            }
        }
        return baralho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Baralho)) return false;
        Baralho baralho1 = (Baralho) o;
        return Objects.equals(baralho, baralho1.baralho);
    }

    /**
     * Tipos de baralho.
     */
    public static enum Tipo {
        /**
         * Baralho com 40 cartas.
         */
        BAR_40,
        /**
         * Baralho com 52 cartas.
         */
        BAR_52
    }
}

