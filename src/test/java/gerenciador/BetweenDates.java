package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class BetweenDates extends Token{
    @Test
    public void Add200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Autorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"from_date\":\"2023-01-01\",\n" +
                        "    \"until_date\":\"2023-05-05\"\n" +
                        "}")
                .post("/between_date")
                .then()
                .statusCode(200);
    }

    @Test
    public void Add500(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Autorization", tokenFail)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"fromm_date\":\"2023-01-01\",\n" +
                        "    \"until_date\":\"2023-05-05\"\n" +
                        "}")
                .post("/between_date")
                .then()
                .statusCode(500);
    }
}
