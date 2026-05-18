package br.ufscar.dc.compiladores.t4;

import java.util.HashMap;
import java.util.Map;

import static br.ufscar.dc.compiladores.t4.SemanticoUtils.reduzNome;

public class TabelaDeSimbolos {

    
    public enum TipoT4 {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        INVALIDO,
        REGISTRO,
        VOID
    }

    public enum TipoRegistro {
        VARIAVEL,
        PROCEDIMENTO,
        FUNCAO
    }
    
    class EntradaTabelaDeSimbolos {
        
        TipoT4 tipo;
        
        private EntradaTabelaDeSimbolos(TipoT4 tipo, TipoRegistro tipoRegistro) {
            this.tipo = tipo;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public TipoT4 verificar(String nome) {
        nome = reduzNome(nome, "[");
        return tabela.get(nome).tipo;
    }

    public void adicionar(String nome, TipoT4 tipo, TipoRegistro tipoRegistro) {
        nome = reduzNome(nome, "[");
        tabela.put(nome, new EntradaTabelaDeSimbolos(tipo, tipoRegistro));
    }

    public boolean existe(String nome) {
        nome = reduzNome(nome, "[");
        return tabela.containsKey(nome);
    }
}