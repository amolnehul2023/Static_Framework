package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
	public static void extractor() throws IOException {
		int statusCode= API_Methods.ResponceStatusCode(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(),
				Post_Req_Repository.Post_Req_TC1());
		System.out.println(statusCode);
		
		String ResponceBody = API_Methods.ResponceBody(Post_Req_Repository.BaseURI(), Post_Req_Repository.Post_Resource(),
				Post_Req_Repository.Post_Req_TC1());
		System.out.println(ResponceBody);
		
		JsonPath JspResponce = new JsonPath(ResponceBody);
		String Res_name = JspResponce.getString("name");
		String Res_job = JspResponce.getString("job");
		
		Assert.assertEquals(Res_name, "Amol");
		Assert.assertEquals(Res_job, "Tester");
	}

}
