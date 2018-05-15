package ru.kpfu.itis.truckingservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.truckingservice.converter.TruckConverter;
import ru.kpfu.itis.truckingservice.dto.TruckDto;
import ru.kpfu.itis.truckingservice.entity.Truck;
import ru.kpfu.itis.truckingservice.repository.TruckRepository;
import ru.kpfu.itis.truckingservice.service.TruckService;
import ru.kpfu.itis.truckingservice.utils.Errors;

@Service
public class TruckServiceImpl extends TruckConverter implements TruckService {

    @Autowired
    TruckRepository truckRepository;

    @Override
    public void addTruck(TruckDto truckDto) throws Exception {

        String truckNumber = truckDto.getCarNumber();

        if(truckRepository.findTruckByCarNumber(truckNumber).isPresent()) {
            throw new Exception(Errors.TRUCK_ALREADY_EXISTS);
        }

        Truck truck = doForward(truckDto);

        truckRepository.save(truck);
    }
}
