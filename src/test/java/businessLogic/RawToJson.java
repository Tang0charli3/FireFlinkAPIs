package businessLogic;

import io.restassured.path.json.JsonPath;

public class RawToJson {
	public static JsonPath RawToJson(String response) {
		JsonPath js =new JsonPath(response);
		return js;
	}

}
