package com.example.billingservice.controller;

import com.example.billingservice.entities.*;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    /*
    c'est accès à distance
     */
    private CustomerService customerService;

    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/fullBill/{id}")
    public Bill getBillById(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(e->{

            e.setProduct(inventoryService.findProductById(e.getProductId()));
        });
        return bill;
    }


}
