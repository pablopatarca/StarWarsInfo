package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_planets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class PlanetsFragment : Fragment() {

    val TYPE_TAG = "fragment_type"
    var planetsList = LinkedHashMap<String,String>()
    val presenter = PlanetsPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namesList = arguments?.getSerializable("namesList") as LinkedHashMap<String,String>

        buildRecyclerView(namesList)
    }

    fun buildRecyclerView(planetsList: LinkedHashMap<String,String>)
    {
        val itemAdapter = ItemAdapter(planetsList.keys)
        itemAdapter.setListener {
            presenter.makePlanetDetailsCall(planetsList, itemAdapter.getPosition())
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }

        progress_circular.visibility = View.GONE
    }

    fun startNewFragment(planet: Planet_Data)
    {
        val args = Bundle()
        args.putSerializable("planet", planet)
        val fragment = PlanetDetailsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
    }
}