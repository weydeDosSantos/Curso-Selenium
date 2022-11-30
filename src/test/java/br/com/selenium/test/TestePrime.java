package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;
import static br.com.selenium.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.selenium.core.Dsl;

public class TestePrime {

	private Dsl dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=7f756");
		dsl = new Dsl();
	}

	@After
	public void quitar() {
		killDriver();

	}

	@Test
	public void deveInteragirComRadio() {
		dsl.clicarRadioby(By.xpath("//input[@id='j_idt344:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt344:console:0"));
	}

	
}
