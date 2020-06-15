package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.lista.ListaTarefas;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoAnuncios;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoOrganizacoes;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoTiposRegimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Leitura de Anúncios através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraAnuncios {

    private Plataforma m_oPlataforma;
    private RegistoTiposRegimento rreg;
    private RegistoAnuncios regA;
    private Tarefa tarefa;
    private ListaTarefas lTarefas;
    private Colaborador c;
    private Anuncio m_oAnuncio;
    private Regimento regT;

    /**
     * Instancia uma nova Leitura de Anúncios.
     */
    public LeituraAnuncios() {

        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rreg = this.m_oPlataforma.getRegistoTiposRegimento();
        this.regA = this.m_oPlataforma.getRegistoAnuncios();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosOrganizacao = new File("Ficheiros\\Anuncios.txt");
            Scanner sc = new Scanner(dadosOrganizacao);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String refTar = dados[0].trim();
                String anunid = dados[1].trim();
                Date dtIniP = new SimpleDateFormat("dd-MM-yyyy").parse(dados[2].trim());
                Date dtFimP = new SimpleDateFormat("dd-MM-yyyy").parse(dados[3].trim());
                Date dtIniC = new SimpleDateFormat("dd-MM-yyyy").parse(dados[4].trim());
                Date dtFimC = new SimpleDateFormat("dd-MM-yyyy").parse(dados[5].trim());
                Date dtIniS = new SimpleDateFormat("dd-MM-yyyy").parse(dados[6].trim());
                Date dtFimS = new SimpleDateFormat("dd-MM-yyyy").parse(dados[7].trim());
                String descTR = dados[8].trim();
                String email = dados[9].trim();
                RegistoOrganizacoes rorg = this.m_oPlataforma.getRegistoOrganizacoes();
                Organizacao org = rorg.getOrganizacaoByEmailUtilizador(email);
                this.c = org.getColaboradorByEmailUtilizador(email);
                this.lTarefas = org.getListaTarefas();
                this.tarefa = this.lTarefas.getTarefasParaPublicarByRef(refTar, this.c);
                this.regT = this.rreg.getTipoRegimentoByDesc(descTR);
                this.m_oAnuncio = this.regA.novoAnuncio(this.c, this.tarefa, dtIniP, dtFimP, dtIniC, dtFimC, dtIniS, dtFimS, this.regT);
                if (this.regA.validaAnuncio(this.m_oAnuncio)) {
                    this.regA.registaAnuncio(this.m_oAnuncio);
                    this.m_oAnuncio.setStrId(anunid);
                } else {
                    this.m_oAnuncio = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Anúncios não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Anúncios!");
        } catch (ParseException pe) {
            System.out.println("Erro no formato das datas no ficheiro Anúncios!");
        }
    }
}
