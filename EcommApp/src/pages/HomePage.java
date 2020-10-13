package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.WebActionUtil;

public class HomePage extends BasePage {
	
	private String xpathForMoreButton = "//a[contains(@href,'product=id')]//span[text()='More']";
	
	@FindBy(className = "logout")
	private WebElement logoutButton;
	
	@FindBy(linkText = "Women")
	private WebElement womenLink;
	
	@FindBy(xpath = "(//a[text()='Dresses'])[2]")
	private WebElement dressesLink;
	
	@FindBy(xpath = "(//a[text()='T-shirts'])[2]")
	private WebElement tshirtsLink;
	
	@FindBy(id = "selectProductSort")
	private WebElement sortDropDown;
	
	@FindBy(linkText = "Grid")
	private WebElement gridView;
	
	@FindBy(linkText = "List")
	private WebElement listView;
	
	@FindBy(xpath = "//ul[@class='product_list grid row']/li")
	private List<WebElement> productList;
	
	public HomePage(WebDriver driver,WebActionUtil webactionutil) {
		super(driver,webactionutil);
	}
	
	public void clickOnLogout()
	{
		webactionutil.clickOnElement(logoutButton);
	}
	
	public void clickOnWomensLink()
	{
		webactionutil.clickOnElement(womenLink);
	}
	
	public void clickOnDressesLink()
	{
		webactionutil.clickOnElement(dressesLink);
	}
	
	public void clickOnTshirtsLink()
	{
		webactionutil.clickOnElement(tshirtsLink);
	}
	
	public void selectSortOption(String text)
	{
		webactionutil.selectDropDownListSelect(sortDropDown, text);
	}
	
	public void clickOnGridView() {
		webactionutil.clickOnElement(gridView);
	}
	
	public void clickOnListView() {
		webactionutil.clickOnElement(listView);
	}
	
	public void selectProduct(String productId) {
		for(WebElement product : productList) {
			WebElement target = product.findElement(By.tagName("a"));
			if(target.getAttribute("href").contains(productId))
			{
				webactionutil.mouseHover(target);
				break;
			}
		}
	}
	
	public ProductPage clickOnMoreButton(String productId)
	{
		xpathForMoreButton = xpathForMoreButton.replace("id", productId);
		WebElement moreButton = driver.findElement(By.xpath(xpathForMoreButton));
		webactionutil.clickOnElement(moreButton);
		return new ProductPage(driver,webactionutil);
	}

}
