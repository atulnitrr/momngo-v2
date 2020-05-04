package com.atul.mongo2.mongov2.controller;

import com.atul.mongo2.mongov2.model.LegoSet;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("legostore/api")
public class LegoStoreController {

    MongoTemplate mongoTemplate;


    public LegoStoreController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping(path = "/insert")
    public void insertData(@RequestBody LegoSet legoSet) {
        mongoTemplate.insert(legoSet);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody LegoSet legoSet) {
        mongoTemplate.save(legoSet);
    }

    @GetMapping(path = "/all")
    public Collection<LegoSet> getAll() {
        return this.mongoTemplate.findAll(LegoSet.class);
    }

    @DeleteMapping("/{id}") // this must match to string id
    public void delete(@PathVariable String id) {
        DeleteResult id1 = this.mongoTemplate.remove(new Query(Criteria.where("id").is(id)), LegoSet.class);
        System.out.println("delete count " + id1.getDeletedCount());
        System.out.println( "was acked " + id1.wasAcknowledged());
    }
}
