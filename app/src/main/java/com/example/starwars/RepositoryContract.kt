package com.example.starwars

interface RepositoryContract {

    fun getPeopleNext(): String

    fun getPlanetsNext(): String

    fun getStarshipsNext(): String

    fun makePeopleCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)

    fun makePlanetsCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)

    fun makeStarshipsCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)

    fun makePersonDetailsCall(url: String, person: Person_Data, presenter: PeoplePresenter)

    fun makePlanetDetailsCall(url: String, planet: Planet_Data, presenter: PlanetsPresenter)

    fun makeStarshipDetailsCall(url: String, starship: Starship_Data, presenter: StarshipsPresenter)
}