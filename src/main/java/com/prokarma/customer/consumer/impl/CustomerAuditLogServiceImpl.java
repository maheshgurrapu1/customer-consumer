package com.prokarma.customer.consumer.impl;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.entity.CustomerAuditLog;
import com.prokarma.customer.consumer.repository.CustomerAuditLogRepository;
import com.prokarma.customer.consumer.service.CustomerAuditLogService;

@Service
public class CustomerAuditLogServiceImpl implements CustomerAuditLogService {

  private CustomerAuditLogRepository customerAuditLogRepository;

  public CustomerAuditLogServiceImpl(CustomerAuditLogRepository customerAuditLogRepository) {
    super();
    this.customerAuditLogRepository = customerAuditLogRepository;
  }

  @Override
  public void save(String payload) throws JsonProcessingException {
    Customer customer = new ObjectMapper().readValue(payload, Customer.class);

    CustomerAuditLog customerAuditLog = new CustomerAuditLog();
    customerAuditLog.setCustomerNumber(customer.getCustomerNumber());
    customerAuditLog.setPayload(payload);

    customerAuditLogRepository.saveAndFlush(customerAuditLog);

  }

}
