package com.example.customer_service.entities.projections;

import com.example.customer_service.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types = Customer.class)
public interface CustomerProjection {

    public String getEmail();

}
