package Test_o1;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtils.ReadTestData;
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
			.statusCode(200);
	}
	@DataProvider(name="SearchProvider")
	public Object[] getdata() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[] data= ReadTestData.readData();
		return data;
	}
	@Test(dataProvider="SearchProvider")
	public void test03(String name) {
		given()
		.when()
		.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
		.statusCode(200)
		.assertThat()
		.body("data.employee_name", hasItem(name));
		
	}

}
