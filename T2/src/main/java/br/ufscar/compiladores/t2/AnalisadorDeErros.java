package br.ufscar.compiladores.t2;

import java.io.PrintWriter;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

// Classe responsável por tratar erros sintáticos durante a análise
public class AnalisadorDeErros extends BaseErrorListener {

    // Objeto para escrever mensagens de erro
    private final PrintWriter writer;

    // Construtor que recebe um PrintWriter
    public AnalisadorDeErros(PrintWriter writer) {
        this.writer = writer;
    }

    // Método chamado quando um erro sintático é detectado
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {

        // Converte o símbolo problemático para Token
        Token t = (Token) offendingSymbol;

        // Obtém o texto do token
        String texto = t.getText();

        // Verifica o tipo de erro e exibe mensagem apropriada
        if (t.getType() == Token.EOF) {
            writer.println("Linha " + line + ": erro sintatico proximo a EOF");
        } else if (t.getType() == AnalisadorSintaticoLALexer.CADEIA_ERRADA) {
            writer.println("Linha " + line + ": cadeia literal nao fechada");
        } else if (t.getType() == AnalisadorSintaticoLALexer.COMENTARIO_ERRADO) {
            writer.println("Linha " + line + ": comentario nao fechado");
        } else if (t.getType() == AnalisadorSintaticoLALexer.ERRO) {
            writer.println("Linha " + line + ": " + texto + " - simbolo nao identificado");
        } else {
            writer.println("Linha " + line + ": erro sintatico proximo a " + texto);
        }

        // Mensagem final indicando o fim da compilação
        writer.println("Fim da compilacao");

        // Interrompe a execução lançando uma exceção
        throw new RuntimeException();
    }
}