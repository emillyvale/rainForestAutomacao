package gerenciador;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Token {

    public String authenticacaoAdm() {

        String token = given()
                .body("{\n" +
                        "   \"api_key\" : \"b96e9a4a-fd76-4a03-8080-ea53e264001a\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/authorization")
                .then()
                .log().all()
                .extract()
                .path("access_token");
        return token;
    }

    public String authenticacaoFake() {

        String tokenFail = String.valueOf(0);
        return tokenFail;
    }
}
