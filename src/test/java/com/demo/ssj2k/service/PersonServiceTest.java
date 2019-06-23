package com.demo.ssj2k.service;

import com.demo.ssj2k.domain.Person;
import com.demo.ssj2k.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @Mock private PersonRepository repository;

  @Captor private ArgumentCaptor<Person> captor;

  @InjectMocks private PersonService service;

  @Test
  public void whenPersonNotExistsSaveWithSuccess() {
    when(repository.findById(any())).thenReturn(Optional.empty());

    final Person person = new Person();
    person.setId(10);
    person.setFullName("Mathew Smith");
    person.setAge(37);

    service.create(person);

    verify(repository).save(captor.capture());

    final Person savedPerson = captor.getValue();

    assertThat(savedPerson.getId()).isEqualTo(10);
    assertThat(savedPerson.getFirstName()).isEqualTo("Mathew");
    assertThat(savedPerson.getLastName()).isEqualTo("Smith");
    assertThat(savedPerson.getFullName()).isEqualTo("Mathew Smith");
    assertThat(savedPerson.getAge()).isEqualTo(37);
  }

  @Test
  public void whenPersonAlreadyExistsThrowException() {
    when(repository.findById(any())).thenReturn(Optional.of(new Person()));

    final Person person = new Person();
    person.setId(10);
    person.setFullName("Mathew Smith");
    person.setAge(37);

    assertThatThrownBy(() -> service.create(person))
        .isInstanceOf(DomainAlreadyExistsException.class);
  }
}
