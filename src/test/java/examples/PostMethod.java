package examples;

import com.jayway.restassured.http.ContentType;
import commonExamples.BodyValues;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class PostMethod {

    public void bddValidation() {
        // http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json
        given().param("t", "Spiderman")
                .param("y", "")
                .param("plot", "short")
                .param("r", "json")
                .when().get("http://www.omdbapi.com")
                .then().statusCode(200);
    }

    @Test
    public void postMethod() {
        BodyValues cpost = new BodyValues();
        cpost.setId(6);
        cpost.setTitle("ABC");
        cpost.setAuthor("Author 1");

        given()
                .contentType(ContentType.JSON)
                .body(cpost)
                .when()
                .post("http://localhost:3333/posts")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON);
    }
}
