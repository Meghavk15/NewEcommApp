package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.WebActionUtil;

public class LoginPage extends BasePage {
	
	@FindBy(partialLinkText = "Sign in")
	private WebElement signinButton;
	
	@FindBy(id = "email")
	private WebElement emailid;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement loginButton;

	public LoginPage(WebDriver driver,WebActionUtil webactionutil) {
		// TODO Auto-generated constructor stub
		super(driver,webactionutil);
	}
	
	public void login(String un,String pwd) {
		webactionutil.clickOnElement(signinButton);
		webactionutil.enterKeys(emailid, un);
		webactionutil.enterKeys(password, pwd);
		webactionutil.clickOnElement(loginButton);
	}

}
