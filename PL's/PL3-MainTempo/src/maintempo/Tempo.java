package maintempo;

/**
 * @author Jordão
 */
public class Tempo {

    /**
     * A hora do tempo por omissao
     */
    private static final int HORAS_POR_OMISSAO = 0;
    /**
     * Os minutos do tempo por omissao
     */
    private static final int MINUTOS_POR_OMISSAO = 0;
    /**
     * Os segundos do tempo por omissao
     */
    private static final int SEGUNDOS_POR_OMISSAO = 0;
    /**
     * A hora do tempo
     */
    private int horas;
    /**
     * Os minutos do tempo
     */
    private int minutos;
    /**
     * Os segundos do tempo
     */
    private int segundos;

    /**
     * Constrói uma instância do Tempo recebendo o ano, o mês e o dia.
     *
     * @param horas    o ano da data
     * @param minutos  o mês da data
     * @param segundos o dia da data
     */
    public Tempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    /**
     * Constrói uma instância de Tempo com o tempo por omissão.
     */
    public Tempo() {
        horas = HORAS_POR_OMISSAO;
        minutos = MINUTOS_POR_OMISSAO;
        segundos = SEGUNDOS_POR_OMISSAO;
    }

    /**
     * Devolve as Horas da Data.
     *
     * @return Horas do Tempo
     */
    public int getHoras() {
        return horas;
    }

    /**
     * Devolve os Minutos da Data.
     *
     * @return Minutos do Tempo
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Devolve as Segundos da Data.
     *
     * @return Segundos do Tempo
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Devolve o Tempo no formato:%02d:%02d:%02d.
     *
     * @return caracteristicas do Tempo
     */
    public String toAnoHorasMinutosSegundos() {
        if (horas < 12) {
            return String.format("%02d:%02d:%02d AM", horas, minutos, segundos);
        } else {
            if (horas == 12) {
                return String.format("%02d:%02d:%02d PM", horas, minutos, segundos);
            } else {
                return String.format("%02d:%02d:%02d PM", horas - 12, minutos, segundos);
            }
        }
    }

    /**
     * Devolve o Tempo no formato:%02d:%02d:%02d com 1 segundo aumentado.
     *
     * @return caracteristicas do Tempo com 1 segundo aumentado
     */
    public String aumentarSegundo() {
        if (segundos < 59) {
            return String.format("%02d:%02d:%02d", horas, minutos, segundos + 1);
        } else {
            if (minutos < 59) {
                return String.format("%02d:%02d:00", horas, minutos + 1);
            } else {
                if (horas < 24) {
                    return String.format("%02d:00:00", horas + 1);
                } else {
                    return String.format("01:00:00");
                }
            }
        }
    }

    /**
     * Devolve true se o Tempo for maior do que o Tempo recebida por parâmetro.
     * Se o Tempo for menor ou igual ao Tempo recebido por parâmetro, devolve
     * false.
     *
     * @param outroTempo o outro Tempo com a qual se compara o Tempo
     * @return true se o Tempo for maior do que o Tempo recebido por parâmetro,
     * caso contrário devolve false
     */
    public boolean isMaior(Tempo outroTempo) {

        int TotalSegundos = ContarSegundos();
        int TotalSegundos1 = outroTempo.ContarSegundos();

        return TotalSegundos > TotalSegundos1;
    }

    /**
     * Devolve true se o Tempo for maior do que o Tempo recebida por parâmetro
     * com horas, minutos e segundos.
     *
     * @param horas    as horas do tempo com a qual se compara o tempo para
     *                 calcular qual o tempo maior
     * @param minutos  os minutos do tempo com a qual se compara o tempo para
     *                 calcular calcular qual o tempo maior
     * @param segundos os segundos do tempo com a qual se compara o tempo para
     *                 calcular qual o tempo maior
     * @return true se o Tempo for maior do que o Tempo recebido por parâmetro,
     * caso contrário devolve false
     */
    public boolean isMaior(int horas, int minutos, int segundos) {

        int TotalSegundos = ContarSegundos();
        Tempo outroTempo = new Tempo(horas, minutos, segundos);
        int TotalSegundos1 = outroTempo.ContarSegundos();

        return TotalSegundos > TotalSegundos1;
    }

    /**
     * Devolve a quantidade de Segundos
     *
     * @return quantidade de Segundos do Tempo
     */
    public int ContarSegundos() {

        int TotalSegundos = ((horas * 3600) + (minutos * 60) + segundos);
        return TotalSegundos;
    }

    /**
     * Devolve a diferença em número de segundos ou Tempo entre o Tempo e o
     * Tempo recebida por parâmetro.
     *
     * @param outroTempo a outro Tempo com a qual se compara o Tempo para
     *                   calcular a diferença do número de Segunodos e Tempo
     * @return diferença em Segundos e Tempo entre o Tempo e o Tempo recebido
     * por parâmetro
     */
    public String calcularDiferenca(Tempo outroTempo) {
        int totalSegundos = ContarSegundos();
        int totalSegundos1 = outroTempo.ContarSegundos();
        int diferenca = (Math.abs(totalSegundos - totalSegundos1));
        int diferencaHoras = diferenca / 3600;
        if (diferencaHoras < 0) {
            diferencaHoras = 0;
        }
        int diferecaMinutos = (diferenca - (diferencaHoras * 3600)) / 60;
        if (diferecaMinutos < 0) {
            diferecaMinutos = 0;
        }
        int diferencaSegundos = (diferenca - ((diferencaHoras * 3600) + (diferecaMinutos * 60)));
        String a = "A diferença entre os dois tempos é de " + diferenca + " segundos, ou seja, ";
        String b = String.format("%02d:%02d:%02d", diferencaHoras, diferecaMinutos, diferencaSegundos);

        return a + b;
    }
}
