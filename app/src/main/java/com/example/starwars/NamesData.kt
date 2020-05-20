package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class NamesData(
    @JsonProperty("results") val results: List<ResultsData>? = null,
    @JsonProperty("name") val next: String? = null  
) 