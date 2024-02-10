package com.dhbw.arch.infrastructure.boosefremdedb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDatabaseFake {
    private Map<Integer, CustomerEntity> customerMap;

    public CustomerDatabaseFake() {
        this.customerMap = new HashMap<>();

        saveCustomer(new CustomerEntity(generateId(), "Alice Johnson", 20));
        saveCustomer(new CustomerEntity(generateId(), "Bob Smith", 30));
        saveCustomer(new CustomerEntity(generateId(), "Charlie Brown", 40));
        saveCustomer(new CustomerEntity(generateId(), "David Miller", 50));
    }

    public CustomerEntity getCustomerById(int customerId) {
        return customerMap.get(customerId);
    }

    public List<CustomerEntity> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    public CustomerEntity saveCustomer(CustomerEntity customer) {
        Date currentDate = new Date();

        if (customer.getId() == 0) {
            // If the customer ID is 0, it's a new customer. Generate ID and set create timestamp.
            int newCustomerId = generateId();
            customer.setId(newCustomerId);
            customer.setCreatedAt(currentDate);
        }

        // Set update timestamp.
        customer.setUpdatedAt(currentDate);

        // Save/update customer in the database.
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    private int generateId() {
        // In a real-world scenario, you might want to implement a more robust ID generation logic.
        // For simplicity, I'm using a basic counter here.
        return customerMap.size() + 1;
    }
}
