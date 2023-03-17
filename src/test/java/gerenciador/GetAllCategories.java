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
                .header("Autorization", token)
                .contentType(ContentType.JSON)
                .post("/get_all_categories")
                .then()
                .log()
                .all()
                //.assertThat()
                //.body("id", equalTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"))
                //.body("category", equalTo("[tecnologia na educação, turismo na educação, musculação na educação, empreendedorismo na educação, tecnologia, automobilismo, empreendedorismo, turismo, nova_categoria_via_postman, nova_categoria_via_postman]"))
            ;
    }

    @Test
    public void GetCategories401(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Autorization", tokenFail)
                .contentType(ContentType.JSON)
                .post("/get_all_categories")
                .then()
                .statusCode(401)
        ;
    }
}
