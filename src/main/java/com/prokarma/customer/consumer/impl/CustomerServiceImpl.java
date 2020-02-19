package com.prokarma.customer.consumer.impl;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.customer.consumer.domain.Customer;
import com.prokarma.customer.consumer.repository.CustomerRepository;
import com.prokarma.customer.consumer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }


  @Override
  public void save(String customerJson) throws JsonProcessingException { // handle the exception
                                                                         // throw RuntimeException
    Customer customer = new ObjectMapper().readValue(customerJson, Customer.class);
    customerRepository.saveAndFlush(customer);

  }

}
