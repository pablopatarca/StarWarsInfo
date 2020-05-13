package com.example.starwars

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIInterface {

    @GET()
    fun getNames(@Url url: String): Call<NamesData>

    @GET()
    fun getPerson(@Url url: String): Call<PersonData>

    @GET()
    fun getPlanet(@Url url: String): Call<PlanetData>

    @GET()
    fun getStarship(@Url url: String): Call<StarshipData>
}