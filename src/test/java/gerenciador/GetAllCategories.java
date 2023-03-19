package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;
import static org.hamcrest.Matchers.equalTo;

public class GetAllCategories extends Token{
    @Test
    public void GetCategories200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .post("/get_all_categories")
                .then()
                .log()
                .all();
    }

    @Test
    public void GetCategories404(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Authorization", tokenFail)
                .contentType(ContentType.JSON)
                .post("/get_categories")
                .then()
                .statusCode(404);
    }
}
