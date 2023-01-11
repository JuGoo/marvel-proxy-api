package com.example.marvelproxy.controller

import com.example.marvelproxy.model.Favorites
import com.example.marvelproxy.model.Hero
import com.example.marvelproxy.service.FavoriteService
import com.example.marvelproxy.service.HeroService
import com.example.marvelproxy.service.MarvelHero
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class HeroController(
    private val heroService: HeroService,
    private val favoriteService: FavoriteService
) {

    @GetMapping("/heroes")
    fun index(@RequestHeader userId: String): List<Hero> = fetchFavorites(userId).let { favorites ->
        heroService.findHeroes(userId).mapToHeroes(favorites)
    }

    @GetMapping("/heroes/{heroId}")
    fun index(@RequestHeader userId: String, @PathVariable heroId: String): List<Hero> =
        fetchFavorites(userId).let { favorites ->
            heroService.findHeroesById(userId, heroId).mapToHeroes(favorites)
        }

    private fun fetchFavorites(userId: String): List<Favorites> = favoriteService.findFavorites(userId)
}

private fun List<MarvelHero>.mapToHeroes(favorites: List<Favorites>) = map {
    mapToHero(it, favorites)
}

private fun mapToHero(hero: MarvelHero, favorites: List<Favorites>) =
    Hero(heroId = hero.id, name = hero.name, isFavorite = favorites.any { it.hero == hero.id })
