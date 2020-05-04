package com.atul.mongo2.mongov2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "legosets")
public class LegoSet {

    @Id
    private String id;

    @TextIndexed
    private String name;
    private LegoSetDifficulty difficulty;

    @Indexed(direction = IndexDirection.ASCENDING)

    @TextIndexed
    private String theme;
    private Collection<ProductReview> productReviews = new ArrayList<>();

    @Field(name = "delivery")
    private DeliveryInfo deliveryInfo;

    @Transient // dont persist in database
    private int noOfparts;

    @PersistenceConstructor // which constructor mongo will use to do serialization and deserialization
    public LegoSet(String id, String name, LegoSetDifficulty difficulty, String theme, Collection<ProductReview> productReviews, DeliveryInfo deliveryInfo) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.theme = theme;

        if (productReviews != null) {
            this.productReviews = productReviews;
        }
        this.deliveryInfo = deliveryInfo;

    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LegoSetDifficulty getDifficulty() {
        return difficulty;
    }

    public String getTheme() {
        return theme;
    }

    public Collection<ProductReview> getProductReviews() {
        return productReviews;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public int getNoOfparts() {
        return noOfparts;
    }
}
