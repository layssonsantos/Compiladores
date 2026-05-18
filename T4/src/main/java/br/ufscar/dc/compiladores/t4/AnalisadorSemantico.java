/**
 *
 * @author Laysson Santos da Silva - 800349
 * 
 * Analisador semântico.
 */
package br.ufscar.dc.compiladores.t4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.ufscar.dc.compiladores.t4.AnalisadorSemanticoLAParser.ProgramaContext;

public class AnalisadorSemantico {

    public static void main(String args[]) throws IOException {

        try (PrintWriter pw = new PrintWriter(new FileWriter(args[1]))) {
            try {
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
                SemanticoUtils.errosSemanticos.forEach((s) -> pw.println(s));
                pw.println("Fim da compilacao");
                pw.close();                
            } catch (RuntimeException e) {
            }
        }
    }
}