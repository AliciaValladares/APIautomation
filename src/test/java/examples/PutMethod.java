package examples;

import com.jayway.restassured.http.ContentType;
import commonExamples.BodyValues;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;

public class PutMethod {

    @Test
    public void update() {
        int id = 5;
        BodyValues cpost = new BodyValues();
        cpost.setId(id);
        cpost.setTitle("spiderman");
        cpost.setAuthor("updated");

        given()
                .contentType(ContentType.JSON)
                .body(cpost)
        .when()
                .put("http://localhost:3333/posts/" + id)
        .then()
                .statusCode(200);
    }
}
