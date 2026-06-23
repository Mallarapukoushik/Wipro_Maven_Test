package Postman;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
import io.restassured.response.Response;
 
public class Get_ReqRes {
	@Test
	public void getUser()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response=given().relaxedHTTPSValidation() .header("x-api-key","reqres_3d74667b02be46d3becef9d68e5e7665")
		.when().get("/api/users?page=2");
		
		//Printing the Data
		System.out.println("Full Response: ");
		System.out.println(response.asPrettyString());
		
		System.out.println("Status Code: "+response.getStatusCode());
		
		response.then().statusCode(200);
	}
}

