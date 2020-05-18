package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class PersonData(
    @JsonProperty("name") val name: String,
    @JsonProperty("height") val height: String,
    @JsonProperty("mass") val mass: String,
    @JsonProperty("hair_color") val hair_color: String,
    @JsonProperty("skin_color") val skin_color: String
) : Serializable