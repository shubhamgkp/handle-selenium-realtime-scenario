package priority.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestNG_Priority4 {
	
	//Methods with Same Priority:

	//There may be a chance that methods may contain same priority. In those cases, testng considers
	//the alphabetical order of the method names whose priority is same.
	
	public WebDriver driver;
	
	@Test(priority=6)
    public void c_method(){
    System.out.println("I'm in method C");
    }
    @Test(priority=9)
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
    @Test(priority=3)
    public void d_method(){
    System.out.println("I'm in method D");
    }
}
