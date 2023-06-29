package Common_API_Methods;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_Methods {
	
	public static int ResponceStatusCode(String BaseURI, String Resource, String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		
		int StatusCode=given().header("Content-Type","application/json").body(RequestBody).when().post(Resource).then().extract()
				.statusCode();
        return StatusCode;
	}
    public static String ResponceBody(String BaseURI, String Resource, String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		
		String ResponceBody=given().header("Content-Type","application/json").body(RequestBody).when().post(Resource).then().extract()
				.response().asString();
        return ResponceBody;

}
}
