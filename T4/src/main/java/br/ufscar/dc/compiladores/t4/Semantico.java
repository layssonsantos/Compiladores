package br.ufscar.dc.compiladores.t4;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.Token;

import static br.ufscar.dc.compiladores.t4.SemanticoUtils.adicionaErroSemantico;
import static br.ufscar.dc.compiladores.t4.SemanticoUtils.confereTipo;
import static br.ufscar.dc.compiladores.t4.SemanticoUtils.verificaCompatibilidade;
import static br.ufscar.dc.compiladores.t4.SemanticoUtils.verificarTipo;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.TipoRegistro;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.TipoT4;

// Classe que implementa a análise semântica, visitando os nós da AST
public class Semantico extends AnalisadorSemanticoLABaseVisitor<Void> {

    // Tabela de símbolos para armazenar escopos
    TabelaDeSimbolos tabela;

    // Escopos aninhados para análise auxiliar
    static Escopos escoposAninhados = new Escopos();

    static HashMap<String, ArrayList<TipoT4>> funcaoProcedimento = new HashMap<>();

    HashMap<String, ArrayList<String>> tabelaRegistro = new HashMap<>();
    
    TabelaDeSimbolos tabelaEscopo;

    // Adiciona variável à tabela de símbolos
    public void adicionaVariavelTabela(String nome, String tipo, Token nomeT, Token tipoT, TipoRegistro tipoRegistro) {
        tabelaEscopo = escoposAninhados.obterEscopoAtual();

        TipoT4 tipoItem;

        // Mapeia string do tipo para enum TipoT4
        switch (tipo) {
            case "literal":
                tipoItem = TipoT4.LITERAL;
                break;
            case "inteiro":
                tipoItem = TipoT4.INTEIRO;
                break;
            case "real":
                tipoItem = TipoT4.REAL;
                break;
            case "logico":
                tipoItem = TipoT4.LOGICO;
                break;
            case "void":
                tipoItem = TipoT4.VOID;
                break;
            case "registro":
                tipoItem = TipoT4.REGISTRO;
                break;
            default:
                tipoItem = TipoT4.INVALIDO;
                break;
        }

        // Erro se tipo inválido
        if (tipoItem == TipoT4.INVALIDO)
            adicionaErroSemantico(tipoT, "tipo " + tipo + " nao declarado");

        // Adiciona se não existe, senão erro de redeclaração
        if (!tabelaEscopo.existe(nome))
            tabelaEscopo.adicionar(nome, tipoItem, tipoRegistro);
        else
            adicionaErroSemantico(nomeT, "identificador " + nome + " ja declarado anteriormente");
    }

    // Visita o nó programa, inicializando tabela
    @Override
    public Void visitPrograma(AnalisadorSemanticoLAParser.ProgramaContext ctx) {
        for (AnalisadorSemanticoLAParser.CmdContext c : ctx.corpo().cmd())
            if (c.cmdRetorne() != null)
                adicionaErroSemantico(c.getStart(), "comando retorne nao permitido nesse escopo");

        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao_local(AnalisadorSemanticoLAParser.Declaracao_localContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        String tipoVariavel;
        String nomeVariavel;
                
        if (ctx.getText().contains("declare")) {
            if (ctx.variavel().tipo().registro() != null) {
                for (AnalisadorSemanticoLAParser.IdentificadorContext ic : ctx.variavel().identificador()) {
                    adicionaVariavelTabela(ic.getText(), "registro", ic.getStart(), null, TipoRegistro.VARIAVEL);

                    for (AnalisadorSemanticoLAParser.VariavelContext vc : ctx.variavel().tipo().registro().variavel()) {
                        tipoVariavel = vc.tipo().getText();
                        
                        for (AnalisadorSemanticoLAParser.IdentificadorContext icr : vc.identificador())
                            adicionaVariavelTabela(ic.getText() + "." + icr.getText(), tipoVariavel, icr.getStart(), vc.tipo().getStart(), TipoRegistro.VARIAVEL);
                    }
                }
            } else {
                tipoVariavel = ctx.variavel().tipo().getText(); 
                if (tabelaRegistro.containsKey(tipoVariavel)) {
                    ArrayList<String> variaveisRegistro = tabelaRegistro.get(tipoVariavel);
                    
                    for (AnalisadorSemanticoLAParser.IdentificadorContext ic : ctx.variavel().identificador()) {
                        nomeVariavel = ic.IDENT().get(0).getText();
                        
                        if (tabela.existe(nomeVariavel) || tabelaRegistro.containsKey(nomeVariavel)) {
                            adicionaErroSemantico(ic.getStart(), "identificador " + nomeVariavel + " ja declarado anteriormente");
                        } else {  
                            adicionaVariavelTabela(nomeVariavel, "registro", ic.getStart(), ctx.variavel().tipo().getStart(), TipoRegistro.VARIAVEL);                            

                            for (int i = 0; i < variaveisRegistro.size(); i = i + 2) {
                                adicionaVariavelTabela(nomeVariavel + "." + variaveisRegistro.get(i), variaveisRegistro.get(i+1), ic.getStart(), ctx.variavel().tipo().getStart(), TipoRegistro.VARIAVEL);
                            }
                        }
                    }
                } else {
                    for (AnalisadorSemanticoLAParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        nomeVariavel = ident.getText();
                        
                        if (funcaoProcedimento.containsKey(nomeVariavel))
                            adicionaErroSemantico(ident.getStart(), "identificador " + nomeVariavel + " ja declarado anteriormente");
                        else
                            adicionaVariavelTabela(nomeVariavel, tipoVariavel, ident.getStart(), ctx.variavel().tipo().getStart(), TipoRegistro.VARIAVEL); 
                    }
                }
            }
        } else if (ctx.getText().contains("tipo")) {
            if (ctx.tipo().registro() != null) {
                ArrayList<String> variaveisRegistro = new ArrayList<>();
                
                for (AnalisadorSemanticoLAParser.VariavelContext vc : ctx.tipo().registro().variavel()) {
                    tipoVariavel = vc.tipo().getText();
                    
                    for (AnalisadorSemanticoLAParser.IdentificadorContext ic : vc.identificador()) {
                        variaveisRegistro.add(ic.getText());
                        variaveisRegistro.add(tipoVariavel);
                    }
                }
                tabelaRegistro.put(ctx.IDENT().getText(), variaveisRegistro);
            }
        } else if (ctx.getText().contains("constante"))
            adicionaVariavelTabela(ctx.IDENT().getText(), ctx.tipo_basico().getText(), ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), TipoRegistro.VARIAVEL);
        
        return super.visitDeclaracao_local(ctx);
    }
    
    @Override
    public Void visitDeclaracao_global(AnalisadorSemanticoLAParser.Declaracao_globalContext ctx) {
        escoposAninhados.criarNovoEscopo();
        
        tabela = escoposAninhados.obterEscopoAtual();

        ArrayList<TipoT4> tiposVariaveis = new ArrayList<>();
        ArrayList<String> variaveisRegistro;
                
        String tipoVariavel;
        TipoT4 tipoAux;
        
        if (ctx.getText().contains("procedimento")) {
            for (AnalisadorSemanticoLAParser.ParametroContext parametro : ctx.parametros().parametro()) {
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                    adicionaVariavelTabela(parametro.identificador().get(0).getText(), parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), parametro.getStart(), parametro.getStart(), TipoRegistro.VARIAVEL);
                    
                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);
                } else if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                    variaveisRegistro = tabelaRegistro.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());

                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);

                    for (AnalisadorSemanticoLAParser.IdentificadorContext ic : parametro.identificador())
                        for (int i = 0; i < variaveisRegistro.size(); i = i + 2)
                            adicionaVariavelTabela(ic.getText() + "." + variaveisRegistro.get(i), variaveisRegistro.get(i + 1), ic.getStart(), ic.getStart(), TipoRegistro.VARIAVEL);                       
                } else
                    adicionaErroSemantico(parametro.getStart(), "tipo nao declarado");                       
            }
            for (AnalisadorSemanticoLAParser.CmdContext c : ctx.cmd())    
                if (c.cmdRetorne() != null)  
                    adicionaErroSemantico(c.getStart(), "comando retorne nao permitido nesse escopo");    
            
            funcaoProcedimento.put(ctx.IDENT().getText(), tiposVariaveis);
        } else if (ctx.getText().contains("funcao")) {
            for (AnalisadorSemanticoLAParser.ParametroContext parametro : ctx.parametros().parametro()) {
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                    adicionaVariavelTabela(parametro.identificador().get(0).getText(), parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), parametro.getStart(), parametro.getStart(), TipoRegistro.VARIAVEL);

                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);
                } else if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                    variaveisRegistro = tabelaRegistro.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());

                    tipoVariavel = parametro.tipo_estendido().tipo_basico_ident().IDENT().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);
                    
                    for (AnalisadorSemanticoLAParser.IdentificadorContext ic : parametro.identificador())
                        for (int i = 0; i < variaveisRegistro.size(); i = i + 2)
                            adicionaVariavelTabela(ic.getText() + "." + variaveisRegistro.get(i), variaveisRegistro.get(i + 1), ic.getStart(), ic.getStart(), TipoRegistro.VARIAVEL);
                } else
                    adicionaErroSemantico(parametro.getStart(), "tipo nao declarado");
            }
            funcaoProcedimento.put(ctx.IDENT().getText(), tiposVariaveis);
        }
        
        super.visitDeclaracao_global(ctx);
        
        escoposAninhados.abandonarEscopo();
        
        if (ctx.getText().contains("procedimento"))      
            adicionaVariavelTabela(ctx.IDENT().getText(), "void", ctx.getStart(), ctx.getStart(), TipoRegistro.PROCEDIMENTO);
        else if (ctx.getText().contains("funcao"))
            adicionaVariavelTabela(ctx.IDENT().getText(), ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ctx.getStart(), ctx.getStart(), TipoRegistro.FUNCAO);

        return null;
    }

    @Override
    public Void visitCmdLeia(AnalisadorSemanticoLAParser.CmdLeiaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        for (AnalisadorSemanticoLAParser.IdentificadorContext id : ctx.identificador()) 
            if (!tabela.existe(id.getText()))
                adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");

        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(AnalisadorSemanticoLAParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
                
        for (AnalisadorSemanticoLAParser.ExpressaoContext expressao : ctx.expressao())
            verificarTipo(tabela, expressao);

        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(AnalisadorSemanticoLAParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdSe(AnalisadorSemanticoLAParser.CmdSeContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdSe(ctx);
    }
        
    @Override
    public Void visitCmdAtribuicao(AnalisadorSemanticoLAParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT4 tipoExpressao = verificarTipo(tabela, ctx.expressao());
        
        String varNome = ctx.identificador().getText();
        
        if (tipoExpressao != TipoT4.INVALIDO) {
            if (!tabela.existe(varNome))
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            else {
                TipoT4 varTipo = verificarTipo(tabela, varNome);
                
                if (varTipo == TipoT4.INTEIRO || varTipo == TipoT4.REAL) {
                    if (ctx.getText().contains("ponteiro")) {
                        if (!verificaCompatibilidade(varTipo, tipoExpressao))
                            if (tipoExpressao != TipoT4.INTEIRO)
                                adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + ctx.identificador().getText());
                    } else if (!verificaCompatibilidade(varTipo, tipoExpressao))
                        if (tipoExpressao != TipoT4.INTEIRO)
                            adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());               
                } else if (varTipo != tipoExpressao)
                    adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
            }
        }
        
        return super.visitCmdAtribuicao(ctx);
    }

}