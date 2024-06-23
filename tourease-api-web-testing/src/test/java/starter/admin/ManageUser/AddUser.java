package starter.admin.ManageUser;

import  io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class AddUser {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjNkZTc3ZDNhLTA1NDItNDY0My04N2ZkLTcxNWNhZmEzYzExNyIsIlVzZXJuYW1lIjoiYWRtaW50b3VyZWFzZSIsIlJvbGUiOiJhZG1pbiIsImV4cCI6MTcxOTE1NjYyMCwiaWF0IjoxNzE5MTU1NDIwLCJuYmYiOjE3MTkxNTU0MjB9.Ygkn7STsOSKDoIRjNoJOcLml3QQIOe2QJt8E9eUb-cg";

    @Step("I set API endpoint for add user data")
    public String setAddUserApiEndpoint() {
        return url + "/users";
    }

    @Step("I send a POST request for add user data")
    public void sendAddUserRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "qealterraaaa")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "nama lengkap")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "qealterraaa@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .post(setAddUserApiEndpoint());
    }

    @Step("I receive status code 201")
    public void receiveStatusCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I received a valid data from new user")
    public void receivedNewUserData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADD_USER_SCHEMA);

        restAssuredThat(response -> response.body("status", notNullValue()));
        restAssuredThat(response -> response.body("message", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request for add user data without body data")
    public void sendInvalidAddUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .post(setAddUserApiEndpoint());
    }

    @Step("I receive status code 400")
    public void receiveStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I received a failed add user message")
    public void receivedFailedAddUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_ADD_USER_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request for add user data with invalid profile picture format")
    public void sendInvalidAddUserProfileRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/testaja.txt");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "arlec")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "nama lengkap")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "arlec@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .post(setAddUserApiEndpoint());
    }

    @Step("I send a POST request for add user data with an already registered username")
    public void sendAddRegisteredUsernameRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "arlec")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "nama lengkap")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "arlec@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .post(setAddUserApiEndpoint());
    }

    @Step("I receive status code 409")
    public void receiveStatusCode409() {
        restAssuredThat(response -> response.statusCode(409));
    }

    @Step("I received a failed username or email already in use message")
    public void receivedFailedNewUserData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request for add user data with an already registered email")
    public void sendAddRegisteredEmailRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "notarlec")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "nama lengkap")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "arlec@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .post(setAddUserApiEndpoint());
    }
}
