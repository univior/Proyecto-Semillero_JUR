package com.lulobank.stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.lulobank.exceptions.ErrorAssertion.THE_CODES_DO_NOT_MATCH;
import static com.lulobank.questions.Response.*;
import static com.lulobank.tasks.Delete.deleteFavourite;
import static com.lulobank.tasks.Get.iexecuteGetMethodWithThe;
import static com.lulobank.tasks.GetAnImage.methodGetImage;
import static com.lulobank.tasks.GetImageFavourite.methodGetImageFavourite;
import static com.lulobank.tasks.Post.createFavouriteWithThe;
import static com.lulobank.tasks.PostUnHappy.createUnHappy;
import static com.lulobank.utils.Constants.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ExecuteServicesStepDefinition {

    @Before
    public static void actor(){
        OnStage.setTheStage(new Cast());
        theActorCalled("Jessica");

    }
    @Before
    public static void setUpRest(){
        RestAssured.baseURI = "https://api.thecatapi.com";
        RestAssured.basePath = "/v1";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .build();
    }
    @Given("I make the connection to the api")
    public void iMakeTheConnectionToTheApi() {
        givenThat(theActorCalled("Jessica").whoCan(CallAnApi.at("/")));

    }
    @When("I Execute the method Get with the resource api {string}")
    public void executeMethodGetWithResourcesApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(iexecuteGetMethodWithThe(resourceApi));

    }
    @Then("I will see that the is returned {int}")
    public void iWillSeeThatTheIsReturned(Integer statusCode) {
        assertThat(THE_CODES_DO_NOT_MATCH,
                theActorInTheSpotlight().asksFor(getStatusCode()) , equalTo(statusCode));

    }

    //CONSULTA DE UNA IMAGEN
    @When("I Execute the method Get with the resource api for consult an image {string}")
    public void iExecuteTheMethodGetWithTheResourceApiForConsultAnImage(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(methodGetImage(resourceApi));
    }



    //CREACION DE VOTO IMAGEN FAVORITA
    @When("I send the Id {string} with the method POST with the resource api {string}")
    public void iSendTheIdWithTheMethodPOSTWithTheResourceApi(String idImage , String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(createFavouriteWithThe(idImage, resourceApi));

    }
    @Then("Check if the image create favourites successfully")
    public void checkIfTheImageCreateFavouritesSuccessfully() {
        assertThat("the ID image do not match",
                theActorInTheSpotlight().asksFor(getMessage()) , equalTo(MESSAGE));


    }

    //OBTENER INFORMACION DE IMAGEN FAVORITA
    @When("I Execute the method Get with the resource api  {string}")
    public void iExecuteTheMethodGetWithTheResourceApi(String resourceApi) {
     when(theActorInTheSpotlight()).wasAbleTo(methodGetImageFavourite(resourceApi));
    }


    //Delete
    @When("Execute the method DELETE with the resource api {string}")
    public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(deleteFavourite(resourceApi));

    }
    @Then("Check if the image was delete successfully")
    public void checkIfTheImageWasDeleteSuccessfully() {
        assertThat("The response message do not match",
                theActorInTheSpotlight().asksFor(getMessage()), equalTo(MESSAGE));

    }

    //CASO UNHAPPY

    @When("I send the Id {string} with {string} for the method POST with the resource api {string}")
    public void iSendTheIdWithForTheMethodPOSTWithTheResourceApi(String idImage , String subId, String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(createUnHappy(idImage, subId, resourceApi));

    }

    @Then("I will see the message {string}")
    public void iWillSeeTheMessage(String messagef) {
        assertThat("the ID image do not match",
                theActorInTheSpotlight().asksFor(getmessageF()) , equalTo(messagef));




    }



}
