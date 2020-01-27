package com.prokarma.customer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prokarma.customer.consumer.domain.CustomerErrorLog;

@Repository
public interface CustomerErrorLogRepository extends JpaRepository<CustomerErrorLog, Long> {

}
