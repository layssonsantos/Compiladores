/**
 *
 * @author Laysson Santos da Silva - 800349
 * 
 * Gerador de código para a linguagem LA.
 */
package br.ufscar.dc.compiladores.t5;

import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.ufscar.dc.compiladores.t5.AnalisadorSemanticoLAParser.ProgramaContext;

public class T5 {

    public static void main(String args[]) throws IOException {

        CharStream cs = CharStreams.fromFileName(args[0]);

        // Inicialização do analisador léxico.
        AnalisadorSemanticoLALexer lexer = new AnalisadorSemanticoLALexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Inicialização do analisador sintático.
        AnalisadorSemanticoLAParser parser = new AnalisadorSemanticoLAParser(tokens);
        ProgramaContext arvore = parser.programa();
        Semantico semantico = new Semantico();

        // Inicialização do programa.
        semantico.visitPrograma(arvore);

        // Verifica a existência de erros, imprime todos os que foram identificados
        SemanticoUtils.errosSemanticos.forEach((s) -> System.out.println(s));

        // Caso não tenham erros no programa, é gerado o código em C equivalente.
        if (SemanticoUtils.errosSemanticos.isEmpty()) {
            GeradorC gera = new GeradorC();
            gera.visitPrograma(arvore); 

            try (PrintWriter pw = new PrintWriter(args[1])) {
                pw.print(gera.saida.toString());
            }
        }
    }
}