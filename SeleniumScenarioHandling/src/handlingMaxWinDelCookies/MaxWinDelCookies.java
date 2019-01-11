package handlingMaxWinDelCookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxWinDelCookies {

	public static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("skv");
		
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=e3BhWojNKIXm8weitZuIBg");
		driver.manage().window().maximize();		
	}
}
