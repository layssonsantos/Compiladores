package br.ufscar.dc.compiladores.t3;

import java.util.HashMap;
import java.util.Map;

public class TabelaDeSimbolos {

    
    public enum TipoT3 {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        INVALIDO
    }
    
    class EntradaTabelaDeSimbolos {
        
        String nome;
        TipoT3 tipo;
        
        private EntradaTabelaDeSimbolos(String nome, TipoT3 tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public TipoT3 verificar(String nome) {
        return tabela.get(nome).tipo;
    }

    public void adicionar(String nome, TipoT3 tipo) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }

    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
}