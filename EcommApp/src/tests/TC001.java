package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;

public class TC001 extends BaseTest{
	
	@Test
	public void addProductToCart()
	{
		HomePage home = new HomePage(driver, webactionutil);
		home.clickOnDressesLink();
		home.selectProduct("4");
		ProductPage productpage = home.clickOnMoreButton("4");
		productpage.clickPlusButton(3);
		productpage.clickMinusButton(1);
		productpage.selectSize("L");
		productpage.selectColor("Yellow");
		productpage.clickOnAddToCart();
		OrderPage orderpage = productpage.clickOnProceedToCheckOut();
		Assert.assertTrue(orderpage.verifyProductIsDispalyed("4"));
	}

}
