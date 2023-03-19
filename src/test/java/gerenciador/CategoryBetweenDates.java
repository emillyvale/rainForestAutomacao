package gerenciador;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class CategoryBetweenDates extends Token{
    @Test
    public void CategoryBates200(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String token = new Token().authenticacaoAdm();

        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"category\":\"tecnologia\",\n" +
                        "    \"from_date\":\"2023-01-01\",\n" +
                        "    \"until_date\":\"2023-05-05\"\n" +
                        "}")
                .post("/category_between_date")
                .then()
                .statusCode(200);
    }

    @Test
    public void CategoryBates500(){
        baseURI = "http://127.0.0.1";
        port = 3500;

        String tokenFail = new Token().authenticacaoFake();

        given()
                .header("Authorization", tokenFail)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"categoryy\":\"tecnologia\",\n" +
                        "    \"from_date\":\"2023-01-01\",\n" +
                        "    \"until_date\":\"2023-05-05\"\n" +
                        "}")
                .post("/category_between_date")
                .then()
                .statusCode(500);
    }

}
