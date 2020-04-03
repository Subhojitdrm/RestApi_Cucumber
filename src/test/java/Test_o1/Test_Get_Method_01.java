package Test_o1;

import static io.restassured.RestAssured.*;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

public class Test_Get_Method_01 {
	
	@Test
	public void thisIs() {
		given()
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
			.assertThat().statusCode(200);
	
	}
	@Test
	public void validateReport() {
		
		given()
		.when()
		.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
		.assertThat()
		.body("status", Is.is("success"));
		
	}
	
	
	
	
}
