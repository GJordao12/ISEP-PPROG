package maintempo;

/**
 * @author Jordão
 */
public class MainTempo {

    public static void main(String[] args) {

        Tempo t1 = new Tempo(5, 30, 12);
        System.out.println(t1.toAnoHorasMinutosSegundos());

        System.out.println("-----------------------------------------------------------------------");

        System.out.println(t1.aumentarSegundo());

        System.out.println("-----------------------------------------------------------------------");

        Tempo t2 = new Tempo(18, 15, 20);
        System.out.println(t2.toAnoHorasMinutosSegundos());

        System.out.println("-----------------------------------------------------------------------");

        if (t1.isMaior(t2)) {
            System.out.println("O tempo " + t1.toAnoHorasMinutosSegundos() + " é maior que o tempo " + t2.toAnoHorasMinutosSegundos() + ".");
        } else {
            System.out.println("O tempo " + t1.toAnoHorasMinutosSegundos() + " é menor que o tempo " + t2.toAnoHorasMinutosSegundos() + ".");
        }

        System.out.println("-----------------------------------------------------------------------");

        if (t1.isMaior(23, 7, 4)) {
            System.out.println("O tempo " + t1.toAnoHorasMinutosSegundos() + " é maior.");
        } else {
            System.out.println("O tempo " + t1.toAnoHorasMinutosSegundos() + " é menor.");
        }

        System.out.println("-----------------------------------------------------------------------");

        System.out.println(t1.calcularDiferenca(t2));

        System.out.println("-----------------------------------------------------------------------");
    }
}
