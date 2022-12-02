package br.com.selenium.test;
import static br.com.selenium.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.selenium.core.Dsl;
import br.com.selenium.page.CampoTreinamentoPage;
import br.com.selenium.core.DriverFactory;

public class TesteFrameEJanelas {

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
		DriverFactory.killDriver();
	}

	@Test
	public void devoInteragirComFrames() {
		page.mudarFrame();
		page.botaoFrame();
		String msg = dsl.alertObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		dsl.mudarFocoParaFramePadrao();
		page.nome(msg);

	}

	@Test
	public void devoInteragirComJanelas() {
		page.botaoPopup();
		page.mudarfocoJanelaPopUp();
		page.textAreaDoPopUp("Deu certo");
		dsl.fecharJanela();
		dsl.mudarFocoJanelaEspecifica("");
		page.areaDeSugestoes("and now?");

	}

	@Test
	public void devoInteragirComJanelasSemTitulo() {
		page.mudarfocoJanelaPopUpDoMal();
		dsl.mudarFocoJanelaEspecifica((String) getDriver().getWindowHandles().toArray()[1]);
		page.textAreaDoPopUp("Deu certo");
		dsl.mudarFocoJanelaEspecifica((String) getDriver().getWindowHandles().toArray()[0]);
		page.areaDeSugestoes("E agora?");

	}
}