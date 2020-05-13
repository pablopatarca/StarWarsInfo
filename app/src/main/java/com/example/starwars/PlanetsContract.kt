package com.example.starwars

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_planets.*

interface PlanetsContract {

    interface View : BaseView<Presenter> {

        fun buildRecyclerView(planetsList: LinkedHashMap<String,String>)

        fun startNewFragment(planet: Planet_Data)
    }

    interface Presenter {

        fun makePlanetDetailsCall(planetsList: LinkedHashMap<String,String>, position: Int)

        fun finishPersonDetailsCall(planet: Planet_Data)
    }
}