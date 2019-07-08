package com.demo.ssj2k.controller

import com.demo.ssj2k.service.PersonService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
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