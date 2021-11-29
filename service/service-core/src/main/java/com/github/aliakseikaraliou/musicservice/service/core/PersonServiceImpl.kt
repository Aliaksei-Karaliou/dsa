package com.github.aliakseikaraliou.musicservice.service.core

import com.github.aliakseikaraliou.musicservice.db.entity.PersonDB
import com.github.aliakseikaraliou.musicservice.db.repo.PersonRepository
import com.github.aliakseikaraliou.musicservice.rest.model.PersonDTO
import com.github.aliakseikaraliou.musicservice.service.api.PersonService
import com.github.aliakseikaraliou.musicservice.service.api.resolver.ParamResolver
import com.github.aliakseikaraliou.musicservice.service.api.resolver.resolveList
import com.github.aliakseikaraliou.musicservice.service.api.resolver.splitToIds
import com.github.aliakseikaraliou.musicservice.service.core.ParamsConstants.ID
import com.github.aliakseikaraliou.musicservice.service.core.ParamsConstants.IS_ACTIVE
import com.github.aliakseikaraliou.musicservice.service.core.ParamsConstants.NAME
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service

@Service
@RefreshScope
class PersonServiceImpl(
    private val personRepository: PersonRepository
) : PersonService, AbstractServiceImpl<PersonDTO, PersonDB>() {

    override fun dbToDto(db: PersonDB) = PersonDTO(
        id = db.id,
        name = db.name,
        isActive = db.isActive,
        description = db.description
    )

    override fun dtoToDb(dto: PersonDTO) = PersonDB(
        id = dto.id ?: 0,
        name = dto.name,
        isActive = dto.isActive,
        description = dto.description
    )

    override val entityRepository
        get() = personRepository

    override val resolverMap: Map<String, ParamResolver<PersonDB>> = mutableMapOf(
        ID to { ids: String -> personRepository.findAllById(ids.splitToIds()).toList() }.resolveList(),
        NAME to { name: String -> personRepository.findAllByName(name) }.resolveList(),
        IS_ACTIVE to { isActive: String -> personRepository.findAllByIsActive(isActive.toBoolean()) }.resolveList()
    )
}