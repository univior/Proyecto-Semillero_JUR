package com.lulobank.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class Response {

    public static Question <Integer> getStatusCode(){
        return Question.about("Status code").answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }

    public static Question<String> getURLImage(){
        return Question.about("Get URL Image").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("$['url']").toString());
    }

    public static Question<String> getMessage(){
        return Question.about("Get message").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("message").toString());
    }

    public static Question<String> createfavouritesImagen(){
        return Question.about("Get favourite SUCCESS").answeredBy(actor -> JsonPath.from(SerenityRest.lastResponse().body().asString()).get("message").toString());
    }


    public static Question<String> getmessageF(){
        return Question.about("Get messageF").answeredBy(actor -> (SerenityRest.lastResponse().getBody().asString()));
    }



}

