package com.github.aliakseikaraliou.musicservice.service.core

import com.github.aliakseikaraliou.musicservice.db.entity.BandDB
import com.github.aliakseikaraliou.musicservice.db.repo.BandRepository
import com.github.aliakseikaraliou.musicservice.rest.model.BandDTO
import com.github.aliakseikaraliou.musicservice.service.api.BandService
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
class BandServiceImpl(
    private val bandRepository: BandRepository
) : BandService, AbstractServiceImpl<BandDTO, BandDB>() {

    override fun dbToDto(db: BandDB) = BandDTO(
        id = db.id,
        name = db.name,
        isActive = db.isActive,
        description = db.description
    )

    override fun dtoToDb(dto: BandDTO) = BandDB(
        id = dto.id ?: 0,
        name = dto.name,
        isActive = dto.isActive,
        description = dto.description
    )

    override val entityRepository
        get() = bandRepository

    override val resolverMap: Map<String, ParamResolver<BandDB>> = mutableMapOf(
        ID to { ids: String -> bandRepository.findAllById(ids.splitToIds()).toList() }.resolveList(),
        NAME to { name: String -> bandRepository.findAllByName(name) }.resolveList(),
        IS_ACTIVE to { isActive: String -> bandRepository.findAllByIsActive(isActive.toBoolean()) }.resolveList()
    )
}