package com.prokarma.customer.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CustomerAuditLogService {

  void save(String payload) throws JsonProcessingException;

}
