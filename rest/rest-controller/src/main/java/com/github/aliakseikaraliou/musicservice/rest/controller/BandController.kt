package com.github.aliakseikaraliou.musicservice.rest.controller

import com.github.aliakseikaraliou.musicservice.rest.model.BandDTO
import com.github.aliakseikaraliou.musicservice.service.api.BandService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/band")
class BandController(val bandService: BandService) {

    @GetMapping
    fun find(
        @RequestParam params: Map<String, String>,
    ): List<BandDTO> {
        val page = params["page"]?.toIntOrNull() ?: 1
        return bandService.find(params)
    }

    @GetMapping("/{page}")
    fun find(
        @PathVariable page: Int,
    ): List<BandDTO> {
        return bandService.find(page)
    }

    @PostMapping
    fun save(@RequestBody band: BandDTO): BandDTO {
        return bandService.save(band)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody person: BandDTO
    ): BandDTO {
        return bandService.update(id, person)
    }
}