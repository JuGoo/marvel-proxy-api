package com.example.marvelproxy.service

import com.example.marvelproxy.repository.FavoriteRepository

import com.example.marvelproxy.Favorites
import org.springframework.stereotype.Service

@Service
class FavoriteService(val database: FavoriteRepository) {

    fun findFavorites(userId: String): List<Favorites> = database.findByUserid(userId)

    fun findFavorites(userId: String, heroId: String): List<Favorites> = database.findByUserid(userId)

    fun findAllFavorites(): List<Favorites> = database.findAll().toList()

    fun addOrRemoveFavorite(userId: String, heroId: String) {
        val result = database.findByUseridAndHero(userId, heroId).firstOrNull()
        if (result == null) {
            database.save(Favorites(userid = userId, hero = heroId))
        } else {
            database.delete(result)
        }
    }
}