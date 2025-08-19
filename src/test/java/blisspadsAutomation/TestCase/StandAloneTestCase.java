package blisspadsAutomation.TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestCase {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.blissnatural.in");
		driver.findElement(By.linkText("Sanitary Pads")).click();
		Thread.sleep(4000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0, 800)");
		driver.findElement(By.xpath("//label[@for='Filter-Size-2']//*[name()='svg']")).click();
		driver.findElement(By.linkText("Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free")).click();
		driver.findElement(By.xpath("//div[@data-value='Pack Of 3']")).click();
		driver.findElement(By.xpath("//button[@name='plus']")).click();
		driver.findElement(By.xpath("(//*[contains(text(), 'Add to cart')])[2]")).click();
		//driver.findElement(By.linkText("View Cart")).click();
		//String name = driver.findElement(By.linkText("Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free")).getText();
		String freeship = driver.findElement(By.xpath("//h4[contains(text(),'Congrats!')]")).getText();
		Assert.assertEquals(freeship, "Congrats! You are eligible for FREE Shipping");
		
		String productName = driver.findElement(By.linkText("Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free")).getText();
		Assert.assertEquals(productName, "Bliss Organic Sanitary Pads XL Fluffy (6 Pads) | Rash and Itch Free");
		driver.findElement(By.xpath("//span[@class='btn-text']/span[contains(text(), 'Checkout')]")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='gokwik-iframe']")));
		
		
		Thread.sleep(10000);
		driver.findElement(By.id("phone-input")).sendKeys("9876543213");
		Thread.sleep(10000);
		driver.close();
		

	}

}
