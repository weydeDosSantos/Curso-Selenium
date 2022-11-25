import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
		page.mudarFrame();
		page.botaoFrame();
		String msg = dsl.alertObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		dsl.mudarFocoParaFramePadrao();
		page.nome(msg);

	}

	@Test
	public void devoInteragirComJanelas() {
		page.botaoPopup();
		page.mudarfocoJanelaPopUp();
		page.textAreaDoPopUp("Deu certo");
		dsl.fecharJanela();
		dsl.mudarFocoJanelaEspecifica("");
		page.areaDeSugestoes("and now?");

	}

	@Test
	public void devoInteragirComJanelasSemTitulo() {
		page.mudarfocoJanelaPopUpDoMal();
		dsl.mudarFocoJanelaEspecifica((String) driver.getWindowHandles().toArray()[1]);
		page.textAreaDoPopUp("Deu certo");
		dsl.mudarFocoJanelaEspecifica((String) driver.getWindowHandles().toArray()[0]);
		page.areaDeSugestoes("E agora?");

	}
}