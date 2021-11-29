package com.github.aliakseikaraliou.musicservice.db.repo

import com.github.aliakseikaraliou.musicservice.db.entity.BandDB
import org.springframework.stereotype.Repository

@Repository
interface BandRepository : EntityDBRepository<BandDB> {
    fun findAllByName(name: String): List<BandDB>

    fun findAllByIsActive(isActive: Boolean): List<BandDB>
}