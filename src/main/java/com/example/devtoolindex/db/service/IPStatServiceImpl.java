package com.example.devtoolindex.db.service;

import com.example.devtoolindex.db.entity.IPStatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by hongkailiu on 2016-04-11.
 */
public class IPStatServiceImpl implements IPStatService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override public void save(IPStatEntity ipStatEntity) {
        mongoTemplate.save(ipStatEntity);
    }

    @Override public void deleteAll() {
        mongoTemplate.dropCollection(IPStatEntity.class);
    }
    // TODO ttl
    //http://ericasberry.com/blog/2013/9/5/creating-ttl-indexes-in-spring-data-for-mongodb
}
