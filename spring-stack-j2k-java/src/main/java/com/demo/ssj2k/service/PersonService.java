package com.demo.ssj2k.service;

import com.demo.ssj2k.domain.Person;
import com.demo.ssj2k.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {
  private final PersonRepository repository;

  public Person create(Person person) {
    final Optional<Person> optional = repository.findById(person.getId());
    if (optional.isPresent()) {
      throw new DomainAlreadyExistsException("Person already exists exception");
    }

    final Person savedPerson = repository.save(person);

    log.debug("Person {} - {} created", person.getId(), person.getFullName());

    return savedPerson;
  }

  public List<Person> findAll() {
    final List<Person> persons = repository.findAll();

    log.debug("{} persons found", persons.size());

    return persons;
  }
}
