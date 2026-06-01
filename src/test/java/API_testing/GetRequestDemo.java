package API_testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.containsString;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class GetRequestDemo {

	public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://gorest.co.in/";

        System.out.println("============== GET REQUEST ==============");

        // GET Request
        Response getResponse = given()
                    .when()
                    .get("/public/v2/users/8056485");

        // Print Response
        System.out.println("Status Code : "
                + getResponse.getStatusCode());

        System.out.println("Response Body : ");
        System.out.println(getResponse.getBody().asString());

        System.out.println("Response Time : "
                + getResponse.getTime());

        System.out.println("Content Type : "
                + getResponse.getContentType());



       System.out.println("\n============== VALIDATIONS ==============");

        // Validations
       given()

       .when()
           .get("/public/v2/users/8056485")

       .then()
           .statusCode(200)
           .body("id", equalTo(8056485))
           .body("name", equalTo("Suresh Gupta"))
           .body("email", equalTo("gupta_suresh@mante.example"))
           .body("gender", equalTo("male"))
           .body("status", equalTo("active"))
           .time(lessThan(5000L))
           .header("Content-Type", containsString("application/json"))
           .log().all();



        System.out.println("\n============== JSON EXTRACTION ==============");

        // JSON Extraction
        JsonPath jsonPath =
                getResponse.jsonPath();

        int id =
                jsonPath.getInt("id");
        
        String name =
                jsonPath.getString("name");

        String email =
                jsonPath.getString("email");

        String gender =
                jsonPath.getString("gender");
        String status =
                jsonPath.getString("status");

        System.out.println("ID : " + id);
        
        System.out.println("Name : " + name);

        System.out.println("Email : " + email);

        System.out.println("Gender : " + gender);

        System.out.println("Status : " + status);


        
        System.out.println("\n============== POST REQUEST ==============");
        
	 	// Request Body
	    String postRequestBody = "{ "
	            + "\"user_id\":8477478,"
	            + "\"title\":\"API Testing\","
	            + "\"body\":\"Post created using postman\""
	            + "}";
 
	    // Bearer Token
	    String token = "dff6f33b2a6d623dafc74cee468ce814344f5ee0c0105adae9db108c7d83aa92";
 
	    // POST Request
	    Response postResponse =
	            given()
	                .header("Authorization", "Bearer " + token)
	                .contentType(ContentType.JSON)
	                .body(postRequestBody)
	            .when()
	                .post("/public/v2/posts");
 
	    // Print Response
	    System.out.println("Status Code : " + postResponse.getStatusCode());
	    System.out.println("Response Body : ");
	    System.out.println(postResponse.getBody().asString());
        // POST Validation
	    postResponse.then()

        .statusCode(201)

        .body("id", notNullValue())
        .body("user_id", equalTo(8477478))
        .body("title", equalTo("API Testing"))
        .body("body", equalTo("Post created using postman"))

        .log().all();

// Extract Generated ID
String generatedId =
        postResponse.jsonPath().getString("id");

System.out.println("Generated ID : "
        + generatedId);



/*System.out.println("\n============== PUT REQUEST ==============");

given()

.when()

    .put("/public/v2/users/8056479")

.then()

    .statusCode(200)

    .body("id", equalTo(8052292))
    .body("name", equalTo("Nitesh kumar"))
    .body("email", equalTo("nk1@gmail.com"))
    .body("gender", equalTo("male"))
    .body("status", equalTo("active"))

    .log().all();



       /* System.out.println("\n============== DELETE REQUEST ==============");

        // DELETE Request
        given()

        .when()

            .delete("/api/users/2")

        .then()

            .statusCode(204)

            .log().all();



        System.out.println("\n============== PATH PARAMETER ==============");

        // Path Parameter
        given()

            .pathParam("id", 2)

        .when()

            .get("/api/users/{id}")

        .then()

            .statusCode(200)

            .log().all();



        System.out.println("\n============== QUERY PARAMETER ==============");

        // Query Parameter
        given()

            .queryParam("page", 2)

        .when()

            .get("/api/users")

        .then()

            .statusCode(200)

            .log().all();



        System.out.println("\n============== HEADERS ==============");

        // Headers Example
        given()

            .header("Content-Type",
                    "application/json")

        .when()

            .get("/api/users/2")

        .then()

            .statusCode(200)

            .log().headers();



        System.out.println("\n============== BEARER TOKEN AUTH ==============");

        // Bearer Token Example

        String token = "YOUR_TOKEN";

        given()

            .header("Authorization",
                    "Bearer " + token)

        .when()

            .get("https://gorest.co.in/public/v2/users")

        .then()

            .statusCode(200)

            .log().all();



        System.out.println("\n============== REQUEST CHAINING ==============");

        // POST Request
        Response chainResponse =

                given()

                    .contentType(ContentType.JSON)

                    .body(postRequestBody)

                .when()

                    .post("/api/users");

        // Extract ID
        String chainId =
                chainResponse.jsonPath().getString("id");

        System.out.println("Chain ID : "
                + chainId);

        // GET using same ID
        given()

            .pathParam("id", chainId)

        .when()

            .get("/api/users/{id}")

        .then()

            .log().all();



        System.out.println("\n============== JSON SCHEMA VALIDATION ==============");

        // Schema Validation
        given()

        .when()

            .get("/api/users/2")

        .then()

            .assertThat()

            .body(matchesJsonSchemaInClasspath(
                    "schema.json"))

            .log().all();



        System.out.println("\n============== PRINT HEADERS ==============");

        // Print Headers
        getResponse.getHeaders().forEach(
                System.out::println);



        System.out.println("\n============== PRINT COOKIES ==============");

        // Print Cookies
        getResponse.getCookies().forEach(
                (k,v) -> System.out.println(
                        k + " : " + v));



        System.out.println("\n============== TEST COMPLETED ==============");
        */
    }

}