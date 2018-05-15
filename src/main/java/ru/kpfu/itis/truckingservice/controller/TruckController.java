package ru.kpfu.itis.truckingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.truckingservice.dto.TruckDto;
import ru.kpfu.itis.truckingservice.entity.enums.Role;
import ru.kpfu.itis.truckingservice.service.SecurityService;
import ru.kpfu.itis.truckingservice.service.TruckService;
import ru.kpfu.itis.truckingservice.utils.ApiResponse;
import ru.kpfu.itis.truckingservice.utils.ResponseCreator;

@RestController
public class TruckController extends ResponseCreator {

    @Autowired
    TruckService truckService;

    @Autowired
    SecurityService securityService;

    //    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/truck", method = RequestMethod.POST)
    public ResponseEntity<?> addTruck(@RequestBody TruckDto truckDto) {

        if(!securityService.getCurrentUser().getRole().equals(Role.ADMINISTRATOR)) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.FORBIDDEN);
        }

        try{
            truckService.addTruck(truckDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }
}
