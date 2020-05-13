package com.example.starwars

class StarshipsPresenter(val view: StarshipsContract.View, val repository: Repository = Repository()) : StarshipsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun makeStarshipDetailsCall(starshipsList: LinkedHashMap<String,String>, position: Int)
    {
        val url = starshipsList.get(starshipsList.keys.elementAt(position))
        if (url != null) {
            repository.makeStarshipDetailsCall(url,this)
        }
    }

    override fun finishStarshipDetailsCall(starship: StarshipData)
    {
        view.startNewFragment(starship)
    }
}