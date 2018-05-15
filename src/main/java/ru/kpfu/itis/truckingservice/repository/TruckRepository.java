package ru.kpfu.itis.truckingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.truckingservice.entity.Truck;

import java.util.Optional;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {


    Optional<Truck> findTruckByCarNumber(String carNumber);
}
