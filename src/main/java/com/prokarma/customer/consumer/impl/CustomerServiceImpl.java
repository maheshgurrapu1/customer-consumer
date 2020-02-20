package com.prokarma.customer.consumer.impl;

import org.springframework.stereotype.Service;
import com.prokarma.customer.consumer.common.JsonConverter;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.repository.CustomerRepository;
import com.prokarma.customer.consumer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;
  private JsonConverter jsonConverter;

  public CustomerServiceImpl(CustomerRepository customerRepository, JsonConverter jsonConverter) {
    this.customerRepository = customerRepository;
    this.jsonConverter = jsonConverter;
  }


  @Override
  public void save(String customerJson) {
    Customer customer = jsonConverter.fromJson(customerJson, Customer.class);
    customerRepository.saveAndFlush(customer);

  }

}
