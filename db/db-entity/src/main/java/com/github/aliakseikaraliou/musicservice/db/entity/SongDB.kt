package com.github.aliakseikaraliou.musicservice.db.entity

import javax.persistence.*

@Entity
@Table(name = "song")
class SongDB(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long,

    @Column(name = "title")
    val title: String,
) : EntityDB()