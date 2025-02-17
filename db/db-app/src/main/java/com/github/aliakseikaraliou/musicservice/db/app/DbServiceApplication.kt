package com.github.aliakseikaraliou.musicservice.db.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DbServiceApplication

fun main(args: Array<String>) {
	runApplication<DbServiceApplication>(*args)
}
