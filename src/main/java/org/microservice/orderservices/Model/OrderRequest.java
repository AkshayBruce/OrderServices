package org.microservice.orderservices.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private  long productID;
    private  long totalAmount;
    private long quantity;
    private PaymentMode paymentMode;

}
