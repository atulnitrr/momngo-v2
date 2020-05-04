package com.atul.mongo2.mongov2.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

public class ProductReview {

    @TextIndexed
    private String userName;
    private String rating;


    public ProductReview(String userName, String rating) {
        this.userName = userName;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public String getRating() {
        return rating;
    }
}
