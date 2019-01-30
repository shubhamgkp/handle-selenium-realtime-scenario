package handlingDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleDropDownLoopingUI {

	WebDriver driver;

	@Test
	public void handleDropDownLoopUI() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://book.spicejet.com/Search.aspx?op=3");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[text()=' Flights ']")).click();		
		Thread.sleep(3000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		int n=1;
		while(n<7){
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			n++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
	}
}
