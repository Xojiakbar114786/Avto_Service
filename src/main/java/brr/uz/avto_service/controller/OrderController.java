package brr.uz.avto_service.controller;

import brr.uz.avto_service.payload.ApiResponse;
import brr.uz.avto_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public ApiResponse createOrder(@RequestParam Long id,
                                   @RequestParam String name,
                                   @RequestParam Double lan,
                                   @RequestParam Double lat,
                                   @RequestParam Long companyId,
                                   @RequestParam String phoneNumber,
                                   @RequestParam Long serviceItem){
        return orderService.orderCreate(id,name,lan,lat,companyId,phoneNumber,serviceItem);
    }
}
