package com.example.devtoolindex.db.entity;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by ehongka on 4/15/16.
 */
public class IPStatEntityTest {

    private IPStatEntity unitUnderTest;

    @Before public void setup() {
        unitUnderTest = new IPStatEntity();
    }

    @Test public void testHashCode() throws Exception {
        unitUnderTest.hashCode();
    }

    @Test public void testEquals() throws Exception {
        Assert.assertTrue(unitUnderTest.equals(unitUnderTest));
        Assert.assertFalse(unitUnderTest.equals(null));
        Assert.assertFalse(unitUnderTest.equals(new Object()));
    }

    @Test public void testGettersAndSetters() throws Exception {
        Assert.assertNotNull(unitUnderTest.getUuid());
        String ip = "127.0.0.1";
        Date visitDate = new Date();
        String path = "/aaa/";
        unitUnderTest.setIp(ip);
        unitUnderTest.setVisitDate(visitDate);
        unitUnderTest.setPath(path);
        Assert.assertEquals(ip, unitUnderTest.getIp());
        Assert.assertEquals(visitDate, unitUnderTest.getVisitDate());
        Assert.assertEquals(path, unitUnderTest.getPath());
    }
}
