package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;

public class Authorization extends Token{
    @Test
    public void Authorization200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .then()
                .log();
    }

    @Test
    public void Authorization401(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        given()
                .body("{\n" +
                        "   \"apii_key\" : \"b96e9a4a-fd76-4a03-8080-ea53e264001a\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/authorization")
                .then()
                .log().all()
                .statusCode(401);
    }

    @Test
    public void Authorization404(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        given()
                .body("{\n" +
                        "   \"api_key\" : \"b96e9a4a-fd76-4a03-8080-ea53e264001a\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/authorizationn")
                .then()
                .log().all()
                .statusCode(404);
    }
}
