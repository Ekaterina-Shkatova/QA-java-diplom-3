package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.BasicConfigurator;

import static burgertest.Resources.*;
import static burgertest.Resources.DELETE_USER_API;
import static io.restassured.RestAssured.given;

public class ApiSteps {

    @Step("Создать пользователя")
    public void userCreate(String name, String email, String password) {

        String jsonString = "{\"name\": \"" + name + "\", \"email\": \"" + email + "\", \"password\": \"" + password + "\"}";

        BasicConfigurator.configure();
        RestAssured.baseURI = BASE_URL;
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(jsonString)
                        .when()
                        .post(CREATE_USER_API);
    }

    @Step("Удалить пользователя")
    public Response userDelete(String email, String password) throws JsonProcessingException {

        String jsonString = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}";

        BasicConfigurator.configure();
        RestAssured.baseURI = BASE_URL;
        String responseLogin =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(jsonString)
                        .when()
                        .post(LOGIN_USER_API).getBody().asPrettyString();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseLogin);
        String accessToken = jsonNode.get("accessToken").asText();

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .header("authorization", accessToken)
                        .when()
                        .delete(DELETE_USER_API);
        return response;
    }
}
