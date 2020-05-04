package com.atul.mongo2.mongov2.repo;

import com.atul.mongo2.mongov2.model.AverageRating;
import com.atul.mongo2.mongov2.model.LegoSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportRepo {

    MongoTemplate mongoTemplate;

    public ReportRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<AverageRating> getRating() {
        ProjectionOperation operation =
                Aggregation.project()
                           .andExpression("name").as("productName")
                .andExpression("{$avg: '$productReviews.ratings'}}").as("rating");
        Aggregation egoSetTypedAggregation = Aggregation.newAggregation(LegoSet.class, operation);

        return mongoTemplate.aggregate(egoSetTypedAggregation, LegoSet.class, AverageRating.class).getMappedResults();

    }
}
