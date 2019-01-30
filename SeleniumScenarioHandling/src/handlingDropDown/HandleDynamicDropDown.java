package handlingDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleDynamicDropDown {
	
	WebDriver driver;
	
	@Test
	public void handleDynamicDropDown() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.spicejet.com/");
		driver.manage().window().maximize();
				
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
	}	
}
