package com.example.starwars

class PlanetsPresenter(view: PlanetsContract.View) : PlanetsContract.Presenter {

    private val view = view         //view
    private val repository = Repository()   //model

    init {
        view.setPresenter(this)
    }

    override fun makePlanetDetailsCall(planetsList: LinkedHashMap<String,String>, position: Int)
    {
        val url = planetsList.get(planetsList.keys.elementAt(position))
        val planet = PlanetData()
        if (url != null) {
            repository.makePlanetDetailsCall(url, planet,this)
        }
    }

    override fun finishPersonDetailsCall(planet: PlanetData)
    {
        view.startNewFragment(planet)
    }
}