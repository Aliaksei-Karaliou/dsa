package com.github.aliakseikaraliou.musicservice.service.api

import com.github.aliakseikaraliou.musicservice.rest.model.EntityDTO

interface Service<T : EntityDTO> {
    fun find(params: Map<String, String>): List<T>

    fun find(page: Int): List<T>

    fun save(item: T): T

    fun update(id: Long, item: T): T
}