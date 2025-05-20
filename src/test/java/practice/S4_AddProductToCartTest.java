package practice;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class S4_AddProductToCartTest {

	public static void main(String[] args) throws IOException {
		
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
					String sortOption = fUtility.readDataFromExcel("Sheet1", 4, 2);

					// Launch brwuser and load the url
					WebDriverManager.chromedriver().setup();
					ChromeDriver driver = new ChromeDriver();
					sUtility.maximizeWindow(driver);
					sUtility.addImplicitlyWait(driver);
					driver.get(url);
					
					//Login to Application
					LoginPage lp = new LoginPage(driver);
					lp.loginToApp(username, password);
					
					//Click on product
					InventoryPage ip = new InventoryPage(driver);
					ip.clickOnProduct(driver,productName);
					//Click on add to cart
					InventoryItemPage iip = new InventoryItemPage(driver);
					iip.clickOnAddToCartBtn();
					
					//Navigate to Cart
					ip.clickOnCartContainer();
					
					//Validate the product in Cart
					CartPage cp = new CartPage(driver);
					String productInCart = cp.captureName();
					if(productInCart.equals(productName))
					{
						System.out.println("Pass");
						System.out.println(productInCart);
					}
					else
					{
						System.out.println("Fail");
					}
					
					//Logout to App
					ip.logoutApp();
					
	}

}
