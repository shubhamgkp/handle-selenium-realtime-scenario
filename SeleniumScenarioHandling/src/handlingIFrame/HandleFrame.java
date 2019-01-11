package handlingIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleFrame {

	public WebDriver driver;	
	
	@Test
	public void iframeHandle() {
		
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();	
		
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		 
		int num = driver.findElements(By.tagName("iframe")).size();
		System.out.println(num);
		
		//driver.switchTo().frame(0); 		//Switch by frame index 
		//Switch by Web element locator of the frame
		WebElement getframe = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
		driver.switchTo().frame(getframe);		
		
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
	}
}