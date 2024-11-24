import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;

public class PostmanEchoTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetMethod() {
        Response response = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2");

        Assertions.assertEquals(200, response.getStatusCode());

        String foo1 = response.jsonPath().getString("args.foo1");
        String foo2 = response.jsonPath().getString("args.foo2");

        Assertions.assertEquals("bar1", foo1);
        Assertions.assertEquals("bar2", foo2);
    }

    @Test
    public void testPostMethod() {
        Response response = given()
                .contentType("application/json")
                .body("{ \"name\": \"John\", \"age\": 30 }")
                .when()
                .post("/post");

        Assertions.assertEquals(200, response.getStatusCode());

        String name = response.jsonPath().getString("json.name");
        int age = response.jsonPath().getInt("json.age");

        Assertions.assertEquals("John", name);
        Assertions.assertEquals(30, age);
    }

    @Test
    public void testPostMethodRawText() {
        Response response = given()
                .contentType("text/plain")
                .body("This is raw text content")
                .when()
                .post("/post");

        Assertions.assertEquals(200, response.getStatusCode());

        String data = response.jsonPath().getString("data");
        Assertions.assertEquals("This is raw text content", data);
    }

    @Test
    public void testPutMethod() {
        Response response = given()
                .contentType("application/json")
                .body("{ \"name\": \"Alice\", \"city\": \"New York\" }")
                .when()
                .put("/put");

        Assertions.assertEquals(200, response.getStatusCode());

        String name = response.jsonPath().getString("json.name");
        String city = response.jsonPath().getString("json.city");

        Assertions.assertEquals("Alice", name);
        Assertions.assertEquals("New York", city);
    }

    @Test
    public void testPatchMethod() {
        Response response = given()
                .contentType("application/json")
                .body("{ \"name\": \"Charlie\", \"age\": 35 }")
                .when()
                .patch("/patch");

        Assertions.assertEquals(200, response.getStatusCode());

        String name = response.jsonPath().getString("json.name");
        int age = response.jsonPath().getInt("json.age");

        Assertions.assertEquals("Charlie", name);
        Assertions.assertEquals(35, age);
    }

    @Test
    public void testDeleteMethod() {
        Response response = given()
                .when()
                .delete("/delete?key=value");

        Assertions.assertEquals(200, response.getStatusCode());

        response = given()
                .when()
                .get("/delete?key=value");

        Assertions.assertEquals(404, response.getStatusCode());
    }
}
