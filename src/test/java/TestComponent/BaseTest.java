package TestComponent;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver ;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.properties");

		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			ChromeOptions options= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver ;
	}
	
	public HomePage launchApplication() throws IOException {
		driver = initializeDriver();
		HomePage home = new HomePage(driver);
		home.goTo();
		return home;
	}
	
	public String getScreenshot(String testCaseName , WebDriver driver) throws IOException  {
		TakesScreenshot ts = (TakesScreenshot)driver ; 
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//reports//" + testCaseName +  ".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir") + "//reports//" + testCaseName +  ".png" ;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
}
