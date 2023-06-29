package RequestRepository;

public class Patch_Req_Repository {
	
	public static String BaseURI() {
		
		String baseURI="https://reqres.in/";
		return baseURI;
	}
    public static String Patch_Resource() {
    	String Patch_Resource = "api/users";
    	return Patch_Resource;
    	
    }
    public static String Patch_Req_TC1() {
    	String RequestBody="{\r\n"
    			+ "    \"name\": \"Amol\",\r\n"
    			+ "    \"job\": \"Tester\"\r\n"
    			+ "}";
    	return RequestBody;
    	
    	
    	
    }
 }
