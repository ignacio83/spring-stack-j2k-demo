package com.demo.ssj2k.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
    @Id val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
) {

    @Transient
    val fullName = "$firstName $lastName"
}