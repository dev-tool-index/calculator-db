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
import java.util.concurrent.TimeUnit;


/**
 * Created by hongkailiu on 2016-04-13.
 */
@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(classes = ITContext.class)
public class IPStatServiceImplTest {

    @Autowired IPStatService ipStatService;

    @Before public void setup() {
        Assert.assertNotNull(ipStatService);
        ipStatService.deleteAll();
        Assert.assertEquals(0, ipStatService.count());
    }

    @After public void teardown() {
        ipStatService.deleteAll();
        Assert.assertEquals(0, ipStatService.count());
    }

    @Test public void testSave() throws Exception {
        IPStatEntity ipStatEntity = new IPStatEntity("127.0.0.1", new Date(), "/aaa/");
        ipStatService.save(ipStatEntity);
    }

    @Test public void testCount() throws Exception {
        IPStatEntity ipStatEntity1 = new IPStatEntity("127.0.0.1", new Date(), "/aaa/");
        ipStatService.save(ipStatEntity1);
        IPStatEntity ipStatEntity2 = new IPStatEntity("127.0.0.1", new Date(), "/aaa/");
        ipStatService.save(ipStatEntity2);
        Assert.assertEquals(2, ipStatService.count());
    }

    @Test public void testFindLatest() throws Exception {
        IPStatEntity ipStatEntity = ipStatService.findLatest();
        Assert.assertTrue(null == ipStatEntity);
        IPStatEntity ipStatEntity1 = new IPStatEntity("127.0.0.1", new Date(), "/aaa/");
        // precision is second for date
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        IPStatEntity ipStatEntity2 = new IPStatEntity("127.0.0.1", new Date(), "/bbb/");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        IPStatEntity ipStatEntity3 = new IPStatEntity("127.0.0.1", new Date(), "/ccc/");

        // save in mixed order
        ipStatService.save(ipStatEntity1);
        ipStatService.save(ipStatEntity3);
        ipStatService.save(ipStatEntity2);

        IPStatEntity result = ipStatService.findLatest();
        // seems no need for defining equals() function
        // template takes care of it
        Assert.assertEquals(ipStatEntity3, result);
    }
}
