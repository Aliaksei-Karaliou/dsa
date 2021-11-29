package com.github.aliakseikaraliou.musicservice.db.entity.converter

import org.joda.time.Partial
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class LocalDateAttributeConverter : AttributeConverter<Partial, String> {

    override fun convertToDatabaseColumn(p0: Partial?): String {
        TODO("Not yet implemented")
    }

    override fun convertToEntityAttribute(p0: String?): Partial {
        TODO("Not yet implemented")
    }
}