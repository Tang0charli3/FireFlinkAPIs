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
//			System.out.println(request.getHeaders().toString());
//			System.out.println(request.getHeaders().get("Authorization"));
//		token=(String) request.getHeaders().get("Authorization");
		if(request.getHeaders().get("Authorization")==null) {
//			System.out.println("Is Null");
//			continue;
		}
		else {
			System.out.println(request.getHeaders().get("Authorization"));
			token=(String)request.getHeaders().get("Authorization");
		}
//		String toke1n=(String)request.getHeaders().get("Authorization");
//		if(toke1n.charAt(0)=='B') {
//			System.out.println(token);
//		}
			
		});
		
//		Request request1=
		driver.findElement(By.name("emailId")).sendKeys("darshan.n@testyantra.com");
    	driver.findElement(By.name("password")).sendKeys("Password@123");
    	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
    	Thread.sleep(20000);
//		driver.get("https://app.fireflink.com/");
		driver.quit();
		return token;
    }
}
