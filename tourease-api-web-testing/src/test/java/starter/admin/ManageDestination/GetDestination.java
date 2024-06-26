package starter.admin.ManageDestination;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetDestination {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6ImU1NTNkMWFiLTliOTItNDQyNS1hMzU3LWI3ZWQ0OTgwMWYxMyIsIlVzZXJuYW1lIjoic3VwZXJhZG1pbiIsIlJvbGUiOiJzdXBlcmFkbWluIiwiZXhwIjoxNzE5MjA4MTkwLCJpYXQiOjE3MTkyMDY5OTAsIm5iZiI6MTcxOTIwNjk5MH0.LGVpRkciPjYSmGAgOZOuNf9W1K2nDDCBVW115iwphsQ";

    @Step("I set API endpoint for get all destination")
    public String setGetAllDestinationApiEndpoint() {
        return url + "/destinations";
    }

    @Step("I send a GET request for get all destination")
    public void sendGetAllDestinationRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetAllDestinationApiEndpoint());
    }

    @Step("I received a valid data from all destination")
    public void receivedAllDestinationData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_DESTINATION_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'nama'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'jam_buka'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'jam_tutup'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'harga_masuk'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'visit_count'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kategori'.'id_kategori'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kategori'.'nama'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'id_alamat'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'id_provinsi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'provinsi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'id_kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'id_kecamatan'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'kecamatan'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'nama_jalan'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat'.'kode_pos'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'total'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'per_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'current_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'last_page'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get destination by ID")
    public String setGetIDDestinationApiEndpoint() {
        return url + "/destinations/f968a9e0-2fae-4e1b-8ab4-edc5076b7b32";
    }

    @Step("I send a GET request with valid destination ID")
    public void sendGetIDDestinationRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetIDDestinationApiEndpoint());
    }

    @Step("I received a valid data from selected destination")
    public void receivedSelectedDestinationData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ID_DESTINATION_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id_destinasi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'nama_destinasi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'jam_buka'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'jam_tutup'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'harga_masuk'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'visit_count'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'deskripsi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'id_alamat'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'id_provinsi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'provinsi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'id_kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'id_kecamatan'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'kecamatan'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'nama_jalan'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'alamat_destinasi'.'kode_pos'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'url_gambar'.'id_media'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'url_gambar'.'url_media'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'url_gambar'.'tipe'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'url_gambar'.'judul'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kategori'.'id_kategori'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kategori'.'nama'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'fasilitas'.'id_fasilitas'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'fasilitas'.'nama'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'fasilitas'.'url_logo'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get destination by invalid ID")
    public String setFailedGetIDDestinationApiEndpoint() {
        return url + "/destinations/062701b6-3f44-413b-995a-6b90f6b3aa5a";
    }

    @Step("I send a GET request with invalid destination ID")
    public void sendFailedGetIDDestinationRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setFailedGetIDDestinationApiEndpoint());
    }

    @Step("I received a failed get destination message")
    public void receivedFailedGetDestinationMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
