package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class LoginPage {
	
	public WebDriver ldriver;
	
	WaitHelper waitHelper;

		public LoginPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(ldriver, this);
			waitHelper = new WaitHelper(ldriver); 
		}


	@FindBy(xpath="//button[@class='cookie-popup-with-overlay__button']")
	@CacheLookup
	WebElement cookieBtn;

	@FindBy(xpath="//span[@class='ry-header__menu-item-title ng-star-inserted' and contains(text(),'Log in')]")
	@CacheLookup
	WebElement linkLogin;

	@FindBy(xpath="//input[@name='email']")
	@CacheLookup
	WebElement inputEmail;

	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement inputPassword;

	@FindBy(xpath= "//button[@type='submit' and contains(text(),'Log in')]")
	@CacheLookup
	WebElement loginBtn;

	public void clickCookieLink()
	{
		waitHelper.WaitForElement(cookieBtn, 30);
	    cookieBtn.click();	
	}


	public void clickLoginLink()
	{
		waitHelper.WaitForElement(linkLogin, 30);
	    linkLogin.click();	
	}

	public void setUserName(String username)
	{
		waitHelper.WaitForElement(inputEmail, 30);
		inputEmail.clear();
		inputEmail.sendKeys(username);
	}

	public void setPassword(String pwd)

	{
	   waitHelper.WaitForElement(inputPassword, 30);
	   inputPassword.clear();
	   inputPassword.sendKeys(pwd);
	}


	public void clickLoginButton()
	{
		waitHelper.WaitForElement(loginBtn, 30);
	    loginBtn.click();	
	}

}
