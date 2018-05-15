package ru.kpfu.itis.truckingservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driverresponds")
public class DriverRespond extends AbstractEntity {

      @Column(name = "driverid")
      Long driverId;

      @Column(name = "orderid")
      Long orderId;
}
