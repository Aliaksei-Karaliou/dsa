package com.github.aliakseikaraliou.musicservice.rest.controller

import com.github.aliakseikaraliou.musicservice.rest.model.PersonDTO
import com.github.aliakseikaraliou.musicservice.service.api.PersonService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(val personService: PersonService) {

    @GetMapping
    fun find(@RequestParam params: Map<String, String>): List<PersonDTO> {
        val page = params["page"]?.toIntOrNull() ?: 1

        return personService.find(params)
    }

    @GetMapping("/{page}")
    fun find(
        @PathVariable page: Int,
    ): List<PersonDTO> {
        return personService.find(page)
    }

    @PostMapping
    fun save(@RequestBody person: PersonDTO): PersonDTO {
        return personService.save(person)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody person: PersonDTO
    ): PersonDTO {
        return personService.update(id, person)
    }
}