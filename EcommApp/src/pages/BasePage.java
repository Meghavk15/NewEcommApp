package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebActionUtil;

public class BasePage {
	
	public WebDriver driver;
	public WebActionUtil webactionutil;
	public BasePage(WebDriver driver,WebActionUtil webactionutil) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.webactionutil = webactionutil;
		PageFactory.initElements(driver, this);
		
	}

}
