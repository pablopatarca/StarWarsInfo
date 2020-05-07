package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*

class PersonDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    //TODO retrieve data from remote
    val peopleList = arrayListOf(
        People("Luke Skywalker", 172, 77, "blond", "fair"),
        People("C-3PO", 175, 70, "green", "green"),
        People("R2-D2", 182, 80, "brown", "fair"),
        People("Darth Vader", 168, 85, "black", "black")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position")
        val person = position?.let { peopleList.get(it) }

        title_details_tv.text = person?.name
        height_tv_content.text = person?.height.toString()
        mass_tv_content.text = person?.mass.toString()
        hair_color_tv_content.text = person?.hairColor
        skin_color_tv_content.text = person?.skinColor

    }
}