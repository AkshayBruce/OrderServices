package org.microservice.orderservices.Services;

import lombok.extern.log4j.Log4j2;
import org.microservice.orderservices.Entity.Order;
import org.microservice.orderservices.External.Client.ProductService;
import org.microservice.orderservices.Model.OrderRequest;
import org.microservice.orderservices.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

    //ORDER ENTITY ->   Save the data with status Order created
    //Product Service - Block  product (Reduce the quantity)
    //Payment Service -> Payment -> Success -> Complete Else Cancelled

        log.info("Placing Order Request: ", orderRequest);

        productService.reduceQuantity(orderRequest.getProductID(),orderRequest.getQuantity());

        log.info("Creating Order with status Created...");

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .Order_productID(orderRequest.getProductID())
                .orderDate(Instant.now())
                .Order_quantity(orderRequest.getQuantity())
                .build();

        orderRepository.save(order);

        log.info("Order placed successfully with orderID: ", order.getOrder_Id() );
        return order.getOrder_Id();
    }
}
