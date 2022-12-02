package br.com.selenium.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.selenium.test.TesteCadastro;
import br.com.selenium.test.TesteCampoTreinamento;
import br.com.selenium.test.TesteRegrasCadastro;
import br.com.selenium.core.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class,
	
})
public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}
