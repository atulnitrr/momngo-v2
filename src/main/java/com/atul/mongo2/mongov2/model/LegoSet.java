package com.atul.mongo2.mongov2.model;

import java.util.ArrayList;
import java.util.Collection;

public class LegoSet {
    private String id;
    private String name;
    private LegoSetDifficulty legoSetDifficulty;
    private String theme;
    private Collection<ProductReview> productReviews = new ArrayList<>();
    private DeliveryInfo deliveryInfo;

    public LegoSet(String id, String name, LegoSetDifficulty legoSetDifficulty, String theme, Collection<ProductReview> productReviews, DeliveryInfo deliveryInfo) {
        this.id = id;
        this.name = name;
        this.legoSetDifficulty = legoSetDifficulty;
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

    public LegoSetDifficulty getLegoSetDifficulty() {
        return legoSetDifficulty;
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
}
