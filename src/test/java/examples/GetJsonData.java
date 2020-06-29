package examples;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.when;

public class GetJsonData {


    public void validateJsonResponse() {
        int id = 5;
        Response response = when()
                .get("http://localhost:3333/posts/" + id);

        System.out.println(response.asString());

    }


    public void validateJsonPath() {
        int id = 6;
        String actualAuthor = when()
                .get("http://localhost:3333/posts/" + id)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .path("author");

        Assert.assertEquals(actualAuthor, "Author 1");
    }

    @Test
    public void validateJsonMultiplePath() {
        int id = 6;
        ValidatableResponse response = when()
                .get("http://localhost:3333/posts/" + id)
                .then()
                .contentType(ContentType.JSON);
        String actualTitle = response.extract().path("title");
        String actualAuthor = response.extract().path("author");
        int actualId = response.extract().path("id");

        Assert.assertEquals(actualAuthor, "Author 1");
        Assert.assertEquals(actualTitle, "ABC");
        Assert.assertEquals(actualId, 6);
    }
}
