package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoOrganizacoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Leitura de Organizações através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraOrganizacoes {

    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private RegistoOrganizacoes ro;
    private Organizacao m_oOrganizacao;

    /**
     * Instancia uma nova Leitura de Organizações.
     */
    public LeituraOrganizacoes() {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oPlataforma = this.m_oApp.getPlataforma();
        this.ro = this.m_oPlataforma.getRegistoOrganizacoes();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosOrganizacao = new File("Ficheiros\\Organizacoes.txt");
            Scanner sc = new Scanner(dadosOrganizacao);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String strNome = dados[0].trim();
                String strNIF = dados[1].trim();
                String strWebsite = dados[2].trim();
                String strTelefone = dados[3].trim();
                String strEmail = dados[4].trim();
                String strLocal = dados[5].trim();
                String strCodPostal = dados[6].trim();
                String strLocalidade = dados[7].trim();
                String strNomeGestor = dados[8].trim();
                String strFuncao = dados[9].trim();
                String strEmailGestor = dados[10].trim();
                String strTelefoneGestor = dados[11].trim();
                EnderecoPostal oMorada = Organizacao.novoEnderecoPostal(strLocal, strCodPostal, strLocalidade);
                Colaborador oColab = Organizacao.novoColaborador(strNomeGestor, strFuncao, strTelefoneGestor, strEmailGestor);
                this.m_oOrganizacao = this.ro.novaOrganizacao(strNome, strNIF, strWebsite, strTelefone, strEmail, oMorada, oColab);
                if (this.ro.validaOrganizacao(this.m_oOrganizacao)) {
                    this.ro.registaOrganizacao(this.m_oOrganizacao);
                } else {
                    this.m_oOrganizacao = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Organizações não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Organizações!");
        }
    }
}
