package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ById extends Token{
    @Test
    public void ById200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"message_id\": 10\n" +
                        "}")
                .when()
                .post("/by_id")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void ById401(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"message_id\": 10\n" +
                        "}")
                .when()
                .post("/by_id")
                .then()
                .log().all()
                .statusCode(401);
    }

    @Test
    public void ById500(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"message_id\": \n" +
                        "}")
                .when()
                .post("/by_id")
                .then()
                .log().all()
                .statusCode(500);
    }
}
