package FireFlink;

import Tokens.GetAccessToken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetManualTestCase {
    public static void main(String[] args) throws InterruptedException {
        RestAssured.baseURI="https://backend1.fireflink.com";
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
        header.put("Accept-Encoding", "gzip, deflate, br");
        header.put("Access-Control-Allow-Origin", "*");
        header.put("Authorization", GetAccessToken.Token());
        header.put("Connection", "keep-alive");
        header.put("Origin", "https://app.fireflink.com");
        header.put("Referer", "https://app.fireflink.com/");
        header.put("Sec-Fetch-Dest", "empty");
        header.put("Sec-Fetch-Mode", "cors");
        header.put("Sec-Fetch-Site", "same-site");
        header.put("projectId", "PJT1003");
        header.put("projectType", "Web");
        header.put("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"115\"");
        header.put("sec-ch-ua-mobile", "?0");
        header.put("sec-ch-ua-platform", "\"Windows\"");
        String manualTestCase=given().headers(header).when().get("project/optimize/v1/scripts/modules/MOD1009/script/SCR1022").then().extract().response().asString();
        System.out.println(manualTestCase);
        JsonPath js=new JsonPath(manualTestCase);
        String firstStep=js.get("responseObject.manualTestCase.testSteps.rows[0][\"Test Steps\"]");
        System.out.println(firstStep);

//        given().header("")
    }
}