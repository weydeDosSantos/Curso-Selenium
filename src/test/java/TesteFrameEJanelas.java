import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrameEJanelas {

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
	public void devoInteragirComFrames() {
		dsl.mudarFocoParaFrameEspecifico("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		dsl.mudarFocoParaFramePadrao();
		dsl.escreve("elementosForm:nome", msg);

	}

	@Test
	public void devoInteragirComJanelas() {
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.mudarFocoJanelaEspecifica("Popup");
		dsl.escreve(By.tagName("textarea"), "Deu certo");
		dsl.fecharJanela();
		dsl.mudarFocoJanelaEspecifica("");
		dsl.escreve(By.tagName("textarea"), "and now?");

	}

	@Test
	public void devoInteragirComJanelasSemTitulo() {
		dsl.clicarBotao("buttonPopUpHard");
		dsl.mudarFocoJanelaEspecifica((String)driver.getWindowHandles().toArray()[1]);
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		dsl.mudarFocoJanelaEspecifica((String)driver.getWindowHandles().toArray()[0]);
		dsl.escreve(By.tagName("textarea"), "E agora?");



	}
}