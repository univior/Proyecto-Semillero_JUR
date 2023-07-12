package com.lulobank.models;

public class CreateFavouriteRequest {

    private String image_id;
    private String sub_id;

    public String getimage_id() {
        return image_id;
    }

    public void setimage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }
}
