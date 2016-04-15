package com.example.devtoolindex.db.service;

import com.example.devtoolindex.db.entity.IPStatEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by hongkailiu on 2016-04-11.
 */
public class IPStatServiceImpl implements IPStatService {

    private MongoTemplate mongoTemplate;

    private IndexDefinition index = new IndexDefinition() {
        @Override public DBObject getIndexKeys() {
            return new BasicDBObject(IPStatEntity.VISIT_DATE_NAME, 1);
        }

        @Override public DBObject getIndexOptions() {
            return new BasicDBObject("expireAfterSeconds", IPStatEntity.TTL);
        }
    };

    public IPStatServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.mongoTemplate.indexOps(IPStatEntity.class).ensureIndex(index);
    }



    @Override public void save(IPStatEntity ipStatEntity) {
        mongoTemplate.save(ipStatEntity);
    }

    @Override public void deleteAll() {
        mongoTemplate.dropCollection(IPStatEntity.class);
    }

    @Override public int count() {
        return mongoTemplate.findAll(IPStatEntity.class).size();
    }

    @Override public IPStatEntity findLatest() {
        Query query = new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, IPStatEntity.VISIT_DATE_NAME)));
        return mongoTemplate.findOne(query, IPStatEntity.class);
    }
}
