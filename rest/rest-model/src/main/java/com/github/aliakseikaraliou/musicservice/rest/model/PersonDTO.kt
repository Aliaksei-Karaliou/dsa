package com.github.aliakseikaraliou.musicservice.rest.model

data class PersonDTO(
    override var id: Long? = null,
    override val name: String,
    override val description: String?,
    override val isActive: Boolean
) : EntityDTO, ArtistDTO