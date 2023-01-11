package com.example.marvelproxy.repository

import com.example.marvelproxy.model.Favorites
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface FavoriteRepository : CrudRepository<Favorites, UUID> {
    fun findByUserid(userid: String): List<Favorites>
    fun findByUseridAndHero(userid: String, hero: String): List<Favorites>
}