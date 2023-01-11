package com.example.marvelproxy.service

import org.springframework.stereotype.Service

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
