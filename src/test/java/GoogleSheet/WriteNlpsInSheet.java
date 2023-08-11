package GoogleSheet;

import FireFlink.GetNLPS;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WriteNlpsInSheet {
public static void main(String[] args) throws InterruptedException {
	RestAssured.baseURI="https://script.google.com";
	String nlps=GetNLPS.NLPs();
	JsonPath js=new JsonPath(nlps);
	System.out.println(nlps);
	int no=js.getInt("responseObject.size()");
	System.out.println(no);
	for(int i=0;i<no;i++) {
		String type=js.get("responseObject["+i+"].platform");
		System.out.println(type);
		String nlpName=js.get("responseObject["+i+"].nlpName");
		String searchName=js.get("responseObject["+i+"].searchName");
		String displayNow=js.get("responseObject["+i+"].displayName");
		String description=js.get("responseObject["+i+"].description");
		String passMessage=js.get("responseObject["+i+"].passMessage");
		String failMessage=js.get("responseObject["+i+"].failMessage");
		String body="{\r\n"
				+ "   \r\n"
				+ "    \"nlpName\":\""+nlpName+"\",\r\n"
				+ "    \"searchName\":\""+searchName+"\",\r\n"
				+ "    \"displayName\":\""+displayNow+"\",\r\n"
				+ "    \"description\":\""+description+"\",\r\n"
				+ "    \"passMessage\":\""+passMessage+"\",\r\n"
				+ "    \"failMessage\":\""+failMessage+"\"\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "";
		if(type.equals("Web")) {
			System.out.println("Type is "+type);
			Map<String,Object> header = new HashMap<String,Object>();
			header.put("Content-Type", "application/json");
			header.put("Accept", "*/*");
			header.put("Accept-Encoding", "gzip, deflate, br");
			header.put("Connection", "keep-alive");
			Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
		            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addWeb");
			System.out.println(response.toString());
			System.out.println(response);
		}
		else if(type.equals("Android")) {
			System.out.println("Type is "+type+" and body is"+body);
			Map<String,Object> header = new HashMap<String,Object>();
			header.put("Content-Type", "application/json");
			header.put("Accept", "*/*");
			header.put("Accept-Encoding", "gzip, deflate, br");
			header.put("Connection", "keep-alive");
			Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
		            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addAndroid");
			System.out.println(response.toString());
		}
		else if(type.equals("iOS")){
			System.out.println("Type is "+type+" and body is"+body);
			Map<String,Object> header = new HashMap<String,Object>();
			header.put("Content-Type", "application/json");
			header.put("Accept", "*/*");
			header.put("Accept-Encoding", "gzip, deflate, br");
			header.put("Connection", "keep-alive");
//			Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
//		            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addIOS");
//			System.out.println(response.toString());
			String response=given().contentType(ContentType.JSON).body(body)
		            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addIOS").then().assertThat()
		            .statusCode(200).extract().response().asString();
			System.out.println(response);
		}
		else {
			System.out.println("Diffrent Type");
		}
	}
//	
}
}
