package isep.mavenproject1;

/**
 *
 * @author Gonçalo Jordão & António Barbosa
 */
public class MainCredito {

    public static void main(String[] args) {

        //a) Criação do seguinte conjunto de instâncias: 
        CreditoEducacao e1 = new CreditoEducacao("Gonçalo Jordão", "Pescador", 18000, 60, 24);
        CreditoEducacao e2 = new CreditoEducacao();
        CreditoHabitacao h1 = new CreditoHabitacao("Maria", "Contabilista", 120000, 240, 1);
        CreditoHabitacao h2 = new CreditoHabitacao();
        CreditoAutomovel a1 = new CreditoAutomovel("António Barbosa", "Construtor", 15000, 50);
        CreditoAutomovel a2 = new CreditoAutomovel();

        //b) Criação de um contentor do tipo array e armazenamento no mesmo das instâncias criadas; 
        Credito[] Clientes = new Credito[10];
        Clientes[0] = e1;
        Clientes[1] = e2;
        Clientes[2] = h1;
        Clientes[3] = h2;
        Clientes[4] = a1;
        Clientes[5] = a2;

        //c) Criação de listagens separadas, sobre o contentor, para: 
        //▪ obter o nome do cliente e o valor que a instituição bancária irá receber até ao final de cada contrato de crédito ao consumo realizado
        System.out.println();
        System.out.println("######VALOR DO CRÉDITO A RECEBER######");
        for (int i = 0; i < Clientes.length && Clientes[i] != null; i++) {
            System.out.printf("NOME: %s%nVALOR A PAGAR DO CRÉDITO: %.2f€%n", Clientes[i].getNome(), Clientes[i].calcularMontanteAReceberPorCadaCredito());
        }
        System.out.println("######################################");

        //▪ obter o nome do cliente e o valor dos juros (para além do montante do empréstimo) que o cliente terá de pagar até ao final de cada contrato de crédito bancário realizado; 
        System.out.println();
        System.out.println("######VALORES DOS JUROS A RECEBER######");
        for (int i = 0; i < Clientes.length && Clientes[i] != null; i++) {
            System.out.printf("NOME: %s%nVALOR A PAGAR DE JUROS: %.2f€%n", Clientes[i].getNome(), Clientes[i].calcularMontanteTotalJuros());
        }
        System.out.println("#######################################");

        //d) Apresentação das quantidades de instâncias de créditos à habitação e de créditos ao consumo criadas (em separado), sem percorrer o contentor; 
        System.out.println();
        System.out.println("########CRÉDITOS########");
        System.out.printf("CRÉDITOS À HABITAÇÃO: %d%nCRÉDITOS AO CONSUMO: %d%n", CreditoHabitacao.getTotalCreditoHabitacao(), CreditoEducacao.getTotalCreditosEducacao() + CreditoAutomovel.getTotalCreditoAutomovel());
        System.out.println("########################");

        //e)Cálculo e apresentação do valor total e dos respetivos juros que a instituição bancária irá receber por todos os créditos bancários realizados, percorrendo apenas uma vez o contentor.
        System.out.println();
        System.out.println("#########VALOR TOTAL A RECEBER POR TODOS OS CRÉDITOS#########");
        float montanteTotalAReceber = 0, totalJurosAReceber = 0;
        for (int i = 0; i < Clientes.length && Clientes[i] != null; i++) {
            montanteTotalAReceber = Clientes[i].calcularMontanteAReceberPorCadaCredito() + montanteTotalAReceber;
            totalJurosAReceber = Clientes[i].calcularMontanteTotalJuros() + totalJurosAReceber;
        }
        System.out.printf("TOTAL A RECEBER POR TODOS OS CRÉDITOS BANCÁRIOS: %.2f€%nTOTAL A RECEBER DE TODOS OS JUROS: %.2f€%n", montanteTotalAReceber, totalJurosAReceber);
        System.out.println("#############################################################");
    }
}
