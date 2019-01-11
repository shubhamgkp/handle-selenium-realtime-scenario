package handlingWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandles {

	public static WebDriver driver; 

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.get("https://accounts.google.com/signin/v2/identifier?flowEntry=ServiceLogin&service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&flowName=GlifWebSignIn");
		driver.manage().window().maximize();
		act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//a[contains(text(),'Learn more')]"))).keyUp(Keys.CONTROL).build().perform();

		System.out.println("Before switching");
		System.out.println(driver.getTitle());

		Set<String> windowid = driver.getWindowHandles();
		Iterator<String> itr = windowid.iterator();
		String parentid = itr.next();
		String childid = itr.next();		

		driver.switchTo().window(childid);		
		System.out.println("After switching");
		System.out.println(driver.getTitle());
		//driver.findElement(By.linkText("Sign in")).click();

		driver.switchTo().window(parentid);
		System.out.println("Switching back to parent window");
		System.out.println(driver.getTitle());	

	}
}
