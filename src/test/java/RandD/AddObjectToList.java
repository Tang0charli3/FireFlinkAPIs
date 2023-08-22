package RandD;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddObjectToList {
    public static void main(String[] args) {
        RestAssured.baseURI="https://script.google.com";
        String tc=given().header("Accept","*/*").when().get("macros/s/AKfycbx0c5qS3psF7arou1j3X3FFDbP8nAWWDWh64niO2GxMw5zb9GLEx0R1kea2RgPGeKekxg/exec").then().extract().response().asString();
        JsonPath js=new JsonPath(tc);
        System.out.println(tc);
//	System.out.println(tc);
        int tcNo=js.get("data.size()");
        List<String> object=new ArrayList<>();
//        for(int i=1;i<tcNo;i++){
            String testSteps=js.getString("data[1][\"Test Steps\"]");
            String description=js.getString("data[1][\"Test Description\"]");
            String[] arr =testSteps.split("\n");
            System.out.println(arr[0]);
            
        object.add("{\n" +
                "                    \"SL No\": \"1\",\n" +
                "                    \"Test Description\": \""+description+"\",\n" +
                "                    \"Test Data\": \"\",\n" +
                "                    \"Test Steps\": \""+arr[0]+"\",\n" +
                "                    \"Element\": \"\",\n" +
                "                    \"Expected Result\": \"\",\n" +
                "                    \"Actual Result\": \"\",\n" +
                "                    \"Status\": \"\"\n" +
                "                }");
            for(int i=1;i< arr.length;i++){
//            for(String a:arr) {
                int sl=i+1;
                object.add("{\n" +
                        "                    \"SL No\": \""+sl+"\",\n" +
                        "                    \"Test Description\": \"\",\n" +
                        "                    \"Test Data\": \"\",\n" +
                        "                    \"Test Steps\": \""+arr[i]+"\",\n" +
                        "                    \"Element\": \"\",\n" +
                        "                    \"Expected Result\": \"\",\n" +
                        "                    \"Actual Result\": \"\",\n" +
                        "                    \"Status\": \"\"\n" +
                        "                }");
            }
//            }
        System.out.println(object.toString());
        }

    }

