package brr.uz.avto_service.controller;

import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.payload.OrderReq;
import brr.uz.avto_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public ApiResponse createOrder(@RequestBody OrderReq orderReq){
        return orderService.orderCreate(orderReq);
    }
}
