package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule1

	//Rule2
	//FindAll - Identify single web element  through multiple  locators,  OR operator
	@FindAll({@FindBy(id="user-name"),@FindBy(xpath="//input[@name='user-name']")})
	private WebElement usernameText1;
	
	//FindAll - Identify single web element  through multiple  locators,  AND operator
	@FindBys({@FindBy(id="user-name"),@FindBy(xpath="//input[@name='user-name']")})
	private WebElement userNameText2;
	
	@FindBy(id="user-name")
	private WebElement usernameText;
	
	@FindBy(name="password")
	private WebElement passwordText;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	//Rule3 - Utilization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule4 - Utilization
	public WebElement getUsernameText() {
		return usernameText;
	}

	public WebElement getPasswordText() {
		return passwordText;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/*
	 * This method will perform login operation 
	 * @param un
	 * @param pwd
	 */
	
	
	public void loginToApp(String un, String pwd)
	{
		usernameText.sendKeys(un);
		passwordText.sendKeys(pwd);
		loginBtn.click();
	}
	
	
}
