package com.city.service;

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
public class CityConnectorServiceTest {

    @Autowired
    private CityConnectorService cityConnectorService;

    @Test
    public void testIsConnected() {
        Assert.assertTrue("Boston and Newark are not connected.", cityConnectorService.isConnected("Boston", "Newark"));
        Assert.assertFalse("Boston and null are connected.", cityConnectorService.isConnected("Boston", null));
        Assert.assertFalse("null and Newark are connected.", cityConnectorService.isConnected(null, "Newark"));
        Assert.assertFalse("Empty string and Newark are connected.", cityConnectorService.isConnected("", "Newark"));
        Assert.assertFalse("Boston and empty string are connected.", cityConnectorService.isConnected("Boston", ""));

        Assert.assertTrue("Newark and Boston are not connected.", cityConnectorService.isConnected("Newark", "Boston"));
        Assert.assertFalse("Newark and null are connected.", cityConnectorService.isConnected("Newark", null));
        Assert.assertFalse("null and Boston are connected.", cityConnectorService.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Boston are connected.", cityConnectorService.isConnected("", "Boston"));
        Assert.assertFalse("Newark and empty string are connected.", cityConnectorService.isConnected("Newark", ""));

        Assert.assertTrue("Boston and Philadelphia are not connected.", cityConnectorService.isConnected("Boston", "Philadelphia"));
        Assert.assertFalse("Boston and null are connected.", cityConnectorService.isConnected("Boston", null));
        Assert.assertFalse("null and Philadelphia are connected.", cityConnectorService.isConnected(null, "Philadelphia"));
        Assert.assertFalse("Empty string and Philadelphia are connected.", cityConnectorService.isConnected("", "Philadelphia"));
        Assert.assertFalse("Boston and empty string are connected.", cityConnectorService.isConnected("Boston", ""));

        Assert.assertTrue("Philadelphia and Boston are not connected.", cityConnectorService.isConnected("Philadelphia", "Boston"));
        Assert.assertFalse("Philadelphia and null are connected.", cityConnectorService.isConnected("Philadelphia", null));
        Assert.assertFalse("null and Boston are connected.", cityConnectorService.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Boston are connected.", cityConnectorService.isConnected("", "Boston"));
        Assert.assertFalse("Philadelphia and empty string are connected.", cityConnectorService.isConnected("Philadelphia", ""));

        Assert.assertTrue("New York and Newark are not connected.", cityConnectorService.isConnected("New York", "Newark"));
        Assert.assertFalse("New York and null are connected.", cityConnectorService.isConnected("New York", null));
        Assert.assertFalse("null and Newark are connected.", cityConnectorService.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Newark are connected.", cityConnectorService.isConnected("", "Boston"));
        Assert.assertFalse("New York and empty string are connected.", cityConnectorService.isConnected("New York", ""));

        Assert.assertTrue("Newark and New York are not connected.", cityConnectorService.isConnected("Newark", "New York"));
        Assert.assertFalse("Newark and null are connected.", cityConnectorService.isConnected("Newark", null));
        Assert.assertFalse("null and New York are connected.", cityConnectorService.isConnected(null, "New York"));
        Assert.assertFalse("Empty string and New York are connected.", cityConnectorService.isConnected("", "New York"));
        Assert.assertFalse("Newark and empty string are connected.", cityConnectorService.isConnected("Newark", ""));

        Assert.assertTrue("Boston and New York are not connected.", cityConnectorService.isConnected("Boston", "New York"));
        Assert.assertFalse("Boston and null are connected.", cityConnectorService.isConnected("Boston", null));
        Assert.assertFalse("null and New York are connected.", cityConnectorService.isConnected(null, "New York"));
        Assert.assertFalse("Empty string and New York are connected.", cityConnectorService.isConnected("", "New York"));
        Assert.assertFalse("Boston and empty string are connected.", cityConnectorService.isConnected("Boston", ""));

        Assert.assertTrue("New York and Boston are not connected.", cityConnectorService.isConnected("New York", "Boston"));
        Assert.assertFalse("New York and null are connected.", cityConnectorService.isConnected("New York", null));
        Assert.assertFalse("null and Boston are connected.", cityConnectorService.isConnected(null, "Boston"));
        Assert.assertFalse("Empty string and Boston are connected.", cityConnectorService.isConnected("", "Boston"));
        Assert.assertFalse("New York and empty string are connected.", cityConnectorService.isConnected("New York", ""));

        Assert.assertTrue("Newark and Philadelphia are not connected.", cityConnectorService.isConnected("Newark", "Philadelphia"));
        Assert.assertFalse("Newark and null are connected.", cityConnectorService.isConnected("Newark", null));
        Assert.assertFalse("null and Philadelphia are connected.", cityConnectorService.isConnected(null, "Philadelphia"));
        Assert.assertFalse("Empty string and Philadelphia are connected.", cityConnectorService.isConnected("", "Philadelphia"));
        Assert.assertFalse("Newark and empty string are connected.", cityConnectorService.isConnected("Newark", ""));

        Assert.assertTrue("Philadelphia and Newark are not connected.", cityConnectorService.isConnected("Philadelphia", "Newark"));
        Assert.assertFalse("Philadelphia and null are connected.", cityConnectorService.isConnected("Philadelphia", null));
        Assert.assertFalse("null and Newark are connected.", cityConnectorService.isConnected(null, "Newark"));
        Assert.assertFalse("Empty string and Newark are connected.", cityConnectorService.isConnected("", "Newark"));
        Assert.assertFalse("Philadelphia and empty string are connected.", cityConnectorService.isConnected("Philadelphia", ""));

        Assert.assertFalse("Philadelphia and Albany are connected.", cityConnectorService.isConnected("Philadelphia", "Albany"));
        Assert.assertFalse("Philadelphia and null are connected.", cityConnectorService.isConnected("Philadelphia", null));
        Assert.assertFalse("null and Albany are connected.", cityConnectorService.isConnected(null, "Albany"));
        Assert.assertFalse("Empty string and Albany are connected.", cityConnectorService.isConnected("", "Albany"));
        Assert.assertFalse("Philadelphia and empty string are connected.", cityConnectorService.isConnected("Philadelphia", ""));

        Assert.assertFalse("Albany and Philadelphia are connected.", cityConnectorService.isConnected("Albany", "Philadelphia"));
        Assert.assertFalse("Albany and null are connected.", cityConnectorService.isConnected("Albany", null));
        Assert.assertFalse("null and Philadelphia are connected.", cityConnectorService.isConnected(null, "Philadelphia"));
        Assert.assertFalse("Empty string and Philadelphia are connected.", cityConnectorService.isConnected("", "Philadelphia"));
        Assert.assertFalse("Albany and empty string are connected.", cityConnectorService.isConnected("Albany", ""));

        /* Test cases for cities which are not in the city.txt and city which has "," in it's name */
        Assert.assertFalse("San Francisco and New York are connected.", cityConnectorService.isConnected("San Francisco", "New York"));
        Assert.assertFalse("San Francisco and San Jose are connected.", cityConnectorService.isConnected("San Francisco", "San Jose"));
        Assert.assertFalse("Santa Clara and Mountain View are connected.", cityConnectorService.isConnected("Santa Clara", "Mountain View"));
        Assert.assertFalse("Washington, DC and New York are connected.", cityConnectorService.isConnected("Washington, DC", "New York"));
        Assert.assertFalse("New York and Washington, DC are connected.", cityConnectorService.isConnected("New York", "Washington, DC"));
    }

}
