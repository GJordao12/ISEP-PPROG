package org.example.model;

import java.io.*;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;

public class FicheiroListaTarefas {

    public static final String NOME_FICHEIRO_TEXTO_OMISSAO = "ListaTarefas.txt";
    public static final String NOME_FICHEIRO_BINARIO_OMISSAO = "ListaTarefas.flt";

    public FicheiroListaTarefas() {

    }

    public boolean guardarFicheiroBinario(ListaTarefas listaTarefas) {
        return guardarFicheiroBinario(new File(NOME_FICHEIRO_BINARIO_OMISSAO), listaTarefas);
    }

    public boolean guardarFicheiroBinario(String nomeFicheiro, ListaTarefas listaTarefas) {
        return guardarFicheiroBinario(new File(nomeFicheiro), listaTarefas);
    }

    public boolean guardarFicheiroBinario(File ficheiro, ListaTarefas listaTarefas) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ficheiro));
            try {
                out.writeObject(listaTarefas);
                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean guardarFicheiroTexto(ListaTarefas listaTarefas) {
        return guardarFicheiroTexto(new File(NOME_FICHEIRO_TEXTO_OMISSAO), listaTarefas);
    }

    public boolean guardarFicheiroTexto(String nomeFicheiro, ListaTarefas listaTarefas) {
        return guardarFicheiroTexto(new File(nomeFicheiro), listaTarefas);
    }

    public boolean guardarFicheiroTexto(File ficheiro, ListaTarefas listaTarefas) {
        try {
            Formatter formatter = new Formatter(ficheiro);
            try {
                formatter.format("%s", listaTarefas.toString());

                return true;
            } catch (IllegalFormatException|FormatterClosedException e) {
                return false;
            } finally {
                formatter.close();
            }
        } catch (FileNotFoundException fnfe) {
            return false;
        }
    }

}

