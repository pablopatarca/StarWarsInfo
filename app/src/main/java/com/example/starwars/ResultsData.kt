package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ResultsData(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String
)