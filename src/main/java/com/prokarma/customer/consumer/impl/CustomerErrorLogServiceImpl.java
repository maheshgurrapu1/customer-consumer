package com.prokarma.customer.consumer.impl;

import org.springframework.stereotype.Service;
import com.prokarma.customer.consumer.entity.CustomerErrorLog;
import com.prokarma.customer.consumer.repository.CustomerErrorLogRepository;
import com.prokarma.customer.consumer.service.CustomerErrorLogService;

@Service
public class CustomerErrorLogServiceImpl implements CustomerErrorLogService {

  private CustomerErrorLogRepository customerErrorLogRepository;

  public CustomerErrorLogServiceImpl(CustomerErrorLogRepository customerErrorLogRepository) {
    this.customerErrorLogRepository = customerErrorLogRepository;
  }

  @Override
  public void save(Throwable throwable, String payload) {
    CustomerErrorLog customerErrorLog = new CustomerErrorLog();
    customerErrorLog.setErrorDescription(throwable.getMessage());
    customerErrorLog.setErrorType("Exception");
    customerErrorLog.setPayload(payload);

    customerErrorLogRepository.saveAndFlush(customerErrorLog);

  }

}
