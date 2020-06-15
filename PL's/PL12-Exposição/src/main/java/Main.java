import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jordão
 */
public class Main {

    public static void main(String[] args) {

        //5. Invoque as funcionalidades da classe Quadro da seguinte forma:
        //a) Crie diversas instâncias de Quadro.
        Quadro q1 = new Quadro();
        Quadro q2 = new Quadro("THE KING", "Gonçalo Jordão", 2018);
        Quadro q3 = new Quadro("Mona Lisa", "Leonardo Da Vinci", 1503);
        Quadro q4 = new Quadro("O Grito", "Edvard Munch", 1893);
        Quadro q5 = new Quadro("Guernica", "Pablo Picasso", 1937);
        Quadro q6 = new Quadro("Autoretrato", "Salvador Dali", 1920);
        Quadro q7 = new Quadro("Mercedes", "Patrícia Ferreira", 2019);
        Quadro q8 = new Quadro("TWD", "Jordão", 2019);
        Quadro q9 = new Quadro("Colinho", "Benfica", 2020);
        Quadro q10 = new Quadro("LAPR1", "O Desespero dos Alunos", 2019);
        Quadro q11 = new Quadro("Morcego", "Chinês", 2020);
        Quadro q12 = new Quadro("ISEP Fechou!", "COVID-19", 2020);
        Quadro q13 = new Quadro("Sem Campeonatos", "Sporting", 2021);
        Quadro q14 = new Quadro("Roubo", "Custóias", 1438);
        Quadro q15 = new Quadro("A peste negra", "Alguém", 1352);
        Quadro q16 = new Quadro("Super Dragões", "Macaco Líder", 1942);
        Quadro q17 = new Quadro("COVID-19", "Chinês", 1852);

        //b) Armazene essas instâncias num contentor do tipo ArrayList.
        ArrayList<Quadro> l1 = new ArrayList<>();
        l1.add(q1);
        l1.add(q2);
        l1.add(q3);
        l1.add(q4);
        l1.add(q5);
        l1.add(q6);
        l1.add(q7);
        l1.add(q8);
        l1.add(q9);
        l1.add(q10);
        l1.add(q11);
        l1.add(q12);
        l1.add(q13);
        l1.add(q14);
        l1.add(q15);
        l1.add(q16);
        l1.add(q17);

        //c) Visualize os objetos do contentor utilizando o método listar.
        listarQd(l1);

        //7. Invoque as funcionalidades da classe Exposição usando o seguinte procedimento:
        // a) Crie diversas instâncias de Exposição, usando as instâncias de Quadro criadas anteriormente. Algumas destas instâncias devem
        // ser partilhadas por todas as exposições criadas.
        Exposicao e1 = new Exposicao("ExpoNor", 1900, q17, q15, q14, q3);
        Exposicao e2 = new Exposicao("ExpoSul", 1990, q4, q16, q17, q14);
        Exposicao e3 = new Exposicao("ExpoOeste",/*31 de dezembro de */2020, q7, q8, q1, q2, q12, q17, q9, q10);
        Exposicao e4 = new Exposicao("ExpoEste", 2030, l1);

        //b) Armazene estas instâncias num contentor do tipo ArrayList.
        ArrayList<Exposicao> l2 = new ArrayList<>();
        l2.add(e1);
        l2.add(e2);
        l2.add(e3);
        l2.add(e4);

        //c) Visualize os objetos deste contentor reutilizando o método listar.
        listarEx(l2);

        //8. Modifique o conteúdo de uma das instâncias de Quadro partilhada por todas as exposições. Para confirmar estas modificações,
        // visualize novamente os objetos do contentor de exposições.
        q17.setAnoDeCriacao(0);
        q17.setDesignacao("PL12");
        q17.setNomeAutor(" Gonçalo Jordão ");
        listarEx(l2);

        //9. Programe uma listagem do contentor de exposições por ordem decrescente do ano da exposição.
        Collections.reverse(l2);
        listarEx(l2);

        //10. Invoque e verifique o resultado do método da classe Exposição para remover um quadro.
        e1.removeQuadro(q17);
        System.out.println();
        System.out.println(e1.toString());
        System.out.print("########################################################################################");
    }

    //4. Nesta classe, crie o método listar para apresentar, na consola, uma listagem dos objetos do contentor recebido por parâmetro. Considere um contentor do tipo List.
    public static void listarEx(List<Exposicao> lista) {
        for (Exposicao exp : lista) {
            System.out.println(exp);
            System.out.println();
        }
        System.out.println("########################################################################################");
    }

    public static void listarQd(List<Quadro> lista) {
        for (Quadro exp : lista) {
            System.out.println(exp);
            System.out.println();
        }
        System.out.println("########################################################################################");
    }
}
