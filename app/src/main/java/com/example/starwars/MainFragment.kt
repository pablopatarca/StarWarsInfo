package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_planets.*

class MainFragment : Fragment() {

    val ROOT_TAG = "fragment_root"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        people_btn.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.container, PeopleFragment())?.addToBackStack(ROOT_TAG)?.commit()
        }

        planets_btn.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.container, PlanetsFragment())?.addToBackStack(ROOT_TAG)?.commit()
        }
        starships_btn.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.container, StarshipsFragment())?.addToBackStack(ROOT_TAG)?.commit()
        }

    }
}