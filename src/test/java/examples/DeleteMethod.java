package examples;

import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteMethod {

    @Test
    public void delete() {
        int id = 1;

        given()
                .contentType(ContentType.JSON)
        .when()
                .delete("http://localhost:3333/posts/" + id)
        .then()
                .statusCode(200);
    }
}
