package com.prokarma.customer.consumer.listener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import com.prokarma.customer.consumer.service.CustomerAuditLogService;
import com.prokarma.customer.consumer.service.CustomerErrorLogService;
import com.prokarma.customer.consumer.service.CustomerService;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"customer_topic"})
class CustomerTopicListenerTest {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private CustomerAuditLogService customerAuditLogService;

  @Autowired
  private CustomerErrorLogService customerErrorLogService;


  private String validJSONPayload =
      "{\n" + "  \"customerNumber\": \"01234\",\n" + "  \"firstName\": \"12345678901234\",\n"
          + "  \"lastName\": \"12345678901234\",\n" + "  \"birthdate\": \"08-05-1993\",\n"
          + "  \"country\": \"India\",\n" + "  \"countryCode\": \"IN\",\n"
          + "  \"mobileNumber\": \"9876543210\",\n" + "  \"email\": \"someone@example.com\",\n"
          + "  \"customerStatus\": \"Open\",\n" + "  \"address\": {\n"
          + "    \"addressLine1\": \"string\",\n" + "    \"addressLine2\": \"string\",\n"
          + "    \"street\": \"string\",\n" + "    \"postalCode\": \"12345\"\n" + "  }\n" + "}";


  @Test
  void testValidMessage() throws InterruptedException {
    kafkaTemplate.send("customer_topic", validJSONPayload);
    Thread.sleep(2000);

  }

  @Test
  void testInvalidMessage() throws InterruptedException {
    kafkaTemplate.send("customer_topic", "Invalid Payload");
    Thread.sleep(2000);

  }

  /*
   * @Test void testInvalidMessage() throws InterruptedException { Message<String> userMessage =
   * MessageBuilder.withPayload("This is invalid payload") .setHeader(KafkaHeaders.TOPIC,
   * messageTopic).setHeader(userHeader, userValue).build();
   * 
   * kafkaTemplate.send(userMessage);
   * 
   * Thread.sleep(2000);
   * 
   * assertEquals(0, userRepository.findAll().size()); assertEquals(1,
   * userAuditRepository.findByCustomerNumber(userValue).size()); assertEquals(1,
   * errorAuditRepository.findByCustomerNumber(userValue).size()); }
   * 
   * @Test void testInvalidMessageWithoutUser() throws InterruptedException { Message<String>
   * userMessage = MessageBuilder.withPayload("This is invalid payload")
   * .setHeader(KafkaHeaders.TOPIC, messageTopic).build();
   * 
   * kafkaTemplate.send(userMessage);
   * 
   * Thread.sleep(2000);
   * 
   * assertEquals(0, userRepository.findAll().size()); assertEquals(1,
   * userAuditRepository.findByCustomerNumber("unknown").size()); assertEquals(1,
   * errorAuditRepository.findByCustomerNumber("unknown").size()); }
   * 
   * @Test void testValidMessageWithoutUser() throws InterruptedException { Message<String>
   * userMessage = MessageBuilder.withPayload(validJSONPayload) .setHeader(KafkaHeaders.TOPIC,
   * messageTopic).setHeader(userHeader, userValue).build();
   * 
   * kafkaTemplate.send(userMessage);
   * 
   * Thread.sleep(2000);
   * 
   * assertEquals(1, userService.findUsersByCustomerNumber("01234").size()); assertEquals(1,
   * userAuditRepository.findByCustomerNumber(userValue).size()); }
   */

}
