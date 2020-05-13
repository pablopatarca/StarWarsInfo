package com.example.starwars

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_starships.*

interface StarshipsContract {

    interface View : BaseView<Presenter> {

        fun buildRecyclerView(starshipsList: LinkedHashMap<String,String>)

        fun startNewFragment(starship: Starship_Data)

    }

    interface Presenter {

        fun makeStarshipDetailsCall(starshipsList: LinkedHashMap<String,String>, position: Int)

        fun finishStarshipDetailsCall(starship: Starship_Data)
    }
}