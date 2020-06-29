package examples;

import com.jayway.restassured.http.ContentType;
import commonExamples.BodyValues;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class PatchMethod {

    @Test
    public void updatePatch() {
        int id = 1;
        BodyValues cpost = new BodyValues();
        cpost.setAuthor("updated");

        given()
                .contentType(ContentType.JSON)
                .body(cpost)
                .when()
                .patch("http://localhost:3333/posts/" + id)
                .then()
                .statusCode(200);
    }
}
