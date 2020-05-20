package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class StarshipData(
    @JsonProperty("name") val name: String,
    @JsonProperty("model") val model: String,
    @JsonProperty("manufacturer") val manufacturer: String,
    @JsonProperty("cost_in_credits") val cost_in_credits: String,
    @JsonProperty("length") val length: String
) : Serializable