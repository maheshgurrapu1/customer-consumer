package com.prokarma.customer.consumer.impl;

import org.springframework.stereotype.Service;
import com.prokarma.customer.consumer.domain.CustomerErrorLog;
import com.prokarma.customer.consumer.repository.CustomerErrorLogRepository;
import com.prokarma.customer.consumer.service.CustomerErrorLogService;

@Service
public class CustomerErrorLogServiceImpl implements CustomerErrorLogService {

  private CustomerErrorLogRepository customerErrorLogRepository;

  public CustomerErrorLogServiceImpl(CustomerErrorLogRepository customerErrorLogRepository) {
    super();
    this.customerErrorLogRepository = customerErrorLogRepository;
  }



  @Override
  public void save(Exception exception, String payload) {
    CustomerErrorLog customerErrorLog = new CustomerErrorLog();
    customerErrorLog.setErrorDescription(exception.getMessage());
    customerErrorLog.setErrorType("Exception");
    customerErrorLog.setPayload(payload);

    customerErrorLogRepository.saveAndFlush(customerErrorLog);

  }

}
