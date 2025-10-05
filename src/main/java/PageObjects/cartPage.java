package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import exceptions.FrameworkExceptions.ElementNotFoundException;
import exceptions.FrameworkExceptions.FrameworkException;


import blisspadsAutomation.AbstractComponents.commonUtility;
//import blisspadsAutomation.TestCase.TestCase;
import utils.LoggerUtil;

public class cartPage extends commonUtility {
	private static final Logger logger = LoggerUtil.getLogger(cartPage.class);
	
	WebDriver driver ; 
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[contains(text(),'Congrats!')]")
	WebElement shippingMessage;
	
	@FindBy(linkText ="Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free")
	WebElement verifyproductName;
	
	@FindBy(xpath="//span[@class='btn-text']/span[contains(text(), 'Checkout')]")
	WebElement checkout;
	
	
	
	public String freeShipping() {
		try {
            logger.info("Fetching free shipping message");
            return shippingMessage.getText();
        } catch (Exception e) {
            logger.error("Shipping message not found", e);
            throw new ElementNotFoundException("Shipping message not found or not visible", e);
        }

	}
	
	public String productName() {
        try {
            logger.info("Fetching product name from cart");
            return verifyproductName.getText();
        } catch (Exception e) {
            logger.error("Product name not found", e);
            throw new ElementNotFoundException("Product name not found on cart page", e);
        }
    }

    public PaymentPage clickCheckout() {
        try {
            logger.info("Clicking on checkout button");
            checkout.click();
            return new PaymentPage(driver);
        } catch (Exception e) {
            logger.error("Checkout button click failed", e);
            throw new FrameworkException("Checkout button click failed", e);
        }
    }

	
	
	
			
	
	
	
	
	
	
	
	

}
