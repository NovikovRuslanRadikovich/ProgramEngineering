package ru.kpfu.itis.truckingservice.converter;

import com.google.common.base.Converter;
import ru.kpfu.itis.truckingservice.dto.TruckDto;
import ru.kpfu.itis.truckingservice.entity.AppUser;
import ru.kpfu.itis.truckingservice.entity.Truck;

public class TruckConverter extends Converter<TruckDto,Truck> {


    @Override
    protected Truck doForward(TruckDto truckDto) {
        return Truck.builder()
                .carNumber(truckDto.getCarNumber())
                .carryingCapacity(truckDto.getCarryingCapacity())
                .bodyVolume(truckDto.getBodyVolume())
                .build();
    }

    @Override
    protected TruckDto doBackward(Truck truck) {
        return null;
    }
}
