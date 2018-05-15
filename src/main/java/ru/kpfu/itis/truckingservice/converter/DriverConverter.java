package ru.kpfu.itis.truckingservice.converter;

import com.google.common.base.Converter;
import ru.kpfu.itis.truckingservice.dto.DriverDto;
import ru.kpfu.itis.truckingservice.entity.Driver;


public class DriverConverter extends Converter<DriverDto, Driver> {


    @Override
    protected Driver doForward(DriverDto driverDto) {
        return null;
    }

    @Override
    protected DriverDto doBackward(Driver driver) {
        return null;
    }
}
