package br.com.selenium.core;

import static br.com.selenium.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {

	@After
	public void quitar() {
		killDriver();
	}
}
