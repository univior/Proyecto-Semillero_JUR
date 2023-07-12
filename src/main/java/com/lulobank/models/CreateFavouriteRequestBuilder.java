package com.lulobank.models;

public class CreateFavouriteRequestBuilder {

    private CreateFavouriteRequest favouriteRequest;

    private CreateFavouriteRequestBuilder(){
        favouriteRequest = new CreateFavouriteRequest();
    }

    public static CreateFavouriteRequestBuilder aFavourite(){
        return new CreateFavouriteRequestBuilder();
    }

    public CreateFavouriteRequestBuilder withidImage(String image_id){
        this.favouriteRequest.setimage_id(image_id);
        return this;
    }

    public CreateFavouriteRequestBuilder withSub_id(String sub_id){
        this.favouriteRequest.setSub_id(sub_id);
        return this;
    }

    public CreateFavouriteRequest build(){
        return favouriteRequest;
    }


}
