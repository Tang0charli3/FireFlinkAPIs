package businessLogic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class DynamicJson {
@Test(dataProvider = "booksData")
public void addBook(String isbn, int aisle) {
	RestAssured.baseURI="http://216.10.245.166/";
	String addbook=given().header("Content-Type","application/json").body(PayLoad.addBook(isbn,aisle))
			.when().post("/Library/Addbook.php")
			.then().assertThat().statusCode(200).log().all().extract().response().asString();
	System.out.println(addbook);
}

@DataProvider(name="booksData")
public Object[][] getData(){
	Object[][] obj=new Object[][] {{"AccB", 1112},{"Acca",2223},{"AccC",3334}};
	return obj;
	
}

}
