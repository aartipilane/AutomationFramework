package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class S3_AddProductUsingUtilityFile {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Create Object of all Utilities
		FileUtility fUtility = new FileUtility();
		JavaUtility jUtility = new JavaUtility();
		SeleniumUtility sUtility = new SeleniumUtility();

		// Read Common data using File Utility
		String url = fUtility.readDataFromPropertyFile("url");
		String username = fUtility.readDataFromPropertyFile("username");
		String password = fUtility.readDataFromPropertyFile("password");

		// Read the data from excel file using File Utility
		String productName = fUtility.readDataFromExcel("Sheet1", 1, 2);

		// Launch brouser and load the url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		sUtility.maximizeWindow(driver);
		sUtility.addImplicitlyWait(driver);
		driver.get(url);

		//Add Details
//		driver.findElement(By.id("user-name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id("login-button")).click();

//		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameText().sendKeys(username);
//		lp.getPasswordText().sendKeys(password);
//		lp.getLoginBtn().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		
		
		
		// login successfully
		boolean result = driver.findElement(By.className("title")).isDisplayed();
		System.out.println(result);

		// click on product and add to cart
		WebElement product= driver.findElement(By.xpath("//div[text()='" + productName + "']"));
		String productName1 = product.getText();
		product.click();
		

		driver.findElement(By.id("shopping_cart_container")).click();

		// validate the product in the cart
		String productCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productCart.equals(productName1)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		// checkout
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Aarti");
		driver.findElement(By.id("last-name")).sendKeys("P");
		driver.findElement(By.id("postal-code")).sendKeys("788888");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();

		//Capture Screenshot
		String screenShotName = "addProductToCart-"+jUtility.getSystemDate();
		String path = sUtility.captureScreenShot(driver, screenShotName);
		System.out.println(path);
		
		System.out.println("Product order successfully");
		driver.findElement(By.id("back-to-products")).click();

		driver.findElement(By.id("react-burger-menu-btn")).click();

		// Logout
		driver.findElement(By.id("logout_sidebar_link")).click();

		Thread.sleep(5000);
		driver.quit();

	}
}
