package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*

class PersonDetailsFragment : Fragment(), PersonDetailContract.View {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val person = arguments?.getSerializable("person") as PersonData

        title_details_tv.text = person.name
        height_tv_content.text = person.height
        mass_tv_content.text = person.mass
        hair_color_tv_content.text = person.hair_color
        skin_color_tv_content.text = person.skin_color

        progress_circular.visibility = View.GONE
    }
}