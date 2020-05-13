package com.example.starwars

interface StarshipsContract {

    interface View : BaseView<Presenter> {

        fun buildRecyclerView(starshipsList: LinkedHashMap<String,String>)

        fun startNewFragment(starship: StarshipData)

    }

    interface Presenter {

        fun makeStarshipDetailsCall(starshipsList: LinkedHashMap<String,String>, position: Int)

        fun finishStarshipDetailsCall(starship: StarshipData)
    }
}