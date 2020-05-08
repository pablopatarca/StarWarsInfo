package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Results_Data {

    lateinit var name: String
    lateinit var url: String

    constructor()   {}
    constructor(name:String, url:String)
    {
        this.name = name
        this.url = url
    }
}