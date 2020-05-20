package com.example.starwars

class PlanetsPresenter(val view: PlanetsContract.View, val repository: Repository = Repository()) : PlanetsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun makePlanetDetailsCall(planetsList: LinkedHashMap<String,String>, position: Int)
    {
        val url = planetsList.get(planetsList.keys.elementAt(position))
        if (url != null) {
            repository.makePlanetDetailsCall(url,this)
        }
    }

    override fun finishPersonDetailsCall(planet: PlanetData)
    {
        view.startNewFragment(planet)
    }
}