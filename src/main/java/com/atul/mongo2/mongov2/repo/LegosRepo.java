package com.atul.mongo2.mongov2.repo;

import com.atul.mongo2.mongov2.model.LegoSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LegosRepo extends MongoRepository<LegoSet, String> {

    Collection<LegoSet> findAllByThemeContains(final String theme);
}
