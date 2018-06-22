package com.city.controller;

import com.city.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityConnectorControllerTest {

    @Autowired
    private CityConnectorController cityConnectorController;

    @Test
    public void testIsCityConnected() {
        Assert.assertEquals("Boston and Newark are not connected.", "Yes", cityConnectorController.isCityConnected("Boston", "Newark").getBody());
        Assert.assertEquals("Boston and Newark are not connected.", HttpStatus.OK, cityConnectorController.isCityConnected("Boston", "Newark").getStatusCode());
        Assert.assertEquals("Boston and null are connected.", "No", cityConnectorController.isCityConnected("Boston", null).getBody());
        Assert.assertEquals("Boston and null are connected.", HttpStatus.OK, cityConnectorController.isCityConnected("Boston", null).getStatusCode());
        Assert.assertEquals("null and Newark are connected.", "No", cityConnectorController.isCityConnected(null, "Newark").getBody());
        Assert.assertEquals("null and Newark are connected.", HttpStatus.OK, cityConnectorController.isCityConnected(null, "Newark").getStatusCode());
        Assert.assertEquals("Empty string and Newark are connected.", "No", cityConnectorController.isCityConnected("", "Newark").getBody());
        Assert.assertEquals("Empty string and Newark are connected.", HttpStatus.OK, cityConnectorController.isCityConnected("", "Newark").getStatusCode());
        Assert.assertEquals("Boston and empty string are connected.", "No", cityConnectorController.isCityConnected("Boston", "").getBody());
        Assert.assertEquals("Boston and empty string are connected.", HttpStatus.OK, cityConnectorController.isCityConnected("Boston", "").getStatusCode());

        Assert.assertEquals("Newark and Boston are not connected.", "Yes", cityConnectorController.isCityConnected("Newark", "Boston").getBody());
        Assert.assertEquals("Newark and null are connected.", "No", cityConnectorController.isCityConnected("Newark", null).getBody());
        Assert.assertEquals("null and Boston are connected.", "No", cityConnectorController.isCityConnected(null, "Boston").getBody());
        Assert.assertEquals("Empty string and Boston are connected.", "No", cityConnectorController.isCityConnected("", "Boston").getBody());
        Assert.assertEquals("Newark and empty string are connected.", "No", cityConnectorController.isCityConnected("Newark", "").getBody());

        Assert.assertEquals("Boston and Philadelphia are not connected.", "Yes", cityConnectorController.isCityConnected("Boston", "Philadelphia").getBody());
        Assert.assertEquals("Boston and null are connected.", "No", cityConnectorController.isCityConnected("Boston", null).getBody());
        Assert.assertEquals("null and Philadelphia are connected.", "No", cityConnectorController.isCityConnected(null, "Philadelphia").getBody());
        Assert.assertEquals("Empty string and Philadelphia are connected.", "No", cityConnectorController.isCityConnected("", "Philadelphia").getBody());
        Assert.assertEquals("Boston and empty string are connected.", "No", cityConnectorController.isCityConnected("Boston", "").getBody());

        Assert.assertEquals("Philadelphia and Boston are not connected.", "Yes", cityConnectorController.isCityConnected("Philadelphia", "Boston").getBody());
        Assert.assertEquals("Philadelphia and null are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", null).getBody());
        Assert.assertEquals("null and Boston are connected.", "No", cityConnectorController.isCityConnected(null, "Boston").getBody());
        Assert.assertEquals("Empty string and Boston are connected.", "No", cityConnectorController.isCityConnected("", "Boston").getBody());
        Assert.assertEquals("Philadelphia and empty string are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", "").getBody());

        Assert.assertEquals("New York and Newark are not connected.", "Yes", cityConnectorController.isCityConnected("New York", "Newark").getBody());
        Assert.assertEquals("New York and null are connected.", "No", cityConnectorController.isCityConnected("New York", null).getBody());
        Assert.assertEquals("null and Newark are connected.", "No", cityConnectorController.isCityConnected(null, "Boston").getBody());
        Assert.assertEquals("Empty string and Newark are connected.", "No", cityConnectorController.isCityConnected("", "Boston").getBody());
        Assert.assertEquals("New York and empty string are connected.", "No", cityConnectorController.isCityConnected("New York", "").getBody());

        Assert.assertEquals("Newark and New York are not connected.", "Yes", cityConnectorController.isCityConnected("Newark", "New York").getBody());
        Assert.assertEquals("Newark and null are connected.", "No", cityConnectorController.isCityConnected("Newark", null).getBody());
        Assert.assertEquals("null and New York are connected.", "No", cityConnectorController.isCityConnected(null, "New York").getBody());
        Assert.assertEquals("Empty string and New York are connected.", "No", cityConnectorController.isCityConnected("", "New York").getBody());
        Assert.assertEquals("Newark and empty string are connected.", "No", cityConnectorController.isCityConnected("Newark", "").getBody());

        Assert.assertEquals("Boston and New York are not connected.", "Yes", cityConnectorController.isCityConnected("Boston", "New York").getBody());
        Assert.assertEquals("Boston and null are connected.", "No", cityConnectorController.isCityConnected("Boston", null).getBody());
        Assert.assertEquals("null and New York are connected.", "No", cityConnectorController.isCityConnected(null, "New York").getBody());
        Assert.assertEquals("Empty string and New York are connected.", "No", cityConnectorController.isCityConnected("", "New York").getBody());
        Assert.assertEquals("Boston and empty string are connected.", "No", cityConnectorController.isCityConnected("Boston", "").getBody());

        Assert.assertEquals("New York and Boston are not connected.", "Yes", cityConnectorController.isCityConnected("New York", "Boston").getBody());
        Assert.assertEquals("New York and null are connected.", "No", cityConnectorController.isCityConnected("New York", null).getBody());
        Assert.assertEquals("null and Boston are connected.", "No", cityConnectorController.isCityConnected(null, "Boston").getBody());
        Assert.assertEquals("Empty string and Boston are connected.", "No", cityConnectorController.isCityConnected("", "Boston").getBody());
        Assert.assertEquals("New York and empty string are connected.", "No", cityConnectorController.isCityConnected("New York", "").getBody());

        Assert.assertEquals("Newark and Philadelphia are not connected.", "Yes", cityConnectorController.isCityConnected("Newark", "Philadelphia").getBody());
        Assert.assertEquals("Newark and null are connected.", "No", cityConnectorController.isCityConnected("Newark", null).getBody());
        Assert.assertEquals("null and Philadelphia are connected.", "No", cityConnectorController.isCityConnected(null, "Philadelphia").getBody());
        Assert.assertEquals("Empty string and Philadelphia are connected.", "No", cityConnectorController.isCityConnected("", "Philadelphia").getBody());
        Assert.assertEquals("Newark and empty string are connected.", "No", cityConnectorController.isCityConnected("Newark", "").getBody());

        Assert.assertEquals("Philadelphia and Newark are not connected.", "Yes", cityConnectorController.isCityConnected("Philadelphia", "Newark").getBody());
        Assert.assertEquals("Philadelphia and null are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", null).getBody());
        Assert.assertEquals("null and Newark are connected.", "No", cityConnectorController.isCityConnected(null, "Newark").getBody());
        Assert.assertEquals("Empty string and Newark are connected.", "No", cityConnectorController.isCityConnected("", "Newark").getBody());
        Assert.assertEquals("Philadelphia and empty string are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", "").getBody());

        Assert.assertEquals("Philadelphia and Albany are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", "Albany").getBody());
        Assert.assertEquals("Philadelphia and null are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", null).getBody());
        Assert.assertEquals("null and Albany are connected.", "No", cityConnectorController.isCityConnected(null, "Albany").getBody());
        Assert.assertEquals("Empty string and Albany are connected.", "No", cityConnectorController.isCityConnected("", "Albany").getBody());
        Assert.assertEquals("Philadelphia and empty string are connected.", "No", cityConnectorController.isCityConnected("Philadelphia", "").getBody());

        Assert.assertEquals("Albany and Philadelphia are connected.", "No", cityConnectorController.isCityConnected("Albany", "Philadelphia").getBody());
        Assert.assertEquals("Albany and null are connected.", "No", cityConnectorController.isCityConnected("Albany", null).getBody());
        Assert.assertEquals("null and Philadelphia are connected.", "No", cityConnectorController.isCityConnected(null, "Philadelphia").getBody());
        Assert.assertEquals("Empty string and Philadelphia are connected.", "No", cityConnectorController.isCityConnected("", "Philadelphia").getBody());
        Assert.assertEquals("Albany and empty string are connected.", "No", cityConnectorController.isCityConnected("Albany", "").getBody());

        /* Test cases for cities which are not in the city.txt and city which has "," in it's name */
        Assert.assertEquals("San Francisco and New York are connected.", "No", cityConnectorController.isCityConnected("San Francisco", "New York").getBody());
        Assert.assertEquals("San Francisco and San Jose are connected.", "No", cityConnectorController.isCityConnected("San Francisco", "San Jose").getBody());
        Assert.assertEquals("Santa Clara and Mountain View are connected.", "No", cityConnectorController.isCityConnected("Santa Clara", "Mountain View").getBody());
        Assert.assertEquals("Washington, DC and New York are connected.", "No", cityConnectorController.isCityConnected("Washington, DC", "New York").getBody());
        Assert.assertEquals("New York and Washington, DC are connected.", "No", cityConnectorController.isCityConnected("New York", "Washington, DC").getBody());
    }

}
