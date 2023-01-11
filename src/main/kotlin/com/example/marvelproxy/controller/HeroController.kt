package com.example.marvelproxy.controller

import com.example.marvelproxy.Hero
import com.example.marvelproxy.service.HeroService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HeroController(private val heroService: HeroService) {

    @GetMapping("/heroes")
    fun index(@RequestBody userId: String): List<Hero> = heroService.findHeroes(userId)

    @GetMapping("/heroes/{id}")
    fun index(@RequestBody userId: String, @PathVariable id: String): List<Hero> =
        heroService.findHeroesById(userId, id)
}
