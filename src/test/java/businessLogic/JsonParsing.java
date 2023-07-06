package businessLogic;

import io.restassured.path.json.JsonPath;

public class JsonParsing {
public static void main(String[] args) {

	
	JsonPath js=new JsonPath(PayLoad.payLoad());
	int numOfCourse=js.getInt("courses.size()");
	System.out.println(numOfCourse);
	System.out.println(js.getInt("dashboard.purchaseAmount"));
	System.out.println(js.getString("courses[0].title"));
	System.out.println(js.getString("courses[1].title"));
	System.out.println(js.getString("courses[2].title"));
	for(int i=0;i<numOfCourse;i++) {
		System.out.println(js.getString("courses["+i+"].title")+" "+js.getInt("courses["+i+"].price"));
	}
	for(int i=0;i<numOfCourse;i++) {
		if((js.getString("courses["+i+"].title").equals("RPA"))){
			System.out.println(js.getInt("courses["+i+"].price"));
			break;
		}
	}
	
	
	
}
}
