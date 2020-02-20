package com.prokarma.customer.consumer.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.prokarma.customer.consumer.service.CustomerErrorLogService;

@Aspect
@Component
public class CustomerTopicListenerAdvice {

  private static final Logger LOGGER = LogManager.getLogger(CustomerTopicListenerAdvice.class);

  private CustomerErrorLogService customerErrorLogService;

  public CustomerTopicListenerAdvice(CustomerErrorLogService customerErrorLogService) {
    this.customerErrorLogService = customerErrorLogService;
  }

  @Pointcut(
      value = "execution(* com.prokarma.customer.consumer.listener.CustomerTopicListener.*(..))")
  private void logAfterOnCustomerTopic() {}

  @AfterThrowing(value = "logAfterOnCustomerTopic()", throwing = "exception")
  public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
    LOGGER.info("Inside afterThrowingAdvice() method = {} , Args = {} ",
        joinPoint.getSignature().getName(), joinPoint.getArgs()[0].toString());

    LOGGER.error("Exception Occured while saving the payload ", exception);
    customerErrorLogService.save(exception, joinPoint.getArgs()[0].toString());

  }

}
