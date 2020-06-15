package pt.ipp.isep.dei;

import java.util.Scanner;

/**
 * @author Jordão
 */
public class Util {

    static Scanner tec = new Scanner(System.in);
    private static String data;
    private static boolean VF = false;

    public static Data lerData() {

        Data dataAniversario = new Data();

        do {
            try {
                System.out.print("Data de Aniversário (ano/mês/dia): ");
                data = tec.nextLine();
                String[] ano_mes_dia = (data.split("/"));
                if (ano_mes_dia.length != 3) {
                    throw new NumberFormatException();
                }
                dataAniversario.setData(Integer.parseInt(ano_mes_dia[0]), Integer.parseInt(ano_mes_dia[1]), Integer.parseInt(ano_mes_dia[2]));
                VF = true;
            } catch (NumberFormatException fie) {
                System.out.println("Formato Inválido!!");
            } catch (MesInvalidoException mie) {
                System.out.println(mie.getMessage());
            } catch (DiaInvalidoException die) {
                System.out.println(die.getMessage());
            }
        } while (!VF);
        return dataAniversario;
    }
}

