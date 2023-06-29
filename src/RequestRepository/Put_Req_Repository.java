package RequestRepository;

public class Put_Req_Repository {
	
	public static String BaseURI() {
		
		String baseURI="https://reqres.in/";
		return baseURI;
	}
    public static String Put_Resource() {
    	String Put_Resource = "api/users";
    	return Put_Resource;
    	
    }
    public static String Put_Req_TC1() {
    	String RequestBody="{\r\n"
    			+ "    \"name\": \"Rahul\",\r\n"
    			+ "    \"job\": \"Tester\"\r\n"
    			+ "}";
    	return RequestBody;
    	
    	
    	
    }
 }
