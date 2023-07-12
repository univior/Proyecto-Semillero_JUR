package com.lulobank.tasks;

import com.google.gson.Gson;
import com.lulobank.models.CreateFavouriteRequest;
import io.restassured.http.Header;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.lulobank.factory.CreateImageDataFactory.SUB_ID_FAVOURITES;
import static com.lulobank.models.CreateFavouriteRequestBuilder.aFavourite;
import static net.serenitybdd.rest.SerenityRest.given;

public class PostUnHappy implements Task {
    private final String resourceApi;
    private final String image_id;
    private final String sub_id;

    public PostUnHappy(String resourceApi, String image_id, String sub_id) {
        this.resourceApi = resourceApi;
        this.image_id = image_id;
        this.sub_id = sub_id;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        CreateFavouriteRequest favourite = aFavourite()
                .withidImage(image_id)
                        .withSub_id(sub_id)
                                .build();

        String favouriteJson = new Gson().toJson(favourite);

        Header header = new Header("x-api-key" , "live_c8mWGG6stBNnmuoao87NESLH8Cv0gMohEoPCEpjHvYwPHeEqVNZvbDAwz8iVxfQJ");


         given().
                header(header)
                 .body(favourite)
                 .when().post(resourceApi)
                .then().extract().response();


    }
        public static PostUnHappy createUnHappy(String image_id , String sub_id ,String resourceApi){
            return Tasks.instrumented(PostUnHappy.class,  resourceApi, image_id , sub_id);



    }
}
