package ru.kpfu.itis.truckingservice.converter;

import com.google.common.base.Converter;
import org.springframework.core.annotation.Order;
import ru.kpfu.itis.truckingservice.dto.OrderDto;

public class OrderConverter extends Converter<OrderDto,Order> {

    @Override
    protected Order doForward(OrderDto orderDto) {
        return null;
    }

    @Override
    protected OrderDto doBackward(Order order) {
        return null;
    }
}
