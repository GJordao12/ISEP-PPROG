package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoAreasAtividade;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoCategorias;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoCompetenciasTecnicas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Leitura de Categorias através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraCategorias {

    private Plataforma m_oPlataforma;
    private RegistoCategorias m_oRegistoCategoria;
    private RegistoAreasAtividade rat;
    private RegistoCompetenciasTecnicas rct;
    private AreaAtividade m_oAreaAtividade;
    private Categoria m_oCategoria;
    private CompetenciaTecnica m_oCompetenciaTecnica;
    private GrauProficiencia gp;
    private CaraterCT cCt;

    /**
     * Instancia uma nova Leitura de Categorias.
     */
    public LeituraCategorias() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.m_oRegistoCategoria = this.m_oPlataforma.getRegistoCategorias();
        this.rat = this.m_oPlataforma.getRegistoAreaAtividade();
        this.rct = this.m_oPlataforma.getRegistoCT();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosCategorias = new File("Ficheiros\\Categorias.txt");
            Scanner sc = new Scanner(dadosCategorias);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String strCodigoAT = dados[0].trim();
                String strDescricao = dados[1].trim();
                this.m_oAreaAtividade = this.rat.getAreaAtividadeByCod(strCodigoAT);
                this.m_oCategoria = this.m_oRegistoCategoria.novaCategoria(strDescricao, this.m_oAreaAtividade);
                if (this.m_oRegistoCategoria.validaCategoria(this.m_oCategoria)) {
                    for (int i = 2; i < dados.length; i++) {
                        String strCTCod = dados[i].trim();
                        i++;
                        int srtGPValor = Integer.parseInt(dados[i].trim());
                        i++;
                        boolean GPObg = dados[i].trim().equals("true");
                        this.m_oCompetenciaTecnica = this.rct.getCompetenciaTecnicaById(strCTCod);
                        this.gp = this.m_oCompetenciaTecnica.getGrauProficienciaByValor(srtGPValor);
                        this.cCt = this.m_oCategoria.novoCaracterCT(this.m_oCompetenciaTecnica, this.gp, GPObg);
                        this.m_oCategoria.registaCaracterCT(this.cCt);
                    }
                    this.m_oRegistoCategoria.registaCategoria(this.m_oCategoria);
                } else {
                    this.m_oCategoria = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Categorias não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Categorias!");
        }
    }
}
