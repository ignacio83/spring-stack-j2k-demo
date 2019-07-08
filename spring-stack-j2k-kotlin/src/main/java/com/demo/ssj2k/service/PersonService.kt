package com.demo.ssj2k.service

import com.demo.ssj2k.domain.Person
import com.demo.ssj2k.repository.PersonRepository
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PersonService(private val repository: PersonRepository) {
    private val log = KotlinLogging.logger {}

    @Transactional
    fun create(person: Person): Person {
        if (repository.findByIdOrNull(person.id) != null) {
            throw DomainAlreadyExistsException("Person already exists exception")
        }

        return repository.save(person).also {
            log.debug { "Person ${it.id} - ${it.fullName} created" }
        }
    }

    fun findAll(): List<Person> = repository.findAll().also {
        log.debug { "${it.size} persons found" }
    }
}