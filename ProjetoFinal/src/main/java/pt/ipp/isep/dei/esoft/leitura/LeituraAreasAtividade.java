package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoAreasAtividade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Leitura de Areas de Atividade através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraAreasAtividade {

    private Plataforma m_oPlataforma;
    private RegistoAreasAtividade rat;
    private AreaAtividade m_oAreaAtividade;

    /**
     * Instancia uma nova Leitura de Areas de Atividade.
     */
    public LeituraAreasAtividade() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rat = this.m_oPlataforma.getRegistoAreaAtividade();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosAreaAtividade = new File("Ficheiros\\AreasAtividade.txt");
            Scanner sc = new Scanner(dadosAreaAtividade);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados_Da_AreaAtividade = linha.split(";");
                String strCodigo = dados_Da_AreaAtividade[0].trim();
                String strDescricaoBreve = dados_Da_AreaAtividade[1].trim();
                String strDescricaoDetalhada = dados_Da_AreaAtividade[2].trim();
                this.m_oAreaAtividade = this.rat.novaAreaAtividade(strCodigo, strDescricaoBreve, strDescricaoDetalhada);
                if (this.rat.validaAreaAtividade(this.m_oAreaAtividade)) {
                    this.rat.registaAreaAtividade(this.m_oAreaAtividade);
                } else {
                    this.m_oAreaAtividade = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Areas de Atividade não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Areas de Atividade!");
        }
    }
}
