package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{

	
	//Declaration 
	@FindBy(className="product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;
	
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement mentuBtn;
	
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;
	
	
	//Initilization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getSortDropDown() {
		return sortDropDown;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}

	public WebElement getMentuBtn() {
		return mentuBtn;
	}
	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	

	//Business Library 
	// This function is written is because this is runtime data. we cannot find that element using POM 
	
	/*
	 * 	 This method will click on a dynamic product
	
	 */
	public void clickOnProduct(WebDriver driver, String productName)
	{
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	}
		
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainer()
	{
			cartContainerBtn.click();
	}

	
	/**
	 * This method will logout of Application
	 */
	
	public  void logoutApp()
	{
		mentuBtn.click();
		logoutLnk.click();
		
	}
	
	
	public void clickOnLowestPriceProduct(WebDriver driver, String sortopt, String productName)
	{
		handleDropdownByText(sortDropDown, sortopt);
		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	}
	
}
