import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dsl {

	private WebDriver driver;

	public Dsl(WebDriver driver) {
		this.driver = driver;
	}

	/********* escreve ***********/
	public void escreve(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);

	}

	public void escreve(By by, String texto) {
		driver.findElement(by).sendKeys(texto);

	}

	/********* escreve ***********/

	/********* clica ***********/

	public void clicarRadio(String id_radio) {
		driver.findElement(By.id(id_radio)).click();

	}

	public void clicarRadioby(By by) {
		driver.findElement(by).click();

	}

	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();

	}

	/********* clica ***********/

	/********* obtêm ***********/

	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();

	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	/********* obtêm ***********/

	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void selecionarComboby(By by, String valor) {
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void selecionarComboPrime(String radical,String valor) {
		clicarRadioby(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadioby(By.xpath("//ul[@id='"+radical+"_items']/li[.='"+valor+"']"));
	}

	public String alertObterTextoEDigitarEAceitar(String num) {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.sendKeys(num);
		alert.accept();
		return valor;
	}

	public String alertObterTextoEAceita() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public String alertObterTextoERecusa() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public String alertObterTexto() {
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		return valor;
	}

	public void mudarFocoParaFrameEspecifico(String frame) {
		driver.switchTo().frame(frame);

	}

	public void mudarFocoParaFramePadrao() {
		driver.switchTo().defaultContent();

	}

	public void mudarFocoJanelaEspecifica(String id) {
		driver.switchTo().window(id);

	}

	public void fecharJanela() {
		driver.close();
	}

	public void ClicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// PROCURAR COLUNA DO REGISTRO
		WebElement tabela = driver.findElement(By.xpath("//table[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		// ENCONTRAR A LINHA DO REGISTRO
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		// PROCURAR COLUNA DO BOTAO
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		// CLICAR NO BOTAO DA CELULA ENCONTRADA
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		celula.findElement(By.xpath(".//input")).click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}

		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}

		}
		return idColuna;
	}
}
