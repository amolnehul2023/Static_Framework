package Test_Classes;

import org.testng.Assert;

import Common_API_Methods.API_Methods;
import RequestRepository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	
	public static void extractor() {
		int statusCode= API_Methods.ResponceStatusCode(Patch_Req_Repository.BaseURI(), Patch_Req_Repository.Patch_Resource(),
				Patch_Req_Repository.Patch_Req_TC1());
		System.out.println(statusCode);
		
		String ResponceBody = API_Methods.ResponceBody(Patch_Req_Repository.BaseURI(), Patch_Req_Repository.Patch_Resource(),
				Patch_Req_Repository.Patch_Req_TC1());
		System.out.println(ResponceBody);
		
		JsonPath JspResponce = new JsonPath(ResponceBody);
		String Res_name = JspResponce.getString("name");
		String Res_job = JspResponce.getString("job");
		
		Assert.assertEquals(Res_name, "Amol");
		Assert.assertEquals(Res_job, "Tester");
	}

}
