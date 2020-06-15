package my.company.tp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Jordão
 */
public class Olxyz {

    public static void main(String[] args) {

        System.out.printf("%n#######            Plataforma Olxyz            #######%n%n");

        //b) Implemente o código Java para responder às seguintes funcionalidades:
        //1. Criar a classe (principal) Olxyz com um contentor do tipo array capaz de conter 5 Anunciantes;
        Anunciante[] anunciantes = new Anunciante[10];

        //2. Adicionar um Anunciante (a1) que pretende vender 1 telemovel e alugar 1 apartamento + 1 carro;
        Endereco e1 = new Endereco("Avenida Primeiro de Maio", "4460-069", "Matosinhos");
        Telemovel t1 = new Telemovel("Iphone 11 pro", 1500);
        Apartamento ap1 = new Apartamento(e1, 320, 1000);
        Automovel c1 = new Automovel("Mercedes-Benz", "Classe S Cabriolet", 120000, 50000);
        Anunciante a1 = new Anunciante("Gonçalo Jordão", e1, new ArrayList<>(Collections.singletonList(t1)), new ArrayList<>(Arrays.asList(ap1, c1)));
        anunciantes[0] = a1;

        //3. Adicionar um Anunciante (a2) que pretende vender 1 carro + 1 telemóvel e alugar 1 apartamento;
        Endereco e2 = new Endereco("Rua Almeida Garrett", "5800-122", "Ovar");
        Automovel c2 = new Automovel("Ferrari", "GT", 320000, 160000);
        Telemovel t2 = new Telemovel("Huawei 30 pro", 780);
        Apartamento ap2 = new Apartamento(e2, 120, 500);
        Anunciante a2 = new Anunciante("António Barbosa", e2, new ArrayList<>(Arrays.asList(c2, t2)), new ArrayList<>(Collections.singletonList(ap2)));
        anunciantes[1] = a2;

        //4. Adicionar um Anunciante (a3) que pretende alugar 2 apartamentos;
        Endereco e3 = new Endereco("Rua do Senhor", "4460-420", "Matosinhos");
        Endereco e4 = new Endereco("Rua Dr António Bernardino de Almeida", "4200-072", "Porto");
        Apartamento ap3 = new Apartamento(e3, 500, 220000);
        Apartamento ap4 = new Apartamento(e4, 1000, 100000);
        Anunciante a3 = new Anunciante("Francisco Rebelo", e3, new ArrayList<>(Collections.emptyList()), new ArrayList<>(Arrays.asList(ap3, ap4)));
        anunciantes[2] = a3;

        //5. Visualizar a quantidade de artigos disponíveis para aluguer na plataforma Olxyz;
        System.out.println("## Artigos disponíveis para aluguer na Plataforma Olxyz ##");
        System.out.println("Quantidade: " + numeroArtigosDisponiveisAAlugar(anunciantes));

        //6. Visualizar, para cada Anunciante que publicita vendas, o respetivo nome, endereço e o somatório das suas possíveis vendas;
        System.out.printf("%n## Possíveis Vendas por Anunciante ##%n");
        listarAnunciantesQueVendem(anunciantes);

        //7. Visualizar, para cada Anunciante, o seu alugável (se existir) que pode gerar maior lucro à Olxyz (quem, o quê e quanto).
        System.out.printf("%n## Alugável mais Caro do Anunciante ##%n");
        listarAlugavelMaisCaro(anunciantes);

        System.out.printf("%n#######             Volte Sempre!!             #######%n");
    }

    public static int numeroArtigosDisponiveisAAlugar(Anunciante[] anunciantes) {
        int numeroDeArtigos = 0;
        for (int i = 0; i < anunciantes.length && anunciantes[i] != null; i++) {
            numeroDeArtigos += anunciantes[i].getNumeroDeArtigosAAlugar();
        }
        return numeroDeArtigos;
    }

    public static void listarAnunciantesQueVendem(Anunciante[] anunciantes) {
        for (int i = 0; i < anunciantes.length && anunciantes[i] != null; i++) {
            if (anunciantes[i].getNumeroDeArtigosAVender() != 0) {
                System.out.printf("%s, que pode faturar %.2f€ com as vendas.\n", anunciantes[i].toString(), anunciantes[i].getTotalPossivelVendas());
            }
        }
    }

    public static void listarAlugavelMaisCaro(Anunciante[] anunciantes) {
        for (int i = 0; i < anunciantes.length && anunciantes[i] != null; i++) {
            if (anunciantes[i].getNumeroDeArtigosAAlugar() != 0) {
                System.out.printf("%s, cujo alugável mais caro: %s, onde a Plataforma Olxyz pode lucrar %.2f€.\n", anunciantes[i].toString(), anunciantes[i].getAlugavelMaisCaro(), (anunciantes[i].getAlugavelMaisCaro().getValorAluguer() - (anunciantes[i].getAlugavelMaisCaro().getValorAluguer() / (1 + Alugavel.taxaDeAluguer))));
            }
        }
    }
}
