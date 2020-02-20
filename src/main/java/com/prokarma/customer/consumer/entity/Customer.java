package com.prokarma.customer.consumer.entity;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Customer
 */

@Entity
public class Customer {

  @Id
  private String customerNumber = null;

  private String firstName = null;

  private String lastName = null;

  private String birthdate = null;

  private String country = null;

  private String countryCode = null;

  private BigDecimal mobileNumber = null;

  private String email = null;

  private String customerStatus = null;

  private Address address = null;

  @Size(min = 5, max = 50)
  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  @Size(min = 10, max = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @NotNull
  @Size(min = 10, max = 50)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public BigDecimal getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(BigDecimal mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }


  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer user = (Customer) o;
    return Objects.equals(this.customerNumber, user.customerNumber)
        && Objects.equals(this.firstName, user.firstName)
        && Objects.equals(this.lastName, user.lastName)
        && Objects.equals(this.birthdate, user.birthdate)
        && Objects.equals(this.country, user.country)
        && Objects.equals(this.countryCode, user.countryCode)
        && Objects.equals(this.mobileNumber, user.mobileNumber)
        && Objects.equals(this.email, user.email)
        && Objects.equals(this.customerStatus, user.customerStatus)
        && Objects.equals(this.address, user.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, firstName, lastName, birthdate, country, countryCode,
        mobileNumber, email, customerStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");

    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

