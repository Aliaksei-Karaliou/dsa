package com.github.aliakseikaraliou.musicservice.db.repo

import com.github.aliakseikaraliou.musicservice.db.entity.PersonDB
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : EntityDBRepository<PersonDB> {
    fun findAllByName(name: String): List<PersonDB>

    fun findAllByIsActive(isActive: Boolean): List<PersonDB>
}