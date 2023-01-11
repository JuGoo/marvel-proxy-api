package com.example.marvelproxy.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("FAVORITES")
data class Favorites(@Id var id: UUID? = null, val userid: String, val hero: String)