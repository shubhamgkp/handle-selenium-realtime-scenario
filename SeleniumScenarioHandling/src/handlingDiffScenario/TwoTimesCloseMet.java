package handlingDiffScenario;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoTimesCloseMet {
	
	public static WebDriver driver; 
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=R9eSWae9GIby8AfJh5mIAw");
		driver.manage().window().maximize();
		
		driver.close();
		System.out.println("Before second time close method!!");		
		driver.close();
		System.out.println("After second time close method!!");
	}

}
