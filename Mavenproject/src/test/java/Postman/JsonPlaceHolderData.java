package Postman;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class JsonPlaceHolderData {
 
    @Test
    public void getPostData() {
 
        RestAssured.useRelaxedHTTPSValidation();
 
        // Base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
 
        // Request
        Response res = RestAssured.given()
                .when()
                .get("/posts/1");
 
        // Convert response
        String responseBody = res.getBody().asString();
        JsonPath jpath = new JsonPath(responseBody);
 
        // Status Code
        int statusCode = res.getStatusCode();
        System.out.println("Status Code: " + statusCode);
 
       
        Assert.assertEquals(statusCode, 200);
 
        int userId = jpath.getInt("userId");
        System.out.println("UserId: " + userId);
 
        int id = jpath.getInt("id");
        System.out.println("ID: " + id);
 
        String title = jpath.getString("title");
        System.out.println("Title: " + title);
 
        String body = jpath.getString("body");
        System.out.println("Body: " + body);
    }
}
 


