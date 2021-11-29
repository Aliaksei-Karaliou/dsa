package com.github.aliakseikaraliou.musicservice.db.repo

import com.github.aliakseikaraliou.musicservice.db.entity.EntityDB
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository

@NoRepositoryBean
interface EntityDBRepository<T : EntityDB> : PagingAndSortingRepository<T, Long>