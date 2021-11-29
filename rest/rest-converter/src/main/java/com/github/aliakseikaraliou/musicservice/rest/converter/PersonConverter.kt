package com.github.aliakseikaraliou.musicservice.rest.converter

import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.github.aliakseikaraliou.musicservice.rest.converter.JsonConstants.DESCRIPTION
import com.github.aliakseikaraliou.musicservice.rest.converter.JsonConstants.IS_ACTIVE
import com.github.aliakseikaraliou.musicservice.rest.converter.JsonConstants.NAME
import com.github.aliakseikaraliou.musicservice.rest.model.PersonDTO
import org.springframework.boot.jackson.JsonComponent

@JsonComponent
class PersonConverter {

    class Deserialize : TreeNodeDeserializer<PersonDTO>() {
        override fun deserialize(
            treeNode: TreeNode,
            context: DeserializationContext
        ): PersonDTO {
            val name = treeNode.obtain<String>(NAME)
            val isActive = treeNode.obtainOrNull<Boolean>(IS_ACTIVE) ?: false
            val description = treeNode.obtainOrNull<String>(DESCRIPTION)

            return PersonDTO(
                name = name,
                isActive = isActive,
                description = description
            )
        }
    }
}
