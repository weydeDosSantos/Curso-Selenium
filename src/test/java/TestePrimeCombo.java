import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrimeCombo {

	private WebDriver driver = new ChromeDriver();
	private Dsl dsl;

	@Before
	public void inicializa() {
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=9ae68");
		dsl = new Dsl(driver);
	}

	@After
	public void quitar() {
		driver.quit();
	}
	@Test
	public void combo() {
		dsl.selecionarComboPrime("j_idt343:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt343:option_label"));
	}
}
