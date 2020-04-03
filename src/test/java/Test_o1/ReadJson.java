package Test_o1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class ReadJson {
	public String url;
	@BeforeMethod
	public void setUp() {
		url="https://jsonplaceholder.typicode.com/posts/2";
	}
	@Test
	public void test02() {
		given()
		.when()
			.get(url)
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	public void test03() {
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/")
		.then()
		.statusCode(200)
		.log().all();
	}

}
