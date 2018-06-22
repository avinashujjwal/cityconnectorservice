package com.city.service.impl;

import com.city.service.CityConnectorService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

@Component
public class CityConnectorServiceImpl implements CityConnectorService {

    private static final Logger LOGGER = Logger.getLogger(CityConnectorServiceImpl.class.getName());

    private volatile Map<String, Set<String>> cityConnectionMap;

    @Value("${city.file}")
    private String file;

    @Value("${city.delimiter}")
    private String delimiter;

    @Value("${city.file.encoding}")
    private String fileEncoding;

    /**
     * Initialize one time cityConnectionMap. The key in the map are the cities that are available. For each line, add two key-value pairs
     * for both directions of possible traversal. The value is a set of string which is a set of cities that this city is connected to.
     * So the strings are the nodes, the name of the cities. If there is a key-value pair (or key to set pair) then those cities are connected.
     * The main value of a Map approach is the constant look-up time, meaning the performance will not get worse.
     */
    @PostConstruct
    public void init() {
        cityConnectionMap = new HashMap<>();
        Resource resource = new ClassPathResource(file);

        /* try with resource for auto closing the resources like InputStream and Scanner classes here */
        try (InputStream resourceAsStream = resource.getInputStream(); Scanner scanner = new Scanner(resourceAsStream, fileEncoding)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                /* Assumption : Comma will not appear within city names in the file. For example, "Washington, D.C." */
                String[] cities = line.split(delimiter);
                String sourceCity = cities[0].trim();
                String destinationCity = cities[1].trim();
                Set<String> sourceCityConnections = getCityConnections(cityConnectionMap, sourceCity);
                Set<String> destinationCityConnections = getCityConnections(cityConnectionMap, destinationCity);
                sourceCityConnections.add(destinationCity);
                destinationCityConnections.add(sourceCity);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException occurred while reading the file (city.txt).", e);
        }
    }

    /* Helper method to default the connected cities in the map to the empty set. */
    private Set<String> getCityConnections(Map<String, Set<String>> cityConnectionMap, String city) {
        if (!cityConnectionMap.containsKey(city)) {
            cityConnectionMap.put(city, new HashSet<>());
        }
        return cityConnectionMap.get(city);
    }

    /**
     * @param origin is the origin city name.
     * @param destination is the destination city name.
     * @return boolean value whether both cities are connected or not.
     */
    @Override
    public boolean isConnected(final String origin, final String destination) {
        if(origin == null || destination == null) {
            return false;
        }

        boolean isConnected = origin.equals(destination);
        /* If both cities are not present in cityConnectionMap already, it's certain that they're not connected */
        if (!isConnected && cityConnectionMap.containsKey(origin) && cityConnectionMap.containsKey(destination)) {
            /* Keep a set of the cities which are already visited. This prevents BFS from looping in cycles
            and allows the BFS to terminate, if no path can be found after exploring all the cities. */
            Set<String> citiesAlreadyVisited = new HashSet<>();

            /* Breadth First Search algorithm to traverse cities using a Queue. */
            Queue<String> citiesToVisit = new LinkedList<>();
            citiesToVisit.add(origin);

            while (!citiesToVisit.isEmpty() && !isConnected) {
                String city = citiesToVisit.poll();
                isConnected = city.equals(destination);
                Set<String> possibleConnections = cityConnectionMap.get(city);
                for (String possibleCity : possibleConnections) {
                    if (!citiesAlreadyVisited.contains(possibleCity)) {
                        citiesToVisit.add(possibleCity);
                        citiesAlreadyVisited.add(possibleCity);
                    }
                }
            }
        }
        return isConnected;
    }

}
