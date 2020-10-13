package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import GenericLibrary.WebActionUtil;

public class ProductPage extends BasePage{
	
	@FindBy(className = "icon-plus")
	private WebElement plusButton;
	
	@FindBy(className = "icon-minus")
	private WebElement minusButton;
	
	@FindBy(id = "group_1")
	private WebElement sizeDropdown;
	
	@FindBy(name = "White")
	private WebElement whiteColorButton;
	
	@FindBy(name = "Yellow")
	private WebElement yellowColorButton;
	
	@FindBy(name = "Blue")
	private WebElement blueColorButton;
	
	@FindBy(name = "Orange")
	private WebElement orangeColorButton;
	
	@FindBy(name = "Green")
	private WebElement greenColorButton;
	
	@FindBy(name = "Submit")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")	
	private WebElement proceedToCheckOutButton;
	
	@FindBy(xpath="//span[contains(.,'Continue shopping')]")	
	private WebElement continueShopButton;
	
	@FindBy(className = "cross")	
	private WebElement closePopUp;

	public ProductPage(WebDriver driver,WebActionUtil webactionutil) {
		super(driver,webactionutil);
	}
	
	public void clickPlusButton(int count)
	{
		for(int i = 1;i<=count;i++)
		{
			webactionutil.clickOnElement(plusButton);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void clickMinusButton(int count)
	{
		for(int i = 1;i<=count;i++)
		{
			webactionutil.clickOnElement(minusButton);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void selectSize(String sizeText)
	{
		webactionutil.selectDropDownListSelect(sizeDropdown, sizeText);
	}
	
	public void selectColor(String color)
	{
		switch(color)
		{
			case "White":webactionutil.clickOnElement(whiteColorButton);
						break;
			case "Yellow":webactionutil.clickOnElement(yellowColorButton);
						break;
			case "Orange":webactionutil.clickOnElement(orangeColorButton);
						break;
			case "Blue":webactionutil.clickOnElement(blueColorButton);
						break;
			case "Green":webactionutil.clickOnElement(greenColorButton);
						break;
			default:Reporter.log("color not present",true);
		}
	}
	
	public OrderPage clickOnProceedToCheckOut()
	{
		webactionutil.clickOnElement(proceedToCheckOutButton);
		return new OrderPage(driver,webactionutil);
	}
	
	public void clickOnContinueToShopping()
	{
		webactionutil.clickOnElement(continueShopButton);
	}
	
	public void closePopUp()
	{
		webactionutil.clickOnElement(closePopUp);
	}
	
	public void clickOnAddToCart()
	{
		webactionutil.clickOnElement(addToCartButton);
		
	}
	

}
