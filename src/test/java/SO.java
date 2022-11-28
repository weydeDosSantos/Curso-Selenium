import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SO {

	private WebDriver driver = new ChromeDriver();

	
	@Before
	public void inicializa() {
		driver.manage().window().maximize();
		driver.get("https://www.bb.com.br/site");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void quitar() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='col-16 col-md-4 buttons']/button[.='Permitir todos']")).click();
		
		WebElement element = driver.findElement(By.id("cardBanner2127024762"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();
		//driver.findElement(By.xpath("//span[@class='menu-title ng-tns-c54-0']")).click();
		
		String texto = driver.findElement(By.xpath("//div[@class='message']")).getText();
		Assert.assertEquals("Aponte a câmera do seu celular para o código ao lado para baixar o App BB.", texto);
	}
}
