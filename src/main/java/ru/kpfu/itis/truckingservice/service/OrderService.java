package ru.kpfu.itis.truckingservice.service;

import ru.kpfu.itis.truckingservice.dto.OrderDto;

public interface OrderService {

    void createOrder(OrderDto orderDto);
}
