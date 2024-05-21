package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	public Properties prop;
    WebDriver driver;
    public   Baseclass() {
        prop = new Properties();
        File propfile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\configugaration\\property1");
        try {
            FileInputStream fis = new FileInputStream(propfile);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public WebDriver initializebrowser( String browser){
            if(browser.equals("chrome")){
                driver=new ChromeDriver();
            } else if (browser.equals("firefox")) {
                driver=new FirefoxDriver();

            }
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            return driver;

        }

}
