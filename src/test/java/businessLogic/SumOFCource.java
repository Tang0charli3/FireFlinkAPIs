package businessLogic;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumOFCource {
@Test
public void sum() {
	JsonPath js =new JsonPath(PayLoad.payLoad());
	int count=js.getInt("courses.size()");
	System.out.println(count);
	int sum=0;
	for(int i=0;i<count;i++) {
		int temp=(js.getInt("courses["+i+"].price"))*(js.getInt("courses["+i+"].copies"));
		sum=sum+temp;
	}
	System.out.println(sum);
	int total=js.getInt("dashboard.purchaseAmount");
	System.out.println(total);
	if(total==sum) {
		System.out.println("Test Case Pass");
	}
	else {
		System.out.println("Test case fail");
	}
}
}
