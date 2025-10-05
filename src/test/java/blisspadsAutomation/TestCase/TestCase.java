package blisspadsAutomation.TestCase;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PaymentPage;
import PageObjects.ProductPage;
import PageObjects.ReviewPage;
import PageObjects.cartPage;
import TestComponent.BaseTest;
import utils.LoggerUtil;

@Listeners(TestComponent.Listeners.class) // Enable reporting and screenshots
public class TestCase extends BaseTest {
	
	// ========== ADDED: Logger instance ==========
	private static final Logger logger = LoggerUtil.getLogger(TestCase.class);

	
	/**
	 * Main test for submitting an order
	 * Data-driven test using HashMap
	 */
	@Test(dataProvider = "getsubmitOrderData", description = "End-to-end order submission test")
	public void submitOrder(HashMap<String, String> data) throws InterruptedException, IOException {
		
		logger.info("╔════════════════════════════════════════════════════════════╗");
		logger.info("║         STARTING TEST: submitOrder                         ║");
		logger.info("╚════════════════════════════════════════════════════════════╝");
		
		logger.info("Test Data: " + data);
		
		try {
			// Step 1: Launch Application
			logger.info("Step 1: Launching application");
			HomePage home = launchApplication();
			logger.info("✓ Home page loaded successfully");
			
			// Step 2: Click on Sanitary Napkins
			logger.info("Step 2: Navigating to Sanitary Napkins section");
			ProductPage product = home.clickSanitaryNapkins();
			logger.info("✓ Product page displayed");
			
			// Step 3: Apply Filters
			logger.info("Step 3: Applying filters");
			product.applyFilters();
			logger.info("✓ Filters applied successfully");
			
			// Step 4: Select Product
			logger.info("Step 4: Selecting product");
			ReviewPage reviewpage = product.selectProduct();
			logger.info("✓ Product selected, review page displayed");
			
			// Step 5: Select Pack
			logger.info("Step 5: Selecting pack");
			reviewpage.selectPack();
			logger.info("✓ Pack selected");
			
			// Step 6: Increase Quantity
			logger.info("Step 6: Increasing quantity");
			reviewpage.Quantity();
			logger.info("✓ Quantity increased");
			
			// Step 7: Add to Cart
			logger.info("Step 7: Adding product to cart");
			cartPage cart = reviewpage.clickAddtoCart();
			logger.info("✓ Product added to cart");
			
			// Step 8: Verify Free Shipping Message
			logger.info("Step 8: Verifying free shipping message");
			String actualShippingMsg = cart.freeShipping();
			String expectedShippingMsg = data.get("freeship");
			logger.info("Expected: " + expectedShippingMsg);
			logger.info("Actual: " + actualShippingMsg);
			Assert.assertEquals(actualShippingMsg, expectedShippingMsg, 
				"Free shipping message does not match");
			logger.info("✓ Free shipping message verified");
			
			// Step 9: Verify Product Name
			logger.info("Step 9: Verifying product name in cart");
			String actualProductName = cart.productName();
			String expectedProductName = data.get("prodName");
			logger.info("Expected: " + expectedProductName);
			logger.info("Actual: " + actualProductName);
			Assert.assertEquals(actualProductName, expectedProductName, 
				"Product name does not match");
			logger.info("✓ Product name verified");
			
			// Step 10: Proceed to Checkout
			logger.info("Step 10: Proceeding to checkout");
			PaymentPage paymentpage = cart.clickCheckout();
			logger.info("✓ Payment page displayed");
			
			// Step 11: Switch to Payment iframe
			logger.info("Step 11: Switching to payment iframe");
			paymentpage.chooseiframe();
			logger.info("✓ Switched to iframe successfully");
			
			// Step 12: Provide Phone Number
			logger.info("Step 12: Entering phone number");
			String phoneNum = data.get("phoneNum");
			paymentpage.providePhoneNum(phoneNum);
			logger.info("✓ Phone number entered: " + phoneNum);
			
			logger.info("╔════════════════════════════════════════════════════════════╗");
			logger.info("║         TEST PASSED: submitOrder                           ║");
			logger.info("╚════════════════════════════════════════════════════════════╝");
			
		} catch (AssertionError e) {
			logger.error("╔════════════════════════════════════════════════════════════╗");
			logger.error("║         TEST FAILED: Assertion Error                       ║");
			logger.error("╚════════════════════════════════════════════════════════════╝");
			logger.error("Assertion failed: " + e.getMessage(), e);
			throw e;
			
		} catch (Exception e) {
			logger.error("╔════════════════════════════════════════════════════════════╗");
			logger.error("║         TEST FAILED: Exception Occurred                    ║");
			logger.error("╚════════════════════════════════════════════════════════════╝");
			logger.error("Exception in test execution: " + e.getMessage(), e);
			throw e;
		}
	}
	
	/**
	 * Data provider for submitOrder test
	 * Returns array of HashMaps containing test data
	 */
	@DataProvider
	public Object[][] getsubmitOrderData() {
		logger.info("Loading test data from DataProvider");
		
		// Test Data Set 1
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("freeship", "Congrats! You are eligible for FREE Shipping");
		map1.put("prodName", "Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free");
		map1.put("phoneNum", "9876543213");
		logger.debug("Test data set 1 prepared: " + map1);
		
		// Test Data Set 2
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("freeship", "Congrats! You are eligible for FREE Shipping");
		map2.put("prodName", "Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free");
		map2.put("phoneNum", "9997777123");
		logger.debug("Test data set 2 prepared: " + map2);
		
		logger.info("Total test data sets: 2");
		return new Object[][] { {map1} };
	}
}

/*
 * LOGGING BEST PRACTICES USED:
 * 
 * 1. INFO level - Important steps and results
 * 2. DEBUG level - Detailed information
 * 3. ERROR level - Failures and exceptions
 * 4. Clear step numbering for easy debugging
 * 5. Log expected vs actual values
 * 6. Visual separators for test start/end
 * 7. Exception details included in error logs
 */