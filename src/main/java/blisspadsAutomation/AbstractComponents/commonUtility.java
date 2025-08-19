package blisspadsAutomation.AbstractComponents;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtility {
	WebDriver driver ;
	
	public commonUtility(WebDriver driver) {
		this.driver = driver ; 
	}

	public void waituntilVisible(WebElement phonenum) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(phonenum));
	    
	}
	public void waituntilClick(WebElement sizeFilter) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(sizeFilter));
	    
	}

	

}
