package com.github.aliakseikaraliou.musicservice.service.core

import com.github.aliakseikaraliou.musicservice.db.entity.EntityDB
import com.github.aliakseikaraliou.musicservice.db.repo.EntityDBRepository
import com.github.aliakseikaraliou.musicservice.rest.model.EntityDTO
import com.github.aliakseikaraliou.musicservice.service.api.Service
import com.github.aliakseikaraliou.musicservice.service.api.resolver.ParamResolver
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.PageRequest
import kotlin.math.max

abstract class AbstractServiceImpl<DTO : EntityDTO, DB : EntityDB> : Service<DTO> {
    @Value("\${app.page.size:1}")
    private var pageSize: Int = 0

    abstract val entityRepository: EntityDBRepository<DB>
    abstract val resolverMap: Map<String, ParamResolver<DB>>

    abstract fun dbToDto(db: DB): DTO
    abstract fun dtoToDb(dto: DTO): DB

    override fun save(item: DTO): DTO {
        item.id = null
        val dtoToDb = dtoToDb(item)
        val savedDb = entityRepository.save(dtoToDb)

        return dbToDto(savedDb)
    }

    override fun update(id: Long, item: DTO): DTO {
        item.id = id
        val savedDb = entityRepository.save(dtoToDb(item))

        return dbToDto(savedDb)
    }

    override fun find(params: Map<String, String>): List<DTO> {
        val paramMap = params
            .filter { resolverMap.keys.contains(it.key) }

        val items = mutableMapOf<DB, Int>()

        paramMap
            .forEach { entry ->
                resolverMap[entry.key]
                    ?.get(entry.value)
                    ?.forEach { entity ->
                        val currentCount = items.getOrDefault(entity, 0)
                        items[entity] = currentCount + 1
                    }
            }

        val dbs = items
            .filter { it.value == paramMap.size }
            .keys

        return dbToDto(dbs)
    }

    override fun find(page: Int): List<DTO> {
        val countedPage = max(page - 1, 0)
        val loadedPage = entityRepository.findAll(PageRequest.of(countedPage, pageSize))

        return dbToDto(loadedPage.toList())
    }

    private fun dbToDto(db: Collection<DB>) = db
        .map { dbToDto(it) }
}