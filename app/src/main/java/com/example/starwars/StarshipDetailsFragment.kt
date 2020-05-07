package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*
import kotlinx.android.synthetic.main.fragment_person_details.title_details_tv
import kotlinx.android.synthetic.main.fragment_starship_details.*

class StarshipDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    //TODO retrieve data from remote
    val starshipsList = arrayListOf(
        Starship("Executor", "Exec", "Kuat", 1143, 19000),
        Starship("Sentinel-class landing craft", "Exec", "Kuat", 1000, 20000),
        Starship("Death Star", "Exec", "Kuat", 2001, 19000),
        Starship("Millennium Falcon", "Exec", "Kuat", 1952, 15000)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starship_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position")
        val starship = position?.let { starshipsList.get(it) }

        title_details_tv.text = starship?.name
        model_tv_content.text = starship?.model
        manufacturer_tv_content.text = starship?.manufacturer
        cost_in_tv_content.text = starship?.costIn.toString()
        length_tv_content.text = starship?.length.toString()

    }
}