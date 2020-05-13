package com.example.starwars

class StarshipsPresenter(view: StarshipsContract.View) : StarshipsContract.Presenter {

    private val view = view         //view
    private val repository = Repository()   //model

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