package br.ufscar.dc.compiladores.t4;

import java.util.LinkedList;
import java.util.List;

// Classe para gerenciar escopos usando uma pilha de tabelas de símbolos
public final class Escopos {

    // Pilha de tabelas de símbolos para representar escopos aninhados
    private final LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    // Construtor: inicializa a pilha e cria o primeiro escopo
    public Escopos() {
        pilhaDeTabelas = new LinkedList<>();
        criarNovoEscopo();
    }

    // Cria um novo escopo empilhando uma nova tabela de símbolos
    public void criarNovoEscopo() {
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }

    // Retorna a tabela de símbolos do escopo atual (topo da pilha)
    public TabelaDeSimbolos obterEscopoAtual() {
        return pilhaDeTabelas.peek();
    }

    // Retorna a lista de todas as tabelas de símbolos (escopos aninhados)
    public List<TabelaDeSimbolos> percorrerEscoposAninhados() {
        return pilhaDeTabelas;
    }

    // Remove o escopo atual da pilha
    public void abandonarEscopo() {
        pilhaDeTabelas.pop();
    }
}