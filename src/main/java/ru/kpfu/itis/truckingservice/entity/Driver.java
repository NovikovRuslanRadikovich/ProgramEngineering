package ru.kpfu.itis.truckingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.truckingservice.entity.enums.DriverStatus;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "driverstatus")
    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;


    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    Set<Order> order;
}
