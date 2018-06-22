package com.city.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.city.service.CityConnectorService;

@RestController
@Api(value="cityconnector", description="Operations pertaining to city connection")
public class CityConnectorController {

    @Autowired
    private CityConnectorService cityConnectorService;

    @ApiOperation(value = "Find whether two cities are connected or not",response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully checked city connection"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/connected", method = RequestMethod.GET)
    public ResponseEntity<String> isCityConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
        boolean isConnected = cityConnectorService.isConnected(origin, destination);
        return (isConnected) ? ResponseEntity.ok("Yes") : ResponseEntity.ok("No");
    }

}
