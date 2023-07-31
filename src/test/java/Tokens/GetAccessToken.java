package Tokens;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Request;


public class GetAccessToken {
	static String token="";
    public static String Token() throws InterruptedException {
    	ChromeDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://app.fireflink.com/");
    	
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.of(1000), Optional.of(1000), Optional.of(1000)));
		devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
			Request request = requestConsumer.getRequest();
		if(request.getHeaders().get("Authorization")==null) {
		}
		else {
			System.out.println(request.getHeaders().get("Authorization"));
			token=(String)request.getHeaders().get("Authorization");
		}
		});
		
		driver.findElement(By.name("emailId")).sendKeys("darshan.n@testyantra.com");
    	driver.findElement(By.name("password")).sendKeys("Password@123");
    	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
    	Thread.sleep(5000);
		driver.quit();
		return token;
    }
}
