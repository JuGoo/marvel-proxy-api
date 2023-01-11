package com.example.marvelproxy.service

import com.example.marvelproxy.model.Hero
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HeroService {
    fun findHeroes(userId: String): List<MarvelHero> = createDummyList()

    fun findHeroesById(userId: String, heroId: String): List<MarvelHero> = createDummyList().filter { it.id == heroId }
}

private fun createDummyList(): List<MarvelHero> = listOf(
    MarvelHero("1", "Captain America"),
    MarvelHero("2", "Iron Man"),
    MarvelHero("3", "Thor"),
    MarvelHero("4", "Spider-Man"),
    MarvelHero("5", "Hulk"),
    MarvelHero("6", "Black Panther")
)

data class MarvelHero(val id: String, val name: String)


internal fun <T : Any> Optional<out T>.toList(): List<T> = if (isPresent) listOf(get()) else emptyList()