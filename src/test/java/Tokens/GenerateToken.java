package Tokens;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class GenerateToken {
    public static void main(String[] args) {
        RestAssured.baseURI="https://backend1.fireflink.com";
        String body=given().header("Content-Type","text/plain").header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br").header("Connection","keep-alive")
                .header("Content-Type","application/json").body("{\n" +
                        "    \"emailId\": \"darshan.n@testyantra.com\",\n" +
                        "    \"password\": \"Password@123\",\n" +
                        "    \"lastSessionData\": \"/signin\"\n" +
                        "}").when().post("appmanagement/optimize/v1/public/user/signin").then().extract().response().asString();
        System.out.println(body);
        JsonPath js=new JsonPath(body);
        String token=js.get("responseObject.access_token");

        token="Bearer "+ token;
        System.out.println(token);
    }
}
