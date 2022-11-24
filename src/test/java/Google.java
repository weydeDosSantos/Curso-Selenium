import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
	
	private WebDriver driver = new ChromeDriver();

	@Before
	public void inicializa() {
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void quitar() {
		driver.quit();
	}
	
	@Test
	public void test(){
	
	driver.get("http://www.google.com.br");
	Assert.assertEquals("Google", driver.getTitle());

	}
}
