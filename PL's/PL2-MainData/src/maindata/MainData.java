package maindata;

/**
 * @author Jordão
 */
public class MainData {

    public static void main(String[] args) {

        Data data1 = new Data(2020, 2, 19);
        System.out.println(data1.toString());

        System.out.println("-------------------------------------------------------");

        Data data2 = new Data(1974, 4, 25);
        System.out.println(data2.toAnoMesDiaString());

        System.out.println("-------------------------------------------------------");

        if (data1.isMaior(data2)) {
            System.out.println("A data " + data1.toAnoMesDiaString() + " é mais recente que a data " + data2.toAnoMesDiaString() + ".");
        }

        System.out.println("-------------------------------------------------------");

        System.out.println("A diferença entre as duas datas é de " + data1.calcularDiferenca(data2) + " dias.");

        System.out.println("-------------------------------------------------------");

        System.out.println("Faltam " + data1.calcularDiferenca(2020, 12, 25) + " para o Natal!");

        System.out.println("-------------------------------------------------------");

        System.out.println("O dia " + data2.toAnoMesDiaString() + " foi numa " + data2.determinarDiaDaSemana() + ".");

        System.out.println("-------------------------------------------------------");

        if (Data.isAnoBissexto(data2.getAno())) {
            System.out.println("O ano " + data2.getAno() + " é bissexto!");
        } else {
            System.out.println("O ano " + data2.getAno() + " não é bissexto!");
        }

        System.out.println("-------------------------------------------------------");

        if (Data.isAnoBissexto(1974)) {
            System.out.println("O ano 1974 é bissexto!");
        } else {
            System.out.println("O ano 1974 não é bissexto!");
        }

        System.out.println("-------------------------------------------------------");
    }
}
