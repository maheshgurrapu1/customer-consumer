package com.prokarma.customer.consumer.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.prokarma.customer.consumer.service.CustomerAuditLogService;
import com.prokarma.customer.consumer.service.CustomerService;

@Component
public class CustomerTopicListener {

  private static final Logger LOGGER = LogManager.getLogger(CustomerTopicListener.class);

  private CustomerService customerService;
  private CustomerAuditLogService customerAuditLogService;

  public CustomerTopicListener(CustomerService customerService,
      CustomerAuditLogService customerAuditLogService) {
    this.customerService = customerService;
    this.customerAuditLogService = customerAuditLogService;
  }

  @KafkaListener(topics = "${kafka.customer.topic.name}")
  public void onCustomerTopic(String payload) {
    LOGGER.info("Message Received -- > {}", payload);

    customerService.save(payload);
    customerAuditLogService.save(payload);

  }
}
