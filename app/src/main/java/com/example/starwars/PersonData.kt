package com.example.starwars

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
class PersonData : Serializable {

    lateinit var name: String
    lateinit var height: String
    lateinit var mass: String
    lateinit var hair_color: String
    lateinit var skin_color: String
    
    constructor()   {}
    constructor(name:String, height:String, mass:String, hair_color:String, skin_color:String)
    {
        this.name = name
        this.height = height
        this.mass = mass
        this.hair_color = hair_color
        this.skin_color = skin_color
    }
}