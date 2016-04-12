package com.example.devtoolindex.db.service;

import com.example.devtoolindex.db.entity.IPStatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by hongkailiu on 2016-04-11.
 */
public class IPStatServiceImpl implements IPStatService {

    @Autowired
    private RedisTemplate<String, IPStatEntity> template;

    @Override public void save(IPStatEntity ipStatEntity) {
        //http://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:template
        //http://stackoverflow.com/questions/24239145/spring-data-redistemplate-serializing-the-value-and-hashvalue
        //http://www.programcreek.com/java-api-examples/index.php?api=org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
        //template.opsForValue().set(ipStatEntity.getIp(), );
    }
}
