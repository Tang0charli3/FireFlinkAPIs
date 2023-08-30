package GoogleSheet;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Convert_Data_from_Merged_Cells {
    public static void main(String[] args) {
        RestAssured.baseURI="https://script.google.com";
        String tc=given().header("Accept","*/*").when().get("macros/s/AKfycbyjWEThdTbyblhzG08EPv6MxR7Z-0bZKvEqTDRNh2KKlcbjYFP0vaAuOu4bTZEgr9js/exec").then().extract().response().asString();
        JsonPath js=new JsonPath(tc);
        System.out.println(tc);
        System.out.println(js.getString("data[1][\"Test Steps\"]").toString());
    }
}
