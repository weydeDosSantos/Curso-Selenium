import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegraDeNegocioTest {

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
	public void nomeDeveSerInformado() {
		
		page.cadastra();
		//String texto = dsl.alertObterTextoEAceita();
		Assert.assertEquals("Nome eh obrigatorio",dsl.alertObterTextoEAceita());
	}

	@Test
	public void sobreNomeDeveSerInformado() {
		page.nome("taciano");
		page.cadastra();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertObterTextoEAceita());

	}

	@Test
	public void deveValidarComidaVegetariano() {
		page.nome("taciano");
		page.sobreNome("junior");
		page.sexoMasculino();
		page.comidaCarne();
		page.comidaVegetariano();
		page.cadastra();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertObterTextoEAceita());

	}

	@Test
	public void deveValidarEsportistaIndeciso() {
		
		page.nome("taciano");
		page.sobreNome("junior");
		page.sexoMasculino();
		page.comidaCarne();
		page.esportes("Futebol","O que eh esporte?");
		page.cadastra();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertObterTextoEAceita());


	}
}