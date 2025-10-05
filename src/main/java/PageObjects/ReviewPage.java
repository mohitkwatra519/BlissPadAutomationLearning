package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blisspadsAutomation.AbstractComponents.commonUtility;
import exceptions.FrameworkExceptions;
import exceptions.FrameworkExceptions.ElementNotFoundException;
import utils.LoggerUtil;

public class ReviewPage extends commonUtility{
	private static final Logger logger = LoggerUtil.getLogger(ReviewPage.class);
	WebDriver driver ; 
	
	public ReviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-value='Pack Of 3']")
	WebElement pack;
	
	@FindBy(xpath="//button[@name='plus']")
	WebElement increaseQty;
	
	@FindBy(xpath="(//*[contains(text(), 'Add to cart')])[2]")
	WebElement addToCart;
	
	
	
	public void selectPack() {
		try	
		{
			logger.info("User is Clicking on pack button");
			pack.click();
		}
		catch (Exception e) {
			logger.error("User is unable to click pack button");
			throw new ElementNotFoundException("Pack button not found", e);
		}
	}
	
	public void Quantity() {
		increaseQty.click();
	}
	public cartPage clickAddtoCart() {
	    try {
	        addToCart.click();
	    } catch (Exception e) {
	        throw new ElementNotFoundException("Failed to click 'Add to Cart'. Element might be missing, not clickable, or blocked.", e);
	    }
	    return new cartPage(driver);
	}
	
	
	
			
	

	
	
	
	

}
