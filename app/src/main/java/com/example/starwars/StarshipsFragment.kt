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
import kotlinx.android.synthetic.main.fragment_starships.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class StarshipsFragment : Fragment(), StarshipsContract.View {

    val TYPE_TAG = "fragment_type"
    var starshipsList = LinkedHashMap<String,String>()
    var presenter = StarshipsPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starships, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namesList = arguments?.getSerializable("namesList") as LinkedHashMap<String,String>

        buildRecyclerView(namesList)
    }

    override fun setPresenter(@NonNull presenter: StarshipsContract.Presenter) {
        this.presenter = Preconditions.checkNotNull(presenter) as StarshipsPresenter
    }

    override fun buildRecyclerView(starshipsList: LinkedHashMap<String,String>)
    {
        val itemAdapter = ItemAdapter(starshipsList.keys)
        itemAdapter.setListener {
            presenter.makeStarshipDetailsCall(starshipsList, itemAdapter.getPosition())
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }

        progress_circular.visibility = View.GONE
    }

    override fun startNewFragment(starship: Starship_Data)
    {
        val args = Bundle()
        args.putSerializable("starship", starship)
        val fragment = StarshipDetailsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
    }
}