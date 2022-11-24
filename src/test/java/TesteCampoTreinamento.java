import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	private WebDriver driver = new ChromeDriver();
	private Dsl dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new Dsl(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void quitar() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		
		page.nome("teste de escrita");
		Assert.assertEquals("teste de escrita", page.obterValueCampoNome());
	}

	@Test
	public void devoInteragirComTextArea() {
		page.areaDeSugestoes("teste/nkkk/n/sadsad");
		Assert.assertEquals("teste/nkkk/n/sadsad", page.obterSugestoesFeitas());
	}

	@Test
	public void devoInteragirComRadioButton() {
		page.sexoMasculino();
		Assert.assertTrue(page.retornarRadioMasculino());

	}

	@Test
	public void devoInteragirComCheckBox() {
		page.comidaCarne();
		Assert.assertTrue(page.retornarRadioCarne());

	}

	@Test
	public void devoInteragirComCombo() {
		/*
		 * WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		 * Select combo = new Select(element); // Combo.selectByIndex(2); //
		 * combo.selectByValue("superior");
		 * combo.selectByVisibleText("2o grau completo");
		 */
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));

	}

	@Test
	public void devoVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
	}

	@Test
	public void devoVerificarValoresComboMultiplo() {
		page.esportes("Futebol","Corrida","O que eh esporte?");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

	}

	@Test
	public void deveInteragirComBotoes() {
		page.botaoCliqueMe();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

	}

	@Test
	public void deveInteragirComLink() {
		dsl.clicarLink("Voltar");
		assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}

	@Test
	public void deveBuscarTextosNaPagina() {
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				dsl.obterTexto(By.xpath("//span[@class='facilAchar']")));
	}
}