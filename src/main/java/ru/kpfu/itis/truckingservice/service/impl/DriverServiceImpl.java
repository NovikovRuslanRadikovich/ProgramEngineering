package ru.kpfu.itis.truckingservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.truckingservice.converter.DriverConverter;
import ru.kpfu.itis.truckingservice.dto.DriverDto;
import ru.kpfu.itis.truckingservice.entity.Driver;
import ru.kpfu.itis.truckingservice.repository.DriverRepository;
import ru.kpfu.itis.truckingservice.service.DriverService;
import ru.kpfu.itis.truckingservice.utils.Errors;

@Service
public class DriverServiceImpl extends DriverConverter implements DriverService {


    @Autowired
    DriverRepository driverRepository;

    @Override
    public void addDriver(DriverDto driverDto) throws Exception {
        String driversPhone = driverDto.getPhoneNumber();
         if(driverRepository.findDriverByPhoneNumber(driversPhone).isPresent()) {
             throw new Exception(Errors.DRIVER_ALREADY_EXISTS);
         }

         Driver driver = doForward(driverDto);

         driverRepository.save(driver);
    }
}
