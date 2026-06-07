package br.ufscar.dc.compiladores.t5;

import java.util.HashMap;
import java.util.Map;

import static br.ufscar.dc.compiladores.t5.SemanticoUtils.reduzNome;

public class TabelaDeSimbolos {

    
    public enum TipoT5 {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        INVALIDO,
        REGISTRO,
        VOID,
        TIPOESTENDIDO,
    }

    public enum TipoRegistro {
        VARIAVEL,
        PROCEDIMENTO,
        FUNCAO
    }
    
    class EntradaTabelaDeSimbolos {
        
        TipoT5 tipo;
        String nome;
        TipoRegistro tipoRegistro;
        
        private EntradaTabelaDeSimbolos(String nome, TipoT5 tipo, TipoRegistro tipoRegistro) {
            this.tipo = tipo;
            this.nome = nome;
            this.tipoRegistro = tipoRegistro;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public TipoT5 verificar(String nome) {
        nome = reduzNome(nome, "[");
        return tabela.get(nome).tipo;
    }

    public void adicionar(String nome, TipoT5 tipo, TipoRegistro tipoRegistro) {
        nome = reduzNome(nome, "[");
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, tipoRegistro));
    }

    public boolean existe(String nome) {
        nome = reduzNome(nome, "[");
        return tabela.containsKey(nome);
    }
}