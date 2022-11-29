import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

	private WebDriver driver = new ChromeDriver();
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void quitar() {
		//driver.quit();
	}

	@Test
	public void devoRealizarCadastro() {
		page.nome("Afonso");
		page.sobreNome("cristopis");
		page.sexoMasculino();
		page.comidaCarne();
		page.escolaridade("Superior");
		page.esportes("Futebol");
		page.cadastra();

		Assert.assertTrue(page.obterResultadoCadstro().startsWith("Cadastrado!"));
		Assert.assertEquals("Nome: Afonso", page.obterNomeCadastro());
		Assert.assertEquals("Sobrenome: cristopis", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Carne", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastro());
	}
}
