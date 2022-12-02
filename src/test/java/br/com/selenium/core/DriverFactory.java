package br.com.selenium.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import br.com.selenium.core.Propriedades;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch(Propriedades.browser) {
				case CHROME: driver = new ChromeDriver();break;
				case EDGE: driver = new EdgeDriver();break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));
		}
		return driver;
	}

	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null; 
		}
		
	}
}
