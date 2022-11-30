package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;
import static br.com.selenium.core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.core.DriverFactory;
import br.com.selenium.core.Dsl;

public class TesteSicronismo {

	private Dsl dsl;

	@Before
	public void inicializa() {

		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new Dsl();
	}

	@After
	public void quitar() {
		killDriver();
	}

	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dsl.escreve("novoCampo", "Deu certo?");
	}

	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("novoCampo")));
		dsl.escreve("novoCampo", "Deu certo?");
	}
}
