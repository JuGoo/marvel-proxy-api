package com.example.marvelproxy

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.example.marvelproxy.controller", "com.example.marvelproxy.service", "com.example.marvelproxy.repository"])
class MarvelProxyApplication {
    companion object {
        val logger: Logger? = LoggerFactory.getLogger(MarvelProxyApplication::class.java)
    }

    @PostConstruct
    fun postConstruct() {
        logger?.info("-------------------------Blog Initializing---------------------")
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder().bannerMode(Banner.Mode.CONSOLE)
        .sources(MarvelProxyApplication::class.java)
        .run(*args)
}





