package ru.kpfu.itis.truckingservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trucks")
public class Truck extends AbstractEntity {

    @Column(name = "carnumber")
    private String carNumber;

    @Column(name = "carryingcapacity")
    private Double carryingCapacity;

    @Column(name = "bodyvolume")
    private Double bodyVolume;

}
