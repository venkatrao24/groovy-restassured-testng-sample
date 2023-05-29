import io.restassured.path.json.JsonPath
import io.restassured.path.xml.XmlPath
import io.restassured.response.Response

import java.nio.file.Files
import java.nio.file.Paths

class Utilities {

    static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)))
    }

    static XmlPath rawToXML(Response res) {
        String response = res.asString()
        XmlPath x = new XmlPath(response)
        return x
    }

    static JsonPath rawToJSON(Response res) {
        String responseString = res.asString()
        JsonPath js = new JsonPath(responseString)
        return js
    }
}
