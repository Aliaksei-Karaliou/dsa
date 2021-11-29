package com.github.aliakseikaraliou.musicservice.rest.converter

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

abstract class TreeNodeDeserializer<T> : JsonDeserializer<T>() {
    override fun deserialize(
        jsonParser: JsonParser,
        context: DeserializationContext
    ): T {
        val treeNode = jsonParser.codec.readTree<TreeNode>(jsonParser)

        return deserialize(treeNode, context)
    }

    abstract fun deserialize(treeNode: TreeNode, context: DeserializationContext): T
}