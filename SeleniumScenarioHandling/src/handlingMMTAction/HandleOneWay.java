package handlingMMTAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandleOneWay {

	@Test
	public void bookOneWayTrip() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		/*
		 * driver.switchTo().frame(driver.findElement(By.xpath(
		 * "//iframe[@id='webklipper-publisher-widget-container-notification-frame']")))
		 * ; driver.findElement(By.xpath(
		 * "//a[@id='webklipper-publisher-widget-container-notification-close-div']")).
		 * click(); driver.switchTo().defaultContent();
		 */

		driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));
		source.click(); 
		source.sendKeys("Mum");
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
				
		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
		destination.click(); 
		Thread.sleep(3000);
		destination.sendKeys("Del");
		Thread.sleep(3000);
		destination.sendKeys(Keys.ARROW_DOWN); 
		destination.sendKeys(Keys.ENTER);
	}
}
