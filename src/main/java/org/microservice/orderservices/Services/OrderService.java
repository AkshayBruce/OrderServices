package org.microservice.orderservices.Services;

import org.microservice.orderservices.Model.OrderRequest;

public interface OrderService {

    long placeOrder(OrderRequest orderRequest);
}
