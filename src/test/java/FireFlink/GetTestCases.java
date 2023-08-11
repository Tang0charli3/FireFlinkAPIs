package FireFlink;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Tokens.GetAccessToken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetTestCases {
public static void main(String[] args) throws InterruptedException {
	RestAssured.baseURI="https://backend1.fireflink.com";
	Map<String,Object> header = new HashMap<String,Object>();
	header.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
	header.put("Accept-Encoding", "gzip, deflate, br");
	header.put("Access-Control-Allow-Origin", "*");
	header.put("Authorization", GetAccessToken.Token());
	header.put("Connection", "keep-alive");
	header.put("Origin", "https://app.fireflink.com");
	header.put("Referer", "https://app.fireflink.com/");
	header.put("Sec-Fetch-Dest", "empty");
	header.put("Sec-Fetch-Mode", "cors");
	header.put("Sec-Fetch-Site", "same-site");
	header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
	header.put("projectId", "PJT1003");
	header.put("projectType", "Web");
	header.put("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"115\"");
	header.put("sec-ch-ua-mobile", "?0");
	header.put("sec-ch-ua-platform", "\"Windows\"");
	String testCases=given().param("sort", "true").headers(header).when().get("alltrees/optimize/v1/trees/modules/").then().assertThat().statusCode(200)
				.extract().response().asString();
	JsonPath js=new JsonPath(testCases);
	System.out.println(testCases);
	String tcName=js.get("responseObject.moduleTree[0].children[1].children[0].title");
	int sizeOfResponseObject=js.getInt("responseObject.moduleTree.size()");
	System.out.println(tcName);
	System.out.println(sizeOfResponseObject);
	List tcID = new ArrayList();
	int sizeOfModuleTree=js.getInt("responseObject.moduleTree[0].children.size()");
	for(int i=0;i<sizeOfResponseObject;i++) {
		for(int j=0;j<sizeOfModuleTree;i++) {
			tcName=js.get("responseObject.moduleTree[0].children["+i+"].children["+j+"].title");
			System.out.println(tcName);
//			for(int k=0;k<1;k++) {
//				for(int l=0;l<1;l++) {
//					
//				}
//			}
		}
	}
}
}
