package com.gjc.mongodb_demo.dao;

import com.gjc.mongodb_demo.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Test test) {

        mongoTemplate.save(test);
    }

    public List<Test> findAll() {
        return mongoTemplate.findAll(Test.class);
    }

    public Test getOneById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Test.class);
    }

    public void update(Test test) {
        Query query = new Query(Criteria.where("id").is(test.getId()));
        Update update = new Update().set("name", test.getName()).set("created", test.getCreated());
        mongoTemplate.updateFirst(query, update, Test.class);
    }



}
