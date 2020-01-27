package com.prokarma.customer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.prokarma.customer.consumer.service.CustomerAuditLogService;
import com.prokarma.customer.consumer.service.CustomerErrorLogService;
import com.prokarma.customer.consumer.service.CustomerService;

@Component
public class CustomerConsumerImpl implements CustomerConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerConsumerImpl.class);

  @Autowired
  private CustomerService customerService;

  @Autowired
  private CustomerAuditLogService customerAuditLogService;

  @Autowired
  private CustomerErrorLogService customerErrorLogService;

  @KafkaListener(topics = "customer_topic")
  public void listnerMyTopic(String customerJson) {
    try {

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Event Received---------------------------->");
      stringBuilder.append(customerJson);

      customerService.save(customerJson);
      customerAuditLogService.save(customerJson);

    } catch (Exception exception) {
      customerErrorLogService.save(exception, customerJson);
    }

  }
}
