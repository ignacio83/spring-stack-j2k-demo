package com.demo.ssj2k.controller

import com.demo.ssj2k.domain.Person
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PersonContract(
    @field:NotNull
    val id: Int?,
    @field:NotEmpty
    val firstName: String?,
    @field:NotEmpty
    val lastName: String?,
    @field:NotNull
    val age: Int?
) {

    constructor(person: Person) :
        this(person.id, person.firstName, person.lastName, person.age)

    fun toDomain() = Person(id!!, firstName!!, lastName!!, age!!)
}