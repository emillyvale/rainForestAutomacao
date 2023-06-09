package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class AddCategories extends Token{
    @Test
    public void Add200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Autorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"category\":\"nova_categoria_via_postman\"\n" +
                        "}")
                .post("/add_category")
                .then()
                .statusCode(200);
    }

    @Test
    public void AddCategories500(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Autorization", tokenFail)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"categ0ry\":\"nova_categoria_via_postman\"\n" +
                        "}")
                .post("/add_category")
                .then()
                .statusCode(500);
    }
}
