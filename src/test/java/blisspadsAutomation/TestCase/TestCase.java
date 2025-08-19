package blisspadsAutomation.TestCase;

import java.io.IOException;
import java.util.HashMap;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PaymentPage;
import PageObjects.ProductPage;
import PageObjects.ReviewPage;
import PageObjects.cartPage;
import TestComponent.BaseTest;


public class TestCase extends BaseTest{
	@Test(dataProvider = "getsubmitOrderData")
	public void submitOrder(HashMap<String, String> data) throws InterruptedException, IOException {
	
	 HomePage home = launchApplication();
	 ProductPage product = home.clickSanitaryNapkins();
	 product.applyFilters();
	 ReviewPage reviewpage =  product.selectProduct();
	 reviewpage.selectPack();
	 reviewpage.Quantity();
	 cartPage cart = reviewpage.clickAddtoCart();
	 Assert.assertEquals(cart.freeShipping(), data.get("freeship"));
	 Assert.assertEquals(cart.productName(), data.get("prodName"));
	 PaymentPage paymentpage = cart.clickCheckout();
	 paymentpage.chooseiframe();
	 paymentpage.providePhoneNum(data.get("phoneNum"));
}
	
	
	@DataProvider
	public Object[][] getsubmitOrderData(){
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("freeship", "Congrats! You are eligible for FREE Shipping");
		map1.put("prodName", "Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free");
		map1.put("phoneNum", "9876543213");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("freeship", "Congrats! You are eligible for FREE Shipping");
		map2.put("prodName", "Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free");
		map2.put("phoneNum", "9997777123");
		return new Object[][] {  {map1} , {map2}   };
	}
	
}
