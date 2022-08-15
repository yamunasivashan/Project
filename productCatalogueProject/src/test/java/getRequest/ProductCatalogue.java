package getRequest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ProductCatalogue {

	@Test
	public void postProduct() {

		String data = "{\"name\":\"Audi Car\",\"description\":\"Black audi car\", \"price\":\"800\",\"itemCount\":\"10\", \"active\" : true}";

		Response res = given().contentType("application/json").body(data).when()
				.post("https://schqarecruitment.azurewebsites.net/v1/product").then().statusCode(200).log().body()
				.extract().response();
	}

	@Test
	public void putProduct() {

		String data = "{\"name\":\"Fiat Car\",\"description\":\"Red Fiat Car\", \"price\":\"1541\",\"itemCount\":\"17\", \"active\" : true}";

		Response res = given().contentType("application/json").body(data).when().put("https://schqarecruitment.azurewebsites.net/v1/product/9335448e-32bd-4f46-991e-2cdd55f35fc8")

					  .then().statusCode(200).log().body().extract().response();

	}
	
	@Test
	public void deletetProduct() {

		given().when().delete("https://schqarecruitment.azurewebsites.net/v1/product/d58fc9b3-58d4-4f2e-bf31-7c5979bb8990")

				.then().statusCode(200).log().body().extract().response();

	}

	@Test
	public void getSingleProduct() {

		int code = get("https://schqarecruitment.azurewebsites.net/v1/product/9335448e-32bd-4f46-991e-2cdd55f35fc8")
				.getStatusCode();

		System.out.println(code);

	}

	@Test
	public void getAllProducts() {

		int code = get("https://schqarecruitment.azurewebsites.net/v1/products").getStatusCode();

		System.out.println(code);
	}

	

}
