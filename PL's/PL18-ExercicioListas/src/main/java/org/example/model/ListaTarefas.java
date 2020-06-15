package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jordão
 */
public class ListaTarefas {

    private List<Tarefa> listaTarefas;

    public ListaTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        Tarefa tar = new Tarefa(descricao, prioridade);
        if (listaTarefas.contains(tar)) {
            return false;
        } else {
            listaTarefas.add(tar);
            return true;
        }
    }

    public void eliminarTarefas() {
        listaTarefas.clear();
    }

    public boolean eliminarUltimaTarefa() {
        Tarefa tar = listaTarefas.get(listaTarefas.size() - 1);
        return listaTarefas.remove(tar);
    }

    public boolean listaVazia() {
        return listaTarefas.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Tarefa tarefa : listaTarefas) {
            s.append(tarefa);
            s.append("\n");
        }
        return s.toString().trim();
    }

    public String toStringPrioridade() {
        List<Tarefa> copia = new ArrayList<>(listaTarefas);
        Collections.sort(copia);

        StringBuilder s = new StringBuilder();
        for (Tarefa tar : copia) {
            s.append(tar);
            s.append("\n");
        }

        return s.toString().trim();
    }
}

