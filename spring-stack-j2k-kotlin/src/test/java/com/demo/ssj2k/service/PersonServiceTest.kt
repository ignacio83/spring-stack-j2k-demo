package com.demo.ssj2k.service

import com.demo.ssj2k.domain.Person
import com.demo.ssj2k.repository.PersonRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

class PersonServiceTest {
    private val repository = mockk<PersonRepository>()
    private val service: PersonService = PersonService(repository)

    @Test
    fun `when person does not exists save with success`() {
        every { repository.findByIdOrNull(any()) } returns null

        val person = Person(10, "Mathew", "Smith", 37)

        val captor = slot<Person>()

        every { repository.save(capture(captor)) } answers { it.invocation.args.first() as Person }

        service.create(person)

        val savedPerson = captor.captured

        assertThat(savedPerson.id).isEqualTo(10)
        assertThat(savedPerson.firstName).isEqualTo("Mathew")
        assertThat(savedPerson.lastName).isEqualTo("Smith")
        assertThat(savedPerson.fullName).isEqualTo("Mathew Smith")
        assertThat(savedPerson.age).isEqualTo(37)
    }

    @Test
    fun `when person already exists throw exception`() {
        every { repository.findByIdOrNull(any()) }.returns(Person(10, "Mathew", "Smith", 37))

        val person = Person(10, "Mathew", "Smith", 37)

        assertThatThrownBy { service.create(person) }.isInstanceOf(DomainAlreadyExistsException::class.java)
    }
}
