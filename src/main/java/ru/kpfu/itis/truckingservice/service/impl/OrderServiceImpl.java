package ru.kpfu.itis.truckingservice.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.truckingservice.converter.OrderConverter;
import ru.kpfu.itis.truckingservice.dto.OrderDto;
import ru.kpfu.itis.truckingservice.service.OrderService;

@Service
public class OrderServiceImpl extends OrderConverter implements OrderService {

    @Override
    public void createOrder(OrderDto orderDto) {

    }
}
