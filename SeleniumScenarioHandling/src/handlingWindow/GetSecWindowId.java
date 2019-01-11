package handlingWindow;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GetSecWindowId {
	
	@Test
	public void login() {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		Actions act = new Actions(driver);
		WebElement clickLogin = driver.findElement(By.xpath("//input[@id='u_0_2']"));
		act.keyDown(Keys.CONTROL).click(clickLogin).keyUp(Keys.CONTROL).perform();	
		System.out.println("Before switching - "+driver.getTitle());
		String currentWindow = driver.getWindowHandle();

		int i=0;
		Set<String> allWindow = driver.getWindowHandles();
		for(String handleWin:allWindow){
						
			i++;
			if(i==2){
				driver.switchTo().window(handleWin);
				break;
			}
		}
		System.out.println("After switcing - "+driver.getTitle());
		driver.switchTo().window(currentWindow);
		System.out.println("Back to parent window "+driver.getTitle());		
	}
}
