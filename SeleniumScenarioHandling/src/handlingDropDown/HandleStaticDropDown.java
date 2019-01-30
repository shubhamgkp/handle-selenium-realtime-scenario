package handlingDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandleStaticDropDown {

	static WebDriver driver;
	
	@Test
	public void staticDropDown() {
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://book.spicejet.com/Search.aspx?op=3");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		Select selStaticDropDown=new Select(driver.findElement(By.xpath("//select[@id='FlifoSearchInputSearchView_originStation']")));
		selStaticDropDown.selectByIndex(2);
		selStaticDropDown.selectByValue("AMD");
		selStaticDropDown.selectByVisibleText("Bangkok (BKK)");
	}
}
