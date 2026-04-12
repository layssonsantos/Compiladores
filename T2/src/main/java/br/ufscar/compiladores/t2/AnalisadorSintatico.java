package br.ufscar.compiladores.t2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author Laysson Santos da Silva - 800349
 * 
 * Analisador sintático para a Linguagem Algoritmica 
 */

public class AnalisadorSintatico {

    public static void main(String[] args) throws IOException {

        // Verifica se foram passados exatamente 2 argumentos (entrada e saída)
        if (args.length != 2) return;

        // Cria um escritor para o arquivo de saída
        try (PrintWriter writer = new PrintWriter(new File(args[1]))) {

            // Lê o conteúdo do arquivo de entrada
            CharStream cs = CharStreams.fromFileName(args[0]);

            // Cria o lexer e passa o fluxo de caracteres
            AnalisadorSintaticoLALexer lexer = new AnalisadorSintaticoLALexer(cs);
            // Cria um fluxo de tokens a partir do lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Cria o parser a partir dos tokens
            AnalisadorSintaticoLAParser parser = new AnalisadorSintaticoLAParser(tokens);

            // Remove os ouvintes de erro padrão
            parser.removeErrorListeners();
            // Adiciona um ouvinte personalizado para capturar erros
            parser.addErrorListener(new AnalisadorDeErros(writer));

            // Inicia a análise sintática
            parser.programa();

            // Escreve mensagem de conclusão
            writer.println("Fim da compilacao");

        } catch (RuntimeException e) {
            // Captura erros já tratados pelo AnalisadorDeErros
        }
    }
}