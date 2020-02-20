package com.prokarma.customer.consumer.service;

public interface CustomerErrorLogService {

  void save(Throwable throwable, String payload);
}
