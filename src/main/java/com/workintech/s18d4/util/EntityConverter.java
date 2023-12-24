package com.workintech.s18d4.util;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static List<CustomerResponse> findResults(List<Customer> customers){
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer: customers){
            customerResponses.add(new CustomerResponse(customer.getId(),
                    customer.getEmail(), customer.getSalary()));
        }
        return customerResponses;
    }

    public static CustomerResponse findResult(Customer customer){
        return new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary());
    }
}
