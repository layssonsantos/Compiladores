// Generated from br/ufscar/dc/compiladores/t3/AnalisadorSemanticoLA.g4 by ANTLR 4.13.1
package br.ufscar.dc.compiladores.t3;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnalisadorSemanticoLAParser}.
 */
public interface AnalisadorSemanticoLAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(AnalisadorSemanticoLAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(AnalisadorSemanticoLAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(AnalisadorSemanticoLAParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(AnalisadorSemanticoLAParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(AnalisadorSemanticoLAParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(AnalisadorSemanticoLAParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(AnalisadorSemanticoLAParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(AnalisadorSemanticoLAParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(AnalisadorSemanticoLAParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(AnalisadorSemanticoLAParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(AnalisadorSemanticoLAParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(AnalisadorSemanticoLAParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(AnalisadorSemanticoLAParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(AnalisadorSemanticoLAParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(AnalisadorSemanticoLAParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(AnalisadorSemanticoLAParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(AnalisadorSemanticoLAParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(AnalisadorSemanticoLAParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(AnalisadorSemanticoLAParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(AnalisadorSemanticoLAParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(AnalisadorSemanticoLAParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(AnalisadorSemanticoLAParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(AnalisadorSemanticoLAParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(AnalisadorSemanticoLAParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(AnalisadorSemanticoLAParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(AnalisadorSemanticoLAParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(AnalisadorSemanticoLAParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(AnalisadorSemanticoLAParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(AnalisadorSemanticoLAParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(AnalisadorSemanticoLAParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(AnalisadorSemanticoLAParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(AnalisadorSemanticoLAParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(AnalisadorSemanticoLAParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(AnalisadorSemanticoLAParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(AnalisadorSemanticoLAParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(AnalisadorSemanticoLAParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(AnalisadorSemanticoLAParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(AnalisadorSemanticoLAParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(AnalisadorSemanticoLAParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(AnalisadorSemanticoLAParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(AnalisadorSemanticoLAParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(AnalisadorSemanticoLAParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(AnalisadorSemanticoLAParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(AnalisadorSemanticoLAParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(AnalisadorSemanticoLAParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(AnalisadorSemanticoLAParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(AnalisadorSemanticoLAParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(AnalisadorSemanticoLAParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(AnalisadorSemanticoLAParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(AnalisadorSemanticoLAParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(AnalisadorSemanticoLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(AnalisadorSemanticoLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(AnalisadorSemanticoLAParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(AnalisadorSemanticoLAParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(AnalisadorSemanticoLAParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(AnalisadorSemanticoLAParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(AnalisadorSemanticoLAParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(AnalisadorSemanticoLAParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(AnalisadorSemanticoLAParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(AnalisadorSemanticoLAParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(AnalisadorSemanticoLAParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(AnalisadorSemanticoLAParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(AnalisadorSemanticoLAParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(AnalisadorSemanticoLAParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(AnalisadorSemanticoLAParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(AnalisadorSemanticoLAParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(AnalisadorSemanticoLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(AnalisadorSemanticoLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(AnalisadorSemanticoLAParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(AnalisadorSemanticoLAParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(AnalisadorSemanticoLAParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(AnalisadorSemanticoLAParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(AnalisadorSemanticoLAParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(AnalisadorSemanticoLAParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(AnalisadorSemanticoLAParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(AnalisadorSemanticoLAParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(AnalisadorSemanticoLAParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(AnalisadorSemanticoLAParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(AnalisadorSemanticoLAParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(AnalisadorSemanticoLAParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(AnalisadorSemanticoLAParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(AnalisadorSemanticoLAParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(AnalisadorSemanticoLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(AnalisadorSemanticoLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(AnalisadorSemanticoLAParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(AnalisadorSemanticoLAParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(AnalisadorSemanticoLAParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(AnalisadorSemanticoLAParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(AnalisadorSemanticoLAParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(AnalisadorSemanticoLAParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(AnalisadorSemanticoLAParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(AnalisadorSemanticoLAParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(AnalisadorSemanticoLAParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(AnalisadorSemanticoLAParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(AnalisadorSemanticoLAParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(AnalisadorSemanticoLAParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(AnalisadorSemanticoLAParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(AnalisadorSemanticoLAParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link AnalisadorSemanticoLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(AnalisadorSemanticoLAParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link AnalisadorSemanticoLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(AnalisadorSemanticoLAParser.Op_logico_2Context ctx);
}