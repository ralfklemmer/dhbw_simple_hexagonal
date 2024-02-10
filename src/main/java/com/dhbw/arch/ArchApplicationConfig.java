package com.dhbw.arch;

import com.dhbw.arch.infrastructure.boosefremdedb.CustomerDatabaseFake;
import com.dhbw.arch.infrastructure.boosefremdedb.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArchApplicationConfig {
    @Bean
    CustomerRepository customerRepository(CustomerDatabaseFake customerDatabaseFake) {
        return new CustomerRepository(customerDatabaseFake);
    }

    @Bean
    CustomerDatabaseFake customerDatabase() {
        return new CustomerDatabaseFake();
    }
}
