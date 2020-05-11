package com.example.starwars

import android.app.Person
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.getSerializable("person") as Person_Data

        title_details_tv.text = person.name
        height_tv_content.text = person.height
        mass_tv_content.text = person.mass
        hair_color_tv_content.text = person.hair_color
        skin_color_tv_content.text = person.skin_color

        progress_circular.visibility = View.GONE
    }
}