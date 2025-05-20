package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {

	/*
	 * This method will maximize window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/*
	 * This method will minimize window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/*
	 * This method add 10 seconds of implicitly wait
	 * 
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/*
	 * This method will wait for 5 secs for element to be visible
	 * 
	 * @param driver
	 * 
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * This method will wait for 5 secs for element to be clickable
	 * 
	 * @param driver
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/*
	 * This method will handle dropdown by Index
	 * 
	 * @param element
	 * 
	 * @param index
	 */

	public void handleDropdownByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/*
	 * This method will handle dropdown by value
	 * 
	 * @param element
	 * 
	 * @param value
	 */

	public void handleDropdownByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/*
	 * This method will handle dropdown by Visible Text
	 * 
	 * @param element
	 * 
	 * @param text
	 */

	public void handleDropdownByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/*
	 * This perform will perform mouse hover action
	 * 
	 * @param driver
	 * 
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	/*
	 * This perform will perform double click action
	 * 
	 * @param driver
	 * 
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/*
	 * This perform will perform drag and drop action
	 * 
	 * @param driver
	 * 
	 * @param element
	 */
	public void dragDrop(WebDriver driver, WebElement srsEle, WebElement destEle) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srsEle, destEle).perform();
	}

	/*
	 * This perform will perform scroll action
	 * 
	 * @param driver
	 * 
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();

	}
	
	/*
	 * This perform will handle frame action
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrameAction(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/*
	 * This perform will handle frame action by ID
	 * @param driver
	 * @param frameID
	 */
	public void handleFrameIDAction(WebDriver driver, int frameID)
	{
		driver.switchTo().frame(frameID);
	}
	
	/*
	 * This perform will handle frame action by webelement
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrameWebEleAction(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/*
	 * This perform will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/*
	 * This perform will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/*
	 * This perform will enter to the alert popup
	 * @param driver
	 */
	public void getAlertText(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/*
	 * This perform will capture text from the alert popup
	 * @param driver
	 */
	public String getAlertTest(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/*
	 * This perform will switch from one window to another
	 * @param driver
	 * @param windowID
	 */
	public void handleWindow(WebDriver driver,String windowID)
	{
		driver.switchTo().window(windowID);
	}
	
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/ScreenShots"+screenshotName+".png");
		FileHandler.copy(src, dest);
		
		return dest.getAbsolutePath();  //Forextentreport
	}
	
}
