package com.demo.ssj2k.controller;

import com.demo.ssj2k.domain.Person;
import com.demo.ssj2k.service.PersonService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
  private final PersonService service;

  @PostMapping
  public PersonContract create(@RequestBody @Valid PersonContract personContract) {
    final Person domain = personContract.toDomain();
    final Person createdPerson = service.create(domain);
    return new PersonContract(createdPerson);
  }

  @GetMapping
  public List<PersonContract> list() {
    return service.findAll().stream().map(PersonContract::new).collect(Collectors.toList());
  }
}
