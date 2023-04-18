package examples;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter2Test {

    @Test
    public void requestZaZipCode0002_checkStatusCode_expectHttp200() {

        given().
        when().
            get("http://zippopotam.us/ZA/0002").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void requestZAZipCode0002_checkContentType_expectApplicationJson() {

        given().
        when().
            get("http://zippopotam.us/ZA/0002").
        then().
            assertThat().
            contentType(ContentType.JSON);
    }

    @Test
    public void requestZaZipCode0002_logRequestAndResponseDetails() {

        given().
            log().all().
        when().
            get("http://zippopotam.us/ZA/0002").
        then().
            log().body();
    }

    @Test
    public void requestZaZipCode4000_checkPlaceNameInResponseBody_expectDurban() {

        given().
        when().
            get("http://zippopotam.us/ZA/4000").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Durban"));
    }

    @Test
    public void requestZaZipCode4220_checkLongitudeValueInResponseBody_expect30() {

        given().
        when().
            get("http://zippopotam.us/ZA/4220").
        then().
            assertThat().
            body("places[0].longitude", equalTo("30.5833"));
    }

    @Test
    public void requestUsZipCode90210_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceNamesInResponseBody_expectOne() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'", hasSize(1));
    }
}
