package br.ufscar.compiladores.t1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Laysson Santos da Silva - 800349
 * 
 * Analisador léxico para a Linguagem Algoritmica 
 */

public class AnalisadorLexico {

    public static void main(String[] args) {

        // Verifica se foram passados exatamente 2 argumentos (arquivo entrada e saída)
        if (args.length != 2) return;

        try {
            // Leitura do arquivo de entrada e criação do CharStream
            CharStream cs = CharStreams.fromFileName(args[0]);
            // O lexer (gerado pelo ANTLR) é responsável por transformar
            // o fluxo de caracteres em uma sequência de tokens da linguagem
            // e instancia o analisador léxico com o stream de caracteres
            AnalisadorLexicoLA lexer = new AnalisadorLexicoLA(cs);

            // Abre arquivo de saída para escrita
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {

                Token t;

                // Loop que processa todos os tokens até encontrar EOF (fim de arquivo)
                while (true) {
                    // Obtém o próximo token reconhecido pelo analisador léxico
                    // Cada chamada consome caracteres da entrada
                    t = lexer.nextToken();

                    // Se chegou ao final do arquivo, encerra o loop
                    if (t.getType() == Token.EOF) {
                        break;
                    }

                    // Extrai informações do token
                    int tipo = t.getType();
                    String texto = t.getText();
                    int linha = t.getLine();

                    // Verifica se houve erro: símbolo não identificado
                    if (tipo == AnalisadorLexicoLA.ERRO) {
                        writer.write("Linha " + linha + ": " + texto + " - simbolo nao identificado");
                        // Quebra de linha \n
                        writer.newLine();
                        break;
                    }

                    // Verifica se houve erro: comentário não fechado
                    if (tipo == AnalisadorLexicoLA.ERRO_COMENT) {
                        writer.write("Linha " + linha + ": comentario nao fechado");
                        writer.newLine();
                        break;
                    }

                    // Verifica se houve erro: cadeia literal não fechada
                    if (tipo == AnalisadorLexicoLA.ERRO_CADEIA) {
                        writer.write("Linha " + linha + ": cadeia literal nao fechada");
                        writer.newLine();
                        break;
                    }

                    // Formata saída diferente para identificadores, números e cadeias
                    // Para identificadores, números e cadeias:
                    // imprime o nome do tipo léxico (ex: IDENT, NUM_INT)
                    // Para os demais tokens (palavras-chave e operadores):
                    // imprime o próprio texto como tipo
                    if (tipo == AnalisadorLexicoLA.IDENT ||
                        tipo == AnalisadorLexicoLA.NUM_INT ||
                        tipo == AnalisadorLexicoLA.NUM_REAL ||
                        tipo == AnalisadorLexicoLA.CADEIA) {

                        // Para esses tipos, escreve o texto e o nome do tipo
                        writer.write("<'" + texto + "'," +
                                AnalisadorLexicoLA.VOCABULARY.getDisplayName(tipo) + ">");
                    } else {
                        // Para operadores e palavras-chave, escreve o texto como tipo também
                        writer.write("<'" + texto + "','" + texto + "'>");
                    }

                    writer.newLine();
                }
            }

        } catch (IOException e) {
            // Captura erros de leitura/escrita de arquivo
            System.err.println("Erro ao ler/escrever arquivo: " + e.getMessage());
        }
    }
}