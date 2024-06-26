package starter.admin.ManageUser;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class EditUser {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjNkZTc3ZDNhLTA1NDItNDY0My04N2ZkLTcxNWNhZmEzYzExNyIsIlVzZXJuYW1lIjoiYWRtaW50b3VyZWFzZSIsIlJvbGUiOiJhZG1pbiIsImV4cCI6MTcxOTM4NDU4MSwiaWF0IjoxNzE5MzgzMzgxLCJuYmYiOjE3MTkzODMzODF9.05pvcbThV9YKVSjw3DwMdVwskChmevQkDLI8U2FAqsg";

    @Step("I set API endpoint for edit user data")
    public String setEditUserApiEndpoint() {
        return url + "/users/083cb941-9a91-4ea4-af6e-5b25384ff00b";
    }

    @Step("I send a PUT request for edit user data")
    public void sendEditUserRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "aventurine")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "aventurine")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "aventurine@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .put(setEditUserApiEndpoint());
    }

    @Step("I received a success edit message")
    public void receivedSuccessEdit() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a PUT request for edit user data without body data")
    public void sendInvalidEditUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .put(setEditUserApiEndpoint());
    }

    @Step("I received a failed edit user message")
    public void receivedFailedEdit() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_EDIT_USER_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a PUT request for edit user data with invalid profile picture format")
    public void sendInvalidEditUserProfileRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/testaja.txt");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "aventurine")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "aventurine")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "aventurine@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .put(setEditUserApiEndpoint());
    }

    @Step("I send a PUT request for edit user data with an already registered username")
    public void sendEditRegisteredUsernameRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "zain")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "aventurine")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "aventurine@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .put(setEditUserApiEndpoint());
    }

    @Step("I send a PUT request for edit user data with an already registered email")
    public void sendEditRegisteredEmailRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "aventurine")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "aventurine")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "shuu@example.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .put(setEditUserApiEndpoint());
    }

    @Step("I set API endpoint for edit user detail by invalid ID")
    public String setFailedEditIDUserApiEndpoint() {
        return url + "/users/00862788-5ded-4065-8275-2569748f64aa";
    }

    @Step("I send a PUT request with invalid user ID")
    public void sendFailedEditIDUserRequest() {
        File sampleFile = new File("src/test/java/starter/admin/ManageUser/path.jpg");

        SerenityRest.given()
                .contentType(ContentType.MULTIPART)
                .multiPart("username", "aventurine")
                .multiPart("password", "123321")
                .multiPart("nama_lengkap", "aventurine")
                .multiPart("bio", "aaqqqqqq")
                .multiPart("email", "aventurine@gmail.com")
                .multiPart("no_telepon", "081818181818")
                .multiPart("foto_profil",sampleFile)
                .multiPart("jenis_kelamin", "pria")
                .multiPart("kota", "jakarta selatan")
                .multiPart("provinsi", "jakarta")
                .header("Authorization", "Bearer " + token)
                .put(setFailedEditIDUserApiEndpoint());
    }

    @Step("I received an account not found message")
    public void receivedFailedEditUserMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
