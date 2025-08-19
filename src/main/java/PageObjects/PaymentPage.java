package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import blisspadsAutomation.AbstractComponents.commonUtility;

public class PaymentPage extends commonUtility{
	WebDriver driver ; 
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//iframe[@class='gokwik-iframe']")
	WebElement iframe;
	
	@FindBy(id="phone-input")
	WebElement phone_num;
	
	
	
	
	
	public void chooseiframe() {
		driver.switchTo().frame(iframe);
	}
	
	public void providePhoneNum(String phonenum) throws InterruptedException {
		waituntilVisible(phone_num);
		phone_num.sendKeys(phonenum);
		Thread.sleep(2000);
		driver.close();
	}

	
	
	
	

	
	
			
	
	
	
	
	
	
	
	

}
