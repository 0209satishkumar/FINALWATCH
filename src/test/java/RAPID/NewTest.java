package RAPID;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {

	static WebDriver driver;

	DateFormat dateFormat = new SimpleDateFormat("HHmmss");

	Date date = new Date();

	String dateFormatted = dateFormat.format(date);

	@Test
	public void f() throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		System.out.println(dateFormatted);

		driver.get("https://demo19952021.flush.com/");

		Thread.sleep(5000);
	}

	@Test()

	public void signup() throws IOException {

		FileReader reader = new FileReader(".//K.properties");

		Properties p = new Properties();

		p.load(reader);

		driver.findElement(By.xpath(p.getProperty("REGISTER"))).click();

		driver.findElement(By.xpath(p.getProperty("USERNAME"))).sendKeys("satish" + dateFormatted);

		driver.findElement(By.xpath(p.getProperty("EMAILID"))).sendKeys("satishkumar" + dateFormatted + "@gmail.com");

		driver.findElement(By.xpath(p.getProperty("CHOOSEPASSWORD"))).sendKeys("Satish@123");

		driver.findElement(By.xpath(p.getProperty("TERMSCHECKBOX"))).click();

		WebElement element = driver.findElement(By.xpath(p.getProperty("WELCOMEPLAYNOW")));

		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element);
		builder.perform();

		Assert.assertTrue(driver.findElement(By.xpath(p.getProperty("WELCOMEPLAYNOW"))).isDisplayed());

		System.out.println("Sign up successfully ");

	}

}
