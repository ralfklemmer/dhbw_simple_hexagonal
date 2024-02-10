package com.dhbw.arch.core;

import com.dhbw.arch.core.port.infrastructure.CustomerPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerPort port;

    public CustomerService(CustomerPort port) {
        this.port = port;
    }

    public List<Customer> fetchAllRegisteredCustomers() {
        return port.fetchAllRegisteredCustomers();
    }

    public Customer register(Customer newCustomer) {
        return port.register(newCustomer);
    }
}
