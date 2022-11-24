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

	public void escreve(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);

	}

	public void escreve(By by, String texto) {
		driver.findElement(by).sendKeys(texto);

	}

	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	public void clicarRadio(String id_radio) {
		driver.findElement(By.id(id_radio)).click();

	}

	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();

	}

	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();

	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
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
}
