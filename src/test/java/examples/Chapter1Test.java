package examples;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter1Test {

    @Test
    public void requestZaZipCode0002_checkPlaceNameInResponseBody_expectPretoria() {

        given().
        when().
            get("http://zippopotam.us/ZA/0002").
        then().
            assertThat().
            body("places[0].'place name'", equalTo("Pretoria")).log().all();
    }
}
