package com.github.aliakseikaraliou.musicservice.service.api.resolver

interface ParamResolver<T> {
    fun get(value: String): List<T>
}

fun <T> ParamResolver<T>.or(resolver: ParamResolver<T>) = object : ParamResolver<T> {
    override fun get(value: String): List<T> {
        val item1 = this@or.get(value)
        val item2 = resolver.get(value)

        return mutableSetOf<T>().apply {
            addAll(item1)
            addAll(item2)
        }.toList()
    }
}

fun <T> ((String) -> T).resolveSingle() = object : ParamResolver<T> {
    override fun get(value: String): List<T> {
        return listOf(invoke(value))
    }
}

fun <T> ((String) -> List<T>).resolveList() = object : ParamResolver<T> {
    override fun get(value: String): List<T> {
        return invoke(value)
    }
}

fun String.splitToIds() = this.split(",").map { it.toLong() }