package api.jsonplaceholder;

import api.jsonplaceholder.photos.Photo;
import api.jsonplaceholder.users.UserResource;
import api.spec.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PlaceHolderTest {
    private final static String URL = "https://jsonplaceholder.typicode.com/";

    @Test()
    public void test1() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<Photo> photos = given()
                .when()
                .get("photos")
                .then().log().all()
                .extract().body().jsonPath().getList(".", Photo.class);

        Assertions.assertEquals(photos.size(), 5000);
    }

    @Test
    public void test2() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserResource> users = given()
                .when()
                .get("users")
                .then().log().all()
                .extract().body().jsonPath().getList(".", UserResource.class);

        List<String> phones = new ArrayList<>();

        users.stream().filter(x -> x.getPhone().contains(".")).forEach(x -> phones.add(x.getPhone()));

        Assertions.assertEquals(2, phones.size());
    }

    @Test
    public void test3() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<Photo> photos = given()
                .when()
                .get("photos")
                .then().log().all()
                .extract().body().jsonPath().getList(".", Photo.class);

        String regex = "\\d{3}\\/";
        photos.forEach(x -> Assertions.assertEquals(x.getThumbnailUrl().replaceAll(regex, ""),
                x.getUrl().replaceAll(regex, "")));
    }

}
