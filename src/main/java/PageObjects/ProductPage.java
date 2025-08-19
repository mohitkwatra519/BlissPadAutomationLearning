package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import blisspadsAutomation.AbstractComponents.commonUtility;

public class ProductPage extends commonUtility{
	WebDriver driver ; 
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@for='Filter-Size-2']//*[name()='svg']")
	WebElement sizeFilterXL;
	
	@FindBy(linkText ="Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free")
	WebElement chooseProduct;
	
	public void applyFilters() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,900)", " ");
		Thread.sleep(3000);
		waituntilClick(sizeFilterXL);
		sizeFilterXL.click();
	    Thread.sleep(3000);
	    
		
	    
		
	}
	
	public ReviewPage selectProduct() {
		chooseProduct.click();
		return new ReviewPage(driver);
	}
	
	
			
	

	
	
	
	

}
