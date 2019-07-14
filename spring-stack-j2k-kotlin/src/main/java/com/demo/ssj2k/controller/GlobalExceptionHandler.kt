package com.demo.ssj2k.controller

import com.demo.ssj2k.service.DomainAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DomainAlreadyExistsException::class)
    fun handleDomainAlreadyExistsException(ex: DomainAlreadyExistsException) =
        ResponseEntity(ErrorContract(ex.message!!), HttpStatus.UNPROCESSABLE_ENTITY)

    data class ErrorContract(val message: String)
}
