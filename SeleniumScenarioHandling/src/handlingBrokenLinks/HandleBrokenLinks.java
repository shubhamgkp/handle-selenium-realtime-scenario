package handlingBrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://www.akick.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("Total links are- "+links.size());

		for(int i=0;i<links.size();i++){

			WebElement link=links.get(i);
			String url=link.getAttribute("href");
			verifyLinkActive(url);
		}		
	}

	public static void verifyLinkActive(String linkURL){
		try{
			URL urlObj = new URL(linkURL);
			HttpURLConnection httpURLConnect =(HttpURLConnection)urlObj.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if(httpURLConnect.getResponseCode()==200){

				System.out.println(linkURL+" - "+httpURLConnect.getResponseMessage());				
			}
			if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println(linkURL+" - "+httpURLConnect.getResponseMessage()+" - "+HttpURLConnection.HTTP_NOT_FOUND);
			}
		}
		catch(Exception e){

			System.out.println("Exception is "+e);
		}
	}
}
