import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

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
	public void deveInteragirComAlertSimples() {
		page.botaoAlert();
		String texto = dsl.alertObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
		page.nome(texto);
	}

	@Test
	public void deveInteragirComConfirm() {
		page.botaoConfirm();
		Assert.assertEquals("Confirm Simples", dsl.alertObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertObterTextoEAceita());
	}

	@Test
	public void deveInteragirNegandoConfirm() {
		page.botaoConfirm();
		Assert.assertEquals("Confirm Simples", dsl.alertObterTextoERecusa());
		Assert.assertEquals("Negado", dsl.alertObterTextoEAceita());
	}

	@Test
	public void deveInteragirComPrompt() {
		page.botaoPrompt();
		Assert.assertEquals("Digite um numero", dsl.alertObterTexto());
		dsl.alertObterTextoEDigitarEAceitar("33");
		Assert.assertEquals("Era 33?", dsl.alertObterTextoEAceita());
		Assert.assertEquals(":D",  dsl.alertObterTextoEAceita());
	}
}