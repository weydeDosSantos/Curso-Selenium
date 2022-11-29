import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {

	private WebDriver driver = new ChromeDriver();
	private Dsl dsl;

	@Before
	public void inicializa() {
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=7f756");
		dsl = new Dsl(driver);
	}

	@After
	public void quitar() {
		driver.quit();
	}

	@Test
	public void deveInteragirComRadio() {
		dsl.clicarRadioby(By.xpath("//input[@id='j_idt344:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt344:console:0"));
	}

	
}
