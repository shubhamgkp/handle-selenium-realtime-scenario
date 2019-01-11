package priority.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestNG_Priority2 {

	//we don’t mention any priority, testng will execute the @Test methods based on alphabetical 
	//order of their method names
	public WebDriver driver;
	
	@Test
	public void c_method(){
	System.out.println("I'm in method C");
	}
	@Test
	public void b_method(){
	System.out.println("I'm in method B");
	}
	@Test
	public void a_method(){
	System.out.println("I'm in method A");
	}
	@Test
	public void e_method(){
	System.out.println("I'm in method E");
	}
	@Test
	public void d_method(){
	System.out.println("I'm in method D");
	}
}
