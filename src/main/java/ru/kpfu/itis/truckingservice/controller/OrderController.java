package ru.kpfu.itis.truckingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.truckingservice.dto.OrderDto;
import ru.kpfu.itis.truckingservice.service.OrderService;
import ru.kpfu.itis.truckingservice.service.SecurityService;
import ru.kpfu.itis.truckingservice.utils.ApiResponse;
import ru.kpfu.itis.truckingservice.utils.ResponseCreator;

import java.util.List;

@RestController
public class OrderController extends ResponseCreator {

    @Autowired
    OrderService orderService;

    @Autowired
    SecurityService securityService;

    //    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> createOrder(@RequestBody OrderDto orderDto) {

        try{
            orderService.createOrder(orderDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }

    //    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/orders_history", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getHistoryOfOrders() {
         String username =
    }

}
