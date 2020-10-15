package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.GenericExcelLibrary;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;

public class TC004 extends BaseTest {

	@DataProvider(parallel = true)
	public Object[][] getData()
	{
		return GenericExcelLibrary.getExcelData(XL_PATH, "Sheet1");
	}
	
	@Test(dataProvider = "getData")
	public void addProductToCart(String productId,String size,String color)
	{
		productId = productId.substring(0,1);
		HomePage home = new HomePage(driver, webactionutil);
		home.clickOnDressesLink();
		home.selectProduct(productId);
		ProductPage productpage = home.clickOnMoreButton(productId);
		productpage.clickPlusButton(3);
		productpage.clickMinusButton(1);
		productpage.selectSize(size);
		productpage.selectColor(color);
		productpage.clickOnAddToCart();
		OrderPage orderpage = productpage.clickOnProceedToCheckOut();
		Assert.assertTrue(orderpage.verifyProductIsDispalyed(productId));
	}

}
