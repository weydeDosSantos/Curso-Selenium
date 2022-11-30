package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;
import static br.com.selenium.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.selenium.core.Dsl;
import br.com.selenium.page.CampoTreinamentoPage;

public class RegraDeNegocioTest {

	private Dsl dsl;
	private CampoTreinamentoPage page;
	
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new Dsl();
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void quitar() {
		killDriver();
	}

	@Test
	public void nomeDeveSerInformado() {
		
		page.cadastra();
		//String texto = dsl.alertObterTextoEAceita();
		Assert.assertEquals("Nome eh obrigatorio",dsl.alertObterTextoEAceita());
	}

	@Test
	public void sobreNomeDeveSerInformado() {
		page.nome("taciano");
		page.cadastra();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertObterTextoEAceita());

	}

	@Test
	public void deveValidarComidaVegetariano() {
		page.nome("taciano");
		page.sobreNome("junior");
		page.sexoMasculino();
		page.comidaCarne();
		page.comidaVegetariano();
		page.cadastra();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertObterTextoEAceita());

	}

	@Test
	public void deveValidarEsportistaIndeciso() {
		
		page.nome("taciano");
		page.sobreNome("junior");
		page.sexoMasculino();
		page.comidaCarne();
		page.esportes("Futebol","O que eh esporte?");
		page.cadastra();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertObterTextoEAceita());


	}
}