package com.prokarma.customer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface CustomerConsumer {

  void listnerMyTopic(String customerJson) throws JsonMappingException, JsonProcessingException;

}
