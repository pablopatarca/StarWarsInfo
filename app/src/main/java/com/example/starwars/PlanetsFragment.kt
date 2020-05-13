package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.common.base.Preconditions
import kotlinx.android.synthetic.main.fragment_planets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class PlanetsFragment : Fragment(), PlanetsContract.View {

    val TYPE_TAG = "fragment_type"
    var planetsList = LinkedHashMap<String,String>()
    var presenter = PlanetsPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namesList = arguments?.getSerializable("namesList") as LinkedHashMap<String,String>

        buildRecyclerView(namesList)
    }

    override fun setPresenter(@NonNull presenter: PlanetsContract.Presenter) {
        this.presenter = Preconditions.checkNotNull(presenter) as PlanetsPresenter
    }

    override fun buildRecyclerView(planetsList: LinkedHashMap<String,String>)
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

    override fun startNewFragment(planet: Planet_Data)
    {
        val args = Bundle()
        args.putSerializable("planet", planet)
        val fragment = PlanetDetailsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
    }
}