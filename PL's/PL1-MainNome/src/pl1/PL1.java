package pl1;

import java.util.Scanner;

/**
 * @author Jordão
 */
public class PL1 {

    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Insira o seu nome: ");
        String nome = tec.nextLine();
        System.out.println("Bem-vindo " + nome + "!");
        System.out.print("Insira a sua idade: ");
        int idade = tec.nextInt();
        System.out.println("--------------------------------------------");

        Nome objeto = new Nome(nome, idade);
        System.out.println(objeto.toString());
        System.out.println("--------------------------------------------");
        String resposta = "";
        tec.nextLine();
        while (!(resposta.equalsIgnoreCase("nao"))) {
            System.out.print("Deseja mudar os dados (\"sim\" ou \"nao\")? ");
            resposta = tec.nextLine();
            System.out.println("--------------------------------------------");
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.print("Insira o novo nome: ");
                objeto.setNome(tec.nextLine());
                System.out.print("Insira a nova idade: ");
                objeto.setIdade(tec.nextInt());
                System.out.println("--------------------------------------------");
                System.out.println(objeto.toString());
                tec.nextLine();
            } else {
                if (resposta.equalsIgnoreCase("nao")) {
                    System.out.println("Até à próxima " + objeto.getNome() + "!");
                } else {
                    System.out.println("Resposta Inválida!");
                }
            }
            System.out.println("--------------------------------------------");
        }
    }
}
