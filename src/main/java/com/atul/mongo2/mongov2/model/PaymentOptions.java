package com.atul.mongo2.mongov2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class PaymentOptions {

    @Id
    private String id;
    private int fee;
    private PaymetType type;

    public PaymentOptions(int fee, PaymetType type) {
        this.fee = fee;
        this.type = type;
    }

    public int getFee() {
        return fee;
    }

    public PaymetType getType() {
        return type;
    }
}
