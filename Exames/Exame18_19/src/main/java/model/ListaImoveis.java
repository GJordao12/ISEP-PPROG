package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Lista de Imóveis.
 *
 * @author Jordãoll
 */
public class ListaImoveis {

    private List<Imovel> imoveis;

    /**
     * A Lista de Imóveis.
     */
    public ListaImoveis() {
        this.imoveis = new ArrayList<>();
    }

    /**
     * Elimina o Imóvel com a Área menor de uma determinada Localidade.
     *
     * @param localidade Localidade
     * @return true se remover. false se não remover.
     */
    public boolean eliminarImovel(String localidade) {
        Collections.sort(this.imoveis);
        for (int i = 0; i < this.imoveis.size(); i++) {
            if (this.imoveis.get(i).getLocalidade().equalsIgnoreCase(localidade))
                try {
                    if (!(this.imoveis.get(i + 1).getLocalidade().equalsIgnoreCase(localidade)))
                        return this.imoveis.remove(this.imoveis.get(i));
                } catch (IndexOutOfBoundsException ie) {
                    return this.imoveis.remove(this.imoveis.get(i));
                }
        }
        return false;
    }

    /**
     * Calcula o Valor de Vendas de cada Tipo de Imóvel.
     */
    public void calcularImoveis() {
        double somaApartamentos = 0;
        double somaMoradia = 0;
        double somaEscritorio = 0;
        for (Imovel imovel : this.imoveis) {
            if (imovel instanceof Apartamento)
                somaApartamentos = somaApartamentos + imovel.calcularVendaImovel();
            if (imovel instanceof Moradia)
                somaMoradia = somaMoradia + imovel.calcularVendaImovel();
            if (imovel instanceof Escritorio)
                somaEscritorio = somaEscritorio + imovel.calcularVendaImovel();
        }
        System.out.println("Valor de Vendas - Apartamentos: " + somaApartamentos + "€");
        System.out.println("Valor de Vendas - Moradia: " + somaMoradia + "€");
        System.out.println("Valor de Vendas - Escritório: " + somaEscritorio + "€");
    }

    /**
     * Exportar para ficheiro os objetos Imóveis.
     *
     * @param ficheiro Ficheiro
     * @return true se exportar. false se não exportar.
     */
    public boolean exporarParaFicheiro(File ficheiro) {
        try {
            FileOutputStream fileOut = new FileOutputStream(ficheiro);
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(this.imoveis);
            outStream.close();
            fileOut.close();
            return true;
        } catch (IOException fne) {
            fne.printStackTrace();
            return false;
        }
    }
}
