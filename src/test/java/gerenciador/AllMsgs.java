package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.equalToPath;

public class AllMsgs extends Token{
    @Test
    public void AllMsgs200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Autorization", token)
                .contentType(ContentType.JSON)
                .get("/all")
                .then()
                .assertThat()
                .body("description.type", equalToPath("string"))
                .body("source.type", equalToPath("string"))
                .log();
    }

    @Test
    public void AllMsgs401(){
        baseURI = "http://127.0.0.1";
        port = 3500;


        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Autorization", tokenFail)
                .contentType(ContentType.JSON)
                .get("/all")
                .then()
                .statusCode(401)
                .assertThat()
                .body("examples.msg", equalToPath("examples.msg"));
    }
}
