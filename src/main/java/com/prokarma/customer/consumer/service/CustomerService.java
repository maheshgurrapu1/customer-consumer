package com.prokarma.customer.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface CustomerService {

  void save(String customerJson) throws JsonMappingException, JsonProcessingException;

}
