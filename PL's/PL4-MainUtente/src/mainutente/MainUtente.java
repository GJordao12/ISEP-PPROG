package mainutente;

/**
 * @author Jordão
 */
public class MainUtente {

    public static void main(String[] args) {

        AtributosUtente utente1 = new AtributosUtente("Jordão", "masculino", 18, 63, 1.81);
        AtributosUtente utente2 = new AtributosUtente("Mesquita", "masculino", 18, 77, 1.75);
        AtributosUtente utente3 = new AtributosUtente("Catarina", "feminino", 18, 52, 1.63);
        AtributosUtente utente4 = new AtributosUtente("Vânia", "feminino", 19, 60, 1.57);
        AtributosUtente utente5 = new AtributosUtente("António", "masculino", 18, 87, 1.85);
        AtributosUtente utente6 = new AtributosUtente("Patrícia", "feminino", 18, 58, 1.69);
        AtributosUtente utente7 = new AtributosUtente("Afonso", "masculino", 13, 44.8, 1.64);
        AtributosUtente utente8 = new AtributosUtente();

        AtributosUtente[] Utentes = new AtributosUtente[10];
        Utentes[0] = utente1;
        Utentes[1] = utente2;
        Utentes[2] = utente3;
        Utentes[3] = utente4;
        Utentes[4] = utente5;
        Utentes[5] = utente6;
        Utentes[6] = utente7;
        Utentes[7] = utente8;

        for (int i = 0; i < Utentes.length && Utentes[i] != null; i++) {
            System.out.println(Utentes[i]);
        }

        System.out.println("----------------------------------------------------------------------------");

        for (int i = 0; i < Utentes.length && Utentes[i] != null; i++) {
            System.out.println("O Utente " + Utentes[i].getNome() + " é " + Utentes[i].calcularGrauDeObesidade() + ".");
        }

        System.out.println("----------------------------------------------------------------------------");

        utente4.setIdade(23);
        utente5.setIdade(31);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        if (utente4.isMaisNovo(utente5) < 0) {
            System.out.println("O Utente " + utente4.getNome() + " é mais novo que o Utente " + utente5.getNome() + ".");
        } else {
            if (utente4.isMaisNovo(utente5) > 0) {
                System.out.println("O Utente " + utente4.getNome() + " é mais velho que o Utente " + utente5.getNome() + ".");
            } else {
                System.out.println("O Utente " + utente4.getNome() + " tem a mesma idade que o Utente " + utente5.getNome() + ".");
            }
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}
