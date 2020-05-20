package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_starship_details.*

class StarshipDetailsFragment : Fragment(), StarshipDetailContract.View {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starship_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val starship = arguments?.getSerializable("starship") as? StarshipData

        titleDetailsTv.text = starship?.name
        modelTvContent.text = starship?.model
        manufacturerTvContent.text = starship?.manufacturer
        costInTvContent.text = starship?.cost_in_credits
        lengthTvContent.text = starship?.length

        progressCircular.visibility = View.GONE
    }
}