package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_planet_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planet_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planet = arguments?.getSerializable("planet") as Planet_Data


        title_details_tv.text = planet.name
        rotation_tv_content.text = planet.rotation_period
        orbital_tv_content.text = planet.orbital_period
        diameter_tv_content.text = planet.diameter
        climate_tv_content.text = planet.climate

        progress_circular.visibility = View.GONE
    }
}