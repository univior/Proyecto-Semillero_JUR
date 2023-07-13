package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static net.serenitybdd.rest.SerenityRest.given;
import io.restassured.http.Header;

public class GetAnImage implements Task {

    private final String resourceApi;

    public GetAnImage(String resourceApi) {
        this.resourceApi = resourceApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        given().
                and().when().get(resourceApi)
                .then().log().all(true).extract().response();

    }


    public static GetAnImage methodGetImage(String resourceApi){
        return Tasks.instrumented(GetAnImage.class, resourceApi);
    }


}


