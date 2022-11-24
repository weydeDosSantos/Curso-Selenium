import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private Dsl dsl;

	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new Dsl(driver);
	}

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

	/************ escrever ***********/

	/************ clica ***********/

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

	public String obterValueCampoNome() {
		return dsl.obterValorCampo("elementosForm:nome");
	}

	public boolean retornarRadioMasculino() {
		return dsl.isRadioMarcado("elementosForm:sexo:0");
	}

	public String obterSugestoesFeitas() {
		return dsl.obterValorCampo("elementosForm:sugestoes");

	}

	public boolean retornarRadioCarne() {
		return dsl.isRadioMarcado("elementosForm:comidaFavorita:0");
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

}
