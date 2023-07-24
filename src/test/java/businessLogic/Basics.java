package businessLogic;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import groovy.util.logging.Log;

public class Basics {
public static void main(String[] args) {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Frontline house\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}").when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
	JsonPath js =new JsonPath(response);//for parsing
	String place_id=js.get("place_id");
	System.out.println(place_id);
//	if(scope.equals("APP")) {
//		System.out.println("Passed");
//	}
	String address="Bangalore, Karnataka";
	String put=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+ place_id+"\",\r\n"
			+ "\"address\":\""+ address +"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}").when().put("maps/api/place/update/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	JsonPath jsput =new JsonPath(put);
	System.out.println(jsput.get("msg").toString());
	String get=given().queryParam("key", "qaclick123").queryParam("place_id", place_id)
	.header("Content-Type","application/json").when().get("maps/api/place/get/json")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath jsget =new JsonPath(get);
	String responseAddres=jsget.get("address");
	if(address.equals(responseAddres)) {
		System.out.println("Address are same");
	}
	else {
		System.out.println("Address is not same");
	}
	Assert.assertEquals(address, responseAddres);
	
}
}
