package ru.kpfu.itis.truckingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.truckingservice.dto.DriverDto;
import ru.kpfu.itis.truckingservice.entity.enums.Role;
import ru.kpfu.itis.truckingservice.service.DriverService;
import ru.kpfu.itis.truckingservice.service.SecurityService;
import ru.kpfu.itis.truckingservice.utils.ResponseCreator;

@RestController
public class DriverController  extends ResponseCreator {

    @Autowired
    DriverService driverService;

    @Autowired
    SecurityService securityService;


    //    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public ResponseEntity<?> addDriver(@RequestBody DriverDto driverDto) {

        if(!securityService.getCurrentUser().getRole().equals(Role.ADMINISTRATOR)) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.FORBIDDEN);
        }

        try{
            driverService.addDriver(driverDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }


}
