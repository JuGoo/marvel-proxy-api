package com.example.marvelproxy.service

import com.example.marvelproxy.Hero
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HeroService() {
    fun findHeroes(userId: String): List<Hero> = listOf() // database.findAll().toList()

    fun findHeroesById(userId: String, heroId: String): List<Hero> = listOf() //  database.findById(id).toList()
}


internal fun <T : Any> Optional<out T>.toList(): List<T> = if (isPresent) listOf(get()) else emptyList()