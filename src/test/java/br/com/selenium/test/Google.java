package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;
import static br.com.selenium.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Google {
	

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void quitar() {
		killDriver();
	}
	
	@Test
	public void test(){
	
		getDriver().get("http://www.google.com.br");
	Assert.assertEquals("Google", getDriver().getTitle());

	}
}
