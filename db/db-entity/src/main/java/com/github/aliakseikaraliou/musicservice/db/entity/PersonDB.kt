package com.github.aliakseikaraliou.musicservice.db.entity

import com.github.aliakseikaraliou.musicservice.db.entity.relationship.AlbumBand
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "person")
class PersonDB(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "is_active")
    val isActive: Boolean,

    @Column(name = "description")
    val description: String?,

    @OneToMany
    val albums: List<AlbumBand>
) : EntityDB() {
    override fun hashCode(): Int = Objects.hash(id, name, isActive, description)

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , isActive = $isActive , description = $description )"
    }
}