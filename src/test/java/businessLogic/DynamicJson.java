package businessLogic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class DynamicJson {
@Test
public void addBook() {
	RestAssured.baseURI="http://216.10.245.166/";
	String addbook=given().header("Content-Type","application/json").body("{\r\n"
			+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
			+ "\"isbn\":\"bcd\",\r\n"
			+ "\"aisle\":\"29226\",\r\n"
			+ "\"author\":\"John foer\"\r\n"
			+ "}\r\n"
			+ "").when().post("/Library/Addbook.php").then().assertThat().statusCode(200).log().all().extract().response().asString();
	System.out.println(addbook);
}
}
