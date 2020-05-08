package com.example.starwars

data class Names_Data(
    val results: List<Results_Data>,
    val next: String
)

data class Results_Data(
    val name: String,
    val url: String

)

data class Person_Data(
    val name: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String
)

data class Planet_Data(
    val name: String,
    val rotation_period: String,
    val orbital_period: String,
    val diameter: String,
    val climate: String
)
data class Starship_Data(
    val name: String,
    val model: String,
    val manufacturer: String,
    val cost_in_credits: String,
    val length: String
)