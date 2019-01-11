package priority.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestNG_Priority5 {
	
	public WebDriver driver;
	
	//Combining both prioritized(having same priority) and non-prioritized methods:
	//In this case, we’ll cover two cases in one testng class.
		//Methods having same priority value.
		//More than one non-prioritized methods.
	
	@Test()
	public void c_method(){
		System.out.println("I'm in method C");
	}
	@Test()
	public void b_method(){
		System.out.println("I'm in method B");
	}
	@Test(priority=6)
	public void a_method(){
		System.out.println("I'm in method A");
	}
	@Test(priority=0)
	public void e_method(){
		System.out.println("I'm in method E");
	}
	@Test(priority=6)
	public void d_method(){
		System.out.println("I'm in method D");
	}

}
