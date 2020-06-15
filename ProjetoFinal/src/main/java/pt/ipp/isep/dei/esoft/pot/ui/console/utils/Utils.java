package pt.ipp.isep.dei.esoft.pot.ui.console.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

/**
 * Utils
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class Utils {
    /**
     * Lê Strings da consola.
     *
     * @param strPrompt prompt
     * @return string
     */
    static public String readLineFromConsole(String strPrompt) {
        try {
            System.out.println("\n" + strPrompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Confirma.
     *
     * @param sMessage message
     * @return boolean
     */
    static public boolean confirma(String sMessage) {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole("\n" + sMessage + "\n");
        } while (!Objects.requireNonNull(strConfirma).equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }

    /**
     * Apresenta e seleciona.
     *
     * @param list    lista
     * @param sHeader header
     * @return lista
     */
    static public Object apresentaESeleciona(List list, String sHeader) {
        apresentaLista(list, sHeader);
        return selecionaObject(list);
    }

    /**
     * Apresenta e seleciona index
     *
     * @param list    lista
     * @param sHeader header
     * @return index
     */
    static public int apresentaESelecionaIndex(List list, String sHeader) {
        apresentaLista(list, sHeader);
        return selecionaIndex(list);
    }

    /**
     * Apresenta lista.
     *
     * @param list    lista
     * @param sHeader header
     */
    static public void apresentaLista(List list, String sHeader) {
        System.out.println(sHeader);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0 - Cancelar");
    }

    /**
     * Seleciona objeto da lista
     *
     * @param list lista
     * @return object
     */
    static public Object selecionaObject(List list) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            assert opcao != null;
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > list.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return list.get(nOpcao - 1);
        }
    }

    /**
     * Seleciona index inteiro.
     *
     * @param list lista
     * @return index
     */
    static public int selecionaIndex(List list) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            assert opcao != null;
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > list.size());

        return nOpcao - 1;
    }
}