package com.github.aliakseikaraliou.musicservice.db.entity.relationship

import com.github.aliakseikaraliou.musicservice.db.entity.AlbumDB
import com.github.aliakseikaraliou.musicservice.db.entity.PersonDB
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "album-person")
@IdClass(AlbumPerson.AlbumPersonPrimaryKey::class)
class AlbumPerson(
    @Id
    @ManyToOne
    @JoinColumn(name = "album", referencedColumnName = "id")
    val album: AlbumDB,

    @Id
    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "id")
    val person: PersonDB,

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    val albumType: AlbumType
) {
    class AlbumPersonPrimaryKey(
        val album: Long,
        val person: Long
    ) : Serializable
}