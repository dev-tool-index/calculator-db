package com.example.devtoolindex.db.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hongkailiu on 2016-04-15.
 */
public class ArithmeticServiceImplTest {

    private ArithmeticService unitUnderTest = new ArithmeticServiceImpl();

    @Test public void testAdd() throws Exception {
        Assert.assertEquals(5, unitUnderTest.add(2, 3));
    }
}
