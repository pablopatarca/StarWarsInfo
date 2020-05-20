package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class PlanetData(
    @JsonProperty("name") val name: String,
    @JsonProperty("rotation") val rotation_period: String,
    @JsonProperty("orbital_period") val orbital_period: String,
    @JsonProperty("diameter") val diameter: String,
    @JsonProperty("climate") val climate: String
) : Serializable