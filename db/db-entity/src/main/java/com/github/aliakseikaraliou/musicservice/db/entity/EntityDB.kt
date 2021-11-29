package com.github.aliakseikaraliou.musicservice.db.entity

import org.hibernate.Hibernate
import java.util.*

abstract class EntityDB {
    abstract val id: Long

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) {
            return false
        }

        return id == (other as EntityDB).id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}