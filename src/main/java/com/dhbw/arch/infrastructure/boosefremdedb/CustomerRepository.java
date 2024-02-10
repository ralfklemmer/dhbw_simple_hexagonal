package com.dhbw.arch.infrastructure.boosefremdedb;

import java.util.List;

public class CustomerRepository {
    CustomerDatabaseFake db;

    public CustomerRepository(CustomerDatabaseFake db) {
        this.db = db;
    }

    public List<CustomerEntity> findAll() {
        return db.getAllCustomers();
    }

    public CustomerEntity byId(int id) {
        return db.getCustomerById(id);
    }

    public CustomerEntity register(CustomerEntity customer) {
        return db.saveCustomer(customer);
    }
}
