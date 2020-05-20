package com.example.starwars

interface PlanetsContract {

    interface View : BaseView<Presenter> {

        fun buildRecyclerView(planetsList: LinkedHashMap<String,String>)

        fun startNewFragment(planet: PlanetData)
    }

    interface Presenter {

        fun makePlanetDetailsCall(planetsList: LinkedHashMap<String,String>, position: Int)

        fun finishPersonDetailsCall(planet: PlanetData)
    }
}