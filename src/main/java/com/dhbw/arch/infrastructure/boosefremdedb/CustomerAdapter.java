package com.dhbw.arch.infrastructure.boosefremdedb;

import com.dhbw.arch.core.Customer;
import com.dhbw.arch.core.port.infrastructure.CustomerPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CustomerAdapter implements CustomerPort {
    CustomerRepository repository;

    public CustomerAdapter(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> fetchAllRegisteredCustomers() {
        List<CustomerEntity> all = repository.findAll();
        return all.stream()
                .map(c -> new Customer(c.getId(), c.getName(), c.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public Customer register(Customer newCustomer) {

        // map DomainObject to Entity
        CustomerEntity e = new CustomerEntity(newCustomer.getId(), newCustomer.getName(), newCustomer.getAge());
        CustomerEntity savedCustomer = repository.register(e);

        // Entity to DomainObject
        return new Customer(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getAge());
    }
}
