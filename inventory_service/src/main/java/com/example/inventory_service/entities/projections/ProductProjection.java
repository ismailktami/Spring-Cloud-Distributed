package com.example.inventory_service.entities.projections;

import com.example.inventory_service.entities.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="fullProduct",types= Product.class)
public interface ProductProjection {
    @Value("#{target.name }"+ "  "+"#{target.price }")
    public String getInfo();
}
