package com.prokarma.customer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prokarma.customer.consumer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
