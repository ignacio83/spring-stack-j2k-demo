package com.demo.ssj2k.controller

import com.demo.ssj2k.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/persons")
class PersonController(private val service: PersonService) {

    @PostMapping
    fun create(@RequestBody @Valid personContract: PersonContract) =
        personContract
            .let(PersonContract::toDomain)
            .run { service.create(this) }
            .let(::PersonContract)

    @GetMapping
    fun list() = service.findAll().map(::PersonContract)
}