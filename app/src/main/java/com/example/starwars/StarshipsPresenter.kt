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
        val starship = Starship_Data()
        if (url != null) {
            repository.makeStarshipDetailsCall(url,starship,this)
        }
    }

    override fun finishStarshipDetailsCall(starship: Starship_Data)
    {
        view.startNewFragment(starship)
    }
}