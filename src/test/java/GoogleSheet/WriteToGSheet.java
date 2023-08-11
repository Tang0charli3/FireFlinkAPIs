package GoogleSheet;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import FireFlink.GetNLPS;


public class WriteToGSheet {
public static void main(String[] args) throws InterruptedException {
	String nlps=GetNLPS.NLPs();
	JsonPath js=new JsonPath(nlps);
	int size=js.getInt("responseObject.size()");
	for(int i=0;i<size;i++) {
	String type=js.get("responseObject["+i+"].platform");
	String nlpName=js.get("responseObject["+i+"].nlpName");
	String searchName=js.get("responseObject["+i+"].searchName");
	String displayNow=js.get("responseObject["+i+"].displayName");
	String description=js.get("responseObject["+i+"].description");
	String passMessage=js.get("responseObject["+i+"].passMessage");
	String failMessage=js.get("responseObject["+i+"].failMessage");
	try {
	if(type.equals("Android")) {
		RestAssured.baseURI="https://script.google.com";
		Map<String,Object> header = new HashMap<String,Object>();
		header.put("Content-Type", "application/json");
		header.put("Accept", "*/*");
		header.put("Accept-Encoding", "gzip, deflate, br");
		header.put("Connection", "keep-alive");
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
		Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
	            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addAndroid");
		System.out.println(body);
		System.out.println(response);
		}
	else if(type.equals("iOS")) {
		RestAssured.baseURI="https://script.google.com";
		Map<String,Object> header = new HashMap<String,Object>();
		header.put("Content-Type", "application/json");
		header.put("Accept", "*/*");
		header.put("Accept-Encoding", "gzip, deflate, br");
		header.put("Connection", "keep-alive");
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
		Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
	            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addIOS");
		System.out.println(body);
		System.out.println(response);
		}
	else {
		RestAssured.baseURI="https://script.google.com";
		Map<String,Object> header = new HashMap<String,Object>();
		header.put("Content-Type", "application/json");
		header.put("Accept", "*/*");
		header.put("Accept-Encoding", "gzip, deflate, br");
		header.put("Connection", "keep-alive");
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
		Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
	            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addWeb");
		System.out.println(body);
		System.out.println(response);
	}
	}
	catch(NullPointerException e) {
		RestAssured.baseURI="https://script.google.com";
		Map<String,Object> header = new HashMap<String,Object>();
		header.put("Content-Type", "application/json");
		header.put("Accept", "*/*");
		header.put("Accept-Encoding", "gzip, deflate, br");
		header.put("Connection", "keep-alive");
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
		Response response=RestAssured.given().contentType(ContentType.JSON).body(body)
	            .post("macros/s/AKfycbxvvWgn_ZvPaeeCHlSh6rzZe9RIIbfpp-jiwYD-S9W6OAnHn8KdeexltaZQLl8CBe3cxQ/exec?action=addWeb");
		System.out.println(body);
		System.out.println(response);
	}
	}
}
}
