package com.github.aliakseikaraliou.musicservice.db.entity

import javax.persistence.*

@Entity
@Table(name = "band")
class BandDB(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "is_active")
    val isActive: Boolean,

    @Column(name = "description")
    val description: String?
) : EntityDB()