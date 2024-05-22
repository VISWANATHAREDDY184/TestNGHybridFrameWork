package testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseclass.Baseclass;
import pageobjects.Homepage;
import pageobjects.Loginpage;

public class Login extends Baseclass{
  WebDriver driver;
   public Login(){
        super();
    }
	@BeforeMethod()
		public void sample() {
		driver=initializebrowser(prop.getProperty( "browser"));
		Homepage h=new Homepage(driver);
		h.clickonmyaccountdropdown();
		h.clickonloginoption();
		}
	@AfterMethod()
	public void teardown() {
	driver.quit();
	}
	@Test
	public void userloginwithvalidcredentials() {
		
		Loginpage l=new Loginpage(driver);
		l.enteremail(prop.getProperty("email"));
		l.enterpassword(prop.getProperty("password"));
		l.clickonloginbutton();
		}
	@Test
	public void userloginwithinvalidcredentials() {
		Loginpage l=new Loginpage(driver);
		l.enteremail(prop.getProperty("invalidemail"));
		l.enterpassword(prop.getProperty("invalidpassword"));
		l.clickonloginbutton();
		
	}
	

}
