package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import blisspadsAutomation.AbstractComponents.commonUtility;

public class cartPage extends commonUtility {
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
		return shippingMessage.getText();
	}
	
	public String productName() {
		return verifyproductName.getText();
	}
	public PaymentPage clickCheckout() {
		checkout.click();
		return new PaymentPage(driver);
	}
	
	
	
			
	
	
	
	
	
	
	
	

}
