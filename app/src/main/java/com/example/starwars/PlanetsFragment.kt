package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_planets.*


class PlanetsFragment : Fragment() {

    val TYPE_TAG = "fragment_type"

    //TODO retrieve data from remote
    val planetsList = arrayListOf(
        "Alderaan",
        "Yavin IV",
        "Hoth",
        "Dagobah"
        )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemAdapter = ItemAdapter(planetsList, activity?.applicationContext)
        itemAdapter.setListener {
            val args = Bundle()
            args.putInt("position", itemAdapter.getPosition())
            val fragment = PlanetDetailsFragment()
            fragment.arguments = args
            fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }
    }
}