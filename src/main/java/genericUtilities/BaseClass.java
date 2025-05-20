package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass {

	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();
	public  WebDriver driver;

	//For listeners
	public static  WebDriver sdriver;
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("---- Database Connection Successful----");
	}
	
	@BeforeClass
//	@Parameters("browser")
//	@BeforeTest
	//public void bcConfig(String browserN) throws IOException
	public void bcConfig() throws IOException
	{
		String url = fUtil.readDataFromPropertyFile("url");
		
		
		//For cross browser  execution - Runtime  polymorphism -driver
//		if(browserN.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//
//		}
//		else if(browserN.equals("edge"))
//		{
//			driver = new EdgeDriver();
//
//		}
//		else if(browserN.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//
//		}
		driver = new ChromeDriver();

		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(url);
		
		//for listener
		sdriver=driver;
		
		System.out.println("--- Browser Launch Successful---");
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String userName = fUtil.readDataFromPropertyFile("username");
		String password = fUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(userName, password);
		
		System.out.println("--- Login to App Successfull ---");
	}
	
	@AfterMethod
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutApp();
		
		System.out.println("--- Logout to App Successful ---");
	}
	
	@AfterTest
	public void acConfig()
	{
		driver.quit();
		System.out.println("--- Browser close successful ---");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("--- Database connection close ---");
	}
	
	
	
	
	
	
	
}
