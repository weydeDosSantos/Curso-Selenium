package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;
import static br.com.selenium.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.selenium.core.Dsl;

public class TestePrimeCombo {

	private Dsl dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=9ae68");
		dsl = new Dsl();
	}

	@After
	public void quitar() {
		killDriver();
	}

	@Test
	public void combo() {
		dsl.selecionarComboPrime("j_idt343:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt343:option_label"));
	}
}
