package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Starship_Data {

    lateinit var name: String
    lateinit var model: String
    lateinit var manufacturer: String
    lateinit var cost_in_credits: String
    lateinit var length: String

    constructor()   {}
    constructor(name:String, model:String, manufacturer:String, cost_in_credits:String, length:String)
    {
        this.name = name
        this.model = model
        this.manufacturer = manufacturer
        this.cost_in_credits = cost_in_credits
        this.length = length
    }
    
}