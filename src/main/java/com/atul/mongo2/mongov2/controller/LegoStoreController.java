package com.atul.mongo2.mongov2.controller;

import com.atul.mongo2.mongov2.model.LegoSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(path = "/all")
    public Collection<LegoSet> getAll() {
        return this.mongoTemplate.findAll(LegoSet.class);
    }
}
