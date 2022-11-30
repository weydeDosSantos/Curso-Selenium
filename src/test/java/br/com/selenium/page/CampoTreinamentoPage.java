package br.com.selenium.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.selenium.core.BasePage;
import br.com.selenium.core.Dsl;

public class CampoTreinamentoPage extends BasePage{

	

	/************ escrever ***********/

	public void nome(String nome) {
		dsl.escreve("elementosForm:nome", nome);

	}

	public void sobreNome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);

	}

	public void areaDeSugestoes(String sugestao) {
		dsl.escreve("elementosForm:sugestoes", sugestao);

	}

	public void textAreaDoPopUp(String texto) {
		dsl.escreve(By.tagName("textarea"), texto);

	}

	/************ escrever ***********/

	/************ clica ***********/

	public void botaoPopup() {
		dsl.clicarBotao("buttonPopUpEasy");

	}

	public void sexoMasculino() {
		dsl.clicarRadio(("elementosForm:sexo:0"));

	}

	public void sexoFeminino() {
		dsl.clicarRadio(("elementosForm:sexo:1"));

	}

	public void comidaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");

	}

	public void comidaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");

	}

	public void cadastra() {
		dsl.clicarBotao("elementosForm:cadastrar");

	}

	public void botaoCliqueMe() {
		dsl.clicarBotao("buttonSimple");

	}

	public void botaoConfirm() {
		dsl.clicarBotao("confirm");

	}

	public void botaoPrompt() {
		dsl.clicarBotao("prompt");

	}

	/************ clica ***********/

	/************ combo ***********/

	public void escolaridade(String... valores) {
		for (String valor : valores)
			dsl.selecionarCombo("elementosForm:escolaridade", valor);

	}

	public void esportes(String... valores) {
		for (String valor : valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);

	}

	/************ combo ***********/

	/************ obter ***********/
	public String obterValueCampoNome() {
		return dsl.obterValorCampo("elementosForm:nome");
	}

	public String obterSugestoesFeitas() {
		return dsl.obterValorCampo("elementosForm:sugestoes");

	}

	public String obterResultadoCadstro() {
		return dsl.obterTexto("resultado");
	}

	public String obterNomeCadastro() {
		return dsl.obterTexto("descNome");
	}

	public String obterSobrenomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}

	public String obterSexoCadastro() {
		return dsl.obterTexto(By.id("descSexo"));
	}

	public String obterComidaCadastro() {
		return dsl.obterTexto(By.id("descComida"));
	}

	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto(By.id("descEscolaridade"));
	}

	public String obterEsporteCadastro() {
		return dsl.obterTexto(By.id("descEsportes"));
	}

	/************ obter ***********/

	/************ boleanos ***********/

	public boolean retornarRadioMasculino() {
		return dsl.isRadioMarcado("elementosForm:sexo:0");
	}

	public boolean retornarRadioCarne() {
		return dsl.isRadioMarcado("elementosForm:comidaFavorita:0");
	}

	/************ boleanos ***********/

	/************ frames ***********/

	public void mudarFrame() {
		dsl.mudarFocoParaFrameEspecifico("frame1");

	}

	public void botaoFrame() {
		dsl.clicarBotao("frameButton");

	}

	/************ janelas ***********/

	public void mudarfocoJanelaPopUp() {
		dsl.mudarFocoJanelaEspecifica("Popup");

	}

	public void mudarfocoJanelaPopUpDoMal() {
		dsl.clicarBotao("buttonPopUpHard");
	}

	/************ janelas ***********/

	public void botaoAlert() {
		dsl.clicarBotao("alert");

	}
}
