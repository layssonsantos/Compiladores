package br.ufscar.dc.compiladores.t5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.t5.AnalisadorSemanticoLAParser.Fator_logicoContext;
import static br.ufscar.dc.compiladores.t5.Semantico.escoposAninhados;
import static br.ufscar.dc.compiladores.t5.Semantico.funcaoProcedimento;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoT5;

public class SemanticoUtils {

    // Criação da lista que armazenará os erros identificados pelo analisador.
    public static List<String> errosSemanticos = new ArrayList<>();

    // Método auxiliar utilizado para adicionar um novo erro identificado na lista.
    public static void adicionaErroSemantico(Token tok, String mensagem) {
        int linha = tok.getLine();
        
        // Verifica se o erro já foi identificado para poder adicioná-lo à lista.
        if (!errosSemanticos.contains("Linha " + linha + ": " + mensagem)) 
            errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    // Método auxiliar que verifica a compatibilidade entre operadores aritméticos.
    // Caso a operação envolva pelo menos um valor real, a operação deve ser tratada
    // como uma operação entre números reais, mesmo que um deles seja um inteiro.
    public static boolean verificaCompatibilidade(TipoT5 T1, TipoT5 T2) {
        boolean flag = false;
        
        if (T1 == TipoT5.INTEIRO && T2 == TipoT5.REAL)
            flag = true;
        else if (T1 == TipoT5.REAL && T2 == TipoT5.INTEIRO)
            flag = true;
        else if (T1 == TipoT5.REAL && T2 == TipoT5.REAL)
            flag = true;
        
        return flag;
    }
    
    // Método auxiliar que verifica a compatibilidade entre operadores para tratá-los
    // como uma operação lógica.
    public static boolean verificaCompatibilidadeLogica(TipoT5 T1, TipoT5 T2) {
        boolean flag = false;
        
        if (T1 == TipoT5.INTEIRO && T2 == TipoT5.REAL)
            flag = true;
        else if (T1 == TipoT5.REAL && T2 == TipoT5.INTEIRO)
            flag = true;

        return flag;
    }
                    
    // Método que verifica o tipo de uma expressão aritmética.
    // Percorre os termos da expressão e determina o tipo resultante,
    // promovendo para REAL se houver incompatibilidade numérica.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Exp_aritmeticaContext ctx) {
        // A variável que será retornada ao fim da execução é inicializada com o tipo
        // do primeiro elemento que será verificado, para fins de comparação.
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.termo().get(0));
                
        for (var termoArit : ctx.termo()) {
            // Esta outra variável recebe os tipos dos outros termos da expressão.
            TipoT5 tipoAtual = verificarTipo(tabela, termoArit);
            
            // Com o auxílio do método declarado anteriormente, o programa verifica se deve tratar a
            // verificação atual como uma operação entre números reais.
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT5.INVALIDO))
                tipoRetorno = TipoT5.REAL;
            else
                tipoRetorno = tipoAtual;
        }

        return tipoRetorno;
    }

    // Método que verifica o tipo de um termo aritmético.
    // Percorre os fatores do termo e determina o tipo resultante,
    // promovendo para REAL se houver incompatibilidade numérica.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.TermoContext ctx) {
        // A variável que será retornada ao fim da execução é inicializada com o tipo
        // do primeiro elemento que será verificado, para fins de comparação.
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.fator().get(0));
                
        for (AnalisadorSemanticoLAParser.FatorContext fatorArit : ctx.fator()) {
            // Esta outra variável recebe os tipos dos outros termos da expressão.
            TipoT5 tipoAtual = verificarTipo(tabela, fatorArit);
            
            // Com o auxílio do método declarado anteriormente, o programa verifica se deve tratar a
            // verificação atual como uma operação entre números reais.
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT5.INVALIDO))
                tipoRetorno = TipoT5.REAL;
            else
                tipoRetorno = tipoAtual;
        }
        
        return tipoRetorno;
    }

    // Método que verifica o tipo de um fator aritmético.
    // Percorre as parcelas do fator e retorna o tipo da última parcela.
    // Se a parcela for um registro, o método reduzNome é utilizado para obter o nome do registro e verificar seu tipo. 
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.FatorContext ctx) {
        TipoT5 tipoRetorno = null;
        
        for (AnalisadorSemanticoLAParser.ParcelaContext parcela : ctx.parcela()) {
            tipoRetorno = verificarTipo(tabela, parcela);
            if (tipoRetorno == TipoT5.REGISTRO) {
                String nome = parcela.getText();
                nome = reduzNome(nome, "(");
                tipoRetorno = verificarTipo(tabela, nome);
            }
        }

        return tipoRetorno;
    }

    // Método que verifica o tipo de uma parcela.
    // Delega para parcela_unario ou parcela_nao_unario conforme o caso.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.ParcelaContext ctx) {
        // Identifica se é uma parcela unária ou não unária.
        if (ctx.parcela_unario() != null)
            return verificarTipo(tabela, ctx.parcela_unario());
        else
            return verificarTipo(tabela, ctx.parcela_nao_unario());
    }

    // Método que verifica o tipo de uma parcela unária.
    // Pode ser um identificador, número inteiro, número real ou uma expressão entre parênteses.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Parcela_unarioContext ctx) {
        TipoT5 tipoRetorno;
        String nome;
        if (ctx.identificador() != null) {
            if (!ctx.identificador().dimensao().exp_aritmetica().isEmpty())
                nome = ctx.identificador().IDENT().get(0).getText();
            else
                nome = ctx.identificador().getText();
            if (tabela.existe(nome)) {
                tipoRetorno = tabela.verificar(nome);
            } else {
                TabelaDeSimbolos tabelaAux = escoposAninhados.obterEscopoAtual();
                if (!tabelaAux.existe(nome)) {
                    adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                    tipoRetorno = TipoT5.INVALIDO;
                } else
                    tipoRetorno = tabelaAux.verificar(nome);
            }
        } else if (ctx.IDENT() != null) {
            if (funcaoProcedimento.containsKey(ctx.IDENT().getText())) {
                List<TipoT5> aux = funcaoProcedimento.get(ctx.IDENT().getText());
                if (aux.size() == ctx.expressao().size()) {
                    for (int i = 0; i < ctx.expressao().size(); i++) {
                        if (aux.get(i) != verificarTipo(tabela, ctx.expressao().get(i)))
                            adicionaErroSemantico(ctx.expressao().get(i).getStart(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                    }
                    tipoRetorno = aux.get(aux.size() - 1);
                } else {
                    adicionaErroSemantico(ctx.IDENT().getSymbol(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
                    tipoRetorno = TipoT5.INVALIDO;
                }
            } else
                tipoRetorno = TipoT5.INVALIDO;
        } else if (ctx.NUM_INT() != null)
            tipoRetorno = TipoT5.INTEIRO;
        else if (ctx.NUM_REAL() != null)
            tipoRetorno = TipoT5.REAL;
        else
            tipoRetorno = verificarTipo(tabela, ctx.expressao().get(0));
        return tipoRetorno;
    }

    // Método que verifica o tipo de uma parcela não unária.
    // Pode ser um identificador ou um literal.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Parcela_nao_unarioContext ctx) {
        TipoT5 tipoRetorno;
        String nome;

        // Utiliza uma lógica semelhante à verificação de tipo anterior, verificando a existência da variável
        // e tentando adicioná-la à lista de erros.
        if (ctx.identificador() != null) {
            nome = ctx.identificador().getText();
        
            if (!tabela.existe(nome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                tipoRetorno = TipoT5.INVALIDO;
            } else 
                tipoRetorno = tabela.verificar(ctx.identificador().getText());
        } else
            tipoRetorno = TipoT5.LITERAL;

        return tipoRetorno;
    }

    // Método que verifica o tipo de uma expressão lógica.
    // Percorre os termos lógicos e verifica se todos têm o mesmo tipo.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.ExpressaoContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.termo_logico(0));

        // Para expressões lógicas, a ideia resume-se apenas em verificar se os tipos analisados
        // são diferentes.
        for (AnalisadorSemanticoLAParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
            TipoT5 tipoAtual = verificarTipo(tabela, termoLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT5.INVALIDO)
                tipoRetorno = TipoT5.INVALIDO;
        }

        return tipoRetorno;
    }

    // Método que verifica o tipo de um termo lógico.
    // Percorre os fatores lógicos e verifica se todos têm o mesmo tipo.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Termo_logicoContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.fator_logico(0));

        // Para expressões lógicas, a ideia resume-se apenas em verificar se os tipos analisados
        // são diferentes.
        for (Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            TipoT5 tipoAtual = verificarTipo(tabela, fatorLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT5.INVALIDO)
                tipoRetorno = TipoT5.INVALIDO;
        }
        return tipoRetorno;
    }

    // Método que verifica o tipo de um fator lógico.
    // Delega para parcela_logica.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Fator_logicoContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.parcela_logica());
        return tipoRetorno;

    }

    // Método que verifica o tipo de uma parcela lógica.
    // Pode ser uma expressão relacional ou um valor lógico.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Parcela_logicaContext ctx) {
        TipoT5 tipoRetorno;

        if (ctx.exp_relacional() != null)
            tipoRetorno = verificarTipo(tabela, ctx.exp_relacional());
         else
            tipoRetorno = TipoT5.LOGICO;

        return tipoRetorno;

    }

    // Método que verifica o tipo de uma expressão relacional.
    // Compara duas expressões aritméticas e retorna LOGICO se compatíveis.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, AnalisadorSemanticoLAParser.Exp_relacionalContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

        if (ctx.exp_aritmetica().size() > 1) {
            TipoT5 tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));

            // Semelhante ao que foi feito com as expressões aritméticas, ocorre uma verificação
            // para saber se a expressão atual pode ser tratada como uma operação lógica.
            if (tipoRetorno == tipoAtual || verificaCompatibilidadeLogica(tipoRetorno, tipoAtual))
                tipoRetorno = TipoT5.LOGICO;
            else
                tipoRetorno = TipoT5.INVALIDO;
        }

        return tipoRetorno;

    }

    // Verificação padrão de tipos de variáveis a partir da tabela.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }

    // método novo para o t5
    // Reduz o nome de um identificador, removendo a parte que se refere a um índice de vetor ou campo de registro.
    public static String reduzNome(String nome, String simbolo) {
        if (nome.contains(simbolo)) {
            boolean continua = true;
            int cont = 0;
            String nomeAux;
            while (continua) {
                nomeAux = nome.substring(cont);
                if (nomeAux.startsWith(simbolo))
                    continua = false;
                else
                    cont++;
            }
            nome = nome.substring(0, cont);
        }
        return nome;
    }

    public static TipoT5 confereTipo(HashMap<String, ArrayList<String>> tabela, String tipoRetorno) {
        TipoT5 tipoAux;
        if (tipoRetorno.charAt(0) == '^') {
            tipoRetorno = tipoRetorno.substring(1);
        }
        if (tabela.containsKey(tipoRetorno))
            tipoAux = TipoT5.REGISTRO;
        else if (tipoRetorno.equals("literal"))
            tipoAux = TipoT5.LITERAL;
        else if (tipoRetorno.equals("inteiro"))
            tipoAux = TipoT5.INTEIRO;
        else if (tipoRetorno.equals("real"))
            tipoAux = TipoT5.REAL;
        else if (tipoRetorno.equals("logico"))
            tipoAux = TipoT5.LOGICO;
        else
            tipoAux = TipoT5.INVALIDO;
        return tipoAux;
    }
}