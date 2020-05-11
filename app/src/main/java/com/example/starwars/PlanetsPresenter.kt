package com.example.starwars

class PlanetsPresenter(fragment: PlanetsFragment) {

    private val fragment = fragment         //view
    private val repository = Repository()   //model

    fun makePlanetDetailsCall(planetsList: LinkedHashMap<String,String>, position: Int)
    {
        val url = planetsList.get(planetsList.keys.elementAt(position))
        val planet = Planet_Data()
        if (url != null) {
            repository.makePlanetDetailsCall(url, planet,this)
        }
    }

    fun finishPersonDetailsCall(planet: Planet_Data)
    {
        fragment.startNewFragment(planet)
    }
}