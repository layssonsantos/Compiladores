// Generated from br/ufscar/dc/compiladores/t3/AnalisadorSemanticoLA.g4 by ANTLR 4.13.1
package br.ufscar.dc.compiladores.t3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnalisadorSemanticoLAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnalisadorSemanticoLAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(AnalisadorSemanticoLAParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(AnalisadorSemanticoLAParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(AnalisadorSemanticoLAParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(AnalisadorSemanticoLAParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(AnalisadorSemanticoLAParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(AnalisadorSemanticoLAParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(AnalisadorSemanticoLAParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(AnalisadorSemanticoLAParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(AnalisadorSemanticoLAParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(AnalisadorSemanticoLAParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(AnalisadorSemanticoLAParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(AnalisadorSemanticoLAParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(AnalisadorSemanticoLAParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(AnalisadorSemanticoLAParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(AnalisadorSemanticoLAParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(AnalisadorSemanticoLAParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(AnalisadorSemanticoLAParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(AnalisadorSemanticoLAParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(AnalisadorSemanticoLAParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(AnalisadorSemanticoLAParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(AnalisadorSemanticoLAParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(AnalisadorSemanticoLAParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(AnalisadorSemanticoLAParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(AnalisadorSemanticoLAParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(AnalisadorSemanticoLAParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(AnalisadorSemanticoLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(AnalisadorSemanticoLAParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(AnalisadorSemanticoLAParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(AnalisadorSemanticoLAParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(AnalisadorSemanticoLAParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(AnalisadorSemanticoLAParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(AnalisadorSemanticoLAParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(AnalisadorSemanticoLAParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(AnalisadorSemanticoLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(AnalisadorSemanticoLAParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(AnalisadorSemanticoLAParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(AnalisadorSemanticoLAParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(AnalisadorSemanticoLAParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(AnalisadorSemanticoLAParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(AnalisadorSemanticoLAParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(AnalisadorSemanticoLAParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(AnalisadorSemanticoLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(AnalisadorSemanticoLAParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(AnalisadorSemanticoLAParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(AnalisadorSemanticoLAParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(AnalisadorSemanticoLAParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(AnalisadorSemanticoLAParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(AnalisadorSemanticoLAParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(AnalisadorSemanticoLAParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(AnalisadorSemanticoLAParser.Op_logico_2Context ctx);
}