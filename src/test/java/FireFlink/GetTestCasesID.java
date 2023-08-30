package FireFlink;

import static Variables.Details.projectId;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Tokens.GetAccessToken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetTestCasesID {
public static void main(String[] args) throws InterruptedException {
	System.out.println(projectId);
	RestAssured.baseURI="https://backend1.fireflink.com";
	Map<String,Object> header = new HashMap<String,Object>();
	header.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
	header.put("Accept-Encoding", "gzip, deflate, br");
	header.put("Access-Control-Allow-Origin", "*");
	header.put("Authorization", GetAccessToken.Token());
	header.put("Connection", "keep-alive");
	header.put("Origin", "https://app.fireflink.com");
	header.put("Referer", "https://app.fireflink.com/");
	header.put("projectId", projectId);
	header.put("projectType", "Web");
	String testCases=given().param("sort", "true").headers(header).when().get("alltrees/optimize/v1/trees/modules/").then().assertThat().statusCode(200)
				.extract().response().asString();
	JsonPath js=new JsonPath(testCases);
	System.out.println(testCases);
	String tcName=js.get("responseObject.moduleTree[0].children[1].children[0].title");
	int sizeOfResponseObject=js.getInt("responseObject.moduleTree[0].children.size()");
	List<String> tcID = new ArrayList();
	int count=0;
	for(int i=0;i<sizeOfResponseObject;i++) {
		int sizeOfModuleTree=js.getInt("responseObject.moduleTree[0].children["+i+"].children.size()");

		for(int j=0;j<sizeOfModuleTree;j++) {
			tcName=js.get("responseObject.moduleTree[0].children["+i+"].children["+j+"].title");
			String key=js.get("responseObject.moduleTree[0].children["+i+"].children["+j+"].key");
//			System.out.println(key);
			tcID.add(key);
//			System.out.println(tcName);
			count++;
		}
	}
	for(Object id:tcID){
		System.out.println(id.toString());
	}
	System.out.println(count);
	System.out.println(tcID.size());
}
}
