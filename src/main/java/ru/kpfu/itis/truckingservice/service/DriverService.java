package ru.kpfu.itis.truckingservice.service;

import ru.kpfu.itis.truckingservice.dto.DriverDto;

public interface DriverService {
    void addDriver(DriverDto driverDto) throws Exception;
}
