package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class NamesData {

    var results: List<ResultsData>? = null
    var next: String? = null

    constructor()   {}
    constructor(results:List<ResultsData>, next:String)
    {
        this.results = results
        this.next = next
    }
}