package com.example.starwars

class StarshipsPresenter(fragment: StarshipsFragment) {

    private val fragment = fragment         //view
    private val repository = Repository()   //model

    fun makeStarshipDetailsCall(starshipsList: LinkedHashMap<String,String>, position: Int)
    {
        val url = starshipsList.get(starshipsList.keys.elementAt(position))
        val starship = Starship_Data()
        if (url != null) {
            repository.makeStarshipDetailsCall(url,starship,this)
        }
    }
}