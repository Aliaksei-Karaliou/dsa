package com.github.aliakseikaraliou.musicservice.rest.converter

import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.node.BooleanNode
import com.fasterxml.jackson.databind.node.TextNode
import com.github.aliakseikaraliou.musicservice.rest.converter.exception.MissingParameterException

inline fun <reified T> TreeNode.obtain(name: String): T = obtainOrNull<T>(name)
    ?: throw MissingParameterException("$name parameter is missing")

inline fun <reified T> TreeNode.obtainOrNull(name: String): T? = when (T::class) {
    Boolean::class -> (this.get(name) as? BooleanNode)?.asBoolean()
    String::class -> (this.get(name) as? TextNode)?.asText()
    else -> null
} as T?