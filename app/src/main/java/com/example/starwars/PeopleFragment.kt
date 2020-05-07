package com.example.starwars

import android.app.Person
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_people.*


class PeopleFragment : Fragment() {

    val TYPE_TAG = "fragment_type"

    //TODO retrieve data from remote
    val peopleList = arrayListOf(
        "Luke Skywalker",
        "C-3PO",
        "R2-D2",
        "Darth Vader"
        )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemAdapter = ItemAdapter(peopleList, activity?.applicationContext)
        itemAdapter.setListener {
            val args = Bundle()
            args.putInt("position", itemAdapter.getPosition())
            val fragment = PersonDetailsFragment()
            fragment.arguments = args
            fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }
    }
}