package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*
import kotlinx.android.synthetic.main.fragment_person_details.title_details_tv
import kotlinx.android.synthetic.main.fragment_planet_details.*

class PlanetDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    //TODO retrieve data from remote
    val planetsList = arrayListOf(
        Planet("Alderaan", 24, 364, 1250, "temperate"),
        Planet("Yavin IV", 25, 365, 1000, "sunny"),
        Planet("Hoth", 26, 254, 1300, "rainy"),
        Planet("Dagobah", 27, 300, 1265, "temperate")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planet_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position")
        val planet = position?.let { planetsList.get(it) }

        title_details_tv.text = planet?.name
        rotation_tv_content.text = planet?.rotation.toString()
        orbital_tv_content.text = planet?.orbital.toString()
        diameter_tv_content.text = planet?.diameter.toString()
        climate_tv_content.text = planet?.climate

    }
}