package com.prokarma.customer.consumer.listener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import com.prokarma.customer.consumer.repository.CustomerAuditLogRepository;
import com.prokarma.customer.consumer.repository.CustomerErrorLogRepository;
import com.prokarma.customer.consumer.repository.CustomerRepository;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"${kafka.customer.topic.name}"})
class CustomerTopicListenerTest {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private CustomerErrorLogRepository customerErrorLogRepository;
  @Autowired
  private CustomerAuditLogRepository auditLogRepository;

  @Value("${kafka.customer.topic.name}")
  private String topicName;



  private String validJSONPayload =
      "{\n" + "  \"customerNumber\": \"01234\",\n" + "  \"firstName\": \"12345678901234\",\n"
          + "  \"lastName\": \"12345678901234\",\n" + "  \"birthdate\": \"08-05-1993\",\n"
          + "  \"country\": \"India\",\n" + "  \"countryCode\": \"IN\",\n"
          + "  \"mobileNumber\": \"9876543210\",\n" + "  \"email\": \"someone@example.com\",\n"
          + "  \"customerStatus\": \"Open\",\n" + "  \"address\": {\n"
          + "    \"addressLine1\": \"string\",\n" + "    \"addressLine2\": \"string\",\n"
          + "    \"street\": \"string\",\n" + "    \"postalCode\": \"12345\"\n" + "  }\n" + "}";



  @BeforeEach
  void clearData() {
    customerRepository.deleteAll();
    customerErrorLogRepository.deleteAll();
    auditLogRepository.deleteAll();
  }

  @Test
  void testValidMessage() throws InterruptedException {
    Message<String> userMessage = MessageBuilder.withPayload(validJSONPayload)
        .setHeader(KafkaHeaders.TOPIC, topicName).setHeader("user", "Mahesh").build();

    kafkaTemplate.send(userMessage);

    Thread.sleep(2000);
    assertEquals(1, customerRepository.findAll().size());
    assertEquals(1, auditLogRepository.findAll().size());

  }

  @Test
  void testInvalidMessageWithoutUserHeader() throws InterruptedException {
    Message<String> userMessage = MessageBuilder.withPayload("This is invalid payload")
        .setHeader(KafkaHeaders.TOPIC, topicName).build();

    kafkaTemplate.send(userMessage);

    Thread.sleep(2000);

    assertEquals(0, customerRepository.findAll().size());
    assertEquals(0, auditLogRepository.findAll().size());
    assertEquals(1, customerErrorLogRepository.findAll().size());
  }


  @Test
  void testValidMessageWithOutUserHeader() throws InterruptedException {
    Message<String> userMessage = MessageBuilder.withPayload(validJSONPayload)
        .setHeader(KafkaHeaders.TOPIC, topicName).build();

    kafkaTemplate.send(userMessage);

    Thread.sleep(2000);
    assertEquals(1, customerRepository.findAll().size());
    assertEquals(1, auditLogRepository.findAll().size());

  }

}
