package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class Planet_Data : Serializable {

    lateinit var name: String
    lateinit var rotation_period: String
    lateinit var orbital_period: String
    lateinit var diameter: String
    lateinit var climate: String

    constructor()   {}
    constructor(name:String, rotation_period:String, orbital_period:String, diameter:String, climate:String)
    {
        this.name = name
        this.rotation_period = rotation_period
        this.orbital_period = orbital_period
        this.diameter = diameter
        this.climate = climate
    }
    
}