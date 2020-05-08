package com.example.starwars

import com.fasterxml.jackson.annotation.JsonProperty
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIInterface {

    @GET()
    fun getNames(@Url url: String): Call<Names_Data>

    @GET()
    fun getPerson(@Url url: String): Call<Person_Data>

    @GET()
    fun getPlanet(@Url url: String): Call<Planet_Data>

    @GET()
    fun getStarship(@Url url: String): Call<Starship_Data>
}