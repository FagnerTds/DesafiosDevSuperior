package com.fagnertds.desafios.services;

import com.fagnertds.desafios.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public Double total(Order order) {
        Double priceWithDiscount = order.getBasic() - (order.getBasic() * (order.getDiscount() / 100));
        return priceWithDiscount + shippingService.shipment(order);
    }
}
