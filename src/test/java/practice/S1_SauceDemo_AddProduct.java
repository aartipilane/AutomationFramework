package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S1_SauceDemo_AddProduct {

	public static void main(String[] args) throws InterruptedException, IOException {

		FileInputStream fis= new FileInputStream("/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/src/test/resources/CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		FileInputStream fis1= new FileInputStream("/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/src/test/resources/ProductData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		String productName = cell.getStringCellValue();
		
		//Launch browser and load the url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		// login successfully
		boolean result = driver.findElement(By.className("title")).isDisplayed();
		System.out.println(result);

		// click on product and add to cart
		WebElement product = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
		String productName1 = product.getText();
		product.click();
		driver.findElement(By.id("add-to-cart")).click();

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

		System.out.println("Product order successfully");
		driver.findElement(By.id("back-to-products")).click();

		driver.findElement(By.id("react-burger-menu-btn")).click();

		// Logout
		driver.findElement(By.id("logout_sidebar_link")).click();

		Thread.sleep(5000);
		driver.quit();

	}

}
