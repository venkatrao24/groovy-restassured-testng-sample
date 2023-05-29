import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.path.json.JsonPath
import io.restassured.path.xml.XmlPath
import io.restassured.response.Response
import org.testng.annotations.Test

import static org.hamcrest.Matchers.equalTo

class basics {

    @Test
    def basic_get_test() {
        RestAssured.baseURI = "https://maps.googleapis.com"

        Response res = RestAssured.given()
                .param("location", "-33.8670522,151.1957362")
                .param("radius", "500")
                .param("types", "food")
                .param("name", "harbour")
                .param("key", "").log().all() //TODO: update this api key
                .when().get(PayLoad.getSearchPathJson())
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("results[0].name", equalTo("Harbour Bar & Kitchen"))
                .and().body("results[0].place_id", equalTo("ChIJkeO_AzquEmsRUpGQn1ZK7Tg"))
                .and().header("Server", "scaffolding on HTTPServer2")
                .extract().response()
        JsonPath js = Utilities.rawToJSON(res)
        def count = js.get("results.size()")
        for (int i = 0; i < count; i++) {
            println "Name: " + js.get("results[${i}].name")
        }

    }

    @Test
    void post_delete_data_test_json() {
        println "BaseURL: " + System.getProperty("baseUrlDelete")
        RestAssured.baseURI = System.getProperty("baseUrlDelete")
        def response = RestAssured.given()
                .queryParam("key", System.getProperty("deleteKey"))
                .body(PayLoad.getPostPayLoadJson())
                .when().post(PayLoad.getAddPlacePathJson())
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("status", equalTo("OK"))
                .extract().response()
        def responseString = response.asString()
        println "Raw Response: " + response
        println "Response String: " + responseString
        JsonPath js = new JsonPath(responseString)
        def place_id = js.get("place_id")

        RestAssured.given()
                .queryParam("key", System.getProperty("deleteKey"))
                .body("{\"place_id\":\"${place_id}\"}")
                .when().post(PayLoad.getDeletePathJson())
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("status", equalTo("OK"))

    }

    @Test
    void post_delete_data_test_xml() {
        URL url = getClass().getResource("AddPlaceXML.xml")
        def post_data_xml = Utilities.GenerateStringFromResource(url.getPath())
        println "BaseURL: " + System.getProperty("baseUrlDelete")
        RestAssured.baseURI = System.getProperty("baseUrlDelete")
        Response response = RestAssured.given()
                .queryParam("key", System.getProperty("deleteKey"))
                .body(post_data_xml)
                .when().post(PayLoad.getAddPlacePathXml())
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.XML)
        //                .and().body("status",equalTo("OK"))
                .extract().response()
        XmlPath x = Utilities.rawToXML(response)
        String status = x.get("response.status")
        println status

        def responseString = response.asString()
        println "Raw Response: " + response
        println "Response String: " + responseString
    }

//    @Test(groups="deleteExisting")
    static void delete_existing_data() {
        RestAssured.baseURI = "" //TODO: Add baseURI to perform delete operation
        RestAssured.given()
                .queryParam("key", "") //TODO: Add key to perform delete operation
                .when().post(PayLoad.getDeletePathJson())
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("status", equalTo("OK"))
    }

}
