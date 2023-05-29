import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ExampleTest {
  @Test
  public static void main(String[] args) {
    RestAssured.baseURI = "https://maps.googleapis.com";

    RestAssured.given()
        .param("location", "-33.8670522,151.1957362")
        .param("radius", "500")
        .param("types", "food")
        .param("name", "harbour")
        .param("key", "") //TODO: Update this API Key
        .when()
        .get("maps/api/place/nearbysearch/json")
        .then()
        .assertThat()
        .statusCode(200);
  }
}
