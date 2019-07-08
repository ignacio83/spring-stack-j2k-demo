package com.demo.ssj2k.controller;

import com.demo.ssj2k.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PersonContract {
  @NotNull private Integer id;

  @NotEmpty private String firstName;

  @NotEmpty private String lastName;

  @NotNull private Integer age;

  public PersonContract(Person person) {
    this.id = person.getId();
    this.firstName = person.getFirstName();
    this.lastName = person.getLastName();
    this.age = person.getAge();
  }

  public Person toDomain() {
    final Person domain = new Person();

    domain.setId(id);
    domain.setFirstName(firstName);
    domain.setLastName(lastName);
    domain.setAge(age);

    return domain;
  }
}
