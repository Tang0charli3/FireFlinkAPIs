package FireFlink;

import static io.restassured.RestAssured.given;


import java.util.HashMap;
import java.util.Map;

import Tokens.GetAccessToken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetWebNLPs {
public static void main(String[] args) throws InterruptedException {
	String token=GetAccessToken.Token();
//	System.out.println(token);
	RestAssured.baseURI="https://backend1.fireflink.com";
	Map<String,Object> header = new HashMap<String,Object>();
	header.put("Accept", "application/json");
	header.put("Accept-Language", "en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,kn;q=0.6");
	header.put("Access-Control-Allow-Origin", "*");
	header.put("Authorization", GetAccessToken.Token());
	header.put("Connection", "keep-alive");
	header.put("Origin", "https://app.fireflink.com");
	header.put("Referer", "https://app.fireflink.com/");
	header.put("Sec-Fetch-Dest", "empty");
	header.put("Sec-Fetch-Mode", "cors");
	header.put("Sec-Fetch-Site", "same-site");
	header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
	header.put("platform", "Web");
	header.put("projectId", "PJT1001");
	header.put("projectType", "Web");
	header.put("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"");
	header.put("sec-ch-ua-mobile", "?0");
	header.put("sec-ch-ua-platform", "\"Windows\"");
	String nlps=given().header("Accept","application/json").headers(header).when().get("/appmanagement/optimize/v1/nlp/").then().assertThat().statusCode(200)
				.extract().response().asString();
//	System.out.println(nlps);
	JsonPath js=new JsonPath(nlps);
	int no=js.getInt("responseObject.size()");
//	System.out.println(no);
	for(int i=0;i<no;i++) {
		String searchName=js.get("responseObject["+i+"].searchName");
		String description=js.get("responseObject["+i+"].description");
		System.out.println("Search Name =  "+searchName + "\n" +"Description =  "+ description +"\n"+"=================================================================" );
	}
}
}
