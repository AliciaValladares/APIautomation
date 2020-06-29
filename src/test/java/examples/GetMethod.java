package examples;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.response.Response;
import org.testng.Assert;

public class GetMethod {


    public void getValidation() {
        Response response = get("https://samples.openweathermap.org");
        //System.out.println(response.asString());

        //Validate response status code
        //System.out.println(response.getStatusCode());
        //Assert.assertEquals(200, response.getStatusCode());

        //Validate response content type
        //System.out.println(response.getContentType());
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }



}
