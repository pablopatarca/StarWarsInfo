package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Names_Data {

    var results: List<Results_Data>? = null
    var next: String? = null

    constructor()   {}
    constructor(results:List<Results_Data>, next:String)
    {
        this.results = results
        this.next = next
    }
}