package com.prokarma.customer.consumer.impl;

import org.springframework.stereotype.Service;
import com.prokarma.customer.consumer.common.JsonConverter;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.entity.CustomerAuditLog;
import com.prokarma.customer.consumer.repository.CustomerAuditLogRepository;
import com.prokarma.customer.consumer.service.CustomerAuditLogService;

@Service
public class CustomerAuditLogServiceImpl implements CustomerAuditLogService {

  private CustomerAuditLogRepository customerAuditLogRepository;
  private JsonConverter jsonConverter;

  public CustomerAuditLogServiceImpl(CustomerAuditLogRepository customerAuditLogRepository,
      JsonConverter jsonConverter) {
    this.customerAuditLogRepository = customerAuditLogRepository;
    this.jsonConverter = jsonConverter;
  }

  @Override
  public void save(String payload) {
    Customer customer = jsonConverter.fromJson(payload, Customer.class);

    CustomerAuditLog customerAuditLog = new CustomerAuditLog();
    customerAuditLog.setCustomerNumber(customer.getCustomerNumber());
    customerAuditLog.setPayload(payload);

    customerAuditLogRepository.saveAndFlush(customerAuditLog);

  }

}
