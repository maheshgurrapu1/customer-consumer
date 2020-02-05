package com.prokarma.customer.consumer.domain;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Customer
 */

@Entity
public class Customer {

  @Id
  @JsonProperty("customerNumber")
  private String customerNumber = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("birthdate")
  @JsonFormat(pattern = "DD-MM-YYYY")
  private String birthdate = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("mobileNumber")
  private BigDecimal mobileNumber = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("customerStatus")
  private String customerStatus = null;

  @JsonProperty("address")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addressId")
  private Address address = null;

  /**
   * Get customerNumber
   * 
   * @return customerNumber
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Pattern(regexp = "^[a-zA-Z0-9]+$")
  @Size(min = 5, max = 50)
  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  /**
   * Get firstName
   * 
   * @return firstName
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Size(min = 10, max = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get lastName
   * 
   * @return lastName
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Size(min = 10, max = 50)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  /**
   * Get birthdate
   * 
   * @return birthdate
   **/
  @ApiModelProperty(example = "DD-MM-YYYY", required = true, value = "")
  @NotNull
  @Valid
  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }


  /**
   * Get country
   * 
   * @return country
   **/
  @ApiModelProperty(example = "India", required = true, value = "")
  @NotNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  /**
   * Get countryCode
   * 
   * @return countryCode
   **/
  @ApiModelProperty(example = "IN", required = true, value = "")
  @NotNull

  @Size(min = 2, max = 2)
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   * Get mobileNumber
   * 
   * @return mobileNumber
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(BigDecimal mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  /**
   * User Status
   * 
   * @return email
   **/
  @ApiModelProperty(example = "abc@gmail.com", required = true, value = "User Status")
  @NotNull

  @Size(max = 50)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @NotNull
  public String getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
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

