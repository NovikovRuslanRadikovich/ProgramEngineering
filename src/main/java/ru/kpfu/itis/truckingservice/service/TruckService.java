package ru.kpfu.itis.truckingservice.service;

import ru.kpfu.itis.truckingservice.dto.TruckDto;

public interface TruckService {
    void addTruck(TruckDto truckDto) throws Exception;
}
