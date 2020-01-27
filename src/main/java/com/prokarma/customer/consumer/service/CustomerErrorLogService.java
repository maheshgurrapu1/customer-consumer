package com.prokarma.customer.consumer.service;

public interface CustomerErrorLogService {

  void save(Exception exception, String payload);
}
