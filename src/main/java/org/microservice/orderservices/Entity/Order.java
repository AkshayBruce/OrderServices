package org.microservice.orderservices.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name="ORDER_DETAILS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_Id;

    @Column(name="PRODUCT_ID")
    private long Order_productID;

    @Column(name="QUANTITY")
    private long Order_quantity;

    @Column(name="DATE")
    private Instant orderDate;

    @Column(name="STATUS")
    private String orderStatus;

    @Column(name="AMOUNT")
    private long amount;

}
