package handlingTableGrids;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingAllColValOfTable {
	
	public static WebDriver driver;	
	
	public static void main(String[] args) {		

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.cricbuzz.com/live-cricket-scorecard/21587/syl-vs-rgr-18th-match-bangladesh-premier-league-2019");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		WebElement table =driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		
		int rowCount=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"))
		.size();
		int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		
		int sum=0;
		for(int i=0;i<count-2;i++){
			
			String valueOfCol=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int value=Integer.parseInt(valueOfCol);
			sum=sum+value;			
		}
		//System.out.println(sum);
		
		String extrasString=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extrasVal=Integer.parseInt(extrasString);
		int finalVal=sum+extrasVal;
		//System.out.println(finalVal);
		
		String totalString=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int totalVal=Integer.parseInt(totalString);
		
		if(finalVal==totalVal){
			
			System.out.println("The calculated value is correct!!");
		}
		else{
			System.out.println("The calculated value is incorrect!!");
		}
	}

}
