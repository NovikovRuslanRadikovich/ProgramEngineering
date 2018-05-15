package ru.kpfu.itis.truckingservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TruckDto {

     private String carNumber;
     private Double carryingCapacity;
     private Double bodyVolume;

}
