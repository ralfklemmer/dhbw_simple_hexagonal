package com.dhbw.arch.presentation;

import com.dhbw.arch.core.Customer;
import com.dhbw.arch.core.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@ResponseBody
class CustomerController {
    private final CustomerService service;

    CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
    List<CustomerDTO> customers() {
        List<Customer> customerEntities = this.service.fetchAllRegisteredCustomers();

        return customerEntities.stream()
                .map(c -> new CustomerDTO(c.getName(), c.getAge()))
                .collect(Collectors.toList());
    }

    @PostMapping("/customers/register")
    public CustomerDTO register(@RequestBody CustomerRegisterDTO newCustomer) {

        Customer customerDomainObject = new Customer(0, newCustomer.name(), newCustomer.age());
        Customer savedCustomer = service.register(customerDomainObject);

        return new CustomerDTO(savedCustomer.getName(), savedCustomer.getAge());
    }

}
