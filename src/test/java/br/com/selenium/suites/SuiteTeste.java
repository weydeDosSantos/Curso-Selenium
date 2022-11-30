package br.com.selenium.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.selenium.test.TesteCadastro;
import br.com.selenium.test.TesteCampoTreinamento;
import br.com.selenium.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class
	
})
public class SuiteTeste {

}
