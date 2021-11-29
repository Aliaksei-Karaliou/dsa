package com.github.aliakseikaraliou.musicservice.db.entity.relationship

import com.github.aliakseikaraliou.musicservice.db.entity.AlbumDB
import com.github.aliakseikaraliou.musicservice.db.entity.BandDB
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "album-band")
@IdClass(AlbumBand.AlbumBandPrimaryKey::class)
class AlbumBand(
    @Id
    @ManyToOne
    @JoinColumn(name = "album", referencedColumnName = "id")
    val album: AlbumDB,

    @Id
    @ManyToOne
    @JoinColumn(name = "band", referencedColumnName = "id")
    val band: BandDB,

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    val albumType: AlbumType
) {
    class AlbumBandPrimaryKey(
        val album: Long,
        val band: Long
    ) : Serializable
}