package com.atul.mongo2.mongov2.repo;

import com.atul.mongo2.mongov2.model.LegoSet;
import com.atul.mongo2.mongov2.model.LegoSetDifficulty;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LegosRepo extends MongoRepository<LegoSet, String> {

    Collection<LegoSet> findAllByThemeContains(final String theme);
    Collection<LegoSet> findAllByThemeContains(final String theme, Sort sort);
    Collection<LegoSet> findAllByDifficultyAndNameStartsWith(final LegoSetDifficulty difficulty, final String name);

    @Query("{ 'deliveryInfo.deliveryFee' : {$lte : ?0} }")
    Collection<LegoSet> findByDeliveryFee(final int fee);

    @Query("{ 'productReviews.rating' : {$eq : ?0} }")
    Collection<LegoSet> findByALlReview(final String rating);
}
