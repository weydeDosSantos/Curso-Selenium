package br.com.selenium.test;

import static br.com.selenium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.selenium.core.BaseTest;
import br.com.selenium.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest{

	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {

		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@Test
	public void devoRealizarCadastro() {
		page.nome("Afonso");
		page.sobreNome("cristopis");
		page.sexoMasculino();
		page.comidaCarne();
		page.escolaridade("Superior");
		page.esportes("Futebol");
		page.cadastra();

		Assert.assertTrue(page.obterResultadoCadstro().startsWith("Cadastrado!"));
		Assert.assertEquals("Nome: Afonso", page.obterNomeCadastro());
		Assert.assertEquals("Sobrenome: cristopis", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Carne", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastro());
	}
}
