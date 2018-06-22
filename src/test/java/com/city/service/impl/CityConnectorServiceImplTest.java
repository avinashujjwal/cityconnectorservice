package com.city.service.impl;

import com.city.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityConnectorServiceImplTest {

    @Autowired
    private CityConnectorServiceImpl cityConnectorServiceImpl;

    @Test
    public void testIsConnected() {
        Assert.assertTrue("Boston and Newark are not connected.", cityConnectorServiceImpl.isConnected("Boston", "Newark"));
        Assert.assertFalse("Boston and null are connected.", cityConnectorServiceImpl.isConnected("Boston", null));
        Assert.assertFalse("null and Newark are connected.", cityConnectorServiceImpl.isConnected(null, "Newark"));
        Assert.assertFalse("Empty string and Newark are connected.", cityConnectorServiceImpl.isConnected("", "Newark"));
        Assert.assertFalse("Boston and empty string are connected.", cityConnectorServiceImpl.isConnected("Boston", ""));

        Assert.assertTrue("Newark and Boston are not connected.", cityConnectorServiceImpl.isConnected("Newark", "Boston"));
        Assert.assertFalse("Newark and null are connected.", cityConnectorServiceImpl.isConnected("Newark", null));
        Assert.assertFalse("null and Boston are connected.", cityConnectorServiceImpl.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Boston are connected.", cityConnectorServiceImpl.isConnected("", "Boston"));
        Assert.assertFalse("Newark and empty string are connected.", cityConnectorServiceImpl.isConnected("Newark", ""));

        Assert.assertTrue("Boston and Philadelphia are not connected.", cityConnectorServiceImpl.isConnected("Boston", "Philadelphia"));
        Assert.assertFalse("Boston and null are connected.", cityConnectorServiceImpl.isConnected("Boston", null));
        Assert.assertFalse("null and Philadelphia are connected.", cityConnectorServiceImpl.isConnected(null, "Philadelphia"));
        Assert.assertFalse("Empty string and Philadelphia are connected.", cityConnectorServiceImpl.isConnected("", "Philadelphia"));
        Assert.assertFalse("Boston and empty string are connected.", cityConnectorServiceImpl.isConnected("Boston", ""));

        Assert.assertTrue("Philadelphia and Boston are not connected.", cityConnectorServiceImpl.isConnected("Philadelphia", "Boston"));
        Assert.assertFalse("Philadelphia and null are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", null));
        Assert.assertFalse("null and Boston are connected.", cityConnectorServiceImpl.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Boston are connected.", cityConnectorServiceImpl.isConnected("", "Boston"));
        Assert.assertFalse("Philadelphia and empty string are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", ""));

        Assert.assertTrue("New York and Newark are not connected.", cityConnectorServiceImpl.isConnected("New York", "Newark"));
        Assert.assertFalse("New York and null are connected.", cityConnectorServiceImpl.isConnected("New York", null));
        Assert.assertFalse("null and Newark are connected.", cityConnectorServiceImpl.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Newark are connected.", cityConnectorServiceImpl.isConnected("", "Boston"));
        Assert.assertFalse("New York and empty string are connected.", cityConnectorServiceImpl.isConnected("New York", ""));

        Assert.assertTrue("Newark and New York are not connected.", cityConnectorServiceImpl.isConnected("Newark", "New York"));
        Assert.assertFalse("Newark and null are connected.", cityConnectorServiceImpl.isConnected("Newark", null));
        Assert.assertFalse("null and New York are connected.", cityConnectorServiceImpl.isConnected(null, "New York"));
        Assert.assertFalse("Empty string and New York are connected.", cityConnectorServiceImpl.isConnected("", "New York"));
        Assert.assertFalse("Newark and empty string are connected.", cityConnectorServiceImpl.isConnected("Newark", ""));

        Assert.assertTrue("Boston and New York are not connected.", cityConnectorServiceImpl.isConnected("Boston", "New York"));
        Assert.assertFalse("Boston and null are connected.", cityConnectorServiceImpl.isConnected("Boston", null));
        Assert.assertFalse("null and New York are connected.", cityConnectorServiceImpl.isConnected(null, "New York"));
        Assert.assertFalse("Empty string and New York are connected.", cityConnectorServiceImpl.isConnected("", "New York"));
        Assert.assertFalse("Boston and empty string are connected.", cityConnectorServiceImpl.isConnected("Boston", ""));

        Assert.assertTrue("New York and Boston are not connected.", cityConnectorServiceImpl.isConnected("New York", "Boston"));
        Assert.assertFalse("New York and null are connected.", cityConnectorServiceImpl.isConnected("New York", null));
        Assert.assertFalse("null and Boston are connected.", cityConnectorServiceImpl.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Boston are connected.", cityConnectorServiceImpl.isConnected("", "Boston"));
        Assert.assertFalse("New York and empty string are connected.", cityConnectorServiceImpl.isConnected("New York", ""));

        Assert.assertTrue("Newark and Philadelphia are not connected.", cityConnectorServiceImpl.isConnected("Newark", "Philadelphia"));
        Assert.assertFalse("Newark and null are connected.", cityConnectorServiceImpl.isConnected("Newark", null));
        Assert.assertFalse("null and Philadelphia are connected.", cityConnectorServiceImpl.isConnected(null, "Philadelphia"));
        Assert.assertFalse("Empty string and Philadelphia are connected.", cityConnectorServiceImpl.isConnected("", "Philadelphia"));
        Assert.assertFalse("Newark and empty string are connected.", cityConnectorServiceImpl.isConnected("Newark", ""));

        Assert.assertTrue("Philadelphia and Newark are not connected.", cityConnectorServiceImpl.isConnected("Philadelphia", "Newark"));
        Assert.assertFalse("Philadelphia and null are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", null));
        Assert.assertFalse("null and Newark are connected.", cityConnectorServiceImpl.isConnected(null, "Newark"));
        Assert.assertFalse("Empty string and Newark are connected.", cityConnectorServiceImpl.isConnected("", "Newark"));
        Assert.assertFalse("Philadelphia and empty string are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", ""));

        Assert.assertFalse("Philadelphia and Albany are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", "Albany"));
        Assert.assertFalse("Philadelphia and null are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", null));
        Assert.assertFalse("null and Albany are connected.", cityConnectorServiceImpl.isConnected(null, "Albany"));
        Assert.assertFalse("Empty string and Albany are connected.", cityConnectorServiceImpl.isConnected("", "Albany"));
        Assert.assertFalse("Philadelphia and empty string are connected.", cityConnectorServiceImpl.isConnected("Philadelphia", ""));

        Assert.assertFalse("Albany and Philadelphia are connected.", cityConnectorServiceImpl.isConnected("Albany", "Philadelphia"));
        Assert.assertFalse("Albany and null are connected.", cityConnectorServiceImpl.isConnected("Albany", null));
        Assert.assertFalse("null and Philadelphia are connected.", cityConnectorServiceImpl.isConnected(null, "Philadelphia"));
        Assert.assertFalse("Empty string and Philadelphia are connected.", cityConnectorServiceImpl.isConnected("", "Philadelphia"));
        Assert.assertFalse("Albany and empty string are connected.", cityConnectorServiceImpl.isConnected("Albany", ""));

        /* Test cases for cities which are not in the city.txt and city which has "," in it's name */
        Assert.assertFalse("San Francisco and New York are connected.", cityConnectorServiceImpl.isConnected("San Francisco", "New York"));
        Assert.assertFalse("San Francisco and San Jose are connected.", cityConnectorServiceImpl.isConnected("San Francisco", "San Jose"));
        Assert.assertFalse("Santa Clara and Mountain View are connected.", cityConnectorServiceImpl.isConnected("Santa Clara", "Mountain View"));
        Assert.assertFalse("Washington, DC and New York are connected.", cityConnectorServiceImpl.isConnected("Washington, DC", "New York"));
        Assert.assertFalse("New York and Washington, DC are connected.", cityConnectorServiceImpl.isConnected("New York", "Washington, DC"));
    }

}
