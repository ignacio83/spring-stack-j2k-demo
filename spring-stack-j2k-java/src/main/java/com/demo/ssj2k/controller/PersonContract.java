package com.demo.ssj2k.controller;

import com.demo.ssj2k.domain.Person;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonContract {
  @NotNull private Integer id;

  @NotEmpty private String fullName;

  @NotNull private Integer age;

  public PersonContract(Person person) {
    this.id = person.getId();
    this.fullName = person.getFullName();
    this.age = person.getAge();
  }

  public Person toDomain() {
    final Person domain = new Person();

    domain.setId(id);
    domain.setFullName(fullName);
    domain.setAge(age);

    return domain;
  }
}
