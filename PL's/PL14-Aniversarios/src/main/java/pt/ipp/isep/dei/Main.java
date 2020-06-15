package pt.ipp.isep.dei;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Jordão
 */
public class Main {

    static Scanner tec = new Scanner(System.in);
    private static String nome;
    private static String ficheiro;
    private static Data data;
    private static boolean VF = false;

    public static void main(String[] args) throws FileNotFoundException {

        do {
            try {
                System.out.print("Nome do Ficheiro: ");
                ficheiro = tec.nextLine();
                PrintWriter out = new PrintWriter(new File(ficheiro));
                VF = true;
            } catch (FileNotFoundException fne) {
                System.out.println("Impossível criar Ficheiro!!");
                System.out.println(ficheiro + " (Acesso Negado)");
            }
        } while (!VF);

        PrintWriter out = new PrintWriter(new File(ficheiro));

        do {
            System.out.printf("%nNome (\"ENTER para terminar\"): ");
            nome = tec.nextLine();
            if (!nome.trim().isEmpty()) {
                data = Util.lerData();
                out.printf("%s; %s%n", nome.trim(), data.toString());
            }
        } while (!nome.trim().isEmpty());

        out.close();
        System.out.printf("%nAplicação terminada.%n");
    }
}
