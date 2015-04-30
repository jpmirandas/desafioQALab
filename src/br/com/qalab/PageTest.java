package br.com.qalab;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageTest {

	private WebDriver driver;
	private Page page;

	@Before
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.page = new Page(this.driver);
	}

	@Test
	public void test() {
		this.page.open();
		this.page.clickOnButtonStart();

		assertTrue(this.page.verifyText());
	}

	@After
	public void tearDown() throws Exception {
		this.driver.close();
		this.driver.quit();
	}

}
