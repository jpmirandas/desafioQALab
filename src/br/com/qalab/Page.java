package br.com.qalab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class interacts with the webpage
 * http://the-internet.herokuapp.com/dynamic_loading/1
 * 
 * @author jpmirandas
 *
 */
public class Page {

	private static final By START_BUTTON = By.cssSelector("button");
	private static final By TEXT_ID = By.id("finish");
	private WebDriver driver;

	/**
	 * Create a new Page object.
	 * 
	 * @param driver
	 *            Webdriver.
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Open the web page.
	 */
	public void open() {
		this.driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		waitForElement(START_BUTTON);
	}

	/**
	 * Click on the Start button.
	 */
	public void clickOnButtonStart() {
		this.driver.findElement(START_BUTTON).click();
	}

	/**
	 * Verify is the text Hello World! is displayed.
	 * 
	 * @return TRUE is the text is displayed, FALSE otherwise.
	 */
	public boolean verifyText() {
		waitForElement(TEXT_ID);
		String text = this.driver.findElement(TEXT_ID).getText();

		return text.equals("Hello World!");
	}

	/**
	 * Wait for By element.
	 * 
	 * @param By
	 *            objected to be waited.
	 */
	private void waitForElement(By element) {
		(new WebDriverWait(this.driver, 20))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.findElement(element).isDisplayed();
					}
				});
	}
}
