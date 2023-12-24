package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import com.workintech.s18d4.util.EntityConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/")
    public List<CustomerResponse> findAll() {
        return EntityConverter.findResults(customerService.findAll());
    }

    @GetMapping("/{id}")
    public CustomerResponse find(@PathVariable long id) {
        return EntityConverter.findResult(customerService.find(id));
    }

    @PostMapping("/")
    public CustomerResponse save(@RequestBody Customer customer) {
        return EntityConverter.findResult(customerService.save(customer));
    }

    @PostMapping("/{id}")
    public CustomerResponse save(@RequestBody Customer customer, @PathVariable long id) {
        Customer findCustomer = customerService.find(id);
        if (findCustomer != null) {
            customer.setId(id);
            return EntityConverter.findResult(customerService.save(customer));
        } else {
            throw new RuntimeException("this customer does not exist");
        }
    }

    @DeleteMapping("/{id}")
    public CustomerResponse remove(@PathVariable long id) {
        return EntityConverter.findResult(customerService.delete(id));
    }

}
