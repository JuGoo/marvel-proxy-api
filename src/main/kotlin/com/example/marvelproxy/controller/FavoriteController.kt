package com.example.marvelproxy.controller

import com.example.marvelproxy.model.Favorites
import com.example.marvelproxy.service.FavoriteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class FavoriteController(val favoriteService: FavoriteService) {

    @GetMapping("/favorites")
    fun index(@RequestHeader userId: String): List<Favorites> = favoriteService.findFavorites(userId)

    @GetMapping("/favorites/all")
    fun all(): List<Favorites> = favoriteService.findAllFavorites()

    @PostMapping("/favorites/add")
    fun post(@RequestBody holder: FavoritesHolder) {
        favoriteService.addOrRemoveFavorite(holder.userId, holder.heroId)
    }
}

data class FavoritesHolder(
    val userId: String,
    val heroId: String
)
