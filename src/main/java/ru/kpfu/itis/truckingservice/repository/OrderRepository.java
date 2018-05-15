package ru.kpfu.itis.truckingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.truckingservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
