package com.dhbw.arch.core.port.infrastructure;

import com.dhbw.arch.core.Customer;

import java.util.List;

public interface CustomerPort {
    List<Customer> fetchAllRegisteredCustomers();

    Customer register(Customer newCustomer);
}
