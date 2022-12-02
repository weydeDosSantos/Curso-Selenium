package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;
import static br.com.selenium.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.selenium.core.Dsl;

public class TesteAjax {

	private Dsl dsl;

	@Before
	public void inicializa() {

		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=67b64");
		dsl = new Dsl();
	}

	@After
	public void quitar() {
		killDriver();
	}

	@Test
	public void testeAjax() {
		dsl.escreve("j_idt343:name", "teste");
		dsl.clicarBotao("j_idt343:j_idt347");
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt343:display"), "teste")); 
		Assert.assertEquals("teste", dsl.obterTexto("j_idt343:display"));
	}

}
