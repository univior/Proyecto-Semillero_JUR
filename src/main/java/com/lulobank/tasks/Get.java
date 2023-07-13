package com.lulobank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static com.lulobank.factory.CreateImageDataFactory.id;
import static net.serenitybdd.rest.SerenityRest.given;

public class Get implements Task {

    private String resourceApi;

    public Get(String resourceApi) {
        this.resourceApi = resourceApi;
    }


    @Step("{0} consume get method")
    @Override
    public <T extends Actor> void performAs(T actor) {

            given().
                and().when().get(resourceApi);
                String api_Key = "live_c8mWGG6stBNnmuoao87NESLH8Cv0gMohEoPCEpjHvYwPHeEqVNZvbDAwz8iVxfQJ";
                given().
                header("Authorization", "Bearer" + api_Key)
                .when().get(resourceApi)
                .then().extract().response();

    }

    public static Get iexecuteGetMethodWithThe(String resourceApi){
        return Tasks.instrumented(Get.class, resourceApi);
    }

}
