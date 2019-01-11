package handlingDiffScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AssignmentAutoSuggestDropDown {

	@Test
	public void handleAutoSuggestDropDown(){

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://www.qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Unit");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		String script = "return document.getElementById(\"autocomplete\").value";
		String text = (String) js.executeScript(script);
		int i=0;
		while(!text.equalsIgnoreCase("United States")){			
			i++;
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			if(i>10){
				break;				
			}
		}
	}
}
