package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import RequestRepository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	@Test
	public static void extractor() {
		int statusCode= API_Methods.ResponceStatusCode(Put_Req_Repository.BaseURI(), Put_Req_Repository.Put_Resource(),
				Put_Req_Repository.Put_Req_TC1());
		System.out.println(statusCode);
		
		String ResponceBody = API_Methods.ResponceBody(Put_Req_Repository.BaseURI(), Put_Req_Repository.Put_Resource(),
				Put_Req_Repository.Put_Req_TC1());
		System.out.println(ResponceBody);
		
		JsonPath JspResponce = new JsonPath(ResponceBody);
		String Res_name = JspResponce.getString("name");
		String Res_job = JspResponce.getString("job");
		
		Assert.assertEquals(Res_name, "Rahul");
		Assert.assertEquals(Res_job, "Tester");
	}

}
