package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blisspadsAutomation.AbstractComponents.commonUtility;

public class HomePage extends commonUtility {
	WebDriver driver ; 
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sanitary Pads")
	WebElement napkins;
	
	public ProductPage clickSanitaryNapkins() {
		napkins.click();
		ProductPage product = new ProductPage(driver);
		return product ;
	}
	
	public void goTo() {
		driver.get("https://www.blissnatural.in");
	}
	

	
	
	
	

}
