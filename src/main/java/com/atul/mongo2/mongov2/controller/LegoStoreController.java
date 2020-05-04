package com.atul.mongo2.mongov2.controller;

import com.atul.mongo2.mongov2.model.LegoSet;
import com.atul.mongo2.mongov2.repo.LegosRepo;
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

    MongoTemplate mongoTemplate; // dont need it

    LegosRepo legosRepo;


    public LegoStoreController(MongoTemplate mongoTemplate, LegosRepo legosRepo) {
        this.mongoTemplate = mongoTemplate;
        this.legosRepo = legosRepo;
    }

    @PostMapping(path = "/insert")
    public void insertData(@RequestBody LegoSet legoSet) {
        legosRepo.insert(legoSet);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody LegoSet legoSet) {
        legosRepo.save(legoSet);
    }

    @GetMapping(path = "/all")
    public Collection<LegoSet> getAll() {
        return this.legosRepo.findAll();
    }

    @DeleteMapping("/{id}") // this must match to string id
    public void delete(@PathVariable String id) {
        this.legosRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public LegoSet getBuyId(@PathVariable final String  id) {
        return legosRepo.findById(id).orElse(null);
    }

    @GetMapping("/byTheme/{theme}")
    public Collection<LegoSet> getALl(@PathVariable final String theme) {
        return legosRepo.findAllByThemeContains(theme);
    }

    @GetMapping("/byDelivery/{fee}")
    public Collection<LegoSet> getAllByFee(@PathVariable final int fee) {
        return legosRepo.findByDeliveryFee(fee);
    }

    @GetMapping("/byRating/{rating}")
    public Collection<LegoSet> getAllReview(@PathVariable final String rating) {
        return  legosRepo.findByALlReview(rating);
    }


}
