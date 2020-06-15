
import java.util.ArrayList;
import java.util.List;

public class MainEmpregado {

    public static void main(String[] args) {

        //a) Crie e visualize uma instância de Data para representar a data atual;
        Data data = new Data(Data.dataAtual());
        System.out.println("########## Data Atual ##########");
        System.out.println(data);
        System.out.println("################################");

        //b) Crie e visualize duas instâncias de Tempo;
        Tempo tempoEntrada = new Tempo(8, 30, 0);
        Tempo tempoSaida = new Tempo(17, 15, 0);

        System.out.println();
        System.out.println("###### Tempos ######");
        System.out.printf("Tempo 1: %s%nTempo 2: %s%n", tempoEntrada, tempoSaida);
        System.out.println("####################");

        //c) Crie duas instâncias de Empregado usando para o efeito as instâncias de Data e de Tempo criadas anteriormente;
        Empregado e1 = new Empregado("Gonçalo", "Jordão", data, tempoEntrada, tempoSaida);
        Empregado e2 = new Empregado("Patrícia", "Ferreira", data, tempoEntrada, tempoSaida);

        //d) Verifique se os atributos do tipo Data dos empregados criados possuem referências partilhadas;
        e1.setDataContrato(new Data(2020, 03, 28));
        System.out.println();
        System.out.printf("### Teste às referências de Data ###%n" + "%s%n" + "%s%n", e1.getDataContrato(), e2.getDataContrato());
        System.out.println("####################################");

        //e) Verifique se os atributos do tipo Tempo dos empregados criados possuem referências partilhadas;
        e1.setHoraEntrada(new Tempo(10));
        e2.setHoraSaida(new Tempo(17));
        System.out.println();
        System.out.printf("### Teste às referências de Tempo ###%n" + "%s - %s%n" + "%s - %s%n", e1.getHoraEntrada(), e1.getHoraSaida(), e2.getHoraEntrada(), e2.getHoraSaida());
        System.out.println("#####################################");

        //f) Altere o conteúdo do objeto Data e o conteúdo dos objetos Tempo inicialmente criados;
        data.setData(2020, 01, 01);
        tempoEntrada.setHoras(11);
        tempoSaida.setHoras(20);

        //g) Visualize as instâncias de Data e de Tempo, bem como as instâncias de Empregado criadas;
        System.out.println();
        System.out.printf("################################ Teste geral ###############################%n" + "Data: %s%n" + "Hora de Entrada: %s%n" + "Hora de Saída: %s%n" + "Empregados: %n" + "- %s%n" + "- %s%n", data, tempoEntrada, tempoSaida, e1, e2);
        System.out.println("############################################################################");

        //h) Altere a data de contrato e as horas de entrada e de saída do segundo empregado;
        e2.setDataContrato(new Data(2020, 07, 04));
        e2.setHoraEntrada(new Tempo(12));
        e2.setHoraSaida(new Tempo(22));

        //i) Armazene as instâncias de Empregado criadas num contentor de objetos do tipo ArrayList;
        List<Empregado> lista = new ArrayList<Empregado>();
        lista.add(e1);
        lista.add(e2);

        //j) Liste todos os empregados & k) Liste o nome, o número de horas de trabalho por semana e a antiguidade de cada um dos empregados.
        System.out.println();
        System.out.println("################################ Empregados ################################");
        listar(lista);
        System.out.println("############################################################################");
    }

    private static void listar(List<Empregado> lista) {
        for (Empregado pessoa : lista) {
            System.out.println(pessoa.toString());
        }
    }
}
