package com.example.devtoolindex.db.service;

import com.example.devtoolindex.db.entity.IPStatEntity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * Created by hongkailiu on 2016-04-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ITContext.class)
public class IPStatServiceImplTest {

    @Autowired IPStatService ipStatService;

    @Before public void setup(){
        Assert.assertNotNull(ipStatService);
        ipStatService.deleteAll();
    }

    @After public void teardown(){
        ipStatService.deleteAll();
    }

    @Test public void testSave() throws Exception {
        IPStatEntity ipStatEntity = new IPStatEntity("127.0.0.1", new Date(), "/aaa/");
        ipStatService.save(ipStatEntity);
    }
}
