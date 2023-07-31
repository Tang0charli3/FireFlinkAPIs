package GoogleSheet;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Tokens.GetAccessToken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetTestCaseFromGoogleSheet {
public static void main(String[] args) {
	RestAssured.baseURI="https://script.google.com";
	String tc=given().header("Accept","*/*").when().get("macros/s/AKfycbx0c5qS3psF7arou1j3X3FFDbP8nAWWDWh64niO2GxMw5zb9GLEx0R1kea2RgPGeKekxg/exec").then().extract().response().asString();
	JsonPath js=new JsonPath(tc);
//	System.out.println(tc);
	String testSteps=js.getString("data[1][\"Test Steps\"]");
//	System.out.println(testSteps);
	String arr[]=testSteps.split("\n");
//	System.out.println(arr[1]);
	for(String a:arr) {
		System.out.println(a);
	}
	
}
}
