package businessLogic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFox {
 public static void main(String[] args) throws MalformedURLException {
//	WebDriver driver=new FirefoxDriver();
//	driver.manage().window().maximize();
//	driver.get("https://app.fireflink.com/");
	 String seleniumServerUrl = "http://localhost:4444/wd/hub";

     // Set the desired capabilities for the browser
     DesiredCapabilities capabilities = new DesiredCapabilities();
     capabilities.setBrowserName("chrome");
     capabilities.setVersion("99.0.4844.84");
     capabilities.setPlatform(Platform.WINDOWS);

     // Create a RemoteWebDriver instance
     WebDriver driver = new RemoteWebDriver(new URL(seleniumServerUrl), capabilities);

     // Navigate to a webpage
     driver.get("https://app.marlo.co/login");
}
}
