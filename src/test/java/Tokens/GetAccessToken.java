package Tokens;

import java.util.Optional;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Request;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;


public class GetAccessToken {
	static String token="";
    public static String Token() throws InterruptedException {
//    	ChromeDriver driver = new ChromeDriver();
//    	driver.manage().window().maximize();
//    	driver.get("https://app.fireflink.com/");
//
//		DevTools devTools = ((ChromeDriver) driver).getDevTools();
//		devTools.createSession();
//		devTools.send(Network.enable(Optional.of(1000), Optional.of(1000), Optional.of(1000)));
//		devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
//			Request request = requestConsumer.getRequest();
//		if(request.getHeaders().get("Authorization")==null) {
//		}
//		else {
//			System.out.println(request.getHeaders().get("Authorization"));
//			token=(String)request.getHeaders().get("Authorization");
//		}
//		});
//
//		driver.findElement(By.name("emailId")).sendKeys("darshan.n@testyantra.com");
//    	driver.findElement(By.name("password")).sendKeys("Password@123");
//    	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
//    	Thread.sleep(5000);
//		driver.quit();
		RestAssured.baseURI="https://backend1.fireflink.com";
    	String email="darshan.n@testyantra.com";
        String password="Password@123";
        String body = given().header("Content-Type","text/plain").header("Accept","*/*")
                .header("Connection","keep-alive").header("Accept-Encoding","gzip, deflate, br")
                .header("Content-Type","application/json").body("" +
                        "{\n" +
                        "    \"emailId\": \""+email+"\",\n" +
                        "    \"password\": \""+password+"\",\n" +
                        "    \"lastSessionData\": \"/signin\"\n" +
                        "}").when().post("appmanagement/optimize/v1/public/user/signin").then().extract().response().asString();
		JsonPath js=new JsonPath(body);
		String token=js.get("responseObject.access_token");

		token="Bearer "+ token;
		return token;
    }
}
