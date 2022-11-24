import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {

	public WebDriver driver = new ChromeDriver();
	public Dsl dsl;
	public CampoTreinamentoPage page;
	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter(value = 2)
	public String sexo;
	@Parameter(value = 3)
	public List<String> comidas;
	@Parameter(value = 4)
	public String[] esportes;
	@Parameter(value = 5)
	public String msg;

	@Before
	public void inicializa() {
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new Dsl(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void quitar() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> getColletion() {
		return Arrays.asList(new Object[][] {
					{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio" },
					{"Guga", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio" },
					{"Guga", "bregadeira", "Masculino", Arrays.asList("Carne","Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?" },
					{"Guga", "bregadeira", "Masculino", Arrays.asList("Carne"), new String[] {"Futebol","O que eh esporte?"}, "Voce faz esporte ou nao?" }
				
				});

	}

	@Test
	public void deveValidarRegras() {

		page.nome(nome);
		page.sobreNome(sobrenome);
		if (sexo.equals("Masculino")) {
			page.sexoMasculino();
		}
		if (sexo.equals("Feminino")) {
			page.sexoFeminino();
		}
		if (comidas.contains("Carne"))
			page.comidaCarne();
		if (comidas.contains("Vegetariano"))
			page.comidaVegetariano();

		page.esportes(esportes);
		page.cadastra();
		Assert.assertEquals(msg, dsl.alertObterTextoEAceita());

	}
}