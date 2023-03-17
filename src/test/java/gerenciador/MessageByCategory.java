package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class MessageByCategory extends Token{
    @Test
    public void MessageCategory200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Autorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"category\":\"tecnologia\"\n" +
                        "}")
                .post("/by_category")
                .then()
                .statusCode(200);
    }

    @Test
    public void MessageCategory401(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Autorization", tokenFail)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"category\":\"tecnologia\"\n" +
                        "}")
                .post("/by_category")
                .then()
                .statusCode(401);
    }
}
