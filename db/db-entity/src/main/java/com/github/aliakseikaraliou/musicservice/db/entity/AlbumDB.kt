package com.github.aliakseikaraliou.musicservice.db.entity

import com.github.aliakseikaraliou.musicservice.db.entity.relationship.AlbumBand
import javax.persistence.*

@Entity
@Table(name = "album")
class AlbumDB(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @OneToMany
    val bands: List<AlbumBand>,

    @OneToMany
    val persons: List<AlbumBand>

) : EntityDB()