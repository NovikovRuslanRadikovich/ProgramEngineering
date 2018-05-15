package ru.kpfu.itis.truckingservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.truckingservice.entity.enums.OrderStatus;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @Column(name = "registrationdate")
    Date registrationDate;

    @Column(name = "cargomass")
    Double cargoMass;

    @Column(name = "cargovolume")
    Double cargoVolume;

    @Column(name = "dispatchplace")
    String dispatchPlace;

    @Column(name = "destinationplace")
    String desinationPlace;

    @Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    AppUser appuser;



    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;




    @PrePersist
    void preInsert() {
        this.orderStatus = OrderStatus.WAITING;
    }


}
