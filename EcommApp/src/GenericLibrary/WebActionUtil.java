package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {
	
	WebDriver driver;
	long ETO;
	WebDriverWait wait;
	public WebActionUtil(WebDriver driver,long ETO) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.ETO = ETO;
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void clickOnElement(WebElement target) {
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
		
	}
	
	public void enterKeys(WebElement target,String keysToSend) {
		wait.until(ExpectedConditions.visibilityOf(target));
		target.clear();
		target.sendKeys(keysToSend);
	}
	
	public void selectDropDownListSelect(WebElement target,String text)
	{
		Select select = new Select(target);
		select.selectByVisibleText(text);
	}
	
	public void mouseHover(WebElement target)
	{
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}

}
