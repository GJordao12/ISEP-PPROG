package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Seriacao1;
import pt.ipp.isep.dei.esoft.pot.model.Seriacao2;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoTiposRegimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Leitura de Regimentos através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraRegimentos {

    private Plataforma m_oPlataforma;
    private RegistoTiposRegimento rreg;

    /**
     * Instantcia uma nova Leitura de Regimentos.
     */
    public LeituraRegimentos() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rreg = this.m_oPlataforma.getRegistoTiposRegimento();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosCategorias = new File("Ficheiros\\Regimentos.txt");
            Scanner sc = new Scanner(dadosCategorias);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                Seriacao1 ser1 = new Seriacao1(dados[0].trim(), dados[1].trim());
                this.rreg.registaTipoRegimento(ser1);
                Seriacao2 ser2 = new Seriacao2(dados[2].trim(), dados[3].trim());
                this.rreg.registaTipoRegimento(ser2);
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Regimentos não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Regimentos!");
        }
    }
}
