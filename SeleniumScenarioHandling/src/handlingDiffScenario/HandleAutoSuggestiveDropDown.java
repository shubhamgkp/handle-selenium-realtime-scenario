package handlingDiffScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleAutoSuggestiveDropDown {
	
	@Test
	public void handleAutoSuggestDropDown(){
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("Beng");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
				
		//Javascript DOM can extract hidden elements but selenium can not identify hidden elements
		//Means cannot do Ajax implementation and Javascript investigate the properties of object if 
		//it has any hidden text 
		
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		String script = "return document.getElementById(\"fromPlaceName\").value";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		
	}

}
