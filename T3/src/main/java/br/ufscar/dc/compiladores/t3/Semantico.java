package br.ufscar.dc.compiladores.t3;

import org.antlr.v4.runtime.Token;

import static br.ufscar.dc.compiladores.t3.SemanticoUtils.adicionaErroSemantico;
import static br.ufscar.dc.compiladores.t3.SemanticoUtils.verificaCompatibilidade;
import static br.ufscar.dc.compiladores.t3.SemanticoUtils.verificarTipo;
import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.TipoT3;

// Classe que implementa a análise semântica, visitando os nós da AST
public class Semantico extends AnalisadorSemanticoLABaseVisitor<Void> {

    // Tabela de símbolos para armazenar escopos
    TabelaDeSimbolos tabela;

    // Escopos aninhados para análise auxiliar
    static Escopos escoposAninhados = new Escopos();
    
    TabelaDeSimbolos tabelaEscopo;

    // Adiciona variável à tabela de símbolos
    public void adicionaVariavelTabela(String nome, String tipo, Token nomeT, Token tipoT) {
        tabelaEscopo = escoposAninhados.obterEscopoAtual();

        TipoT3 tipoItem;

        // Mapeia string do tipo para enum TipoT3
        switch (tipo) {
            case "literal":
                tipoItem = TipoT3.LITERAL;
                break;
            case "inteiro":
                tipoItem = TipoT3.INTEIRO;
                break;
            case "real":
                tipoItem = TipoT3.REAL;
                break;
            case "logico":
                tipoItem = TipoT3.LOGICO;
                break;
            default:
                tipoItem = TipoT3.INVALIDO;
                break;
        }

        // Erro se tipo inválido
        if (tipoItem == TipoT3.INVALIDO)
            adicionaErroSemantico(tipoT, "tipo " + tipo + " nao declarado");

        // Adiciona se não existe, senão erro de redeclaração
        if (!tabelaEscopo.existe(nome))
            tabelaEscopo.adicionar(nome, tipoItem);
        else
            adicionaErroSemantico(nomeT, "identificador " + nome + " ja declarado anteriormente");
    }

    // Visita o nó programa, inicializando tabela
    @Override
    public Void visitPrograma(AnalisadorSemanticoLAParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    // Visita declarações, obtém escopo atual
    @Override
    public Void visitDeclaracoes(AnalisadorSemanticoLAParser.DeclaracoesContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        // Visita cada declaração local ou global
        for (AnalisadorSemanticoLAParser.Decl_local_globalContext declaracao : ctx.decl_local_global())
            visitDecl_local_global(declaracao);
        
        return super.visitDeclaracoes(ctx);
    }

    // Visita declaração local ou global
    @Override
    public Void visitDecl_local_global(AnalisadorSemanticoLAParser.Decl_local_globalContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        // Identifica tipo de declaração
        if (ctx.declaracao_local() != null)
            visitDeclaracao_local(ctx.declaracao_local());
        else if (ctx.declaracao_global() != null)
            visitDeclaracao_global(ctx.declaracao_global());

        return super.visitDecl_local_global(ctx);
    }

    // Visita declaração local, adiciona variáveis
    @Override
    public Void visitDeclaracao_local(AnalisadorSemanticoLAParser.Declaracao_localContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        String tipoVariavel;
        String nomeVariavel;

        // Se é declaração de variável
        if (ctx.getText().contains("declare")) {
            tipoVariavel = ctx.variavel().tipo().getText();

            // Adiciona cada identificador à tabela
            for (AnalisadorSemanticoLAParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                nomeVariavel = ident.getText();
                adicionaVariavelTabela(nomeVariavel, tipoVariavel, ident.getStart(), ctx.variavel().tipo().getStart());
            }
        }

        return super.visitDeclaracao_local(ctx);
    }

    // Visita comando leia, verifica se variáveis declaradas
    @Override
    public Void visitCmdLeia(AnalisadorSemanticoLAParser.CmdLeiaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        for (AnalisadorSemanticoLAParser.IdentificadorContext id : ctx.identificador())
            // Erro se identificador não declarado
            if (!tabela.existe(id.getText()))
                adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");

        return super.visitCmdLeia(ctx);
    }

    // Visita comando escreva, verifica tipos das expressões
    @Override
    public Void visitCmdEscreva(AnalisadorSemanticoLAParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT3 tipo;

        for (AnalisadorSemanticoLAParser.ExpressaoContext expressao : ctx.expressao())
            tipo = verificarTipo(tabela, expressao);

        return super.visitCmdEscreva(ctx);
    }

    // Visita comando enquanto, verifica tipo da expressão
    @Override
    public Void visitCmdEnquanto(AnalisadorSemanticoLAParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT3 tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdEnquanto(ctx);
    }

    // Visita comando atribuição, verifica compatibilidade de tipos
    @Override
    public Void visitCmdAtribuicao(AnalisadorSemanticoLAParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT3 tipoExpressao = verificarTipo(tabela, ctx.expressao());
        
        String varNome = ctx.identificador().getText();
        
        if (tipoExpressao != TipoT3.INVALIDO) {
            // Erro se variável não declarada
            if (!tabela.existe(varNome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            } else {
                // Obtém tipo da variável
                TipoT3 varTipo = verificarTipo(tabela, varNome);
                
                // Verifica compatibilidade para numéricos
                if (varTipo == TipoT3.INTEIRO || varTipo == TipoT3.REAL) {
                    if (!verificaCompatibilidade(varTipo, tipoExpressao)) {
                        // Erro se expressão não inteira
                        if (tipoExpressao != TipoT3.INTEIRO) {
                            adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                        }
                    }
                // Verifica igualdade de tipos para outros
                } else if (varTipo != tipoExpressao)
                    adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
            }
        }
        
        return super.visitCmdAtribuicao(ctx);
    }

}