package com.prokarma.customer.consumer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_AUDIT_LOG")
public class CustomerAuditLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "CUSTOMER_NUMBER")
  private String customerNumber;

  @Lob
  @Column(name = "PAYLOAD", length = 3000)
  private String payload;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }



}
