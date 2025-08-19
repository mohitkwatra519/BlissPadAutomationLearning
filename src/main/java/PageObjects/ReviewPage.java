package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blisspadsAutomation.AbstractComponents.commonUtility;

public class ReviewPage extends commonUtility{
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
		pack.click();
	}
	
	public void Quantity() {
		increaseQty.click();
	}
	public cartPage clickAddtoCart() {
		addToCart.click();
		return new cartPage(driver);
	}
	
	
	
			
	

	
	
	
	

}
