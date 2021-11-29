package com.github.aliakseikaraliou.musicservice.db.entity.relationship

import com.github.aliakseikaraliou.musicservice.db.entity.BandDB
import com.github.aliakseikaraliou.musicservice.db.entity.SongDB
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "song-band")
@IdClass(BandSong.SongBandPrimaryKey::class)
class BandSong(
    @Id
    @ManyToOne
    @JoinColumn(name = "song", referencedColumnName = "id")
    val song: SongDB,

    @Id
    @ManyToOne
    @JoinColumn(name = "band", referencedColumnName = "id")
    val band: BandDB,

//    @Enumerated(EnumType.STRING)
//    @Column(name = "type")
//    val songType: SongType
) {
    class SongBandPrimaryKey(
        val song: Long,
        val band: Long
    ) : Serializable
}