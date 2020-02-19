package com.prokarma.customer.consumer.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.prokarma.customer.consumer.service.CustomerAuditLogService;
import com.prokarma.customer.consumer.service.CustomerErrorLogService;
import com.prokarma.customer.consumer.service.CustomerService;

@Component
public class CustomerTopicListener {

  private static final Logger LOGGER = LogManager.getLogger(CustomerTopicListener.class);

  @Autowired
  private CustomerService customerService;

  @Autowired
  private CustomerAuditLogService customerAuditLogService;

  @Autowired
  private CustomerErrorLogService customerErrorLogService;

  @KafkaListener(topics = "${kafka.customer.topic.name}")
  public void onCustomerTopic(String payload) {
    try {
      LOGGER.info("Message Received -- > {}", payload);

      customerService.save(payload);
      customerAuditLogService.save(payload);

    } catch (Exception exception) {
      customerErrorLogService.save(exception, payload); // Use AOP after throwwing
    }

  }
}
