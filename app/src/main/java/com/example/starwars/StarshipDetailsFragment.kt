package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_starship_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipDetailsFragment : Fragment(), StarshipDetailContract.View {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starship_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val starship = arguments?.getSerializable("starship") as Starship_Data

        title_details_tv.text = starship.name
        model_tv_content.text = starship.model
        manufacturer_tv_content.text = starship.manufacturer
        cost_in_tv_content.text = starship.cost_in_credits
        length_tv_content.text = starship.length

        progress_circular.visibility = View.GONE
    }
}