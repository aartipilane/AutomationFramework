package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(className="inventory_item_name")
	private WebElement itemName;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	@FindBy(className="inventory_item_price")
	private WebElement priceField;
	
	@FindBy(id = "first-name")
	private WebElement firstNText;

	@FindBy(id = "last-name")
	private WebElement lastNText;

	@FindBy(id = "postal-code")
	private WebElement postalCText;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}


	public WebElement getFirstNText() {
		return firstNText;
	}


	public WebElement getLastNText() {
		return lastNText;
	}


	public WebElement getPostalCText() {
		return postalCText;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}


	public WebElement getFinishBtn() {
		return finishBtn;
	}


	public WebElement getPriceField() {
		return priceField;
	}
	
	
	
	public WebElement getItemName() {
		return itemName;
	}


	/*
	 * This method will capture product name and return to caller
	 */
	public String captureName()
	{
		return itemName.getText();
	}
	
//	public void clickOnRemoveBtn()
//	{
//		removeBtn.click();
//	}
}
