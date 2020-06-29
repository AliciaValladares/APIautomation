package APIautomation;

import APIautomation.apiLibrary.Post;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

public class tests {

    @Test
    public void test1() {
        int input = 29;

        Post cpost = new Post();
        cpost.setId(input);
        cpost.setTitle("Title 29");
        cpost.setAuthor("Author 29");

        //Step 1: creating a resource and validate is inserted correctly.
        ValidatableResponse statusCode = given()
                .contentType(ContentType.JSON)
                .body(cpost)
        .when()
                .post("http://localhost:3333/posts")
        .then()
                .contentType(ContentType.JSON);

        int responseId = statusCode.extract().path("id");
        int actualStatusCode = statusCode.extract().response().getStatusCode();

        Assert.assertEquals(actualStatusCode, 201);

        //Step 2: Get request where we can get data inserted in the step 1 and validate this data.
        ValidatableResponse respId = when()
                .get("http://localhost:3333/posts/" + responseId)
        .then()
                .contentType(ContentType.JSON);

        String actTitle = respId.extract().path("title");
        String actAuthor = respId.extract().path("author");

        Assert.assertEquals(actTitle, "Title 29");
        Assert.assertEquals(actAuthor, "Author 29");

        // Update resource created and get title and author values
        Post cpostUpdate = new Post();
        cpostUpdate.setId(input);
        cpostUpdate.setTitle("Updated title");
        cpostUpdate.setAuthor("Updated author");

        ValidatableResponse respUpdate = given()
                .contentType(ContentType.JSON)
                .body(cpostUpdate)
        .when()
                .put("http://localhost:3333/posts/" + input)
        .then()
                .contentType(ContentType.JSON);

        ValidatableResponse respUpdated = when()
                .get("http://localhost:3333/posts/" + responseId)
                .then()
                .contentType(ContentType.JSON);

        String updatedTitle = respUpdated.extract().path("title");
        String updatedAuthor = respUpdated.extract().path("author");

        Assert.assertEquals(updatedTitle, "Updated title");
        Assert.assertEquals(updatedAuthor, "Updated author");

        //Step 4: delete the resource and check it has been removed.
        when()
                .delete("http://localhost:3333/posts/" + input);

        ValidatableResponse respDelete = when()
                .get("http://localhost:3333/posts/" + responseId)
        .then()
                .contentType(ContentType.JSON);

        Assert.assertNotEquals(respDelete.extract().response().statusCode(), 201);

    }


}
