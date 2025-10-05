package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blisspadsAutomation.AbstractComponents.commonUtility;
import exceptions.FrameworkExceptions;
import exceptions.FrameworkExceptions.FrameworkException;
import utils.LoggerUtil;

public class HomePage extends commonUtility {
	private static final Logger logger = LoggerUtil.getLogger(HomePage.class) ;
	
	WebDriver driver ; 
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sanitary Pads")
	WebElement napkins;
	
	public ProductPage clickSanitaryNapkins() {
		try {
			logger.info("clicking on napkins button");
			napkins.click();
			ProductPage product = new ProductPage(driver);
			return product ;
		}
		
		catch (Exception e) {
            logger.error("Checkout button click failed", e);
            throw new FrameworkException("Checkout button click failed", e);
        }
		
		
	}
	
	public void goTo() {
		driver.get("https://www.blissnatural.in");
		
		
		
	}
	

	
	
	
	

}
