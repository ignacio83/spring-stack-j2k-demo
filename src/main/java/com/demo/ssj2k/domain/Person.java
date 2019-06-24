package com.demo.ssj2k.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Person {

  @Id private Integer id;
  private String firstName;
  private String lastName;
  private Integer age;

  public String getFullName() {
    final StringBuilder sb = new StringBuilder(firstName);
    if (lastName != null) {
      sb.append(lastName);
    }
    return sb.toString();
  }

  public void setFullName(String fullName) {
    final String[] split = fullName.split(" ");

    firstName = split[0];
    if (split.length > 1) {
      lastName = split[1];
    }
  }
}
