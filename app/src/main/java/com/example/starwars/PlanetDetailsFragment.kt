package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_planet_details.*

class PlanetDetailsFragment : Fragment(), PlanetDetailContract.View {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planet_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planet = arguments?.getSerializable("planet") as PlanetData


        titleDetailsTv.text = planet.name
        rotationTvContent.text = planet.rotation_period
        orbitalTvContent.text = planet.orbital_period
        diameterTvContent.text = planet.diameter
        climateTvContent.text = planet.climate

        progressCircular.visibility = View.GONE
    }
}