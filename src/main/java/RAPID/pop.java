package RAPID;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pop {
	 
	static WebDriver driver;
	
	  @Test
	  public void f() throws IOException {
		  
		  WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--headless");
			
			driver = new ChromeDriver(options);
			
			options.setHeadless(true);

			options.addExtensions(new File(".//Metamask//Extension1.crx"));

			
			
			
			options.addArguments("--no-sandbox");
			
			options.addArguments("--disable-dev-shm-usage");
			
	        //options.addArguments("--disable-dev-shm-usage");

			driver.manage().deleteAllCookies();
			
			driver.get("https://main.d1wxtput80cmif.amplifyapp.com");

			System.out.println("Page title of new tab: " + driver.getTitle());

			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());

			driver.switchTo().window(newTb.get(0));

			driver.navigate().refresh();

			driver.navigate().refresh();

			WebDriverWait wait = new WebDriverWait(driver, 60);

			driver.switchTo().window(newTb.get(0));

			Dimension d = new Dimension(1800, 1080);

			driver.manage().window().setSize(d);
			
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// creates file at System.getProperty("user.dir")

			FileUtils.copyFile(srcFile, new File(".//Screenshots//helo1.png"));
			
			WebElement Name=driver.findElement(By.xpath("//*[text()='Login']"));
			Name.click();
			System.out.println(" Login button clicked succesfully");
		

	  
	}

}
