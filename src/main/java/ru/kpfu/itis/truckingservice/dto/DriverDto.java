package ru.kpfu.itis.truckingservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverDto {


    private String name;
    private String surname;
    private String phoneNumber;

}
