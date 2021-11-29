package com.github.aliakseikaraliou.musicservice

import org.springframework.boot.CommandLineRunner
import org.springframework.core.env.*
import org.springframework.stereotype.Component
import java.util.*

import java.util.stream.StreamSupport

@Component
class CRunner(val environment: AbstractEnvironment) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val props = Properties()
        val propSrcs = environment.propertySources

        StreamSupport.stream(propSrcs.spliterator(), false)
            .filter { ps: PropertySource<*>? -> ps is EnumerablePropertySource<*> }
            .map { ps: PropertySource<*> -> (ps as EnumerablePropertySource<*>).propertyNames }
            .flatMap<Any>(Arrays::stream)
            .forEach { propName ->
                props.setProperty(
                    propName.toString(),
                    environment.getProperty(propName.toString())
                )
            }
    }
}